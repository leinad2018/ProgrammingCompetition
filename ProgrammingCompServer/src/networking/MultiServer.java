
package networking;

import java.io.IOException;
import java.net.ServerSocket;

import submission.Submittable;

public class MultiServer {
	
	private static volatile Submittable[] submittedThings=new Submittable[0];
	
	public static void main(String[] args) throws IOException {
		System.out.println("Server Started...");
		ServerSocket serverSocket=null;
		boolean listening=true;
		short port=9999;

		try {
			serverSocket=new ServerSocket(port);
		} catch (IOException e) {
			System.err.println("Could not listen on port: "+port+"...");
			System.exit(-1);
		}

		while (listening) {
			new MultiServerThread(serverSocket.accept()).start();
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
