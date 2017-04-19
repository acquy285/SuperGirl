import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class server1{
    private class client1 extends Thread{
        BufferedReader read;
        BufferedWriter write;
        @Override
        public void run(){
            try{
                Socket s = new Socket("localhost", 4444);
                System.out.println("Connected voi Server chu!");
            } catch (IOException ex) {
                Logger.getLogger(server1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        @Override
        public void start(){
            while(true){
                System.out.println("abc");
            }
        }
    }
    
    public static void main(String[] args){
             
		try {  
                        Socket socket = new Socket("localhost",4444);
                        System.out.println("Da ket noi voi Server cha");
          		ServerSocket server = new ServerSocket(2500);
			Socket s = server.accept();
			System.out.println("Connected");
			} catch(IOException e) {}
	}
   
    }