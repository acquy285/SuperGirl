/*
Các ngu?n dùng d? làm project
Source:
.......
*/

//-----------------------------------------------------------------------------------------------
//Các thu vi?n c?n import
import java.io.*;
import java.net.*;
import java.util.Scanner;

//-----------------------------------------------------------------------------------------------

public class Client extends Thread {
	
	private final Socket socket;
    private final InputStream in;
    private final OutputStream out;

    public Client(String serverAddress, int serverPort) throws UnknownHostException, IOException {
        socket = new Socket(InetAddress.getByName(serverAddress), serverPort);
        in = socket.getInputStream();
        out = socket.getOutputStream();
    }

    private void send(String message) throws IOException {
        out.write(message.getBytes());
    }
	
	/*private void getMACaddress(StringBuilder sb) {
		InetAddress ip;
		try {

			ip = InetAddress.getLocalHost();

			NetworkInterface network = NetworkInterface.getByInetAddress(ip);

			byte[] mac = network.getHardwareAddress();

			//System.out.print("Current MAC address : ");

			sb = new StringBuilder();
			for (int i = 0; i < mac.length; i++) {
				sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
			}
			//System.out.println(sb.toString());

		} catch (UnknownHostException e) {

			e.printStackTrace();

		} catch (SocketException e){

			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
        }
	}*/

    @Override
    public void run() {
        byte[] buffer = new byte[2048];
        try {
            while (true) {
                int receivedBytes = in.read(buffer);
                if (receivedBytes < 1)
                    break;
                String message = new String(buffer, 0, receivedBytes);
                System.out.println("Message from " + message);
            }
        } catch (IOException e) {}
        close();
        System.exit(0);
    }

    private void close() {
        try {
            socket.close();
        } catch (IOException e) {
        }
    }

    public static void main(String[] args) {
		
		String serverName = args[0];
		
        Scanner scanner = new Scanner(System.in);
        Client client = null;
		StringBuilder sb = null;
        String username = scanner.nextLine();
		Socket checkSocket = new Socket();
		
		InetSocketAddress addr = new InetSocketAddress("www.google.com",80); 
		
		try
		{
			checkSocket.connect(addr,3000);
			System.out.println("You are connected!!");
			try {
				
				client = new Client(serverName, 4444);
				
				System.out.println("Username: ");
				client.send(username);
				client.start();
				while (true) {
					String message = scanner.nextLine();
					System.out.println("Message: ");
					client.send(message);
				}
			} catch (UnknownHostException e) {
				System.err.println("Don't know about host: " + serverName);
			} catch (IOException e) {
				System.err.println("Couldn't get I/O for the connection to: " + serverName);
			} 
			if (client != null)
				client.close();
			scanner.close();
		}
		catch (IOException e) {
		System.out.println("Please check your Internet Connection!");
		}
    }
}