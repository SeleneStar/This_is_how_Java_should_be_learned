/*
 * Fuction: 提供接收和发送信息的能力
 * Author:YBX
 * Time:Sun Mar 22 12:57:36 CST 2020
 *
 * */
import java.net.*;
import java.io.*;

public class Neter{
	private PrintWriter pw;
	private BufferedReader br;

	public Neter(Socket s){
		try{
			InputStream is = s.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			br = new BufferedReader(isr);

			OutputStream os = s.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			pw = new PrintWriter(osw, true);
		}catch(Exception e){
		}
	}

	public void send(String message){
		try{
			pw.println(message); 
		}catch(Exception e){
		}
	}
	public String receive(){
		String message = "";
		try{
			message = br.readLine(); 
		}catch(Exception e){
		}
		return message;
	}

}
