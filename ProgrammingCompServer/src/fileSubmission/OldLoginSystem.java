package fileSubmission;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class OldLoginSystem {
	private ComboBoxDemo comboBox=new ComboBoxDemo();
	private JFrame frame=new JFrame();
	private boolean loginPressed=false;
	private JPanel mainPanel=new JPanel();
	private int problem=0;
	private JButton submitButton=new JButton("Choose File");
	private String username="";
	private JTextField usernameBox=new JTextField(10);
	private JLabel usernameLabel=new JLabel("Username: ");
	
	public OldLoginSystem() {
		setUpFrame();
	}
	
	public int getProblem() {
		return problem;
	}
	
	public String getUsername() {
		return username.replaceAll(" ", "").replaceAll("\t", "");
	}
	
	public boolean loginPressed() {
		return loginPressed;
	}
	
	private void onButtonPressed() {
		problem=comboBox.getSelected();
		username=usernameBox.getText();
		loginPressed=true;
		frame.setVisible(false);
	}
	
	private void setUpFrame() {
		final OldLoginSystem window=this;
		submitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				window.onButtonPressed();
			}
		});
		
		
		frame.add(mainPanel);
		mainPanel.setPreferredSize(new Dimension(250, 100));
		mainPanel.add(usernameLabel);
		mainPanel.add(usernameBox);
		mainPanel.add(comboBox);
		mainPanel.add(submitButton);
		frame.pack();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
