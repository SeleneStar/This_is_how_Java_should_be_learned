import java.io.*;

public class MyReadFile{
    public static void main(String args[]){
        try{
            File f = new File( "../test.txt");

            FileInputStream fin = new FileInputStream(f);

            System.out.println( fin.available() );
        }catch (Exception e){}
    }
}