/**
 * 新增 panel 功能
 */
// import java.awt.*;

// public class MyTest{
//     public static void main(String args[]){
//         Frame f = new Frame();
//         f.setSize(300, 400);

//         MyPanel mp = new MyPanel();
//         f.add(mp);

//         f.setVisible(true);
//     }
// }

// class MyPanel extends Panel{
//     public void paint(Graphics g){
//         g.setColor(Color.red);
//         g.drawLine(30, 20, 300, 300);
//     }
// }
import java.awt.*;

public class MyTest{
    public static void main(String args[]){
        Frame f = new Frame();
        f.setSize(200, 300);

        MyPanel mp = new MyPanel();
        f.add(mp);

        f.setVisible(true);
    }
}

class MyPanel extends Panel{
    public void paint(Graphics g){
        g.setColor(Color.green);
        g.drawLine(20, 20, 200, 300);
    }
}