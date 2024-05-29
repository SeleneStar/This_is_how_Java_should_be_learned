import java.io.*;

public class MyReadBigFile{
    public static void main(String args[]){
        try{
            File f = new File("/usr/local/lib/jdk1.8.0_201/src.zip");

            FileInputStream fin = new FileInputStream(f);
            FileOutputStream fou = new FileOutputStream("./src_copy.zip");

            byte[] tmp = new byte[8192];
            int length = fin.available()/8192;
            for(int i = 0; i<length; i++){
                fin.read(tmp);
                fou.write(tmp);
            }
            int size = fin.available();
            fou.write(tmp, 0, size);    
        }catch(Exception e){}
    }
}