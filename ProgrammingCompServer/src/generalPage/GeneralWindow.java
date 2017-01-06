package generalPage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import clarification.AskClarificationPanel;
import fileSubmission.SubmitFilePanel;
import submissionHistory.SubmissionHistoryPanel;
import viewScores.ViewScoresPanel;

public class GeneralWindow {
	private JFrame frame;
	private JPanel mainPanel, buttonsPanel, contentPanel;
	private JButton viewScores, submitSolution, askClarification, viewSubmissionHistory;
	private ContentTypes currentContentType=ContentTypes.VIEW_SCORES;
	private JLabel contentLabel;
	public static GeneralWindow main;
	
	public GeneralWindow() {
		main=this;
		frame=new JFrame();
		mainPanel=new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		frame.add(mainPanel);
		setUpButtons();
		setUpContent();
		setContentType(ContentTypes.VIEW_SCORES);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	private void setUpButtons() {
		final GeneralWindow me=this;
		viewScores=new JButton("View Scores");
		viewScores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				me.setContentType(ContentTypes.VIEW_SCORES);
			}
		});
		submitSolution=new JButton("Submit Solution");
		submitSolution.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				me.setContentType(ContentTypes.SUBMIT_SOLUTION);
			}
		});
		askClarification=new JButton("Ask Clarification");
		askClarification.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				me.setContentType(ContentTypes.ASK_CLARIFICATION);
			}
		});
		viewSubmissionHistory=new JButton("View Submission History");
		viewSubmissionHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				me.setContentType(ContentTypes.VIEW_SUBMISSION_HISTORY);
			}
		});

		buttonsPanel=new JPanel();
		buttonsPanel.add(viewScores);
		buttonsPanel.add(submitSolution);
		buttonsPanel.add(askClarification);
		buttonsPanel.add(viewSubmissionHistory);

		mainPanel.add(buttonsPanel);
	}

	private void setUpContent() {
		contentPanel=new JPanel();
		mainPanel.add(contentPanel);
		contentLabel=new JLabel("This is the contentPanel");
		contentPanel.add(contentLabel);
	}

	public void setContentType(ContentTypes newContentType) {
		this.currentContentType=newContentType;
		updateContentType();
	}
	
	public void updateContentType() {
		switch(currentContentType) {
		case ASK_CLARIFICATION:
			contentPanel.removeAll();
			contentPanel.add(new AskClarificationPanel());
			frame.pack();
			break;
		case SUBMIT_SOLUTION:
			contentPanel.removeAll();
			contentPanel.add(new SubmitFilePanel());
			frame.pack();
			break;
		case VIEW_SCORES:
			contentPanel.removeAll();
			contentPanel.add(new ViewScoresPanel());
			frame.pack();
			break;
		case VIEW_SUBMISSION_HISTORY:
			contentPanel.removeAll();
			contentPanel.add(new SubmissionHistoryPanel());
			frame.pack();
			break;
		default:
			System.out.println("Invalid Content Type!");
			throw new Error("Invalid Content Type!");
		}
	}
}
