import java.io.*;

public class MyTest{
    public static void main(String[] args) {
        try{
            File f = new File("/home/Tony/Documents/This_is_how_Java_should_be_learned/");

            File sub[] = f.listFiles();
            
            for(File s : sub){
                if(s.isFile()){
                    if(s.isHidden()){
                        System.out.println(s.getName()+" ==> is Hidden File");
                    }else{
                        System.out.println(s.getName()+" ==> is File");
                    }
                }
                if(s.isDirectory()){
                    if(s.isHidden()){
                        System.out.println(s.getName()+" ==> is Hidden Directory");
                    }else{
                        System.out.println(s.getName()+" ==> is Directory");
                    }
                }
            }
        }catch(Exception e){}
    }
}
