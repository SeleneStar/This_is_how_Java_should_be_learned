/**
 * 任务分解：
 *  1.做漫天星星
 * 	2，将星星改成10个随机字母
 * 	3.让字母下落
 * 	4.接收键盘输入病消除比配的字母
 * 	5.积分程序
 */
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyChar {

	public static void main(String[] args) {
		Frame w = new Frame() ;
		w.setSize(300 , 400) ;
		
		MyPanel mp = new MyPanel() ;
		w.add(mp) ;
		
		Thread t = new Thread(mp) ;
		t.start() ;
		
		w.addKeyListener(mp) ;
		mp.addKeyListener(mp) ;
		
		w.setVisible(true) ;
	}
}

class MyPanel extends Panel implements Runnable , KeyListener{
	int x[] = new int[10] ;
	int y[] = new int[10] ;
	char c[] = new char[10] ;
	int score = 1000 ;
	MyPanel() {
		for (int i = 0; i < 10; i++) {
			x[i] = (int)(Math.random()*300) ;
			y[i] = (int)(Math.random()*300) ; //不用400的原因，一出现就结束了，不给人机会	
			c[i] = (char)(Math.random()*26+97) ;
		}
	}
	public void paint(Graphics g){
		for(int i = 0 ; i < 10 ; i ++){
			g.drawString(new Character(c[i]).toString(), x[i] , y[i]) ;
		}
		g.setColor(Color.RED) ;
		g.drawString("你的成绩是"+score, 5, 15) ;
	}
	public void run() {
		while(true){
			for (int i = 0; i < 10; i++) {
				y[i] ++ ;
				if(y[i]>400){
					y[i] = 0 ;
					x[i] = (int)(Math.random()*300) ;
					c[i] = (char)(Math.random()*26+97) ;
					score -= 100 ;
				}
			}
			try{
				Thread.sleep(30) ;
			}catch(Exception e){}
			repaint() ;
		}
	}
	@Override
	public void keyPressed(KeyEvent arg0) {
		char keyC = arg0.getKeyChar() ;
		int nowY = -1 ;
		int nowIndex = -1 ;
		for(int i = 0 ; i < 10 ; i ++){
			if(keyC==c[i]){
				if(y[i]>nowY){
					nowY = y[i] ;
					nowIndex = i ;
				}
			}
		}
		
		if(nowIndex!=-1){
			y[nowIndex] = 0 ;
			x[nowIndex] = (int)(Math.random()*300) ;
			c[nowIndex] = (char)(Math.random()*26+97) ;
			score += 10 ;
		}else {
			score -= 100 ;
		}
		
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}