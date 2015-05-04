package peliprojekti;

import com.googlecode.lanterna.gui.Action;
import com.googlecode.lanterna.gui.Border;
import com.googlecode.lanterna.gui.Component;
import com.googlecode.lanterna.gui.GUIScreen;
import com.googlecode.lanterna.gui.Component.Alignment;
import com.googlecode.lanterna.gui.Window;
import com.googlecode.lanterna.gui.component.ActionListBox;
import com.googlecode.lanterna.gui.component.Button;
import com.googlecode.lanterna.gui.component.EmptySpace;
import com.googlecode.lanterna.gui.component.Label;
import com.googlecode.lanterna.gui.component.Panel;
import com.googlecode.lanterna.gui.component.TextArea;
import com.googlecode.lanterna.gui.dialog.MessageBox;
import com.googlecode.lanterna.gui.layout.LinearLayout;

import java.util.ArrayList;
import java.util.Date;

public class GameWindow extends Window {
	/* Yläreunan infopaneelit */
	Panel infoPanel = new Panel(Panel.Orientation.HORISONTAL);
	Panel infoPanelInfo1 = new Panel(new Border.Bevel(true), Panel.Orientation.HORISONTAL);
	Panel infoPanelInfo2 = new Panel(new Border.Bevel(true), Panel.Orientation.HORISONTAL);
	Panel infoPanelInfo3 = new Panel(new Border.Bevel(true), Panel.Orientation.HORISONTAL);

	/* Pelaajan toimintopaneelit */
	Panel actionPanel = new Panel(Panel.Orientation.VERTICAL);

	/* Pelaajan tietopaneelit */
	Panel playerPanel = new Panel(Panel.Orientation.HORISONTAL);
	Panel playerPanelInfo1 = new Panel(new Border.Bevel(true), Panel.Orientation.HORISONTAL);
	Panel playerPanelInfo2 = new Panel(new Border.Bevel(true), Panel.Orientation.HORISONTAL);
	Panel playerPanelInfo3 = new Panel(new Border.Bevel(true), Panel.Orientation.HORISONTAL);

	Label ageLabel = new Label("");
	Label healthLabel = new Label("");
	Label sanityLabel = new Label("");
	Label moneyLabel = new Label("");

	public GameWindow() {
		super("KelaSim");
		actionPanel.setAlignment(Component.Alignment.CENTER);
		System.out.println("New GameWindow "+this.toString()+" created");
	}

	public GameWindow(final Player player, final GameEngine gameEngine) {
		super("KelaSim");
		GUIScreen gui = this.getOwner();
		/* Määritellään pelaajan tietopaneelit pelaajan tietojen mukaisiksi */
		ageLabel.setText("Päivä: "+Integer.toString(player.getPlayerAge()));
		healthLabel.setText("Hyvinvointi: "+Integer.toString(player.getPlayerHealth()));
		sanityLabel.setText("Mielenterveys: "+Integer.toString(player.getPlayerSanity()));
		moneyLabel.setText("Raha: "+Integer.toString(player.getPlayerMoney()));

		infoPanelInfo1.addComponent(ageLabel);
		infoPanelInfo2.addComponent(new Label("Postilaatikko"));
		infoPanelInfo3.addComponent(new Label("Muuta"));
		
		
		actionPanel.addComponent(new EmptySpace(1, 1), LinearLayout.MAXIMIZES_VERTICALLY);
		actionPanel.addComponent(new Button("Nuku", new Action() {
			public void doAction() {
				player.changePlayerAge(1);
				ageLabel.setText(Integer.toString(player.getPlayerAge()));
				System.out.println("player.getPlayerAge: "+player.getPlayerAge());
			}
		}
				));
		actionPanel.addComponent(new Button("Tee Hakemus", new Action() {
			//@Override
			public void doAction() {
				ApplicationMenu applicationMenu = new ApplicationMenu();
				gameEngine.gameGui.showWindow(applicationMenu);
			}
		}));
		actionPanel.addComponent(new Button("Osta ruokaa", new Action() {
			//@Override
			public void doAction() {
				Grocery newGrocery = new Grocery();
				newGrocery.buyFood();
			}
		}));
		actionPanel.addComponent(new Button("Tallenna", new Action() {
			//@Override
			public void doAction() {
				MessageBox.showMessageBox(getOwner(), "Hienoa!", "Painoit toista nappia.");
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

		infoPanel.addComponent(new EmptySpace(1, 1), LinearLayout.MAXIMIZES_HORIZONTALLY);
		infoPanel.addComponent(infoPanelInfo1);
		infoPanel.addComponent(infoPanelInfo2);
		infoPanel.addComponent(infoPanelInfo3);
		infoPanel.addComponent(new EmptySpace(1, 1), LinearLayout.MAXIMIZES_HORIZONTALLY);

		playerPanel.addComponent(new EmptySpace(1, 1), LinearLayout.MAXIMIZES_HORIZONTALLY);
		playerPanel.addComponent(playerPanelInfo1);
		playerPanel.addComponent(playerPanelInfo2);
		playerPanel.addComponent(playerPanelInfo3);
		playerPanel.addComponent(new EmptySpace(1, 1), LinearLayout.MAXIMIZES_HORIZONTALLY);

		
		addComponent(infoPanel);
		addComponent(actionPanel);
		//Menu actionMenu = new Menu(actionPanel);
		//gameEngine.gameGui.showWindow(actionMenu);
		addComponent(playerPanel);
		
		int testCounter = 0;
		testCounter++;
		System.out.println("GameWindow completed "+testCounter+" times");
	}


}

