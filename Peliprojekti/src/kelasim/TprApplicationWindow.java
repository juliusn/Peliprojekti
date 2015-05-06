package kelasim;

import com.googlecode.lanterna.gui.dialog.MessageBox;

public class TprApplicationWindow extends ApplicationWindow {

	public TprApplicationWindow(String title, Player player) {
		super(title, player);
		this.instructions.setText("Työttömyyspäivärahahakemus");
	}
	
	
	public void send(final Player player) {
		Application tprApplication = new TprApplication(this.name, player);
		tprApplication.setForeName(fillForeNameBox.getText());
		tprApplication.setSurName(fillSurNameBox.getText());
		tprApplication.setSsn(fillSsnBox.getText());
		Boolean canAdd = true;
		for (int i = 0; i < player.getApplications().size(); i++) {
			if (player.getApplications().get(i) instanceof TprApplication) {
				MessageBox.showMessageBox(getOwner(), "", tprApplication.getApplicationType()+" on jo käsittelyssä.");
				canAdd = false;
			}
			/*
			if (player.getApplications().get(i).getApplicationType().equals(tprApplication.getApplicationType())) {
				MessageBox.showMessageBox(getOwner(), "", tprApplication.getApplicationType()+" on jo käsittelyssä.");
				canAdd = false;
			}*/
		}
		if (canAdd) {
			player.addApplication(tprApplication);
			MessageBox.showMessageBox(getOwner(), "Viesti Kelalta", "Hakemus vastaanotettu.");
			close();
		}
	}
}
