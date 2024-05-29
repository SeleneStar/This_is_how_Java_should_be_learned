import java.sql.*;

public class TestSQL{
    public static void main(String[] args) {
        try{
            Class.forName("org.mariadb.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://192.168.122.104:3306/test", "root", "12345");
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("select * from student");

        }catch(Exception e){}
    }
}
