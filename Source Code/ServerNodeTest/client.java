import java.io.*;
import java.net.*;

public class Client{
	public static void main(String[] args) throws UnknownHostException, IOException{
		String name = args[0];
                int port = 4444;
                //for(port = 2000;port < 5000;port++)
                while(true){
		Socket socket = new Socket("localhost",port);
       
		PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
                String readerInput = null;
		while(true){
			readerInput = read.readLine();
			printWriter.println(name +" send :  "+readerInput); 
			if(readerInput.equals("yes")){
                            break;
                            
                        }
                }
		socket.close();
                port = 2500;

                }
        }
}