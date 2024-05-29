import java.io.*;

public class MyKey {

	public static void main(String[] args) {
		try {
            File f = new File("./Key") ;

            int[] a = new int[250];

            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
			
			for (int i = 0; i < 250; i++) {
                a[i] = (int)(Math.random()*250);
            }

            String s = "";
            for(int i=0;i<a.length;i++){
                s = s + a[i];//拼接成字符串，最终放在变量s中
            }

            for(int i = 0; i<250; i++){
                System.out.print(a[i]+ " ");
            }
            pw.write(s);    //pw.write只能接收字符串，所以需要先将整型数组转换成字符串
            pw.close();
		} catch (Exception e) {
            e.printStackTrace();
        }
	}
}