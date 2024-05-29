import java.sql.* ;
import java.io.*;
	
public class DataBase {
	public static Connection getConnection(String dbName){
		Connection cn = null ;
		try {
						File f = new File("./SQL.ini");
						FileReader fr = new FileReader(f);
						BufferedReader br = new BufferedReader(fr);

						String driver = br.readLine();
						String url = br.readLine();
						String u = br.readLine();
						String p = br.readLine();

						Class.forName(driver);
						cn = DriverManager.getConnection(url,  u, p) ;
	    }
	    catch (Exception ex) {
	    }
		return cn ;		
	}
	public static Connection getConnection(){
		return getConnection("") ;		
	}
}
