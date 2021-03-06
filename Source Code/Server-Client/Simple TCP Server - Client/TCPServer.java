/*
Source from: https://systembash.com/a-simple-java-tcp-server-and-tcp-client/
*/


import java.io.*;
import java.net.*;

public class TCPServer {
   public static void main(String argv[]) throws Exception {
	   
	   
        String clientSentence;
        String capitalizedSentence;
        ServerSocket welcomeSocket = new ServerSocket(4444);

        while(true)
        {
            Socket connectionSocket = welcomeSocket.accept();
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
			
			//---------------------------------------------------------------------------------------------------------
			
            clientSentence = inFromClient.readLine();
            System.out.println("Received: " + clientSentence);
            outToClient.writeBytes("RECEIVED!!" + "\n");
        }
    }
}
