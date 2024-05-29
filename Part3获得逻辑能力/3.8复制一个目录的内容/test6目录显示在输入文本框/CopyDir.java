import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.*;

public class CopyDir extends JFrame implements ActionListener{
    JTextField txtFrom = new JTextField() ;
	JTextField txtTo = new JTextField() ;
    JTextArea txtIng = new JTextArea() ;
    
    CopyDir(){
        this.setSize(500, 600);

        JLabel labFrom = new JLabel("源目录");
        JLabel labTo = new JLabel("目的目录");

        JButton btnFrom = new JButton("源目录");
        JButton btnTo = new JButton("目标目录");

        JTextArea txtIng = new JTextArea();
        JScrollPane sp = new JScrollPane(txtIng);

        JButton btnCopy = new JButton("复制");

        btnFrom.addActionListener(this);
        btnTo.addActionListener(this);
        btnCopy.addActionListener(this);

        JPanel panInput = new JPanel();
        panInput.setLayout(new GridLayout(2, 3));

        panInput.add(labFrom);
        panInput.add(txtFrom);
        panInput.add(btnFrom);

        panInput.add(labTo);
        panInput.add(txtTo);
        panInput.add(btnTo);

        this.setLayout(new BorderLayout());

        this.add(panInput, BorderLayout.NORTH);
        this.add(sp, BorderLayout.CENTER);
        this.add(btnCopy, BorderLayout.SOUTH);
    }

    public static void main(String args[]){
        CopyDir w = new CopyDir();
        w.setVisible(true);
    }

    public void actionPerformed(ActionEvent arg0){
        if(arg0.getActionCommand().equals("源目录")){
			JFileChooser fc = new JFileChooser() ;
			fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY) ;
			fc.showOpenDialog(this) ;
			File chooseFile = fc.getSelectedFile() ;
			txtFrom.setText(chooseFile.getPath()) ;
        }
        
        if(arg0.getActionCommand().equals("目标目录")){
            JFileChooser fc = new JFileChooser();
            fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            fc.showSaveDialog(this);
            File chooseFile = fc.getSelectedFile();
            txtTo.setText(chooseFile.getPath());
        }
        if(arg0.getActionCommand().equals("复制")){
        }
    }

    
}
