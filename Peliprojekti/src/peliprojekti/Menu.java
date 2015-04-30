package peliprojekti;

import com.googlecode.lanterna.gui.Window;
import com.googlecode.lanterna.gui.component.Panel;

public class Menu extends Window {

	public Menu(Panel panel) {
		super("Valitse Toiminto: ");
		addComponent(panel);
	}
	
	
}
