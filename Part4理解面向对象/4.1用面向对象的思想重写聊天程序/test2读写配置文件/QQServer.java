/*
 * Fuction:QQserver服务端程序
 * Author:YBX
 * Time:Sun Mar 22 13:28:00 CST 2020
 *
 * */
import java.net.*;
import java.util.*;
import java.io.*;

public class QQServer{
	public static void main(String[] argv){
		try{
					HashMap<String, Neter> hm = new HashMap<String, Neter>();

					ServerSocket ss = new ServerSocket(8000);

					while(true){
						System.out.println("Listening ...");
						Socket s = ss.accept();
						Neter net = new Neter(s);

						MyService t = new MyService();
						t.setNeter(net);
						t.setHashMap(hm);
						t.start();
					}
		 }catch(Exception e){
		}
	}
	
	class MyService extends Thread{
		private Neter net;
		private HashMap<String, Neter> hm;
		public void setHashMap(HashMap hm){
			this.hm = hm;
		}
		public void setNeter(Neter net){
			this.net = net;
		}

		public void run(){
			try{
					String uandp = net.recevice();

					String u = uandp.split("%")[0];
					String p = uandp.split("%")[1];

					SQLer sql = new SQLer();
					if(sql.vail(u,p)){
						net.send("ok");
						
						//将本人的名字发送给其他用户
						for(Neter n:hm.values()){
							n.send("add%"+u);
						}

						//将其他人的名字发送给自己
						for(String tu:hm.keySet()){
							net.send("add%"+tu);
						}

						//将本人的用户名和Socket存入到HashMap
						hm.put(u, net);

						//不断接收客户端发送过来的信息
						while(true){
							String message = net.receive();
							if(message.equals("{exit}")){
								hm.remove(u);

								for(Neter n: hm.values()){
									n.send("exit%"+u);
								}
								return ;
							}

								String to = message.split("%")[0];
								String mess = message.split("%")[1];
								Neter n = hm.get(to);
								n.send("mess%"+mess);
						}
					}else{
						net.send("err");
					}
		 	}catch(Exception e){
			}
		}
	}
}

