package peliprojekti;

import com.googlecode.lanterna.gui.Action;
import com.googlecode.lanterna.gui.Border;
import com.googlecode.lanterna.gui.Window;
import com.googlecode.lanterna.gui.component.Button;
import com.googlecode.lanterna.gui.component.Label;
import com.googlecode.lanterna.gui.component.Panel;
import com.googlecode.lanterna.gui.component.TextBox;
import com.googlecode.lanterna.gui.dialog.MessageBox;

public class ApplicationWindow extends Window {
	private String name = null;
	final TextBox fillForeNameBox = new TextBox("");
	final TextBox fillSurNameBox = new TextBox("");
	final TextBox fillSsnBox = new TextBox("");
	final TextBox fillDateOfBirthBox = new TextBox("");

	Panel instructionsPanel = new Panel();
	Panel fillForeNamePanel = new Panel(new Border.Invisible(), Panel.Orientation.HORISONTAL);
	Panel fillSurNamePanel = new Panel(new Border.Invisible(), Panel.Orientation.HORISONTAL);
	Panel fillSsnPanel = new Panel(new Border.Invisible(), Panel.Orientation.HORISONTAL);
	Panel fillDateOfBirthPanel = new Panel(new Border.Invisible(), Panel.Orientation.HORISONTAL);


	public ApplicationWindow(String title, Player player) {
		super(title);
		this.name = title;

		System.out.println("New TPRApplication "+title+" created");
	}

	public String getName() {
		return this.name;
	}

	public void fill(final Player player, final GameWindow gameWindow) {
		fillForeNamePanel.addComponent(new Label("Etunimi:"));
		fillForeNamePanel.addComponent(fillForeNameBox);
		fillSurNamePanel.addComponent(new Label("Sukunimi:"));
		fillSurNamePanel.addComponent(fillSurNameBox);
		fillSsnPanel.addComponent(new Label("Sosiaaliturvatunnus:"));
		fillSsnPanel.addComponent(fillSsnBox);
		Label instructions = new Label("", 50);
		switch (this.name) {
		case "Työttömyyspäivärahahakemus":
			instructions.setText("Työttömyyspäivärahaa maksetaan työttömille työnhakijoille.\n"
					+ "Sinun täytyy olla ilmoittautunut työnhakijaksi työnhakutoimistossa.");
		case "Asumistukihakemus":
			instructions.setText("Asumistuki maksetaan suoraan vuokranantajalle, joka vähentää tuen määrän vuokrastasi.");

		case "Toimeentulotukihakemus":
			instructions.setText("Toimeentulotukea maksetaan harkinnanvaraisesti työttömille, heikkotuloisille ja muille ali-ihmisille.");
		}
		instructionsPanel.addComponent(instructions);
		addComponent(instructionsPanel);
		addComponent(fillForeNamePanel);
		addComponent(fillSurNamePanel);
		addComponent(fillSsnPanel);
		addComponent((new Button("Lähetä hakemus", new Action(){
			public void doAction() {
				send(player);
				gameWindow.refresh(player);
			}

		})));
		addComponent((new Button("Sulje hakemus", new Action(){
			public void doAction() {
				close();
			}

		})));

	}
	public void send(final Player player) {
		Application application = new Application(this.name, player);
		application.setForeName("fillForeNameBox.getText()");
		application.setSurName("fillSurNameBox.getText()");
		application.setSsn("fillSsnBox.getText()");
		Boolean canAdd = true;
		for (int i = 0; i < player.getApplications().size(); i++) {
			if (player.getApplications().get(i).getApplicationType() == application.getApplicationType()) {
				MessageBox.showMessageBox(getOwner(), "", application.getApplicationType()+" on jo käsittelyssä.");
				canAdd = false;
			}
		}
		if (canAdd) {
			player.addApplication(application);
			MessageBox.showMessageBox(getOwner(), "", "Hakemus lähetetty.");
			close();
		}
	}
}
