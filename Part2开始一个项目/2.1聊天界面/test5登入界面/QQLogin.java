import java.awt.*;
import javax.swing.*;

public class QQLogin{
    public static void main(String args[]){
        JFrame jf = new JFrame();
        jf.setSize(250, 125);

        //User name 
        JLabel jl1 = new JLabel("User name");

        //User Password
        JLabel jl2 = new JLabel("Password");

        //Input name
        JTextField name = new JTextField();

        //Input password
        JPasswordField password = new JPasswordField();

        //User paibu
        JPanel name_text = new JPanel();
        name_text.setLayout(new GridLayout(1, 2));
        name_text.add(jl1);
        name_text.add(name);

        //Password paibu
        JPanel password_text = new JPanel();
        password_text.setLayout(new GridLayout(1, 2));
        password_text.add(jl2);
        password_text.add(password);

        //Button
        JButton login = new JButton("Login");
        JButton register = new JButton("Register");
        JButton cancel = new JButton("Cancel");

        JPanel button = new JPanel();
        button.setLayout(new GridLayout(1, 3));
        button.add(login);
        button.add(register);
        button.add(cancel);

        jf.setLayout(new GridLayout(3,1));
        jf.add(name_text);
        jf.add(password_text);
        jf.add(button);
        

        jf.setVisible(true);
    }
}