/**
 * 确定是那个键
 */
import java.awt.*;
import java.awt.event.*;

public class MyBall{
    public static void main(String args[]){
        Frame f = new Frame();
        f.setSize(200, 300);

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
        System.out.println("You press: "+arg0.getKeyChar());
        System.out.println("You press: "+arg0.getKeyCode());
    }

    public void keyReleased(KeyEvent arg0) {
		System.out.println("Key Released!");
    }
    
	public void keyTyped(KeyEvent arg0) {	
	}
}