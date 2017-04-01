/*
Các ngu?n dùng d? làm project
Source:
.......
*/

//-----------------------------------------------------------------------------------------------
//Các thu vi?n c?n import
import java.io.*;
import java.net.*;

//-----------------------------------------------------------------------------------------------

public class Server
{
        
	public static void main(String[] args) throws IOException
        {
		new Server().Run(); // goi ham khoi chay Server
	}
	public void Run() throws IOException
        {
		ServerSocket s = new ServerSocket(0); // Tao serversocket co cong PORT den Server lang nghe
		System.out.println("San sang de ket noi!");
		while(true)
            { 
			Socket socket = s.accept(); // Chap nhan ket noi tu Client 
            System.out.println("Da nhan ket noi tu: " +s.getInetAddress() + s.getLocalPort());
			new ServerThread(socket).start(); // Khoi dong Thread de phuc vu Client 
                        
		    }
        }
}