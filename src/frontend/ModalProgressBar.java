package frontend;

import javax.swing.JDialog;
import javax.swing.JProgressBar;

public class ModalProgressBar extends JDialog {

	public ModalProgressBar() {
		super();
		JProgressBar dialog_progressBar = new JProgressBar();
		dialog_progressBar.setIndeterminate(true);
		dialog_progressBar.setVisible(true);
		this.getContentPane().add(dialog_progressBar);
		this.setSize(200, 50);
		this.setLocationRelativeTo(null);
		this.setTitle("Loading Dataset...");
	}
}
