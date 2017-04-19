
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class client extends Thread{
    public static void main(String[] args) throws IOException{
        Socket socket;
        int port =4444;
        BufferedReader read;
        BufferedWriter write;
        PrintWriter print;
        while(true){
        try{
           Socket s = new Socket("localhost",port);
           System.out.println("Da ket noi den server!");
           DataInputStream din = new DataInputStream(s.getInputStream());
           DataOutputStream dout = new DataOutputStream(s.getOutputStream());
           
           read = new BufferedReader(new InputStreamReader(System.in));
           //write = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
           
           String tinnhan="", tingui="";
           while(!tinnhan.equals("end")){
               if(tinnhan.equals("get")){
                   port = 2500;
               }
                tingui = read.readLine();
                dout.writeUTF(tingui);
                tinnhan = din.readUTF();
                System.out.println("Server: " +tinnhan);       
                }
        }catch(IOException e){
            System.out.println("Ngat ket noi");
        }
    }
    }
}