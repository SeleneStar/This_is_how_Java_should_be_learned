import java.net.*;

public class MyClient{
    public static void main(String args[]){
        try{
            Socket s = new Socket("192.168.122.104", 8000);
        }catch(Exception e){}
    }
}