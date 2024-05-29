/**
 * 确定是那个键
 */

import java.awt.*;
import java.awt.event.*;

public class MyBall {
    public static void main(String args[]){
        Frame f = new Frame();
        f.setSize(300, 400);

        MyPanel mp = new MyPanel();
        f.add(mp);

        f.addKeyListener(mp);
        mp.addKeyListener(mp);

        f.setVisible(true);
    }
}

class MyPanel extends Panel implements KeyListener{
    int x = 30;
    int y = 30;

    public void paint(Graphics g){
        g.setColor(Color.RED);
        g.fillOval(x, y, 30, 30);
    }

    public void keyPressed(KeyEvent e){
        if(e.getKeyCode() == 37){
            x--;
        }
        if(e.getKeyCode() == 38){
            y--;
        }
        if(e.getKeyCode() == 39){
            x++;
        }
        if(e.getKeyCode() == 40){
            y++;
        }
        repaint();
    }
    public void keyReleased(KeyEvent arg0){
    }
    public void keyTyped(KeyEvent arg0){
    }
}