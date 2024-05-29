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
    char c=' ';
    public void paint(Graphics g){
        super.paint(g); //清屏
        g.drawString(""+c, 10, 10);
    }

    @Override
    public void keyPressed(KeyEvent arg0){
    }

    @Override
    public void keyReleased(KeyEvent arg0){
    }

    @Override
    public void keyTyped(KeyEvent arg0){
    }
}
