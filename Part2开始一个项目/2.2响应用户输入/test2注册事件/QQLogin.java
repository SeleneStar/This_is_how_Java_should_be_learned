import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class QQLogin implements ActionListener{
    public static void main(String args[]){
        JFrame jf = new JFrame();
        jf.setSize(300, 125);

        JLabel labUser = new JLabel("User name");
        JLabel labPass = new JLabel("Password");

        JTextField txtUser = new JTextField();
        JPasswordField txtPass = new JPasswordField();

        JButton btnLogin = new JButton("Login");
        JButton btnReg = new JButton("Register");
        JButton btnCancel = new JButton("Cancel");

        JPanel panInput = new JPanel();
        panInput.setLayout(new GridLayout(2,2));
        panInput.add(labUser);
        panInput.add(txtUser);
        panInput.add(labPass);
        panInput.add(txtPass);

        JPanel panButton = new JPanel();
        panButton.setLayout(new FlowLayout());
        panButton.add(btnLogin);
        panButton.add(btnReg);
        panButton.add(btnCancel);

        jf.setLayout(new BorderLayout());
        jf.add(panInput, BorderLayout.NORTH);
        jf.add(panButton, BorderLayout.SOUTH);

        //register Event
        //parameter is an object that implements an interface class
        //QQLogin implements interface class
        QQLogin e = new QQLogin();
        btnLogin.addActionListener(e);
        btnReg.addActionListener(e);
        btnCancel.addActionListener(e);

        jf.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent arg0){
        System.out.println("Event respond!!!");
    }
}