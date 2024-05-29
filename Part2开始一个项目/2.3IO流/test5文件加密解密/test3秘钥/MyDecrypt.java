/**
 * MyDecrypt
 */
import java.io.*;

public class MyDecrypt{
    public static void main(String args[]){
        try{
            int key[] = new int[250];

            File keyFile = new File("./Key");

            FileInputStream fkey = new FileInputStream(keyFile);

            for(int i = 0; i<250; i++){
                key[i] = fkey.read();
            }

            //Decrypt
            File f = new File("./test_encrypt.txt");

            FileInputStream fin = new FileInputStream(f);

            int length = fin.available();
            for(int i = 0; i<length; i++){
                System.out.print((char)(fin.read()-key[i%250]));
            }
        }catch(Exception e){}
    }
}