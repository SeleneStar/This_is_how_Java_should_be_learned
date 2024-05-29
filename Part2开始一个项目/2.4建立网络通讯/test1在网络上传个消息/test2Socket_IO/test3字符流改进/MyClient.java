import java.net.*;
import java.io.*;

public class MyClient{
    public static void main(String args[]){
        try{
            Socket s = new Socket("localhost", 8000);

            OutputStream os = s.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            PrintWriter pw = new PrintWriter(osw, true);

            pw.println("YBX is the most handsome man in NCEPU");
        }catch(Exception e){}
    }
}