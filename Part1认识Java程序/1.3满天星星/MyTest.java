import java.awt.*;

public class MyTest{
    public static void main(String args[]){
        Frame f = new Frame();
        f.setSize(1920, 1080);
        f.setBackground(Color.BLACK);

        MyPanel mp = new MyPanel();
        f.add(mp);

        f.setVisible(true);
    }
}

class MyPanel extends Panel{
    public void paint(Graphics g){
        g.setColor(Color.YELLOW);
        for(int i=0; i<300; i++){
            g.drawString("*", (int)(1920*Math.random()), (int)(1080*Math.random()));
        }
    }
}