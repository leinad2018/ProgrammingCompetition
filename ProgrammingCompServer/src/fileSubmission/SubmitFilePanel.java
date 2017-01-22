package fileSubmission;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;

import generalPage.ContentTypes;
import generalPage.GeneralWindow;
import main.Main;

public class SubmitFilePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JButton chooseFileButton, submitButton;
	private File chosenFile = null;
	private ComboBoxDemo comboBox;
	private JLabel filePathLabel;
	private File lastFileDir;

	public SubmitFilePanel() {
		final SubmitFilePanel me = this;

		// Main.setToNotifyOnFileChoose(this);
		comboBox = new ComboBoxDemo();
		filePathLabel = new JLabel("No file choosen.");

		chooseFileButton = new JButton("Choose file...");
		chooseFileButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				File selected = tryToChooseFile();
				if (selected != null && selected.exists() && selected.canRead()) {
					submitButton.setEnabled(true);
					chosenFile = selected;
					setPathText(selected);
				} else {
					System.out.println("Could not Find/Read File");
				}
			}
		});

		submitButton = new JButton("Submit");
		submitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				me.onSubmitClicked();
			}
		});
		submitButton.setEnabled(false);

		add(comboBox);
		add(chooseFileButton);
		add(filePathLabel);
		add(submitButton);
	}

	public void onSubmitClicked() {
		Main.submitFileToServer(chosenFile, Main.username, comboBox.getSelected());
		GeneralWindow.main.setContentType(ContentTypes.VIEW_SUBMISSION_HISTORY);
	}

	public void setPathText(File file) {
		String path = chosenFile.getPath();
		if (path.length() > 25) {
			path = "..." + path.substring(path.length() - 22);
		}
		filePathLabel.setText(path);
	}

	public File tryToChooseFile() {
		JFileChooser chooser = new JFileChooser();
		if (lastFileDir != null)
			chooser.setCurrentDirectory(lastFileDir);
		int returnVal = chooser.showOpenDialog(this);
		lastFileDir = chooser.getCurrentDirectory();
		if (returnVal == JFileChooser.APPROVE_OPTION)
			return chooser.getSelectedFile();
		else
			return null; // throw?
	}

}