package kelasim;

import com.googlecode.lanterna.gui.Action;
import com.googlecode.lanterna.gui.GUIScreen;
import com.googlecode.lanterna.gui.Window;
import com.googlecode.lanterna.gui.component.Button;

public class ApplicationMenu extends Window {

	public ApplicationMenu(final Player player, final GameWindow gameWindow) {
		super("Valitse Hakemus");
		addComponent((new Button("Työttömyyspäivärahahakemus", new Action(){
			public void doAction() {
				ApplicationWindow tprApplicationWindow = new TprApplicationWindow("Työttömyyspäivärahahakemus", player);
				tprApplicationWindow.fill(player, gameWindow);
				close();
				getOwner().showWindow(tprApplicationWindow, GUIScreen.Position.CENTER);
			}
		})));
		addComponent((new Button("Asumistukihakemus", new Action(){
			public void doAction() {
				ApplicationWindow atApplicationWindow = new AtApplicationWindow("Asumistukihakemus", player);
				atApplicationWindow.fill(player, gameWindow);
				close();
				getOwner().showWindow(atApplicationWindow, GUIScreen.Position.CENTER);
			}
		})));
		addComponent((new Button("Toimeentulotukihakemus", new Action(){
			public void doAction() {
				ApplicationWindow tttApplicationWindow = new TttApplicationWindow("Toimeentulotukihakemus", player);
				tttApplicationWindow.fill(player, gameWindow);
				close();
				getOwner().showWindow(tttApplicationWindow, GUIScreen.Position.CENTER);
			}
		})));
		addComponent((new Button("Sulje", new Action(){
			public void doAction() {
				close();
			}
		})));

	}
}