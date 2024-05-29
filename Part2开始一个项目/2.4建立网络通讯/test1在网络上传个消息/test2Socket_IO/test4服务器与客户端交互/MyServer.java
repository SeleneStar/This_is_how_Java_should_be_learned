import java.io.*;
import java.net.*;

public class MyServer{
    public static void main(String args[]){
        try{
            ServerSocket ss = new ServerSocket(8000);

            System.out.println("Listening ... ");
            Socket s = ss.accept();

            InputStream is = s.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            String name = br.readLine();
            System.out.println(name);

            OutputStream os = s.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            PrintWriter pw = new PrintWriter(osw, true);

            pw.println("Yes, as we all know, "+name);
        }catch(Exception e){}
    }
}