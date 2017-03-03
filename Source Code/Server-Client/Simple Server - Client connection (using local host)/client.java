import java.net.*;

public class client {
	public static void main(String[] args) throws UnknownHostException {
		try {
			Socket s = new Socket("127.0.0.1",2500);
			System.out.println("Connected!!!");
			
			} catch(Exception e){}
	}
}