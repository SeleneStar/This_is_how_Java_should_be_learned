/**
 * 任务分解：
 *  1.做个窗体
 *  2.做个小球
 *  3.让小球斜飞
 *  4.遇到墙反弹
 * 
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
    int att = 0;
    public void paint(Graphics g){
        g.setColor(Color.RED);
        g.fillOval(x, y, 20, 20);
    }
    
    public void run(){
        while(true){
            if(att == 0){
                x++;
                y++;
            }
            if(att == 1){
                x--;
                y++;
            }
            if(att == 2){
                x--;
                y--;
            }
            if(att == 3){
                x++;
                y--;
            }
            //改变飞行姿势
            if(x>263){
                if(att == 0){
                    att = 1;
                }else{
                    att = 2;
                }
            }
            if(y>341){
                if(att == 1){
                    att = 2;
                }else{
                    att = 3;
                }
            }
            if(x<0){
                if(att == 2){
                    att = 3;
                }else{
                    att = 0;
                }
            }
            if(y<0){
                if(att == 3){
                    att = 0;
                }else{
                    att = 1;
                }
            }
            try{
                Thread.sleep(30);
            }catch(Exception e){}
            repaint();
        }
    }
}