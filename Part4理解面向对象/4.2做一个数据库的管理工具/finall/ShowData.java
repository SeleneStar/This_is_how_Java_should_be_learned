import java.awt.* ;
import javax.swing.* ;

public class ShowData extends JFrame {
	ShowData(String database , String table , int x , int y , int width , int height) {
		//
		this.setLocation(x+width , y) ;
		
		this.setSize(300 , height) ;		
	}
}