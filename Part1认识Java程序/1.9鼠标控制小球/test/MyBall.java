import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MyBall{
    public static void main(String args[]){
        Frame f = new Frame();
        f.setSize(300, 400);

        MyPanel mp = new MyPanel();
        f.add(mp);

        f.addMouseMotionListener(mp);
        mp.addMouseMotionListener(mp);

        f.setVisible(true);
    }
}

class MyPanel extends Panel implements MouseMotionListener{
    int x = 30;
    int y = 30;
    public void paint(Graphics g){
        g.fillOval(x, y, 20, 20);
    }

    public void mouseDragged(MouseEvent arg0){
        x = arg0.getX();
        y = arg0.getY();
        repaint();
    }

    public void mouseMoved(MouseEvent arg0){

    }
}