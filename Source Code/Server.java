import java.net.*;
import java.io.*;
 
public class Server1
{
    public static void main(String[] args) throws Exception
	{
		Server1 SERVER = new Server1();
		SERVER.run();
	}
	
	
	public void run() throws Exception
	{
		ServerSocket SVSOCK = new ServerSocket (0001);
		Socket SOCK = SVSOCK.accept();
		InputStreamReader IR = new InputStreamReader (SOCK.getInputStream());
		BufferedReader BR = new BufferedReader (IR);
		
		String MESS = BR.readLine();
		System.out.println(MESS);
		
		If(MESS != null)
		{
			PrinntStream PS = new PrintStream(SOCK.getOuputStream());
			PS.println ("We have received a new Messege" + MESS);
		}
	}
}