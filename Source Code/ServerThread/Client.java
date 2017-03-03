import java.io.*;
import java.net.*;

public class Client{
	public static void main(String[] args) throws UnknownHostException, IOException{
		String name = args[0];
		Socket socket = new Socket("localhost",4444);
		PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			String readerInput = bufferedReader.readLine();
			printWriter.println(name +":"+readerInput);
		}
	}
}