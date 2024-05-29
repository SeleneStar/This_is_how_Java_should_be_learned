import java.io.*;

public class MyDecrypt{
    public static void main(String args[]){
        try{
            File f = new File("./test_encrypt.txt");

            FileInputStream fin = new FileInputStream(f);

            int length = fin.available();
            for(int i = 0; i<length; i++){
                System.out.print((char)(fin.read()-i%100));
            }
            fin.close();
        }catch(Exception e){}
    }
}