import java.awt.*;

public class MyBall{
    public static void main(String[] args) {
        Frame f = new Frame();
        f.setSize(1920, 1080);

        MyPanel mp = new MyPanel();
        f.add(mp);

        Thread t = new Thread(mp);
        t.start();

        f.setVisible(true);
    }
}

class MyPanel extends Panel implements Runnable{
    int x=30, y = 30;
    public void paint(Graphics g){
        g.setColor(Color.BLACK);
        g.fillOval(x, y, 20, 20);
    }

    public void run(){
        while(true){
            x++;
            y++;
            try{
                Thread.sleep(30);
            }catch(Exception e){ };
            repaint();
        }
    }
}
