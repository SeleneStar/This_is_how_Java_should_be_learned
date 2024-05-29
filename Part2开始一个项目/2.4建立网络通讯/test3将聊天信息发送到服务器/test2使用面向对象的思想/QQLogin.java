import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.* ;
import java.net.* ;

public class QQLogin extends JFrame implements ActionListener {
	JTextField txtUser = new JTextField() ;
	JPasswordField txtPass = new JPasswordField() ;
	
	public QQLogin() {
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
		QQLogin w = new QQLogin() ;
		w.setVisible(true) ;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Login")){
            System.out.println("Click Login");
            try{
                String name = txtUser.getText();
                String password = String.valueOf(txtPass.getPassword());
                
                Socket s = new Socket("localhost", 8000);

                OutputStream os = s.getOutputStream();
                OutputStreamWriter osw = new OutputStreamWriter(os);
                PrintWriter pw = new PrintWriter(osw, true);

                pw.println(name+"%"+password);

                //The acknowledgement message sent back by the receiving server
                InputStream is = s.getInputStream() ;
				InputStreamReader isr = new InputStreamReader(is) ;
				BufferedReader br = new BufferedReader(isr) ;
				
				String yorn = br.readLine() ;
			
				if (yorn.equals("ok")) {
					QQMain w = new QQMain();
					w.setSocket(s);
					w.setVisible(true);
					this.setVisible(false);
				}else {
					JOptionPane.showMessageDialog(this, "Sorry, wrong username or password!") ;
				}		
            }catch(Exception a){}
        }
        if(e.getActionCommand().equals("Register")){
            System.out.println("Click Register");
        }
        if(e.getActionCommand().equals("Cancel")){
            System.out.println("Click Cancel");
		}
	}
}