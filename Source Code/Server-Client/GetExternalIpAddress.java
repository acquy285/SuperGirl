import java.io.*;
import java.net.*;

public class GetExternalIpAddress {

    public static void main(String[] args) throws Exception {
        URL whatismyip = new URL("http://checkip.amazonaws.com");
		BufferedReader in = new BufferedReader(new InputStreamReader(whatismyip.openStream()));

		String ip = in.readLine(); //you get the IP as a String
		System.out.println(ip);
    }
}