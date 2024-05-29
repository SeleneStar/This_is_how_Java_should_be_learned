import java.net.*;

public class MyServer{
    public static void main(String args[]){
        try{
            ServerSocket ss = new ServerSocket(8000);

            System.out.println("Listening ....");
            Socket s = ss.accept();
            System.out.println("Listened.");
        }catch(Exception e){}
    }
}