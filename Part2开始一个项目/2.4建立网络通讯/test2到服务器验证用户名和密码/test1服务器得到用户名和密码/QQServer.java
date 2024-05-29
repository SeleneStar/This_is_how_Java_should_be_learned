import java.net.*;
import java.io.*;

public class QQServer {
	public static void main(String[] args) {
		try{
			ServerSocket ss = new ServerSocket(8000) ;
		
			System.out.println("Listening ... ") ;
			Socket s = ss.accept() ;
			
			InputStream is = s.getInputStream() ;
			InputStreamReader isr = new InputStreamReader(is) ;
			BufferedReader br = new BufferedReader(isr) ;
		
			String uandp = br.readLine() ;
			
			System.out.println(uandp);
		}catch(Exception e){}
	}
}