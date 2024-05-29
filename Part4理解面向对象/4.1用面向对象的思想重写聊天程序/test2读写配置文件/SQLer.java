/**
 * Function: 数据库调用，读取数据库配置文件
 * Author:YBX
 * Time:Sun Mar 22 11:01:19 CST 2020
 *
 * */
import java.sql.*;
import java.io.*;

public class SQLer{
	public boolean vali(String user, String pass){
		boolean b = false;
		try{
			File f = new File("./SQL.ini");

			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);

			String driver = br.readLine();
			String url =  br.readLine();
			String u =  br.readLine();
			String p = br.readLine();

			Class.forName(driver);
			Connection cn = DriverManager.getConnection(url, u, p);
			PreparedStatement ps = cn.prepareStatement(
											"SELECT * FROM userwhere username=? and password=?");
			ps.setString(1, user);
			ps.setString(2, pass);

			ResultSet rs = ps.executeQuery();

			b = rs.next();
		}catch(Exception e){}
		return b;
	}
}
