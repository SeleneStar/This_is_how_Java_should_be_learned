import java.io.*;

public class MyReadFile{
    public static void main(String args[]){
        try{
            File e = new File("../test.txt");

            FileInputStream fin = new FileInputStream(e);

            for(int i = 0; i < fin.available(); i++){
                System.out.print((char)fin.read());
            }
        }catch(Exception e){}
    }
}