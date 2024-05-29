import java.net.*;

public class MyClient{
    public static void main(String args[]){
        try{
            Socket s = new Socket("localhost", 8000);

            s.getOutputStream().write(122);
        }catch(Exception e){}
    }
}