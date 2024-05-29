import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyLinkedNote{
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
    Node firstNode = new Node();

    public void paint(Graphics g){
        super.paint(g);

        Node tmpNode = firstNode;
        int x = 0;
        while(tmpNode.next != null){
            g.drawString(""+tmpNode.next.value, 10+x*8, 10);
            x++;

            tmpNode = tmpNode.next;
        }
    }

    public void keyPressed(KeyEvent e){
        if(e.getKeyCode() >= KeyEvent.VK_A && e.getKeyCode() <= KeyEvent.VK_Z){
            Node newNode = new Node();
            newNode.value = e.getKeyChar();
            firstNode.next = newNode;
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

/**
 * 结构体与类的区别是结构体没有方法，
 * 如果类里面也没有方法，这个类等同于结构体
 */

class Node{
    public char value = ' ';
    public Node next = null;
}