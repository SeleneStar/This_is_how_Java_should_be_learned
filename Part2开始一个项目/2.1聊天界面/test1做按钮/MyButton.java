import javax.swing.*;

public class MyButton{
    public static void main(String args[]){
        JFrame w = new JFrame();
        w.setSize(300, 400);

        JButton jb = new JButton("按钮");
        jb.setSize(10, 5);
        w.add(jb);

        w.setVisible(true);
    }
}