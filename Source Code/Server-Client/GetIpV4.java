import java.net.*;

public class GetIpV4 {

	public static void main(String[] args) {

	  InetAddress ip;
	  try {
		ip = InetAddress.getLocalHost();
		System.out.println("Current IP address : " + ip.getHostAddress());
	  } catch (UnknownHostException e) {
		e.printStackTrace();
	  }
	}
}