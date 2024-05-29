import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class CopyDir extends JFrame implements ActionListener, Runnable{
    JTextField txtFrom = new JTextField() ;
	JTextField txtTo = new JTextField() ;
    JTextArea txtIng = new JTextArea() ;
    
    CopyDir(){
        this.setSize(500, 600);

        JLabel labFrom = new JLabel("源目录");
        JLabel labTo = new JLabel("目的目录");

        JButton btnFrom = new JButton("源目录");
        JButton btnTo = new JButton("目标目录");

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
            Thread t = new Thread(this) ;
            t.start();	
        }
    }

    public void run(){
        copy(new File(txtFrom.getText()), new File(txtTo.getText()));
    }

    public void copy(File from, File to){
        String newDir = to.getPath()+"/"+from.getName();
        txtIng.append("正在创建目录"+"/"+"...\n");
        File newDirFile = new File(newDir);
        newDirFile.mkdir();
        File sub[] = from.listFiles();
        for(File s : sub){
            if(s.isDirectory()){
                copy(s, newDirFile);
            }
            if(s.isFile()){
                txtIng.append("正在复制文件"+s+"...\n");
                copyFile(s, new File(newDir+"/"+s.getName()));
            }
        }
    }

    public void copyFile(File from, File to){
        try{
            FileInputStream fis = new FileInputStream(from);
            FileOutputStream fos = new FileOutputStream(to);

            byte[] tmp = new byte[8192];
            int length = fis.available()/8192;
            for(int i=0; i<length; i++){
                fis.read(tmp);
                fos.write(tmp);
            }

            int size=fis.read(tmp);
            fos.write(tmp, 0, size);
            fos.close();
        }catch(Exception e){}
    }
}
