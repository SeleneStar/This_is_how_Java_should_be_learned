import java.awt.*;

public class MyChar{
    public static void main(String args[]){
        Frame f = new Frame();
        f.setSize(300, 400);
        f.setBackground(Color.BLACK);

        MyPanel mp = new MyPanel();
        f.add(mp);

        Thread t = new Thread(mp);
        t.start();

        f.setVisible(true);
    }
}

class MyPanel extends Panel implements Runnable{
    int x[] = new int [10];
    int y[] = new int [10];
    char c[] = new char [10];

    public MyPanel(){
        for(int i = 0; i<10; i++){
            x[i] = (int)(Math.random()*300);
            y[i] = (int)(Math.random()*400);
            c[i] = (char)(Math.random()*26+97);
        }
    }

    public void paint(Graphics g){
        g.setColor(Color.YELLOW);
        for(int i = 0; i<10; i++){
            g.drawString(new Character(c[i]).toString(), x[i], y[i]);
        }
    }

    public void run(){
        while(true){
            try{
                for(int i = 0; i< 10; i++){
                    y[i]++;
                    if(y[i] > 400){
                        y[i] = 0;
                    }
                }
                Thread.sleep(30);
            }catch(Exception e){}
            repaint();
        }
    }
}