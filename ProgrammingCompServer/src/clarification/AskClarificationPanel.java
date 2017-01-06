package clarification;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import fileSubmission.ComboBoxDemo;
import generalPage.ContentTypes;
import generalPage.GeneralWindow;
import main.Main;

public class AskClarificationPanel extends JPanel {
	private static final long serialVersionUID=1L;

	private JLabel whichQuestionLabel;
	private ComboBoxDemo questionComboBox;
	private JTextArea textArea;
	private JButton submitRequestButton;
	
	public AskClarificationPanel() {
		final AskClarificationPanel me=this;
		whichQuestionLabel=new JLabel("Which Question?");
		questionComboBox=new ComboBoxDemo();
		textArea=new JTextArea("", 7, 30);
		submitRequestButton=new JButton("Submit Request");
		submitRequestButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				me.onSubmitRequestButtonPressed();
			}
		});

		add(whichQuestionLabel);
		add(questionComboBox);
		add(textArea);
		add(submitRequestButton);
	}
	
	
	public void onSubmitRequestButtonPressed() {
		Main.submitRequestForClarification(textArea.getText(), Main.username, questionComboBox.getSelected());
		GeneralWindow.main.setContentType(ContentTypes.VIEW_SUBMISSION_HISTORY);
	}
}
