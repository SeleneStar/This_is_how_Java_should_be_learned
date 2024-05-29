import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.* ;
import java.net.* ;

public class QQMain extends JFrame implements ActionListener{
	JTextField txtMess = new JTextField() ;
	JComboBox cmbUser = new JComboBox() ;
	JTextArea txtContent = new JTextArea() ;
	//成员变量私有化
	private Socket s ;
	public void setSocket(Socket value){
		s = value;
	}
	
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
		
		txtContent.append(txtMess.getText()+"\n") ;

		try{
			File f = new File("./Chat_record.qq") ;
			
			FileReader fr = new FileReader(f) ;
			BufferedReader br = new BufferedReader(fr) ;
			
			while(br.ready()){
				txtContent.append(br.readLine()+"\n") ;
			}
			br.close();
		}catch(Exception e){}
	}

	public void actionPerformed(ActionEvent arg0) {
		// txtMess -------> txtContent
		txtContent.append(txtMess.getText()+"\n") ;
		
		try{
			File f = new File("./Chat_record.qq") ;
			
			FileWriter fw = new FileWriter(f) ;
			PrintWriter pw = new PrintWriter(fw) ;
			
			pw.println(txtMess.getText()) ;
			
			pw.close() ;
		}catch(Exception e){}
		
		try{
			OutputStream os = s.getOutputStream() ; 
			OutputStreamWriter osw = new OutputStreamWriter(os) ;
			PrintWriter pw = new PrintWriter(osw , true) ;
			
			pw.println(txtMess.getText()) ;
		}catch(Exception e){}

		txtMess.setText("") ;		
	}
}