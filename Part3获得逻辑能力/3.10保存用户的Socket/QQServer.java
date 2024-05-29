import java.net.*;
import java.io.*;
import java.sql.*;
import java.util.*;

public class QQServer {
	public static void main(String[] args) {
		try {
			//声明存放所有人的Socket的集合
		  HashMap<String,Socket> hm=new HashMap<String,Socket>();
			
			// 服务器在8000端口监听
			ServerSocket ss = new ServerSocket(8000);

			while (true) {
				System.out.println("服务器正在8000端口监听......");
				Socket s = ss.accept();

				MyService t = new MyService();
				t.setSocket(s);
				//将HashMap的引用传入服务线程
				t.setHashMap(hm) ;
				t.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class MyService extends Thread {
	private Socket s;
	public void setSocket(Socket s){
		this.s = s ;
	}
	//接收HashMap的引用
	private HashMap<String , Socket> hm ;
	public void setHashMap(HashMap hm){
		this.hm = hm ;
	}
	public void run() {
		try{
			// 接受用户名和密码
			InputStream is = s.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
	
			String uandp = br.readLine();
	
			// 拆分用户名和密码
			String u = uandp.split("%")[0];
			String p = uandp.split("%")[1];
	
			OutputStream os = s.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			PrintWriter pw = new PrintWriter(osw, true);
			
			//到数据库中验证用户身份
			Class.forName("org.gjt.mm.mysql.Driver") ;
			Connection cn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/qq","root","123456") ;
			PreparedStatement ps = cn.prepareStatement("select * from user where username=? and password=?") ;
			ps.setString(1, u) ;
			ps.setString(2, p) ;
			
			ResultSet rs = ps.executeQuery() ;
			
			if (rs.next()) {
				// 发送正确信息到客户端
				pw.println("ok");
	
				//将本人的用户名和Socket存入HashMap
				hm.put(u, s) ;
				
				//不断地接收客户端发送过来的信息
				while (true) {
					String message = br.readLine();
					System.out.println(message);
				}
			} else {
				// 发送错误信息到客户端
				pw.println("err");
			}
		}catch(Exception e){}
	}
}