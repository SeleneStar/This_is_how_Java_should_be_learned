import java.awt.*;
import javax.swing.*;

public class FlowLayoutTest{
    public static void main(String args[]){
        JFrame jf = new JFrame();
        jf.setSize(300, 400);

        JButton jb1 = new JButton("OK1");
        JButton jb2 = new JButton("OK2");
        JButton jb3 = new JButton("OK3");
        JButton jb4 = new JButton("OK4");
        JButton jb5 = new JButton("OK5");
        JButton jb6 = new JButton("OK6");

        jf.setLayout(new FlowLayout());
        jf.add(jb1);
        jf.add(jb2);
        jf.add(jb3);
        jf.add(jb4);
        jf.add(jb5);
        jf.add(jb6);

        jf.setVisible(true);
    }
}