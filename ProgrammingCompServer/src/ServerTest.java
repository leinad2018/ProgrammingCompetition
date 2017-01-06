import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerTest {

	public static void main(String[] args) {
		System.out.println("**********Server Program**************");
		int byteRead=0;
		try {
			ServerSocket serverSocket=new ServerSocket(9999);
			if (!serverSocket.isBound()) System.out.println("Sever Socket not Bounded...");
			else
				System.out.println("Server Socket bounded to Port : "+serverSocket.getLocalPort());

			Socket clientSocket=serverSocket.accept();
			if (!clientSocket.isConnected()) System.out.println("Client Socket not Connected...");
			else
				System.out.println("Client Socket Connected : "+clientSocket.getInetAddress());
			
			InputStream in=clientSocket.getInputStream();
			OutputStream os=new FileOutputStream("Test.txt");
			Scanner scanner=new Scanner(in);
			String toRead=scanner.nextLine();
			System.out.println("just got: "+toRead);
			byte[] byteArray=new byte[100];

			while ((byteRead=in.read(byteArray, 0, byteArray.length))!=-1) {
				os.write(byteArray, 0, byteRead);
				System.out.println("No. of Bytes Received : "+byteRead);
			}
			synchronized (os) {
				os.wait(10000);
			}
			os.close();
			serverSocket.close();
			
			System.out.println("File Received...");

		} catch (Exception e) {
			System.out.println("Server Exception : "+e.getMessage());
			e.printStackTrace();
		}
	}
}