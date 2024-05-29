import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;

public class QQMain extends JFrame implements ActionListener{
    JTextField txtMess = new JTextField();
    JComboBox cmbUser = new JComboBox();
    JTextArea txtContent = new JTextArea();

    QQMain(){
        this.setSize(300, 400);

        JButton btnSend = new JButton("Send");

        JScrollPane spContent = new JScrollPane(txtContent);

        btnSend.addActionListener(this);

        JPanel panSmall = new JPanel();
        panSmall.setLayout(new GridLayout(1, 2));

        panSmall.add(cmbUser);
        panSmall.add(btnSend);

        JPanel panBig = new JPanel();
        panBig.setLayout(new GridLayout(2, 1));

        panBig.add(txtMess);
        panBig.add(panSmall);

        this.setLayout(new BorderLayout());

        this.add(panBig, BorderLayout.NORTH);
        this.add(spContent, BorderLayout.SOUTH);
    }

    public void actionPerformed(ActionEvent arg0){

    }
}