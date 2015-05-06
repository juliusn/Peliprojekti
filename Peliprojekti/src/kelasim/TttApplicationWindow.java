package kelasim;

import com.googlecode.lanterna.gui.dialog.MessageBox;

public class TttApplicationWindow extends ApplicationWindow {

	public TttApplicationWindow(String title, Player player) {
		super(title, player);
		this.instructions.setText("Asumistukihakemus");
	}
	
	
	public void send(final Player player) {
		Application tttApplication = new TttApplication(this.name, player);
		tttApplication.setForeName("fillForeNameBox.getText()");
		tttApplication.setSurName("fillSurNameBox.getText()");
		tttApplication.setSsn("fillSsnBox.getText()");
		Boolean canAdd = true;
		for (int i = 0; i < player.getApplications().size(); i++) {
			if (player.getApplications().get(i) instanceof TttApplication) {
				MessageBox.showMessageBox(getOwner(), "", tttApplication.getApplicationType()+" on jo käsittelyssä.");
				canAdd = false;
			}
		}
		if (canAdd) {
			player.addApplication(tttApplication);
			MessageBox.showMessageBox(getOwner(), "Viesti Kelalta", "Hakemus vastaanotettu.");
			close();
		}
	}
}


