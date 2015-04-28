package peliprojekti;

import com.googlecode.lanterna.gui.Action;
import com.googlecode.lanterna.gui.Border;
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


	public GameWindow(final Player player) {
		super("KelaSim");

		Panel infoPanel = new Panel(Panel.Orientation.HORISONTAL);
		Panel infoPanelInfo1 = new Panel(new Border.Bevel(true), Panel.Orientation.HORISONTAL);
		Panel infoPanelInfo2 = new Panel(new Border.Bevel(true), Panel.Orientation.HORISONTAL);
		Panel infoPanelInfo3 = new Panel(new Border.Bevel(true), Panel.Orientation.HORISONTAL);
		Panel actionPanel = new Panel(Panel.Orientation.VERTICAL);
		actionPanel.setAlignment(Alignment.CENTER);
		Panel playerPanel = new Panel(Panel.Orientation.HORISONTAL);
		playerPanel.setAlignment(Alignment.BOTTON_CENTER);
		Panel playerPanelInfo1 = new Panel(new Border.Bevel(true), Panel.Orientation.HORISONTAL);
		Panel playerPanelInfo2 = new Panel(new Border.Bevel(true), Panel.Orientation.HORISONTAL);
		Panel playerPanelInfo3 = new Panel(new Border.Bevel(true), Panel.Orientation.HORISONTAL);

		infoPanelInfo1.addComponent(new TextArea("Päivä "
				+player.getPlayerAge()
				));
		infoPanelInfo2.addComponent(new Label("Postilaatikko"));
		infoPanelInfo3.addComponent(new Label("Muuta"));



		actionPanel.addComponent(new EmptySpace(1, 1), LinearLayout.MAXIMIZES_VERTICALLY);
		actionPanel.addComponent(new Button("Nuku", new Action() {
			public void doAction() {
				player.keepPlaying = true;
				player.changePlayerAge(1);
				close();
				//Tähän refresh!
			}
		}
				));
		actionPanel.addComponent(new Button("Tee Hakemus", new Action() {
			//@Override
			public void doAction() {
				ApplicationMenu applicationMenu = new ApplicationMenu();
				Main.gui.showWindow(applicationMenu);
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
				player.keepPlaying = false;
				close();
			}
		}));
		actionPanel.addComponent(new EmptySpace(1, 1), LinearLayout.MAXIMIZES_VERTICALLY);

		playerPanelInfo1.addComponent(new Label("Raha: "+player.getPlayerMoney()+"€"));
		playerPanelInfo2.addComponent(new Label("Hyvinvointi: "+player.getPlayerHealth()));
		playerPanelInfo3.addComponent(new Label("Mielenterveys: "+player.getPlayerSanity()));

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
		addComponent(playerPanel);
		int testCounter = 0;
		System.out.println("Testcounter: "+testCounter);
		testCounter++;
	}


}

