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

        JButton btnLogin = new JButton("Login");    //这里写什么，下面的 getActionCommand() 就写什么
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
        //在注册事件的时候，参数应该是实现接口的对象，没有就声明一下
        QQLogin e = new QQLogin();
        btnLogin.addActionListener(e);
        btnReg.addActionListener(e);
        btnCancel.addActionListener(e);

        jf.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand().equals("Login") ){    //这里写的就是新建的时候上面写的内容
            System.out.println("User click Login");
        }
        if(e.getActionCommand().equals("Register")){
            System.out.println("User click Register");
        }
        if(e.getActionCommand().equals("Cancel")){
            System.out.println("User click Cancel");
        }
    }
}