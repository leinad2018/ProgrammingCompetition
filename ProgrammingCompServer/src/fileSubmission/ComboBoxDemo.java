package fileSubmission;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class ComboBoxDemo extends JPanel {

	private static final long serialVersionUID=1L;
	private static JComboBox<String> petList;
	
	
	public ComboBoxDemo() {
		super(new BorderLayout());

		String[] petStrings= {"Bird", "Cat", "Dog", "Rabbit", "Pig"};

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