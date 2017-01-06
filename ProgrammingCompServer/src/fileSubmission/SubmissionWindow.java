package fileSubmission;

import java.awt.Component;
import java.io.File;

import javax.swing.JFileChooser;

public class SubmissionWindow extends Component {
	private static final long serialVersionUID=1L;
	private JFileChooser chooser;
	private File choosen;
	private int returnVal=-9864;

	public SubmissionWindow() {
		chooser=new JFileChooser();
		returnVal=chooser.showOpenDialog(this);
		choosen=chooser.getSelectedFile();
	}

	public boolean chooserWorked() {
		return returnVal==JFileChooser.APPROVE_OPTION;
	}
	
	public File getFile() {
		return choosen;
	}
}
