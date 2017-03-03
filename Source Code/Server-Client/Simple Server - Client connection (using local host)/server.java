import java.net.*;

public class server {
	
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(2500);
			Socket s = server.accept();
			
			
			System.out.println("Connected");
			} catch(Exception e) {}
	}
	
}