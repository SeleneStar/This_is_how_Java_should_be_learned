import java.io.*;

public class MyReadFile{
    public static void main(String args[]){
        try{
            File f = new File("./test.txt");

            FileInputStream fin = new FileInputStream(f);

            int length = fin.available();

            FileOutputStream fou = new FileOutputStream("./out.txt");

            for(int i = 0; i<length; i++){
                fou.write(fin.read());
            }
        }catch(Exception e){}
    }
}