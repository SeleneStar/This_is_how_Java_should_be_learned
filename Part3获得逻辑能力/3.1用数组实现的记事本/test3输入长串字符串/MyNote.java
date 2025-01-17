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
    }

    @Override
    public void keyPressed(KeyEvent arg0){
        c[size]=arg0.getKeyChar();
        size++;
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent arg0){
    }

    @Override
    public void keyTyped(KeyEvent arg0){
    }
}
