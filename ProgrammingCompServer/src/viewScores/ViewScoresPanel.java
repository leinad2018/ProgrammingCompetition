package viewScores;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.Main;
import networking.Client;

public class ViewScoresPanel extends JPanel {
	private static final long serialVersionUID=1L;

	public ViewScoresPanel() {
		String[][] toView=Client.viewScores(Main.username);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		JPanel[] panels=new JPanel[toView.length];
		for (int i=0; i<panels.length; i++) {
			panels[i]=new JPanel();
			for (int j=0; j<toView[i].length; j++) {
				JLabel toAdd=new JLabel(toView[i][j]);
				toAdd.setPreferredSize(new Dimension(110, 30));
				panels[i].add(toAdd);
			}
			add(panels[i]);
		}
	}
}
