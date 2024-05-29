import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class MyNote{
    public static void main(String[] args) {
        JFrame jf = new JFrame();
        jf.setSize(300, 400);

        MyPanel mp = new MyPanel();
        jf.add(mp);

        jf.addKeyListener(mp);
        mp.addKeyListener(mp);

        jf.setVisible(true);
    }
}

class MyPanel extends JPanel implements KeyListener{
    LinkedList ll = new LinkedList();
    int cursor = 0;

    public void paint(Graphics g){
        super.paint(g);

        for(int i=0; i<ll.size(); i++){
            g.drawString(ll.get(i).toString(), 10+i*8, 10);
        }

        g.drawLine(10+cursor*8, 0, 10+cursor*8, 10);
    }

    public void keyPressed(KeyEvent e){
        if(e.getKeyCode() >= KeyEvent.VK_A&&e.getKeyCode() <= KeyEvent.VK_Z || e.getKeyCode() == KeyEvent.VK_SPACE){
            ll.add(cursor, e.getKeyChar());
            cursor++;
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT){        
            if(cursor>0){
                cursor--;
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            if(cursor<ll.size()){
                cursor++;
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_DELETE){
            if(cursor<ll.size()){
                ll.remove(cursor);
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE){
            if(cursor<=ll.size()){
                ll.remove(--cursor);
            }
        }
        repaint();
    }

    public void keyReleased(KeyEvent e){
    }

    public void keyTyped(KeyEvent e){
    }
}

