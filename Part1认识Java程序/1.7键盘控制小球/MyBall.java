/**
 * 事件处理函数：
 * 	1.实现接口
 * 	2.注册事件
 * 	3.编写事件  处理程序
 */
import java.awt.* ;
//上一行代码只对本层有效，所以需要写下行代码
import java.awt.event.* ;

public class MyBall {
	public static void main(String args[]){
		Frame w = new Frame() ;
		w.setSize(300 , 400) ;
		
		MyPanel mp = new MyPanel() ;
		w.add(mp) ;
		
		w.addKeyListener(mp) ;
		mp.addKeyListener(mp) ;
		
		w.setVisible(true) ;
	}
}

class MyPanel extends Panel implements KeyListener{
	int x = 30 ;
	int y = 30 ;
	public void paint(Graphics g){
		g.fillOval(x, y, 20, 20) ;
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		System.out.println (arg0.getKeyCode()) ;
		if(arg0.getKeyCode()==37){
			x -- ;
		}
		if(arg0.getKeyCode()==38){
			y -- ;
		}
		if(arg0.getKeyCode()==39){
			x ++ ;
		}
		if(arg0.getKeyCode()==40){
			y ++ ;
		}
		repaint() ;
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
	}
}