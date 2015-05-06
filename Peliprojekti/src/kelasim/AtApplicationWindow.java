package kelasim;

import com.googlecode.lanterna.gui.dialog.MessageBox;

public class AtApplicationWindow extends ApplicationWindow {

	public AtApplicationWindow(String title, Player player) {
		super(title, player);
		this.instructions.setText("Asumistukihakemus");
	}
	
	
	public void send(final Player player) {
		Application atApplication = new AtApplication(this.name, player);
		atApplication.setForeName(fillForeNameBox.getText());
		atApplication.setSurName(fillSurNameBox.getText());
		atApplication.setSsn(fillSsnBox.getText());
		Boolean canAdd = true;
		for (int i = 0; i < player.getApplications().size(); i++) {
			if (player.getApplications().get(i) instanceof AtApplication) {
				MessageBox.showMessageBox(getOwner(), "", atApplication.getApplicationType()+" on jo käsittelyssä.");
				canAdd = false;
			}
		}
		if (canAdd) {
			player.addApplication(atApplication);
			MessageBox.showMessageBox(getOwner(), "Viesti Kelalta", "Hakemus vastaanotettu.");
			close();
		}
	}
}
