import java.awt.*;
import javax.swing.*;

public class BorderLayouttest{
    public static void main(String args[]){
        JFrame jf = new JFrame();
        jf.setSize(300, 400);

        JButton b1 = new JButton("OK1");
        JButton b2 = new JButton("OK2");
        JButton b3 = new JButton("OK3");
        JButton b4 = new JButton("OK4");
        JButton b5 = new JButton("OK5");

        jf.setLayout(new BorderLayout());

        jf.add(b1, BorderLayout.NORTH);
        jf.add(b2, BorderLayout.SOUTH);
        jf.add(b3, BorderLayout.WEST);
        jf.add(b4, BorderLayout.EAST);
        jf.add(b5, BorderLayout.CENTER);

        jf.setVisible(true);
    }
}