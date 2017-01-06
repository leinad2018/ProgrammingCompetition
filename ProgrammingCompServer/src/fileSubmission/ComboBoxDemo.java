package fileSubmission;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import networking.Formatter;
import submission.ProblemSubmission;

public class ComboBoxDemo extends JPanel {

	private static final long serialVersionUID=1L;
	private static JComboBox<String> petList;
	
	
	public ComboBoxDemo() {
		super(new BorderLayout());

		String[] petStrings=new String[Formatter.problems];
		for(int i = 0; i < petStrings.length; i++){
			petStrings[i] = ProblemSubmission.questionNumberToQuestionName(i);
		}

		petList=new JComboBox<String>(petStrings);
		petList.setSelectedIndex(4);
		petList.getSelectedIndex();
		add(petList, BorderLayout.PAGE_START);
		setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
	}

	/*private static void createAndShowGUI() {
		JFrame frame=new JFrame("ComboBoxDemo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JComponent newContentPane=new ComboBoxDemo();
		newContentPane.setOpaque(true); // content panes must be opaque
		frame.setContentPane(newContentPane);

		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		createAndShowGUI();
	}*/
	
	public int getSelected() {
		return petList.getSelectedIndex();
	}
}