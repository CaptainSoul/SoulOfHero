package UI.common;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class InventoryUI extends JFrame{
	//大的UI
	//全是按钮组件
	//点击按钮产生事件打开小UI
	
	public InventoryUI(){
		//"Package"
		super("淫梦大家族");
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(400,600);
		this.setLocation(1000, 300);
		// maximized at first f.setExtendedState(JFrame.MAXIMIZED_BOTH);

		Container container = getContentPane();
		
		GridLayout layout = new GridLayout(5,4);
		
		JPanel panel = new JPanel();
		
		// 背包格子的图片
		ImageIcon background = new ImageIcon("background.png");
		
		// 图标 
		ImageIcon yajue = new ImageIcon("YJSNPI.png");
		Image image = yajue.getImage();
		setIconImage(image);
		
		// 20个按钮，4*5大小
		JButton[][] btn = new JButton[5][4]; 
		// 每个按钮都设置事件监听
		for ( int i = 0; i != 5; i++){
			for ( int j = 0; j != 4; j++){
				btn[i][j] = new JButton(" ");
				btn[i][j].setIcon(background);
			}
		}
		
		//这部分暂时未写，内容为：item与按钮的联系,无item时按钮的图片
		//加上item时，item的图片转变，建立联系, 考虑编号问题：如果i=5满，换行
		// int countA = 0;
		// int countB = 0;
		// 产生action时countA和countB改变
		// countA = 3,获得item, countA = 0 并且countB++， numItems++
		// countA = 0,减少item, countA = 3 并且countB--， numItems--
		//失去item时，item的图片改回background，剪断联系
		//需要调整图片的大小，已锁定框大小，调整合适大小放入即可
		//以下为思想：（当一个物品获得时）
		ImageIcon pinky = new ImageIcon("pinky.png");
		btn[0][0].setIcon(yajue);
		btn[0][1].setIcon(pinky);
		// 大UI需要实现的事件：
		// 点击按钮，打开小UI, 大UI隐藏
		// 关闭小UI，大UI回复
			btn[0][0].addActionListener(new ActionListener() {				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					dispose();
					new ItemUI();
				}
			});
		//(当一个物品失去时)
		btn[0][1].setIcon(background);
		
		
		// 边框
		Border border = BorderFactory.createTitledBorder("Package");
		// 字体
		//Font font = new Font("华文彩云", Font.ITALIC,24);

		// 布局	
		panel.setLayout(layout);
		
		// 加按钮
		for ( int i = 0; i != 5; i++){
			for ( int j = 0; j != 4; j++){
				panel.add(btn[i][j]);
			}
		}
		panel.setBorder(border);
		container.add(panel);
		setResizable(false);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InventoryUI f = new InventoryUI();
	}

}
