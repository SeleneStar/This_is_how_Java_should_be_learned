import java.io.*;

public class MyReadFile {
	public static void main(String args[]){
		try{
			//Step1：定位数据源
			File f = new File("./test.txt") ;

			//Step2：建议管道
			FileInputStream fis = new FileInputStream(f) ;
			
			//Step3:操作管道
			int length = fis.available() ;
			System.out.println(length);
			for (int i = 0; i < length ; i ++ ) {
				System.out.print((char)fis.read()) ;
			}
		}catch(Exception e){}
	}
}