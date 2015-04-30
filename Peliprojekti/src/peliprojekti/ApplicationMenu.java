package peliprojekti;

import com.googlecode.lanterna.gui.Action;
import com.googlecode.lanterna.gui.GUIScreen;
import com.googlecode.lanterna.gui.Window;
import com.googlecode.lanterna.gui.component.Button;

public class ApplicationMenu extends Window {

	public ApplicationMenu() {
		super("Valitse Hakemus");
		addComponent((new Button("Työttömyyspäivärahahakemus", new Action(){
			public void doAction() {
				Application tprApplication = new TPRApplication("Työttömyyspäivärahahakemus");
				tprApplication.fill();
				getOwner().showWindow(tprApplication, GUIScreen.Position.CENTER);
			}
		})));
		addComponent((new Button("Asumistukihakemus", new Action(){
			public void doAction() {

			}
		})));
		addComponent((new Button("Toimeentulotukihakemus", new Action(){
			public void doAction() {

			}
		})));
		addComponent((new Button("Sulje", new Action(){
			public void doAction() {
				close();
			}
		})));

	}
}