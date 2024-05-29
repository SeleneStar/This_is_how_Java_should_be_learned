import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyNote{
    public static void main(String[] args) {
        JFrame jf = new JFrame();
        jf.setSize(300, 400);

        jf.setVisible(true);
    }
}

class MyPanel extends JPanel implements KeyListener{
    public void paint(Graphics g){
        super.paint(g);
    }

    public void keyPressed(KeyEvent e){
        if(e.getKeyCode() >= KeyEvent.VK_A&&e.getKeyCode() <= KeyEvent.VK_Z){
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
        }
        if(e.getKeyCode() == KeyEvent.VK_DELETE){
        }
        repaint();
    }

    public void keyReleased(KeyEvent e){
    }

    public void keyTyped(KeyEvent e){
    }
}

