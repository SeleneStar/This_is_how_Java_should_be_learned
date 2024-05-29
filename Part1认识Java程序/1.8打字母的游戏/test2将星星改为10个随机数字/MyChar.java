// import java.awt.*;

// public class MyChar{
//     public static void main(String args[]){
//         Frame f = new Frame();
//         f.setSize(300, 400);

//         MyPanel mp = new MyPanel();
//         f.add(mp);

//         f.setVisible(true);
//     }
// }

// class MyPanel extends Panel{
//     int x[] = new int[10];
//     int y[] = new int[10];
//     char c[] = new char[10];
//     MyPanel(){
//         for(int i = 0; i<10; i++){
//             x[i] = (int)(Math.random()*300);
//             y[i] = (int)(Math.random()*300);
//             c[i] = (char)(Math.random()*26+97);
//         }
//     }
//     public void paint(Graphics g){
//         g.setColor(Color.RED);
//         for(int i = 0; i<10; i++){
//             g.drawString(new Character(c[i]).toString(), x[i], y[i]);
//         }
//     }
// }

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

class MyPanel extends Panel {
    int x[] = new int [10];
    int y[] = new int [10];
    char c[] = new char [10];
    public MyPanel(){
        for(int i = 0; i<10; i++){
            x[i] = (int)(Math.random()*300);
            y[i] = (int)(Math.random()*300);
            c[i] = (char)(Math.random()*26+97);
        }
    }
    public void paint(Graphics g){
        g.setColor(Color.RED);
        for(int i = 0; i< 10; i++){
            g.drawString(new Character(c[i]).toString(), x[i], y[i]);
        }
    }
}
