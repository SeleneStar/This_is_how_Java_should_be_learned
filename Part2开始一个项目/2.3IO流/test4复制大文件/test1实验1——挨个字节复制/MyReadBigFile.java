import java.io.*;

public class MyReadBigFile{
    public static void main(String args[]){
        try{
            File f = new File("/usr/local/lib/jdk1.8.0_201/src.zip");

            FileInputStream fin = new FileInputStream(f);
            FileOutputStream fou = new FileOutputStream("./src_copy.zip");

            int length = fin.available();

            for(int i = 0; i< length; i++){
                fou.write(fin.read());
            }
        }catch(Exception e){}
    }
}