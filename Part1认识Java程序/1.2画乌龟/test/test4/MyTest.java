import java.awt.*;

public class MyTest{
    public static void main(String args[]){
        Frame f = new Frame();
        f.setSize(300, 400);

        MyPanel mp = new MyPanel();
        f.add(mp);

        f.setVisible(true);
    }
}

class MyPanel extends Panel{
    public void paint(Graphics g){
        g.setColor(Color.blue);
        g.drawLine(20, 20, 200, 300);
        g.fillOval(30, 30, 50, 100);
    }
}
