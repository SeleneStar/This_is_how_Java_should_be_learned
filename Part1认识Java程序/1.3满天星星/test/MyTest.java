/**
 * 任务分解：
 *  1.先画一个黑夜
 *  2.画一颗星星
 *  3.画300可星星
 */
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

//画星星
class MyPanel extends Panel{
    public void paint(Graphics g){
        g.setColor(Color.YELLOW);
        for(int i=0; i<300; i++){
            /**
             * Math.random() 产生的是0-1之间的数字
             * 需要强制类型转换
             */
            g.drawString("*", (int)(1920*Math.random()), (int)(1080*Math.random()));
        }
    }
}