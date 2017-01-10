
package networking;

import java.io.IOException;
import java.net.ServerSocket;

import submission.Submittable;

public class MultiServer {
	
	private static volatile Submittable[] submittedThings=new Submittable[0];
	
	public static void main(String[] args) throws IOException {
		System.out.println("Server Started...");
		Process p = Runtime.getRuntime().exec("cmd /c start ..\\ProgComp\\MakeDirectories.bat "+ "..\\ProgComp " + MultiServerThread.users);
		System.out.println("Files created...");
		ServerSocket serverSocket=null;
		boolean listening=true;
		short port=9999;

		final long competitionStartTime=System.currentTimeMillis();
		try {
			serverSocket=new ServerSocket(port);
		} catch (IOException e) {
			System.err.println("Could not listen on port: "+port+"...");
			System.exit(-1);
		}

		Thread answerQuestionThread=new Thread(new AnswerQuestionThread());
		answerQuestionThread.start();
		System.out.println("thread started...");
		while (listening) {
			new MultiServerThread(serverSocket.accept(), competitionStartTime).start();
		}

		serverSocket.close();
	}
	
	public static void submitSomething(Submittable toSubmit) {
		Submittable[] newArray=new Submittable[submittedThings.length+1];
		for (int i=0; i<submittedThings.length; i++) {
			newArray[i]=submittedThings[i];
		}
		newArray[newArray.length-1]=toSubmit;
		submittedThings=newArray;
	}
	
	public static Submittable[] getSubmittedThings() {
		return submittedThings;
	}
}
