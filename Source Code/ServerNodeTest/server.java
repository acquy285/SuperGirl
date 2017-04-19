
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class server{
    public static void main(String[] args) throws IOException{
        Socket socket;
        BufferedReader read;
        BufferedWriter write;
        PrintWriter print;
        System.out.println("San sang ket noi");
        try{
            
            while(true){
                
                   ServerSocket s = new ServerSocket(4444);
                   socket = s.accept();
                   new serverThread(socket).start();
                   //
                   System.out.println("Da ket noi.");
                   DataInputStream din = new DataInputStream(socket.getInputStream());
                   DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
                   //
                   read = new BufferedReader(new InputStreamReader(System.in));
                   write = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                   String tinnhan = "", tingui ="";
                   
                   while(!tinnhan.equals("end")){
                       tinnhan = din.readUTF();
                       System.out.println("Client:" +tinnhan);
                       tingui = read.readLine();
                       dout.writeUTF(tingui);
                       dout.flush();
                   }
                   s.close();
            }
        }catch(IOException e){}
    }
    private static class serverThread extends Thread{
        Socket socket;
        serverThread(Socket socket){
            this.socket = socket;
        }
        @Override
        public void run(){
            System.out.println("Ung lam");
        }
    }
    
}