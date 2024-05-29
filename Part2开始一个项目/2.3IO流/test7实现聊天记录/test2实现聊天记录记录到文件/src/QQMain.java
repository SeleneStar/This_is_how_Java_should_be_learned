import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
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

        //读之前的聊天记录
        try{
			File f = new File("./Chat_record.qq") ;
			
			FileReader fr = new FileReader(f) ;
			BufferedReader br = new BufferedReader(fr) ;
			
			while(br.ready()){
				txtContent.append(br.readLine()+"\n") ;
			}
		}catch(Exception e){}
    }

    public void actionPerformed(ActionEvent arg0){
        
        txtContent.append(txtMess.getText()+"\n") ;

		try{
			File f = new File("./Chat_record.qq") ;
			
			FileWriter fw = new FileWriter(f) ;
			PrintWriter pw = new PrintWriter(fw) ;
			
			pw.println(txtMess.getText()) ;
			
			pw.close() ;
		    }catch(Exception e){}
        
        txtMess.setText("") ;	
    }
}