/**
 * Encrypt
 */
import java.io.*;

public class MyEncrypt{
    public static void main(String args[]){
        try{
            int key[] = new int[250];
            File keyFile = new File("./Key");

            FileInputStream fkey = new FileInputStream(keyFile);

            for(int i =0; i<250; i++){
                key[i] = fkey.read();
            }

            //Encrypt
            File inFile = new File("./test.txt");
            File outFile = new File("./test_encrypt.txt");

            FileInputStream fin = new FileInputStream(inFile);
            FileOutputStream fou = new FileOutputStream(outFile);

            int length = fin.available();
            for(int i = 0; i<length; i++){
                fou.write(fin.read()+key[i%250]);
            }
        }catch(Exception e){}
    }
}