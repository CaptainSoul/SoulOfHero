package UI.common;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

public class ItemUI extends JFrame{
	//点开大UI产生的小UI的class
	//具体指的是 每个小物件的UI
	//能看见道具的图标和描述（Label）
	//还有一个btn来使用（button）
	//再加一个框显示使用后效果
	

	public ItemUI(){
		super("PINKY姐贵");
		
		this.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent arg0) {
				// TODO Auto-generated method stub
				//System.out.print("1");
			}
			
			@Override
			public void windowIconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				//System.out.print("2");
			}
			
			@Override
			public void windowDeiconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				//System.out.print("3");
			}
			
			@Override
			public void windowDeactivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				//System.out.print("4");
			}
			
			@Override
			public void windowClosing(WindowEvent arg0) {
				// TODO Auto-generated method stub
				dispose();
				new InventoryUI();
			}
			
			@Override
			public void windowClosed(WindowEvent arg0) {
				// TODO Auto-generated method stub
				//System.out.print("6");
			}
			
			@Override
			public void windowActivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				//System.out.print("7");
			}
		});
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(500,550);
		this.setLocation(1200, 500);
		// maximized at first f.setExtendedState(JFrame.MAXIMIZED_BOTH);
		

		Container container = getContentPane();
		
		JPanel panel = new JPanel();
		
		// 道具的图片（现在道具名字为例子，到时候要改），位于左边
		ImageIcon pinky = new ImageIcon("pinky.png");
		JLabel label1 = new JLabel(pinky, JLabel.NORTH_EAST);
		// 道具的名字， 位于顶部（也是标题的名字）
		JLabel label2 = new JLabel("噔噔咚！（绝望）",JLabel.RIGHT);
		// 道具的描述， 位于名字下面
		JLabel label3 = new JLabel("pinky姐贵", JLabel.CENTER);
		// 道具的效果，位于名字下面或右边
		JLabel label4 = new JLabel("心肺停止，对方即死效果",JLabel.CENTER);
		// 现在位置放置还存在问题（小问题），非常僵的摆放
		
		// 图标就设置为道具的图片
		Image image = pinky.getImage();
		setIconImage(image);

		// 一个文本框，显示使用或者丢弃道具后的内容
		JTextArea tf = new JTextArea(10,30);
		
		// 两个按钮，道具的使用，丢弃
		JButton button1 = new JButton("Use");
		JButton button2 = new JButton("Drap");
		button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //吃掉这个食物，装备武器，装备防具
            	//让内容显示在文本框里面
            	int n = JOptionPane.showConfirmDialog(null, "你疯了要吃pinky？", "天使", JOptionPane.YES_NO_OPTION);   
            	if (n == JOptionPane.YES_OPTION) {   
            		//操作：食物（remove），
            		//武器防具不移除，改变人物装备的状态（如果相同，则不变，而且不能叠加）
            		//食物：inventoryUI相应图标还原，联系切断
            		
            	    JOptionPane.showMessageDialog(new JFrame(),"已死亡");  
            	    tf.setText("噔噔咚！");
            	} else if (n == JOptionPane.NO_OPTION) {   
            	    JOptionPane.showMessageDialog(new JFrame(),"已心停止"); 
            	    tf.setText("噔噔咚噔噔！");
            	}  
            }
        });
		button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //丢掉这个item
            	int n = JOptionPane.showConfirmDialog(null, "扔掉pinky?", "天使", JOptionPane.YES_NO_OPTION);   
            	if (n == JOptionPane.YES_OPTION) {   
            		//remove（item）,
            		//inventoryUI相应图标还原，联系切断
            		
            		
            	    JOptionPane.showMessageDialog(new JFrame(),"十你悔改罢十");  
            	    tf.setText("（绝望）");
            	} else if (n == JOptionPane.NO_OPTION) {   
            	    JOptionPane.showMessageDialog(new JFrame(),"（绝望）");  
            	}  
            	tf.setText("（即死）");
            }
        });
	
		// 美化部分
		// 边框
		Border border = BorderFactory.createLineBorder(Color.BLACK, 10);
		// 背景色
		panel.setBackground(Color.lightGray);
		// 字体
		//Font font = new Font("华文彩云", Font.ITALIC,24);

		// 布局	
		panel.setLayout(null);
		label1.setBounds(20 ,10, 250, 250);
		label2.setBounds(290,10, 120, 100);
		label4.setBounds(290,50, 150, 200);
		label3.setBounds(290,180, 120, 100);
		button1.setBounds(100, 280, 70, 40);
		button2.setBounds(290, 280, 70, 40);
		tf.setBounds(20, 330, 440, 100);
		
		panel.setBorder(border);
		panel.add(label1);
		panel.add(label2);
		panel.add(label3);
		panel.add(label4);
		panel.add(tf);
		panel.add(button1);
		panel.add(button2);
		
		container.add(panel);
		setResizable(false);
		setVisible(true);
		requestFocus();
	}
	public static void main(String[] args) {
		ItemUI f = new ItemUI();	
	}
}
