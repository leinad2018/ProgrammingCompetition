package fileSubmission;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import generalPage.ContentTypes;
import generalPage.GeneralWindow;
import main.Main;

public class SubmitFilePanel extends JPanel {
	private static final long serialVersionUID=1L;
	private ComboBoxDemo comboBox;
	private JButton chooseFileButton, submitButton;
	private JLabel fileChosen;
	private File chosenOne=null;

	public SubmitFilePanel() {
		final SubmitFilePanel me=this;
		
		Main.setToNotifyOnFileChoose(this);
		comboBox=new ComboBoxDemo();
		chooseFileButton=new JButton("Choose file...");
		chooseFileButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.tryToChooseFile();
			}
		});
		fileChosen=new JLabel("No file choosen.");
		submitButton=new JButton("Submit");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				me.onSubmitClicked();
			}
		});
		submitButton.setEnabled(false);
		add(comboBox);
		add(chooseFileButton);
		add(fileChosen);
		add(submitButton);
	}
	
	public void onFileChoose(File choosen) {
		chosenOne=choosen;
		submitButton.setEnabled(true);
		String path=chosenOne.getPath();
		if (path.length()>25) {
			path="..."+path.substring(path.length()-22);
		}
		fileChosen.setText(path);
	}
	
	public void onSubmitClicked() {
		Main.submitFileToServer(chosenOne, Main.username, comboBox.getSelected());
		GeneralWindow.main.setContentType(ContentTypes.VIEW_SUBMISSION_HISTORY);
	}
}
