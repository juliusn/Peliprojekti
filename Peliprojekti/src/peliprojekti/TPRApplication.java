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
	private String fillName = "";
	private String fillSocialSecurityNumber ="";
	private String fillDateOfBirth = "";

	Label fillNameLabel = new Label("Nimi:");
	final TextBox fillNameBox = new TextBox("", 30);
	Button fillNameButton = new Button("OK", new Action() {
		public void doAction() {
			fillName = fillNameBox.getText();
		}
	}
			);

	Label fillSocialSecurityNumberLabel = new Label("Sosiaaliturvatunnus:");
	final TextBox fillSocialSecurityNumberBox = new TextBox("", 30);
	Button fillSocialSecurityNumberButton = new Button("OK", new Action() {
		public void doAction() {
			fillSocialSecurityNumber = fillSocialSecurityNumberBox.getText();
		}
	}
			);
	Label fillDateOfBirthLabel = new Label("Syntymäaika");
	final TextBox fillDateOfBirthBox = new TextBox("", 30);
	Button fillDateOfBirthButton = new Button("OK", new Action() {
		public void doAction() {
			fillDateOfBirth = fillDateOfBirthBox.getText();
		}
	}
			);

	Panel fillNamePanel = new Panel(new Border.Invisible(), Panel.Orientation.HORISONTAL);
	Panel fillSocialSecurityNumberPanel = new Panel(new Border.Invisible(), Panel.Orientation.HORISONTAL);
	Panel fillDateOfBirthPanel = new Panel(new Border.Invisible(), Panel.Orientation.HORISONTAL);


	public TPRApplication(String title) {
		super(title);
		this.name = title;
		System.out.println("New TPRApplication "+title+" created");
	}

	public String getName() {
		return this.name;
	}

	public void fill() {
		fillNamePanel.addComponent(fillNameBox);
		fillNamePanel.addComponent(fillNameButton);
		fillSocialSecurityNumberPanel.addComponent(fillSocialSecurityNumberBox);
		fillSocialSecurityNumberPanel.addComponent(fillSocialSecurityNumberButton);
		fillDateOfBirthPanel.addComponent(fillDateOfBirthBox);
		fillDateOfBirthPanel.addComponent(fillDateOfBirthButton);

		addComponent(fillNameLabel);
		addComponent(fillNamePanel);
		addComponent(new EmptySpace(1, 1));
		addComponent(fillSocialSecurityNumberLabel);
		addComponent(fillSocialSecurityNumberPanel);
		addComponent(new EmptySpace(1, 1));
		addComponent(fillDateOfBirthLabel);
		addComponent(fillDateOfBirthPanel);
		addComponent(new EmptySpace(1, 1));
		addComponent((new Button("Sulje hakemus", new Action(){
			public void doAction() {
				close();
			}

		})));
	}
}
