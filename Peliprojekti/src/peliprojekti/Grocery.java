package peliprojekti;

import com.googlecode.lanterna.gui.Action;
import com.googlecode.lanterna.gui.Border;
import com.googlecode.lanterna.gui.Window;
import com.googlecode.lanterna.gui.component.Button;
import com.googlecode.lanterna.gui.component.Label;
import com.googlecode.lanterna.gui.component.Panel;
import com.googlecode.lanterna.gui.component.TextBox;
import com.googlecode.lanterna.gui.dialog.MessageBox;

public class Grocery extends Window {

	public Grocery(String title, final Player player, final GameWindow gameWindow) {
		super(title);
		
		final TextBox amountBox = new TextBox("", 10);
		Button checkoutButton = new Button("Osta", new Action() {
			public void doAction() {
				int value = 0;

				try {
					value = Integer.parseInt(amountBox.getText());
					if (player.getPlayerMoney() >= value) {
						player.changePlayerMoney(-value);
						player.changePlayerFood(value);
						gameWindow.refresh(player);
						MessageBox.showMessageBox(getOwner(), "", "Ostit "+Integer.toString(value)+" markalla ruokaa.");
						close();
					} else {
						MessageBox.showMessageBox(getOwner(), "", "Rahasi ei riitä.");
					}
				} catch (NumberFormatException e) {
					MessageBox.showMessageBox(getOwner(), "", "Syötä kokonaisluku.");
					e.printStackTrace();
				}
			}
		}
				);
		Panel buyPanel = new Panel(new Border.Invisible(), Panel.Orientation.HORISONTAL);
		buyPanel.addComponent(new Label("Syötä summa:"));
		buyPanel.addComponent(amountBox);
		buyPanel.addComponent(new Label("mk"));
		addComponent(buyPanel);
		addComponent(checkoutButton);
		addComponent((new Button("Sulje", new Action(){
			public void doAction() {
				close();
			}
		})));
	}
}