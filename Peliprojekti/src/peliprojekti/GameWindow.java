package peliprojekti;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import com.googlecode.lanterna.gui.Action;
import com.googlecode.lanterna.gui.Border;
import com.googlecode.lanterna.gui.Component;
import com.googlecode.lanterna.gui.GUIScreen.Position;
import com.googlecode.lanterna.gui.Window;
import com.googlecode.lanterna.gui.component.Button;
import com.googlecode.lanterna.gui.component.EmptySpace;
import com.googlecode.lanterna.gui.component.Label;
import com.googlecode.lanterna.gui.component.Panel;
import com.googlecode.lanterna.gui.dialog.MessageBox;
import com.googlecode.lanterna.gui.layout.LinearLayout;

public class GameWindow extends Window {
	/* Yläreuna: pelin infopaneelit */
	Panel kelaPanel = new Panel(Panel.Orientation.HORISONTAL);
	Panel applicationPanel = new Panel(new Border.Bevel(true), Panel.Orientation.HORISONTAL);
	Panel allowancePanel = new Panel(new Border.Bevel(true), Panel.Orientation.HORISONTAL);

	Panel infoPanel = new Panel(Panel.Orientation.HORISONTAL);
	Panel moneyPanel = new Panel(new Border.Bevel(true), Panel.Orientation.HORISONTAL);
	Panel foodPanel = new Panel(new Border.Bevel(true), Panel.Orientation.HORISONTAL);

	/* Keskelle: Pelaajan toimintopaneeli */
	Panel actionPanel = new Panel(Panel.Orientation.VERTICAL);
	Panel middleContainer = new Panel(Panel.Orientation.HORISONTAL);

	/* Alareuna: pelaajan ominaisuudet */
	Panel playerPanel = new Panel(Panel.Orientation.HORISONTAL);
	Panel agePanel = new Panel(new Border.Bevel(true), Panel.Orientation.HORISONTAL);
	Panel healthPanel = new Panel(new Border.Bevel(true), Panel.Orientation.HORISONTAL);
	Panel hungerPanel = new Panel(new Border.Bevel(true), Panel.Orientation.HORISONTAL);
	Panel sanityPanel = new Panel(new Border.Bevel(true), Panel.Orientation.HORISONTAL);

	Label ageLabel = new Label("");
	Label applicationLabel = new Label("");
	Label allowanceLabel = new Label("");
	Label moneyLabel = new Label("");
	Label foodLabel = new Label("");
	Label healthLabel = new Label("");
	Label hungerLabel = new Label("");
	Label sanityLabel = new Label("");

	public GameWindow() {
		super("KelaSim");
		actionPanel.setAlignment(Component.Alignment.CENTER);
		System.out.println("New GameWindow "+this.toString()+" created");
	}

