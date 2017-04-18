/*
Các ngu?n dùng d? làm project
Source:
http://sontx.blogspot.com/2016/06/chatroom-su-dung-tcp-socket.html
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
	
	 private void sendMAC(String MacAddress) throws IOException {
        out.write(MacAddress.getBytes());
    }
	
	private void getMACaddress() {
		InetAddress ip;
		try {

			ip = InetAddress.getLocalHost();

			NetworkInterface network = NetworkInterface.getByInetAddress(ip);

			byte[] mac = network.getHardwareAddress();

			//System.out.print("Current MAC address : ");

			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < mac.length; i++) {
				sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
			}
			//System.out.println(sb.toString());
			sendMAC(sb.toString());
			
		} catch (UnknownHostException e) {

			e.printStackTrace();

		} catch (SocketException e){

			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
        }
	}

    @Override
    public void run() {
        byte[] buffer = new byte[2048];
        try {
			int receivedBytes = in.read(buffer);
			//String MacAddress = new String(buffer, 0, receivedBytes);
			//System.out.println("Connection from Mac Address: " + MacAddress);
            while (true) {
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
        String username = scanner.nextLine();
		Socket checkSocket = new Socket();
		
		InetSocketAddress addr = new InetSocketAddress("www.google.com",80); 
		
		try
		{
			//check connection, if connect then continue
			checkSocket.connect(addr,3000);
			System.out.println("You are connected!!");
			try {
				//connect to server at port 4444
				client = new Client(serverName, 4444);
				//run class get mac address of client and send it to server
				client.getMACaddress();
				//login with username and begin to send message
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
			//close client socket
			if (client != null)
				client.close();
			scanner.close();
		}
		//if not connect then print and close
		catch (IOException e) {
		System.out.println("Please check your Internet Connection!");
		}
    }
}