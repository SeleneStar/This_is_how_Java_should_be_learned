/**
 * 任务分解：
 *  1.做个窗体
 *  2.做个小球
 *  3.让小球掉下来
 * 
 * 问题：
 *  循环但是不能满足重画
 */

import java.awt.*;

public class MyBall{
    public static void main(String args[]){
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
    int x = 20; 
    int y = 20;
    public void paint(Graphics g){
        g.setColor(Color.GRAY);
        g.fillOval(x, y, 30, 30);
    }

    public void run(){
        while(true){
            y++;
            if(y>1000){
                y = 0;
            }
            try{
                Thread.sleep(30);
            }catch(Exception e){}

            repaint();
        }
    }
}