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
    int cursor = 0;
    
    public void paint(Graphics g){
        super.paint(g);

        for(int i=0; i<size; i++){
            g.drawString(""+c[i], 10+8*i, 10);
        }

        //用小竖线做光标
        g.drawLine(10+cursor*8, 0, 10+cursor*8, 10);
    }

    @Override
    public void keyPressed(KeyEvent arg0){
        if(arg0.getKeyCode() >= KeyEvent.VK_A && arg0.getKeyCode() <= KeyEvent.VK_Z){
            for(int i = size; i>cursor; i--){
                c[i] = c[i-1];
            }
            c[cursor] = arg0.getKeyChar();
            size++;
            cursor++;
        }
        if(arg0.getKeyCode() == KeyEvent.VK_LEFT){
            if(cursor>0){
                cursor--;
            }
        }
        if(arg0.getKeyCode() == KeyEvent.VK_RIGHT){
            if(cursor<size){
                cursor++;
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


