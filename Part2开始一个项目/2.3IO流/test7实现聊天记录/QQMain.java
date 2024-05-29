import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.* ;

public class QQMain extends JFrame implements ActionListener{
	JTextField txtMess = new JTextField() ;
	JComboBox cmbUser = new JComboBox() ;
	JTextArea txtContent = new JTextArea() ;
	QQMain(){
		this.setSize(300 , 400) ;
		
		//new���
		JButton btnSend = new JButton("����") ;
		
		JScrollPane spContent = new JScrollPane(txtContent) ;
		
		//ע���¼�����
		btnSend.addActionListener(this) ;
		
		//����С���
		JPanel panSmall = new JPanel() ;
		panSmall.setLayout(new GridLayout(1 , 2)) ;
		
		panSmall.add(cmbUser) ;
		panSmall.add(btnSend) ;
		
		//���ô����
		JPanel panBig = new JPanel() ;
		panBig.setLayout(new GridLayout(2 , 1)) ;
		
		panBig.add(txtMess) ;
		panBig.add(panSmall) ;
		
 		//布置窗口
		this.setLayout(new BorderLayout()) ;
		
		this.add(panBig , BorderLayout.NORTH) ;
		this.add(spContent , BorderLayout.CENTER) ;

		//读取聊天记录
		try{
			File f = new File("c:/work/聊天记录.qq") ;
			
			FileReader fr = new FileReader(f) ;
			BufferedReader br = new BufferedReader(fr) ;
			
			while(br.ready()){
				txtContent.append(br.readLine()+"\n") ;
			}
		}catch(Exception e){}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// 将 txtMess 放到 txtContent 中
		// txtMess -------> txtContent
		txtContent.append(txtMess.getText()+"\n") ;
		
		// 将 txtMess 的内容存入聊天记录文件
		try{
			File f = new File("c:/work/聊天记录.qq") ;
			
			FileWriter fw = new FileWriter(f) ;
			PrintWriter pw = new PrintWriter(fw) ;
			
			pw.println(txtMess.getText()) ;
			
			pw.close() ;
		}catch(Exception e){}
		
		// 清除 txtMess 中的内容
		txtMess.setText("") ;		
	}
}