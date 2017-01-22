package networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Scanner;

import fileIO.FileLoader;

public class Client {
	
	private static BufferedReader in=null;
	private static Socket kkSocket=null;
	private static PrintWriter out=null;
	public static String serverIP="192.168.1.96";
	
	public static void clientInit() {
		Scanner s=null;
		try {
			s=new Scanner(new URL("http://wumbogames.github.io/secret/publicip.txt").openStream());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//serverIP=s.nextLine();
		try {
			kkSocket=new Socket(serverIP, 9999);
			out=new PrintWriter(kkSocket.getOutputStream(), true);
			in=new BufferedReader(new InputStreamReader(kkSocket.getInputStream()));
		} catch (UnknownHostException e) {
			System.err.println("Don't know about host: localhost.");
			System.exit(1);
		} catch (IOException e) {
			System.err.println("Couldn't get I/O for the connection.");
			System.exit(1);
		}
	}
	
	/*public static void main(String[] args) throws IOException {
		System.out.println("Client starting...");
		
		clientInit();
		
		out.println("Hello World!");
		submitFile("DavidHarmeyer", 5, "C:/Users/David/Documents/Unity/asdf.txt");
		submitRequestForClarification("yoyoyo", 3, "Help I don't get it lol");
		
		System.out.println("Closing everything...");
		out.close();
		in.close();
		kkSocket.close();
		
	}*/
	
	
	public static String[][] getSubmissionHistory(String username) {
		out.println("get submission history");
		out.println(username);
		ArrayList<String> read=new ArrayList<String>();
		try {
			String lastLine=in.readLine();
			while (lastLine.startsWith("fake:")) {
				read.add(lastLine);
				lastLine=in.readLine();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		String[][] toReturn=new String[read.size()/4][4];
		for (int x=0; x<toReturn.length; x++) {
			for (int y=0; y<4; y++) {
				toReturn[x][y]=read.get(x*4+y).substring(5);
			}
		}
		return toReturn;
	}
	
	public static void submitFile(String username, int problem, String filePath) {
		out.println("submit file");
		out.println(username);
		out.println(problem+"");
		
		if (FileLoader.fileExists(filePath)) {
			String[] fileAsStrings=FileLoader.readFile(filePath);
			for (String s:fileAsStrings) {
				out.println("fake:"+s);
			}
			out.println("done");
		}
		else {
			System.out.println("File doesn't exist");
		}
	}
	
	public static void submitRequestForClarification(String username, int problem, String request) {
		out.println("request clarification");
		out.println(username);
		out.println(problem+"");
		out.println("fake:"+request.replaceAll("\n", "\nfake:"));
		out.println("done");
	}
	
	public static boolean verifyUsername(String username){
		out.println("verify username");
		out.println(username);
		try {
			return in.readLine().equals("Yes");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static String[][] viewScores(String username) {
		out.println("view scores");
		out.println(username);
		int columns=0;
		ArrayList<String> read=new ArrayList<String>();
		try {
			columns=Integer.parseInt(in.readLine());
			String lastLine=in.readLine();
			while (lastLine.startsWith("fake:")) {
				read.add(lastLine);
				lastLine=in.readLine();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		String[][] toReturn=new String[read.size()/columns][columns];
		for (int x=0; x<toReturn.length; x++) {
			for (int y=0; y<columns; y++) {
				toReturn[x][y]=read.get(x*columns+y).substring(5);
			}
		}
		return toReturn;
	}
}

