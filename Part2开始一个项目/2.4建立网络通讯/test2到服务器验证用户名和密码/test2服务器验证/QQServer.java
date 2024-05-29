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
		
			String uandp = br.readLine();

			String u = uandp.split("%")[0];
			String p = uandp.split("%")[1];

			//这里假定用户名是 aaa， 密码是 111
			OutputStream os = s.getOutputStream() ;
			OutputStreamWriter osw = new OutputStreamWriter(os) ;
			PrintWriter pw = new PrintWriter(osw , true) ;
	
			if(u.equals("aaa")&&p.equals("111")){
				pw.println("ok") ;
			}else {
				pw.println("err") ;
			}	
		}catch(Exception e){}
	}
}