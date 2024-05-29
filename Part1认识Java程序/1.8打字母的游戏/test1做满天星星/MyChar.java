import java.awt.*;

public class MyChar{
    public static void main(String args[]){
        Frame f = new Frame();
        f.setSize(300, 400);

        MyPanel mp = new MyPanel();
        f.add(mp);

        f.setVisible(true);
    }
}

class MyPanel extends Panel{
    int x = (int)(300*Math.random());
    int y = (int)(300*Math.random());
    public void paint(Graphics g){
        g.setColor(Color.RED);
        for(int i = 0; i<10; i++){
            int x = (int)(300*Math.random());
            int y = (int)(300*Math.random());   //不用400的原因
            g.drawString("*", x, y);
        }
    }
}