import java.io.*;

public class MyReadChar{
    public static void main(String args[]){
        try{
            File f = new File("./test.txt");

            FileInputStream fis = new FileInputStream(f);

            System.out.println(fis.read());
            //需要强制类型转换
            System.out.println((char)fis.read());
        }catch(Exception e){}
    }
}