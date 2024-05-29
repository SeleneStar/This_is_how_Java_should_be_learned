import java.sql.*;

public class TestSQL{
    public static void main(String[] args) {
        try{
            Class.forName("org.mariadb.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://192.168.122.104:3306/test", "tony", "12345");
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT id, name FROM student");
            while(rs.next()){
                String id = rs.getString("id");
                String name = rs.getString("name");
                System.out.println(id+" "+name);
            }
        }catch(Exception e){}
    }
}
