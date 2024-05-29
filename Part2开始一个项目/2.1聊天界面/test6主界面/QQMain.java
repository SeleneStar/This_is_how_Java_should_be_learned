import javax.swing.*;
import java.awt.*;

public class QQMain{
    public static void main(String args[]){
        JFrame jf = new JFrame("QQMain");
        jf.setSize(300, 400);

        JTextField txtMess = new JTextField();
        JComboBox cmbUser = new JComboBox<>();
        cmbUser.addItem("YBX");
        cmbUser.addItem("ybx");
        JButton jb = new JButton("Send");
        JTextArea txtContent = new JTextArea();
        JScrollPane spContent = new JScrollPane(txtContent);

        //set panel small
        JPanel pansmall = new JPanel();
        pansmall.setLayout(new GridLayout(1, 2));
        pansmall.add(cmbUser);
        pansmall.add(jb);

        //Set panelBIg
        JPanel panBig = new JPanel();
        panBig.setLayout(new GridLayout(2, 1));
        panBig.add(txtMess);
        panBig.add(pansmall);

        //set window
        jf.setLayout(new BorderLayout());
        jf.add(panBig, BorderLayout.NORTH);
        jf.add(spContent, BorderLayout.CENTER);

        jf.setVisible(true);
    }
}
