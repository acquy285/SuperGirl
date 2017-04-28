/*
Source:
*/

//--------------------------------------------------------------------------------------------------
import java.io.*;
import java.net.*;

//--------------------------------------------------------------------------------------------------
public class ServerThread extends Thread
{
        
	Socket socket;
	ServerThread(Socket socket)
        {
		this.socket = socket;
	}
	
	//----------------------------------------------------------------------------------------------
	public void run()
        {
		try
                {
			String message = null;
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream())); // Create input stream
			while((message = bufferedReader.readLine()) != null )
                        {
				System.out.println("Client 1:" + message);	// Show message from Client
			}
			socket.close(); // Close connection
		}catch(IOException e)
                {
                        
			System.out.println("Closing connection with IP: " + socket.getInetAddress());
		}
	}
}


