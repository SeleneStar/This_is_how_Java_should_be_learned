import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyLinkedNote {
	public static void main(String args[]){
		JFrame w = new JFrame() ;
		w.setSize(300, 400);

		MyPanel mp = new MyPanel();
		w.add(mp);

		w.addKeyListener(mp);
		mp.addKeyListener(mp);

		w.setVisible(true);
	}
}

class MyPanel extends JPanel implements KeyListener {
	Node firstNode = new Node() ;	//定义第一个节点
	Node nowNode = firstNode ;		//当前结点
	int cursor = 0 ;
	public void paint(Graphics g) {
		super.paint(g);
		//遍历每个结点
		//声明的临时变量是Node类型的，这样才能够指向每个结点
		Node tmpNode = firstNode ;
		int x = 0 ;		//需要调整x坐标
		while(tmpNode.next!=null){	//最后一个结点的next是NULL
			g.drawString(""+tmpNode.next.value, 10+x*8, 10) ;
			x ++ ;
			//让 tmpNode 在链表中向下移动
			tmpNode = tmpNode.next ;
		}
		
		//显示光标
		g.drawLine(10+cursor*8, 0, 10+cursor*8, 10) ;
	}

	@Override
	public void keyPressed(KeyEvent e) {
	   if(e.getKeyCode()>=KeyEvent.VK_A&&e.getKeyCode()<=KeyEvent.VK_Z) {
			if(nowNode.next==null){		//思考范围条件
				Node newNode = new Node() ;
				newNode.value = e.getKeyChar() ;
				nowNode.next = newNode ;
				nowNode = newNode ;
				cursor ++ ;
			}else {
				//1创建新节点
				Node newNode = new Node() ;
				//2复制
				newNode.value = e.getKeyChar() ;
				//3让新结点的next指向下一个结点
				newNode.next = nowNode.next ;
				//4让当前结点的next指向新节点
				nowNode.next = newNode ;
				//5维护 nowNode 和光标
				nowNode = newNode ;
				cursor ++ ;
			}		
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			if(cursor>0){
				cursor -- ;
				//从第一个结点开始，找到当前结点的前一个结点
				Node tmpNode = firstNode ;
				while(tmpNode.next!=nowNode){	//思考训话条件
					tmpNode = tmpNode.next ;
				}
				nowNode = tmpNode ;				//修改 nowNode 的值
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if(nowNode.next!=null){				//思考范围条件
				cursor ++ ;
				nowNode = nowNode.next ;
			}
		}
		if(e.getKeyCode()==KeyEvent.VK_DELETE){
			if(nowNode.next!=null){
				nowNode.next = nowNode.next.next ;
			}		
		}
		repaint();
	}
	
	public void keyReleased(KeyEvent arg0) {
	}
	
	public void keyTyped(KeyEvent arg0) {
	}
}

class Node {
	public char value = ' ';
	public Node next = null ;
}