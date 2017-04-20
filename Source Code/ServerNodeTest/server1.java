import java.io.*;
import java.net.*;

//-----------------------------------------------------------------------------------------------

public class Server1
{
    BufferedReader read = null;
    BufferedWriter write = null;

    
        // Client con + Server xu li
	public static void main(String[] args) throws IOException
            {
                
                new Server1().run();
                
            }
        public void run()throws IOException{
            Socket s = new Socket("Localhost", 4444);
   
                System.out.println("Da ket noi voi Server cha");
           ServerSocket ServerSocket = new ServerSocket(2500);
           System.out.println("San sang de ket noi");
           
           int Num =0;
           while(true){
               Socket SocketofServer = ServerSocket.accept();
               
               Num++;
               System.out.println("Da co " +Num +" ket noi");
               new ServerThread1(SocketofServer).start();
                PrintWriter PrintWriter = new PrintWriter(s.getOutputStream(), true);
                PrintWriter.println(" Server 1 dang co " +Num +" Client ket noi den.");
           }
        }  
     public class ServerThread1 extends Thread {
	Socket socket;
	ServerThread1(Socket socket){
		this.socket = socket;
	}
        @Override
	public void run(){
		try{
			String message = null;
                        BufferedWriter write = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			BufferedReader read = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while((message = read.readLine()) != null ){
                            //if(message.equals("get")){
                                
                            //}
				System.out.println("Client: " + message);	
			}
			socket.close(); // dong ket noi 
		}catch(IOException e){
			System.out.println("Khong co ket noi");
		}
	}
}
}