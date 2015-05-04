package peliprojekti;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import com.googlecode.lanterna.gui.Action;
import com.googlecode.lanterna.gui.Border;
import com.googlecode.lanterna.gui.Component;
import com.googlecode.lanterna.gui.Window;
import com.googlecode.lanterna.gui.component.Button;
import com.googlecode.lanterna.gui.component.EmptySpace;
import com.googlecode.lanterna.gui.component.Label;
import com.googlecode.lanterna.gui.component.Panel;
import com.googlecode.lanterna.gui.dialog.MessageBox;
import com.googlecode.lanterna.gui.layout.LinearLayout;

public class GameWindow extends Window {
	/* Yläreuna: pelin infopaneelit */
	Panel infoPanel = new Panel(Panel.Orientation.HORISONTAL);
	Panel infoPanelInfo1 = new Panel(new Border.Bevel(true), Panel.Orientation.HORISONTAL);
	Panel infoPanelInfo2 = new Panel(new Border.Bevel(true), Panel.Orientation.HORISONTAL);
	Panel infoPanelInfo3 = new Panel(new Border.Bevel(true), Panel.Orientation.HORISONTAL);

	/* Keskelle: Pelaajan toimintopaneeli */
	Panel actionPanel = new Panel(Panel.Orientation.VERTICAL);
	Panel middleContainer = new Panel(Panel.Orientation.HORISONTAL);

	/* Alareuna: pelaajan tietopaneelit */
	Panel playerPanel = new Panel(Panel.Orientation.HORISONTAL);
	Panel playerPanelInfo1 = new Panel(new Border.Bevel(true), Panel.Orientation.HORISONTAL);
	Panel playerPanelInfo2 = new Panel(new Border.Bevel(true), Panel.Orientation.HORISONTAL);
	Panel playerPanelInfo3 = new Panel(new Border.Bevel(true), Panel.Orientation.HORISONTAL);
	Panel playerPanelInfo4 = new Panel(new Border.Bevel(true), Panel.Orientation.HORISONTAL);

	Label ageLabel = new Label("");
	Label healthLabel = new Label("");
	Label sanityLabel = new Label("");
	Label hungerLabel = new Label("");
	Label foodLabel = new Label("");
	Label moneyLabel = new Label("");

	public GameWindow() {
		super("KelaSim");
		actionPanel.setAlignment(Component.Alignment.CENTER);
		System.out.println("New GameWindow "+this.toString()+" created");
	}

	public GameWindow(final Player player, final GameEngine gameEngine) {
		super("KelaSim");
		final GameWindow gameWindow = this;
		System.out.println(gameEngine.gameGui.getScreen());
		refresh(player);
		/* Määritellään pelaajan tietopaneelit pelaajan tietojen mukaisiksi */
		infoPanelInfo1.addComponent(ageLabel);
		infoPanelInfo2.addComponent(new Label("Postilaatikko"));
		infoPanelInfo3.addComponent(foodLabel);


		actionPanel.addComponent(new EmptySpace(1, 1), LinearLayout.MAXIMIZES_VERTICALLY);
		actionPanel.addComponent(new Button("Nuku", new Action() {
			public void doAction() {
				player.changePlayerAge(1);
				player.changePlayerHealth(1);
				player.changePlayerHunger(2);
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
				gameEngine.gameGui.showWindow(newGrocery);
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
				ApplicationMenu applicationMenu = new ApplicationMenu();
				gameEngine.gameGui.showWindow(applicationMenu);
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
				gameEngine.keepPlaying = false;
				close();
			}
		}));
		actionPanel.addComponent(new EmptySpace(1, 1), LinearLayout.MAXIMIZES_VERTICALLY);

		playerPanelInfo1.addComponent(moneyLabel);
		playerPanelInfo2.addComponent(healthLabel);
		playerPanelInfo3.addComponent(sanityLabel);
		playerPanelInfo4.addComponent(hungerLabel);

		infoPanel.addComponent(new EmptySpace(1, 1), LinearLayout.MAXIMIZES_HORIZONTALLY);
		infoPanel.addComponent(infoPanelInfo1);
		infoPanel.addComponent(infoPanelInfo2);
		infoPanel.addComponent(infoPanelInfo3);
		infoPanel.addComponent(new EmptySpace(1, 1), LinearLayout.MAXIMIZES_HORIZONTALLY);

		playerPanel.addComponent(new EmptySpace(1, 1), LinearLayout.MAXIMIZES_HORIZONTALLY);
		playerPanel.addComponent(playerPanelInfo1);
		playerPanel.addComponent(playerPanelInfo2);
		playerPanel.addComponent(playerPanelInfo3);
		playerPanel.addComponent(playerPanelInfo4);
		playerPanel.addComponent(new EmptySpace(1, 1), LinearLayout.MAXIMIZES_HORIZONTALLY);


		addComponent(infoPanel);
		addComponent(new EmptySpace(1, 1), LinearLayout.MAXIMIZES_VERTICALLY);
		middleContainer.addComponent(new EmptySpace(1, 1), LinearLayout.MAXIMIZES_HORIZONTALLY);
		middleContainer.addComponent(actionPanel);
		middleContainer.addComponent(new EmptySpace(1, 1), LinearLayout.MAXIMIZES_HORIZONTALLY);
		addComponent(middleContainer);
		addComponent(new EmptySpace(1, 1), LinearLayout.MAXIMIZES_VERTICALLY);
		addComponent(playerPanel);

		if (player.getPlayerHealth() == 0) {
			MessageBox.showMessageBox(getOwner(), ":-(:", "Kuolit.");
		}
		if (player.getPlayerHunger() == 10) {
			MessageBox.showMessageBox(getOwner(), ":-(:", "Kuolit nälkään.");
		}
		if (player.getPlayerSanity() == 10) {
			MessageBox.showMessageBox(getOwner(), ":-(:", "Sekosit.");
		}

		int testCounter = 0;
		testCounter++;
		System.out.println("GameWindow completed "+testCounter+" times");
	}

	public void refresh(Player player) {
		ageLabel.setText("Päivä: "+Integer.toString(player.getPlayerAge()));
		healthLabel.setText("Hyvinvointi: "+Integer.toString(player.getPlayerHealth()));
		sanityLabel.setText("Mielenterveys: "+Integer.toString(player.getPlayerSanity()));
		hungerLabel.setText("Nälkä: "+Integer.toString(player.getPlayerHunger()));
		foodLabel.setText("Ruokaa: "+Integer.toString(player.getPlayerFood()));
		moneyLabel.setText("Rahaa: "+Integer.toString(player.getPlayerMoney()));
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

