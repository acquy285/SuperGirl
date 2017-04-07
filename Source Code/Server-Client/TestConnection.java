/*
Youtube : https://www.youtube.com/user/TechWorld3g 
*/
import java.net.*;

public class TestConnection {
	
	public static void main(String[] args) {
		new TestConnection().InternetConnection();
	}
	
	//-----------------------------------------------------------------------
	public void InternetConnection()
    {
        Socket sock = new Socket();
        InetSocketAddress addr = new InetSocketAddress("www.google.com",80); 

        try
        {
            sock.connect(addr,3000);//3000 ms = 3s
            System.out.println("You are connected!!");
        }
        catch (Exception e)
        {
            System.out.println("Please check your Internet Connection!");
        }
        finally
        {
            try
            {
                sock.close();
            }
            catch (Exception e)
            {

            }
        }
    }
}