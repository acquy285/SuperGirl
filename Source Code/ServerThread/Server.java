import java.io.*;
import java.net.*;

public class Server{
	public static final int PORT = 4444;
	public static void main(String[] args) throws IOException{
		new Server().runServer();
	}
	public void runServer() throws IOException{
		ServerSocket serverSocket = new ServerSocket(PORT);
		System.out.println("San sang de ket noi!");
		while(true){
			Socket socket = serverSocket.accept();
			new ServerThread(socket).start();
		}
	}
}