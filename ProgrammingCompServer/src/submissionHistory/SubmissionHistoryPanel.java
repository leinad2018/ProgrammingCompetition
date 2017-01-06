package submissionHistory;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.Main;
import networking.Client;

public class SubmissionHistoryPanel extends JPanel {
	
	private static final long serialVersionUID=1L;
	private JPanel[] panels;
	
	public SubmissionHistoryPanel() {
		String[][] history=Client.getSubmissionHistory(Main.username);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		panels=new JPanel[history.length];
		for (int i=0; i<panels.length; i++) {
			panels[i]=new JPanel();
			for (int j=0; j<4; j++) {
				if (j==1) {
					continue;
				}
				JLabel toAdd=new JLabel(history[i][j]);
				toAdd.setPreferredSize(new Dimension(100*(j+2), 20));
				panels[i].add(toAdd);
			}
			add(panels[i]);
		}
	}
	
	/*private static String format(String toFormat, int width) {
		if (toFormat.length()<width) {
			
		}
	}*/
}
