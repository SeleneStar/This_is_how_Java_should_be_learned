import java.io.*;

public class MyReadFile{
    public static void main(String args[]){
        try{
            File inFile = new File("./test.txt");
            File outFile = new File("./test_copy.txt");

            FileReader fr = new FileReader(inFile);
            BufferedReader br = new BufferedReader(fr);

            FileWriter fw = new FileWriter(outFile);
            PrintWriter pw = new PrintWriter(fw);

            while(br.ready()){
                pw.println(br.readLine());
            }

            br.close();
            pw.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}