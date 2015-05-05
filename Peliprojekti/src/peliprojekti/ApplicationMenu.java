package peliprojekti;

import com.googlecode.lanterna.gui.Action;
import com.googlecode.lanterna.gui.GUIScreen;
import com.googlecode.lanterna.gui.Window;
import com.googlecode.lanterna.gui.component.Button;

public class ApplicationMenu extends Window {

	public ApplicationMenu(final Player player, final GameWindow gameWindow) {
		super("Valitse Hakemus");
		addComponent((new Button("Työttömyyspäivärahahakemus", new Action(){
			public void doAction() {
				ApplicationWindow application = new ApplicationWindow("Työttömyyspäivärahahakemus", player);
				application.fill(player, gameWindow);
				close();
				getOwner().showWindow(application, GUIScreen.Position.CENTER);
			}
		})));
		addComponent((new Button("Asumistukihakemus", new Action(){
			public void doAction() {
				ApplicationWindow application = new ApplicationWindow("Asumistukihakemus", player);
				application.fill(player, gameWindow);
				close();
				getOwner().showWindow(application, GUIScreen.Position.CENTER);
			}
		})));
		addComponent((new Button("Toimeentulotukihakemus", new Action(){
			public void doAction() {
				ApplicationWindow application = new ApplicationWindow("Toimeentulotukihakemus", player);
				application.fill(player, gameWindow);
				close();
				getOwner().showWindow(application, GUIScreen.Position.CENTER);
			}
		})));
		addComponent((new Button("Sulje", new Action(){
			public void doAction() {
				close();
			}
		})));

	}
}