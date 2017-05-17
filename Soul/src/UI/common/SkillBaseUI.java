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

import skill.Skill;


public class SkillBaseUI extends JFrame{
	//	与InventoryUI类似
	// SkillBase不考虑删除技能选项，只考虑增加技能
	public SkillBaseUI(){
		//"Package"
		super("战斗淫梦");
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(100,500);
		this.setLocation(500, 400);
		// maximized at first f.setExtendedState(JFrame.MAXIMIZED_BOTH);

		Container container = getContentPane();
		
		GridLayout layout = new GridLayout(5,1);
		
		JPanel panel = new JPanel();
		
		// 背包格子的图片
		ImageIcon background = new ImageIcon("background.png");
		
		// 图标 
		ImageIcon sik = new ImageIcon("sik.png");
		Image image = sik.getImage();
		setIconImage(image);
		
		// 5个按钮，1*5大小
		JButton[][] btn = new JButton[5][1]; 
		// 每个按钮都设置事件监听
		for ( int i = 0; i != 5; i++){
				btn[i][0] = new JButton(" ");
				btn[i][0].setIcon(background);
		// 大UI需要实现的事件：
		// 点击按钮，打开小UI, 大UI隐藏
		// 关闭小UI，大UI回复
				btn[i][0].addActionListener(new ActionListener() {				
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						dispose();
						new SkillUI();
					}
				});
		}
		
		//这部分暂时未写，内容为：skill与按钮的联系,无skill时按钮的图片
		//加上skill时，skill的图片转变，建立联系
		//需要调整图片的大小，已锁定框大小，调整合适大小放入即可
		ImageIcon yajue = new ImageIcon("YJSNPI.png");
		btn[0][0].setIcon(sik);
		btn[1][0].setIcon(yajue);
		
		// 边框
		Border border = BorderFactory.createTitledBorder("SkillBase");
		// 字体
		//Font font = new Font("华文彩云", Font.ITALIC,24);

		// 布局	
		panel.setLayout(layout);
		
		// 加按钮
		for ( int i = 0; i != 5; i++){
			panel.add(btn[i][0]);
		}
		panel.setBorder(border);
		container.add(panel);
		setResizable(false);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SkillBaseUI skillBaseUI = new SkillBaseUI();
	}

}
