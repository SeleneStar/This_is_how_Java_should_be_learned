import java.io.*;

public class MyDecrypt{
    public static void main(String args[]){
        try{
            File f = new File("./testDecrypt");

            FileInputStream fin = new FileInputStream(f);
            
            int length = fin.available();
            for(int i = 0; i<length; i++){
                System.out.print((char)(fin.read()-100));
            }
        }catch(Exception e){}
    }
}