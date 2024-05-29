/**
 * Function: 读取聊天记录
 * Author:YBX
 * Time:Sun Mar 22 11:02:21 CST 2020
 *
 * */
import java.io.*;

public class Recorder{
	private File f;
	public Recorder(){
		f = new File("./chat/chatRecorder.qq");
	}

	public Recorder(String url){
		f = new File(url);
	}
	public void write(String message){
		try{
		 		FileWriter fw = new FileWriter(f, true);
				PrintWriter pw = new PrintWriter(fw);

				pw.println(message);

				pw.close();
				fw.close();
			}catch(Exception e){
		}
	}

	public String read(){
		String mess = "";
		try{
			FileReader fr = new FileReader(f);
		 	BufferedReader br = new BufferedReader(fr);

			while(br.ready()){
				mess += br.readLine()+"\n";
			}
		}	catch(Exception e){
		}
			return mess;
	}
}