	public GameWindow(final Player player, final GameEngine gameEngine) {
		super(player.getPlayerForeName()+" "+player.getPlayerSurName()+" ("+player.getPlayerSsn()+")");
		final GameWindow gameWindow = this;
		System.out.println(gameEngine.gameGui.getScreen());
		refresh(player);

		/* Määritellään pelaajan tietopaneelit pelaajan tietojen mukaisiksi */
		applicationPanel.addComponent(applicationLabel);
		allowancePanel.addComponent(allowanceLabel);
		moneyPanel.addComponent(moneyLabel);
		foodPanel.addComponent(foodLabel);


		actionPanel.addComponent(new EmptySpace(1, 1), LinearLayout.MAXIMIZES_VERTICALLY);
		actionPanel.addComponent(new Button("Nuku", new Action() {
			public void doAction() {
				player.changePlayerAge(1);
				player.changePlayerHealth(1);
				player.changePlayerHunger(4);
				for (int i = 0; i < player.getApplications().size(); i++) {
					player.getApplications().get(i).increaseDateCounter(1);
				}
				for (int i = 0; i < player.getAllowances().size(); i++) {
					player.getAllowances().get(i).increaseDate(player);
				}

				refresh(player);
				System.out.println("player.getPlayerAge: "+player.getPlayerAge());
			}
		}));
		actionPanel.addComponent(new Button("Syö", new Action() {

			public void doAction() {
				if (player.getPlayerHunger() > 0) {
					if (player.getPlayerFood() > 0) {
						player.changePlayerFood(-1);
						player.changePlayerHunger(-1);
					} else {
						MessageBox.showMessageBox(getOwner(), "", "Sinulla ei ole ruokaa.");
					}
				} else {
					MessageBox.showMessageBox(getOwner(), "", "Sinulla ei ole nälkä.");
				}
				refresh(player);
			}
		}));
		actionPanel.addComponent(new Button("Osta Ruokaa", new Action() {
			//@Override
			public void doAction() {
				Grocery newGrocery = new Grocery("Ruokakauppa", player, gameWindow);
				gameEngine.gameGui.showWindow(newGrocery, Position.CENTER);
				/*player.changePlayerMoney(-10);
				moneyLabel.setText(Integer.toString(player.getPlayerMoney()));
				System.out.println("player.getPlayerMoney: "+player.getPlayerMoney());
				player.changePlayerHealth(10);
				healthLabel.setText(Integer.toString(player.getPlayerHealth()));
				System.out.println("player.getPlayerHealth: "+player.getPlayerHealth());*/
			}
		}));
		actionPanel.addComponent(new Button("Tee Hakemus", new Action() {
			//@Override
			public void doAction() {
				ApplicationMenu applicationMenu = new ApplicationMenu(player, gameWindow);
				gameEngine.gameGui.showWindow(applicationMenu, Position.CENTER);
			}
		}));
		actionPanel.addComponent(new Button("Käy Työnhakutoimistossa", new Action() {
			//@Override
			public void doAction() {
				MessageBox.showMessageBox(getOwner(), "", "Olet ilmoittautunut työttömäksi työnhakijaksi. \n"
						+"Juuri nyt ei ole töitä tarjolla.\n"
						+"Tule kahden viikon kuluttua uudestaan.");
				player.isApplicant = true;
				refresh(player);
			}
		}));
		actionPanel.addComponent(new Button("Tallenna", new Action() {
			//@Override
			public void doAction() {
				save(player);
			}
		}));
		actionPanel.addComponent(new Button("Lopeta", new Action() {
			//@Override
			public void doAction() {
				player.keepPlaying = false;
				close();
			}
		}));
		actionPanel.addComponent(new EmptySpace(1, 1), LinearLayout.MAXIMIZES_VERTICALLY);

		agePanel.addComponent(ageLabel);
		healthPanel.addComponent(healthLabel);
		hungerPanel.addComponent(hungerLabel);
		sanityPanel.addComponent(sanityLabel);

		kelaPanel.addComponent(new EmptySpace(1, 1), LinearLayout.MAXIMIZES_HORIZONTALLY);
		kelaPanel.addComponent(applicationPanel);
		kelaPanel.addComponent(allowancePanel);
		kelaPanel.addComponent(new EmptySpace(1, 1), LinearLayout.MAXIMIZES_HORIZONTALLY);

		infoPanel.addComponent(new EmptySpace(1, 1), LinearLayout.MAXIMIZES_HORIZONTALLY);
		infoPanel.addComponent(moneyPanel);
		infoPanel.addComponent(foodPanel);
		infoPanel.addComponent(new EmptySpace(1, 1), LinearLayout.MAXIMIZES_HORIZONTALLY);

		playerPanel.addComponent(new EmptySpace(1, 1), LinearLayout.MAXIMIZES_HORIZONTALLY);
		playerPanel.addComponent(agePanel);
		playerPanel.addComponent(healthPanel);
		playerPanel.addComponent(hungerPanel);
		playerPanel.addComponent(sanityPanel);
		playerPanel.addComponent(new EmptySpace(1, 1), LinearLayout.MAXIMIZES_HORIZONTALLY);


		addComponent(kelaPanel);
		addComponent(infoPanel);
		addComponent(new EmptySpace(1, 1), LinearLayout.MAXIMIZES_VERTICALLY);
		middleContainer.addComponent(new EmptySpace(1, 1), LinearLayout.MAXIMIZES_HORIZONTALLY);
		middleContainer.addComponent(actionPanel);
		middleContainer.addComponent(new EmptySpace(1, 1), LinearLayout.MAXIMIZES_HORIZONTALLY);
		addComponent(middleContainer);
		addComponent(new EmptySpace(1, 1), LinearLayout.MAXIMIZES_VERTICALLY);
		addComponent(playerPanel);


		int testCounter = 0;
		testCounter++;
		System.out.println("GameWindow completed "+testCounter+" times");
	}

