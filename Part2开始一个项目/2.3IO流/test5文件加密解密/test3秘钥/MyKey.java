import java.io.*;

public class MyKey {

	public static void main(String[] args) {
		try {
            File f = new File("./Key") ;
            int[] a = new int[250];
			
			FileOutputStream fos = new FileOutputStream(f) ;
			
			for (int i = 0; i < 250; i++) {
                a[i] = (int)(Math.random()*250);
            }
            for(int i = 0; i<250; i++){
                System.out.print(a[i]);
                fos.write(a[i]);
            }
            fos.close();
		} catch (Exception e) {}
	}
}