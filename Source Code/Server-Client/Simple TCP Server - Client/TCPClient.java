/*
Source from: https://systembash.com/a-simple-java-tcp-server-and-tcp-client/
*/


import java.io.*;
import java.net.*;

public class TCPClient {
	public static void main(String argv[]) throws Exception {
		
		//Declaration Section
		String sentence;
		String modifiedSentence;
		
		//----------------------------------------------------------------------------------
		
		while(true) {
			Socket clientSocket = new Socket("localhost", 4444);
			BufferedReader inFromUser = new BufferedReader( new InputStreamReader(System.in));
			DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
			BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		
		//----------------------------------------------------------------------------------
		
			System.out.println("Message to Server: ");
			sentence = inFromUser.readLine();
			outToServer.writeBytes(sentence + '\n');
			modifiedSentence = inFromServer.readLine();
			System.out.println("FROM SERVER: " + modifiedSentence);
		}
	}
}