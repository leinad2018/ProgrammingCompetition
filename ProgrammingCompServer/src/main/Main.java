package main;

import java.io.File;

import generalPage.GeneralWindow;
import loginPage.LoginWindow;
import networking.Client;

public class Main {

	public static String username;

	public static void main(String[] args) {
		Client.clientInit();
		tryToLogin();
	}

	public static void wait(double seconds) {
		try {
			Thread.sleep((long) (seconds * 1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void tryToLogin() {
		LoginWindow loginWindow = new LoginWindow();
		while (!loginWindow.areCredentialsVerified()) {
			wait(0.1);
		}
		username = loginWindow.getUsername();
		openGeneralWindow();
	}

	public static void openGeneralWindow() {
		GeneralWindow mainWindow = new GeneralWindow();
	}

	public static void submitFileToServer(File toSubmit, String username, int questionNumber) {
		Client.submitFile(username, questionNumber, toSubmit.getPath());
	}

	public static void submitRequestForClarification(String clarification, String username, int questionNumber) {
		Client.submitRequestForClarification(username, questionNumber, clarification);
	}
}
