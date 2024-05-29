import java.sql.*;

public class SQLer{
	public boolean vali(String user, String pass){
		boolean b = false;
		try{
			Class.forName("org.mariadb.jdbc.Driver");
			Connection cn = DriverManager.getConnection(
					"jdbc:mysql://0.0.0.0:3306/QQ", "tony", "12345");
			PreparedStatement ps = cn.
				prepareStatement("select * from user where username=? and password=?");
			ps.setString(1, user);
			ps.setString(2, pass);

			ResultSet rs = ps.executeQuery();

			b = rs.next();
		}catch(Exception e){}
		return 0;
	}
}
