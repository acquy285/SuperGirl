import java.io.*;
import java.net.*;

public class ServerThread extends Thread
{
        
	Socket socket;
	ServerThread(Socket socket)
        {
		this.socket = socket;
	}
	public void run()
        {
		try
                {
			String message = null;
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream())); // tao luong input
			while((message = bufferedReader.readLine()) != null )
                        {
				System.out.println("Client: " + message);	// hien thi massage ma Client gui den
			}
			socket.close(); // dong ket noi 
		}catch(IOException e)
                {
                        
			System.out.println("Da ngat ket noi voi" + socket.getInetAddress());
		}
	}
}


