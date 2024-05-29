import java.io.*;

public class MyEncrypt{
    public static void main(String args[]){
        try{
            File inFile = new File("./test.txt");
            File outFile = new File("./testDecrypt");

            FileInputStream fin = new FileInputStream(inFile);
            FileOutputStream fou = new FileOutputStream(outFile);

            int length = fin.available();
            for(int i = 0; i<length; i++){
                fou.write(fin.read()+100);
            }
        }catch(Exception e){}
    }
}