package peliprojekti;

import com.googlecode.lanterna.gui.Action;
import com.googlecode.lanterna.gui.Window;
import com.googlecode.lanterna.gui.component.Button;
import com.googlecode.lanterna.gui.component.Label;

public class InstructionsWindow extends Window{
	
	public InstructionsWindow() {
		super("Ohjeet");
		addComponent(new Label("Häläpäti hämmää häpäti hää.\n"
				+ "Häpä äläpäti hämmää läpä lää.\n"
				+ "Hämmää häpäti hää."));
		addComponent(new Label("Häläpäti hämmää häpäti hää.\n"
				+ "Häpä äläpäti hämmää läpä lää.\n"
				+ "Hämmää häpäti hää."));
		addComponent(new Button("Okei", new Action(){
			public void doAction() {
				close();
			}
		}));

	}

}
