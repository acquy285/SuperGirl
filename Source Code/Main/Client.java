import java.io.*;
import java.net.*;

public class Client
{
	public static void main(String[] args) throws UnknownHostException, IOException
        {
        String tenClient = args[0];
        
        Socket socket = new Socket("localhost",4444); //Tao client Socket de ket noi den Server
        
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true); // Tao output stream ket noi den Socket
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in)); // Tao input stream
        while(true)
			{
			String readerInput = bufferedReader.readLine();
			printWriter.println(tenClient +":" +readerInput);
			}
	
        }
}