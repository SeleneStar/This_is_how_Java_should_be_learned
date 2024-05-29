import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyNote{
    public static void main(String args[]){
        JFrame w = new JFrame();
        w.setSize(300, 400);

        MyPanel mp = new MyPanel();
        w.add(mp);

        w.addKeyListener(mp);
        mp.addKeyListener(mp);

        w.setVisible(true);
    }
}

class MyPanel extends JPanel implements KeyListener{
    char c[] = new char [1000];
    int size = 0;
    
    public void paint(Graphics g){
        super.paint(g);

        for(int i=0; i<size; i++){
            g.drawString(""+c[i], 10+8*i, 10);
        }

        //用小竖线做光标
        g.drawLine(10+size*8, 0, 10+size*8, 10);
    }

    @Override
    public void keyPressed(KeyEvent arg0){
        if(arg0.getKeyCode() >= KeyEvent.VK_A && arg0.getKeyCode() <= KeyEvent.VK_Z){
            c[size] = arg0.getKeyChar();
            size++;
        }
        if(arg0.getKeyCode() == KeyEvent.VK_LEFT){
            if(size>0){
                size--;
            }
        }
        if(arg0.getKeyCode() == KeyEvent.VK_RIGHT){
            if(size<1000){
                size++;
            }
        }

        repaint();
    }

    @Override
    public void keyReleased(KeyEvent arg0){
    }

    @Override
    public void keyTyped(KeyEvent arg0){
    }
}
