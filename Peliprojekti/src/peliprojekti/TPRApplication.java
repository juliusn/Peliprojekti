package peliprojekti;

import com.googlecode.lanterna.gui.Action;
import com.googlecode.lanterna.gui.Border;
import com.googlecode.lanterna.gui.component.Button;
import com.googlecode.lanterna.gui.component.EmptySpace;
import com.googlecode.lanterna.gui.component.Label;
import com.googlecode.lanterna.gui.component.Panel;
import com.googlecode.lanterna.gui.component.TextArea;
import com.googlecode.lanterna.gui.component.TextBox;

public class TPRApplication extends Application {
	private String name = null;
	private String fillName;
	final TextBox fillNameBox = new TextBox("", 30);
	Button fillNameButton = new Button("OK", new Action() {
		public void doAction() {
			fillName = fillNameBox.getText();
		}
	}

			);

	Panel namePanel = new Panel(new Border.Invisible(), Panel.Orientation.HORISONTAL);
	

	public TPRApplication(String title) {
		super(title);
		this.name = title;
		System.out.println("New TPRApplication "+title+" created");
	}
	public String getName() {
		return this.name;
	}
	public void fill() {
		namePanel.addComponent(fillNameBox);
		namePanel.addComponent(fillNameButton);
		addComponent(namePanel);
		addComponent((new Button("Sulje hakemus", new Action(){
			public void doAction() {
				close();
			}

		})));
	}
}
