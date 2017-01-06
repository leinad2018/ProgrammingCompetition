package loginPage;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginWindow {
	private JFrame frame;
	private JPanel mainPanel;
	private JLabel usernameLabel;
	private JTextField usernameTextBox;
	private JButton submitButton;
	private JLabel invalidLoginCredentials;
	public volatile boolean credentialsVerified=false;
	private String username;
	
	public LoginWindow() {
		frame=new JFrame();
		mainPanel=new JPanel();
		usernameLabel=new JLabel("Username:");
		usernameTextBox=new JTextField(10);
		submitButton=new JButton("Submit");
		final LoginWindow me=this;
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				me.onSubmitClicked();
			}
		});
		invalidLoginCredentials=new JLabel("                                                               ");
		mainPanel.setPreferredSize(new Dimension(250, 80));
		mainPanel.add(usernameLabel);
		mainPanel.add(usernameTextBox);
		mainPanel.add(submitButton);
		mainPanel.add(invalidLoginCredentials);
		
		frame.add(mainPanel);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
	}
	
	public void onSubmitClicked() {
		username=usernameTextBox.getText();
		if (verifyCredentials(username)) {
			frame.dispose();
			credentialsVerified=true;
		}
		else {
			System.out.println("Invalid");
			invalidLoginCredentials.setText("     Invalid Username/Password     ");
			usernameTextBox.setText("");
			usernameTextBox.requestFocus();
			frame.pack();
		}
	}
	
	public boolean verifyCredentials(String username) {
		return username.equals("asdf");
	}
	
	public boolean areCredentialsVerified() {
		return credentialsVerified;
	}
	
	public String getUsername() {
		return username;
	}
}
