import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyChar{
    public static void main(String args[]){
        Frame f = new Frame();
        f.setSize(350, 400);
        f.setBackground(Color.BLACK);

        MyPanel mp = new MyPanel();
        f.add(mp);

        Thread t = new Thread(mp);
        t.start();

        f.addKeyListener(mp);
        mp.addKeyListener(mp);

        f.setVisible(true);
    }
}

class MyPanel extends Panel implements Runnable , KeyListener{
    int x[] = new int [10];
    int y[] = new int [10];
    char c[] = new char [10];
    int score = 1000;

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

        g.setColor(Color.RED);
        g.drawString("Score: "+score, 5, 15);
    }

    public void keyPressed(KeyEvent arg0){
        char keyC = arg0.getKeyChar();
        boolean mark = false;
        for(int i = 0; i< 10; i++){
            if(keyC == c[i]){
                y[i] = 0;
                x[i] = (int)(Math.random()*300);
                c[i] = (char)(Math.random()*26+97);
                mark = true;
                score += 10;
                break;
            }
        }

        if(mark){
            score += 10;
        }else{
            score -= 100;
        }
    }

    @Override
	public void keyReleased(KeyEvent arg0) {
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
	}

    public void run(){
        while(true){
            try{
                for(int i = 0; i< 10; i++){
                    y[i]++;
                    if(y[i] > 400){
                        y[i] = 0;
                        x[i] = (int)(Math.random()*300);
                        c[i] = (char)(Math.random()*26+97);
                        score -= 100;
                    }
                }
                Thread.sleep(30);
            }catch(Exception e){}
            repaint();
        }
    }
}
