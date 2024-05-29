import java.sql.*;

public class TestSQL{
    public static void main(String[] args) {
        try{
             //注册驱动
             String driver ="org.mariadb.jdbc.Driver";
             Class.forName(driver);
 
             //获取数据库连接
             String url="jdbc:mysql://192.168.122.104:3306/test";
             String user = "tony";
             String password = "12345";
             Connection connection = DriverManager.getConnection(url, user, password);
             System.out.println("Connection Success!!!");
             
             //Select
             System.out.println("\nThe original data:");
             Statement statement = connection.createStatement();
             ResultSet result1 = statement.executeQuery("SELECT id, name FROM student");
             while(result1.next()){
                 String id = result1.getString("id");
                 String name = result1.getString("name");
                 System.out.println("id: "+id+"\t"+"name: "+name+" ");
             }
 
             //Insert
             System.out.println("\nInsert");
             String sql1 = "INSERT INTO student VALUES(2, 'Jerry')";
             int result_insert = statement.executeUpdate(sql1);
             System.out.println("Change Line: "+result_insert);  
 
             //Select
             System.out.println("\nAfter Insert:");
             ResultSet result2 = statement.executeQuery("SELECT id, name FROM student");
             while(result2.next()){
                 String id = result2.getString("id");
                 String name = result2.getString("name");
                 System.out.println("id: "+id+"\t"+"name: "+name+" ");
             }
 
             //Update
             String sql2 = "UPDATE student SET name='tony' WHERE id=2";
             int result_update = statement.executeUpdate(sql2);
             System.out.println("Change Line: "+result_update);
 
             //Select
             System.out.println("\nAfter Update:");
             ResultSet result3 = statement.executeQuery("SELECT id, name FROM student");
             while(result3.next()){
                 String id = result3.getString("id");
                 String name = result3.getString("name");
                 System.out.println("id: "+id+"\t"+"name: "+name+" ");
             }
 
             //Delete
             String sql3 = "DELETE FROM student WHERE id=2";
             int result_delete = statement.executeUpdate(sql3);
             System.out.println("Change Line: "+result_delete);
 
             //Select
             System.out.println("\nAfter Delete:");
             ResultSet result4 = statement.executeQuery("SELECT id, name FROM student");
             while(result4.next()){
                 String id = result4.getString("id");
                 String name = result4.getString("name");
                 System.out.println("id: "+id+"\t"+"name: "+name+" ");
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                result1.close();
                result2.close();
                result3.close();
                result4.close();
                statement.close();
                connection.close();
            }catch(Exception e){}
        }
    }
}
