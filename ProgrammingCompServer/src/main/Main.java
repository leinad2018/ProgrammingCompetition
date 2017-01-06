package main;

import java.io.File;

import fileSubmission.SubmissionWindow;
import fileSubmission.SubmitFilePanel;
import generalPage.GeneralWindow;
import loginPage.LoginWindow;
import networking.Client;

public class Main {

	public static volatile File fileChosen=null;
	private static SubmitFilePanel toNotifyOnFileChoose=null;
	public static String username;
	
	public static void main(String[] args) {
		Client.clientInit();
		tryToLogin();
	}

	
	public static void wait(double seconds) {
		try {
			Thread.sleep((long)(seconds*1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void tryToLogin() {
		LoginWindow loginWindow=new LoginWindow();
		while (!loginWindow.areCredentialsVerified()) {
			wait(0.1);
		}
		username=loginWindow.getUsername();
		openGeneralWindow();
	}
	
	public static void openGeneralWindow() {
		GeneralWindow mainWindow=new GeneralWindow();
	}
	
	public static File tryToChooseFile() {
		SubmissionWindow selectionWindow=new SubmissionWindow();
		//If it worked, return the file, otherwise, return null
		if (selectionWindow.chooserWorked()) {			
			fileChosen=selectionWindow.getFile();
			if (toNotifyOnFileChoose!=null) {
				toNotifyOnFileChoose.onFileChoose(fileChosen);
			}
		}
		else {
			fileChosen=null;
		}
		return fileChosen;
	}
	
	public static void setToNotifyOnFileChoose(SubmitFilePanel newPanel) {
		toNotifyOnFileChoose=newPanel;
	}
	
	public static void submitFileToServer(File toSubmit, String username, int questionNumber) {
		Client.submitFile(username, questionNumber, toSubmit.getPath());
	}
	
	public static void submitRequestForClarification(String clarification, String username, int questionNumber) {
		Client.submitRequestForClarification(username, questionNumber, clarification);
	}
}
