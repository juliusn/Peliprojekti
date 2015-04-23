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
import com.googlecode.lanterna.gui.dialog.MessageBox;
import com.googlecode.lanterna.gui.layout.LinearLayout;

import java.util.Date;

public class GameWindow extends Window {


	public GameWindow(Player player) {
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

		Date now = new Date();
		infoPanelInfo1.addComponent(new Label("Aika: "
				+now
				));
		infoPanelInfo2.addComponent(new Label("Postilaatikko"));
		infoPanelInfo3.addComponent(new Label("Muuta"));

		actionPanel.addComponent(new Button("Nappi", new Action() {
			//@Override
			public void doAction() {
				MessageBox.showMessageBox(getOwner(), "Hienoa!", "Painoit nappia.");
			}
		}));
		actionPanel.addComponent(new Button("Nappi 2", new Action() {
			//@Override
			public void doAction() {
				MessageBox.showMessageBox(getOwner(), "Hienoa!", "Painoit toista nappia.");
			}
		}));
		actionPanel.addComponent(new Button("Lopeta", new Action() {
			//@Override
			public void doAction() {
				close();
			}
		}));

		ActionListBox actionListBox = new ActionListBox();
		Action pilipali = new Action() {
			public void doAction() {
				System.out.println("pilipali");
			}
		};
		Action lopeta = new Action() {
			public void doAction() {
				close();	
			}
		};

		playerPanelInfo1.addComponent(new Label("Raha: "+player.getPlayerMoney()+"€"));
		playerPanelInfo2.addComponent(new Label("Hyvinvointi: "+player.getPlayerHealth()));
		playerPanelInfo3.addComponent(new Label("Mielenterveys: "+player.getPlayerSanity()));

		infoPanel.addComponent(new EmptySpace(1, 1), LinearLayout.MAXIMIZES_HORIZONTALLY);
		infoPanel.addComponent(infoPanelInfo1);
		infoPanel.addComponent(infoPanelInfo2);
		infoPanel.addComponent(infoPanelInfo3);
		infoPanel.addComponent(new EmptySpace(1, 1), LinearLayout.MAXIMIZES_HORIZONTALLY);

		actionPanel.addComponent(new EmptySpace(1, 1), LinearLayout.MAXIMIZES_VERTICALLY);
		actionListBox.addAction(pilipali);
		actionListBox.addAction(lopeta);
		actionPanel.addComponent(actionListBox);
		actionPanel.addComponent(new EmptySpace(1, 1), LinearLayout.MAXIMIZES_VERTICALLY);


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

