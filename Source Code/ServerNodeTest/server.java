
//-----------------------------------------------------------------------------------------------
//Các thu vi?n c?n import
import java.io.*;
import java.net.*;

//-----------------------------------------------------------------------------------------------

public class Server
{
        
	public static void main(String[] args) throws IOException
        {
		new Server().Run(); 
	}
      
       
	public void Run() throws IOException
        {
            int Num = 0;
		ServerSocket s = new ServerSocket(4444);
		System.out.println("San sang de ket noi!");
                Socket socket = null;
		while(true){
                    
			socket = s.accept();
                        System.out.println("Da ket noi");
                        //Num++;
                        //System.out.println("Dang co " +Num +" client ket noi");
       
			new ServerThread(socket).start(); 
                        
		    }
        }
        
        // Thread cho Server
        public class ServerThread extends Thread {
	Socket socket;
	ServerThread(Socket socket){
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