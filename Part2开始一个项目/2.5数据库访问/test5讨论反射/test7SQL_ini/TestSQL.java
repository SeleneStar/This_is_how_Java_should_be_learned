import java.sql.*;
import java.io.*;

public class TestSQL{
    public static void main(String[] args) {
        String u="tom";
        String p="qwert";
        Connection cn = null;
        Statement st=null;
        ResultSet rs = null;
        try{
            File f = new File("SQL.ini");

            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            String driver = br.readLine();
            String url = br.readLine();
            String username = br.readLine();
            String password = br.readLine();

            Class.forName(driver);
            cn=DriverManager.getConnection(url, username, password);
            PreparedStatement ps = cn.prepareStatement("select * from user where username=? and password=?");
            ps.setString(1, u);
            ps.setString(2, p);
            rs=ps.executeQuery();

            if(rs.next()){
                System.out.println("验证成功");
            }else{
                System.out.println("验证失败");
            }
        }catch (Exception e){
                e.printStackTrace();
            }finally{
                try{
                    rs.close();
                    st.close();
                    cn.close();
                }catch(Exception e){
            }
        }
    }
}

