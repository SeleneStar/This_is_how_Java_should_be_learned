import java.io.*;
public class MyTest{
    public static void main(String[] args) {
        try{
            File f = new File("/home/Tony/Documents/This_is_how_Java_should_be_learned/Part3获得逻辑能力/");
            
            String sub[] = f.list();

            for(String s: sub){
                System.out.println(s);
            }
        }catch(Exception e){}
    }
}