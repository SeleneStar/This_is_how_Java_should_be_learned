import java.sql.*;

public class TestSQL{
    public static void main(String[] args) {
        try{
            Class.forName("org.gjt.mm.mysql.Driver");
        }catch(Exception e){}
    }
}