	public void refresh(Player player) {
		/* Hakemusten tila tarkistetaan */
		for (int i = 0; i < player.getApplications().size(); i++) {
			player.getApplications().get(i).check(player);
			if (player.getApplications().get(i).isApproved()) {
				MessageBox.showMessageBox(getOwner(), "", player.getApplications().get(i).getApplicationType()+" hyväksytty!");
				player.removeApplication(player.getApplications().get(i).getApplicationType());
			}
		}
		for (int i = 0; i < player.getAllowances().size(); i++) {
			// Tukimaksut tähän
		}
		/* Pelinäkymän tiedot päivitetään */
		ageLabel.setText("Päivä: "+Integer.toString(player.getPlayerAge()));
		if (player.getApplications().isEmpty()) {
			applicationLabel.setText("Ei hakemuksia");
		} else {
			applicationLabel.setText("Hakemuksia käsittelyssä: "+player.getApplications().size()+" kpl");
		}
		if (player.getAllowances().isEmpty()) {
			allowanceLabel.setText("Ei tukia");
		} else {
			allowanceLabel.setText("Hyväksyttyjä tukipäätöksiä: "+player.getAllowances().size()+" kpl");
		}

		healthLabel.setText("Hyvinvointi: "+Integer.toString(player.getPlayerHealth())+"%");
		sanityLabel.setText("Mielenterveys: "+Integer.toString(player.getPlayerSanity())+"%");
		hungerLabel.setText("Nälkä: "+Integer.toString(player.getPlayerHunger())+"%");
		foodLabel.setText("Ruokaa: "+Integer.toString(player.getPlayerFood())+" mk edestä");
		moneyLabel.setText("Rahaa tilillä: "+Integer.toString(player.getPlayerMoney())+" markkaa");


		/* Tarkistetaan, jatkuuko peli */
		if (player.getPlayerHealth() == 0) {
			MessageBox.showMessageBox(getOwner(), "Game Over:", "Kuolit.");
			player.keepPlaying = false;
			close();
		}
		if (player.getPlayerHunger() == 100) {
			MessageBox.showMessageBox(getOwner(), "Game Over:", "Kuolit nälkään.");
			player.keepPlaying = false;
			close();
		}
		if (player.getPlayerSanity() == 0) {
			MessageBox.showMessageBox(getOwner(), "Game Over:", "Sekosit.");
			player.keepPlaying = false;
			close();
		}
	}

	public void save(Player player) {
		try {
			FileOutputStream out = new FileOutputStream("player.ser");
			ObjectOutputStream obout = new ObjectOutputStream(out);
			obout.writeObject(player);
			obout.close();
			MessageBox.showMessageBox(getOwner(), "", "Peli tallennettu!");
		} catch (FileNotFoundException e) {
			System.out.println("Could not open player.ser");
			e.printStackTrace();
			MessageBox.showMessageBox(getOwner(), "Virhe:", "Peliä ei voitu tallentaa.");
		} catch (IOException e) {
			System.out.println("Error writing into file");
			e.printStackTrace();
			MessageBox.showMessageBox(getOwner(), "Virhe:", "Peliä ei voitu tallentaa.");
		}
	}
}

