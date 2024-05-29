import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.util.*;

public class MyNote{
    public static void main(String[] args) {
        JFrame jf = new JFrame();
        jf.setSize(700, 800);
        MyPanel mp = new MyPanel();
        jf.add(mp);

        // jf.addKeyListener(mp);
        // mp.addKeyListener(mp);

        jf.setVisible(true);
    }
}

class MyPanel extends JPanel implements ActionListener {
    LinkedList ll = new LinkedList();
    int cursor = 0;
	JTextField txtFrom = new JTextField() ;
    JTextArea txtContent = new JTextArea();

    MyPanel(){
        //设置窗体属性
		//this.setSize(500 , 600) ;
		
		//new组件
		JLabel labOpen = new JLabel("文件");
		JButton btnOpen = new JButton("打开文件") ;
		
		//注册事件监听
		btnOpen.addActionListener(this) ;
		
		//布置输入面板
		JPanel panInput = new JPanel() ;
		panInput.setLayout(new GridLayout(1 , 3)) ;
		
		panInput.add(labOpen) ;
		panInput.add(txtFrom) ;
		panInput.add(btnOpen) ;
        
        JScrollPane spContent = new JScrollPane(txtContent);
         
        //布置窗体
		this.setLayout(new BorderLayout()) ;
		this.add(panInput , BorderLayout.NORTH) ;
        this.add(spContent , BorderLayout.CENTER);
    }

    // public void paint(Graphics g){
    //     super.paint(g);

    //     for(int i=0; i<ll.size(); i++){
    //         g.drawString(ll.get(i).toString(), 10+i*8, 10);
    //     }

    //     g.drawLine(10+cursor*8, 0, 10+cursor*8, 10);
    // }

    // public void keyPressed(KeyEvent e){
    //     if(e.getKeyCode() >= KeyEvent.VK_A&&e.getKeyCode() <= KeyEvent.VK_Z || e.getKeyCode() == KeyEvent.VK_SPACE){
    //         ll.add(cursor, e.getKeyChar());
    //         cursor++;
    //     }
    //     if(e.getKeyCode() == KeyEvent.VK_LEFT){        
    //         if(cursor>0){
    //             cursor--;
    //         }
    //     }
    //     if(e.getKeyCode() == KeyEvent.VK_RIGHT){
    //         if(cursor<ll.size()){
    //             cursor++;
    //         }
    //     }
    //     if(e.getKeyCode() == KeyEvent.VK_DELETE){
    //         if(cursor<ll.size()){
    //             ll.remove(cursor);
    //         }
    //     }
    //     if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE){
    //         if(cursor<=ll.size()){
    //             ll.remove(--cursor);
    //         }
    //     }
    //     repaint();
    // }

    // public void keyReleased(KeyEvent e){
    // }

    // public void keyTyped(KeyEvent e){
    // }

    public void actionPerformed(ActionEvent arg0) {
		if(arg0.getActionCommand().equals("打开文件")){
            txtContent.setText("");
			JFileChooser fc = new JFileChooser() ;
			fc.setFileSelectionMode(JFileChooser.FILES_ONLY) ;
			fc.showOpenDialog(this) ;
            File chooseFile = fc.getSelectedFile() ;
            String openfile = chooseFile.getPath();
            txtFrom.setText(openfile);
            try{
                File f = new File(openfile) ;
                
                FileReader fr = new FileReader(f) ;
                BufferedReader br = new BufferedReader(fr) ;
                
                while(br.ready()){
                    txtContent.append(br.readLine()+"\n") ;
                }
                br.close();            
            }catch(Exception e){}	
		}
	}
}


