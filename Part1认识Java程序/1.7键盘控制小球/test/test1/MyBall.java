/**
 * 只要按键就会反应
 */
import java.awt.*;
import java.awt.event.*;

public class MyBall{
    public static void main(String args[]){
        Frame f = new Frame();
        f.setSize(1920, 1080);

        MyPanel mp = new MyPanel();
        f.add(mp);

        f.addKeyListener(mp);
        mp.addKeyListener(mp);

        f.setVisible(true);
    }
}

class MyPanel extends Panel implements KeyListener{
    public void paint(Graphics g){
        g.setColor(Color.RED);
        g.fillOval(30, 30, 20, 20);
    }

    public void keyPressed(KeyEvent arg0){
        System.out.println("Key Pressed!");
    }

    public void keyReleased(KeyEvent arg0) {
		System.out.println("Key Released!");
    }
    
	public void keyTyped(KeyEvent arg0) {	
	}
}