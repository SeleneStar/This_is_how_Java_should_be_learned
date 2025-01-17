import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * 输入用户名与密码，
 * 点击 Login 在 Terminal 里面显示用户名与密码
 */

public class MyTest extends JFrame implements ActionListener{
    JTextField txtUser = new JTextField();
    JPasswordField txtPass = new JPasswordField();

    public MyTest(){
        this.setSize(300, 125);
        JLabel labUser = new JLabel("User name");
        JLabel labPass = new JLabel("Password");
        
        JPanel input = new JPanel();
        input.setLayout(new GridLayout(2,2));
        input.add(labUser);
        input.add(txtUser);
        input.add(labPass);
        input.add(txtPass);

        JButton jb1 = new JButton("Login");
        JButton jb2 = new JButton("Register");
        JButton jb3 = new JButton("Cancel");
        JPanel jbp = new JPanel();
        jbp.setLayout(new FlowLayout());
        jbp.add(jb1);
        jbp.add(jb2);
        jbp.add(jb3);

        this.setLayout(new BorderLayout());
        this.add(input, BorderLayout.NORTH);
        this.add(jbp, BorderLayout.SOUTH);

        jb1.addActionListener(this);
        jb2.addActionListener(this);
        jb3.addActionListener(this);
    }
    public static void main(String args[]){
        MyTest jf = new MyTest();
        jf.setVisible(true);        
    }

    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand().equals("Login")){
            System.out.println("Click Login");
            String name = txtUser.getText();
            //String password = txtPass.getText();  
            //JPasswordField 里面的 getText() 过时的解决办法
            String password = String.valueOf(txtPass.getPassword());
            System.out.println("Username: " + name);
            System.out.println("UserPassword: "+password);
        }
        if(e.getActionCommand().equals("Register")){
            System.out.println("Click Register");
        }
        if(e.getActionCommand().equals("Cancel")){
            System.out.println("Click Cancel");
        }
    }
}