package UI.common;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;

import character.Sprite;

import java.awt.Window.Type;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;

public class SkillBar {

	private JFrame frame;
	private Sprite sprite;
	private MenuBar menuBar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SkillBar window = new SkillBar(new Sprite("Dec"));
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SkillBar window = new SkillBar(sprite);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SkillBar(Sprite sprite) {
		this.sprite = sprite;
		initialize();
		Dimension screenSize=java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize= frame.getSize();
		frame.setLocation((screenSize.width-frameSize.width)/2,(screenSize.height-frameSize.height)/2);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(SkillBar.class.getResource("/pic/skill/Ability_Warrior_BattleShout.jpg")));
		btnNewButton.setBounds(85, 73, 64, 64);
		frame.getContentPane().add(btnNewButton);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(SkillBar.class.getResource("/pic/skill/Ability_Rogue_KidneyShot.jpg")));
		button.setBounds(85, 193, 64, 64);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon(SkillBar.class.getResource("/pic/skill/Ability_BullRush.jpg")));
		button_1.setBounds(85, 331, 64, 64);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.setIcon(new ImageIcon(SkillBar.class.getResource("/pic/skill/Ability_TrueShot.jpg")));
		button_2.setBounds(85, 466, 64, 64);
		frame.getContentPane().add(button_2);
		
		JLabel lblAbilitybullrushAttack = new JLabel("");
		lblAbilitybullrushAttack.setIcon(new ImageIcon(SkillBar.class.getResource("/pic/skill/BattleShoutDes.png")));
		lblAbilitybullrushAttack.setBounds(188, 73, 575, 65);
		frame.getContentPane().add(lblAbilitybullrushAttack);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(188, 194, 72, 18);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setBounds(188, 330, 72, 18);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.setBounds(177, 470, 72, 18);
		frame.getContentPane().add(label_4);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(SkillBar.class.getResource("/pic/skill/KidneyShotDes.png")));
		label_1.setBounds(188, 193, 575, 65);
		frame.getContentPane().add(label_1);
		
		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon(SkillBar.class.getResource("/pic/skill/BullRushDes.png")));
		label_5.setBounds(188, 331, 575, 65);
		frame.getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon(SkillBar.class.getResource("/pic/skill/TrueShotDes.png")));
		label_6.setBounds(188, 465, 575, 65);
		frame.getContentPane().add(label_6);
		
		JButton btnBack = new JButton("");
		btnBack.setBackground(new Color(0, 0, 0));
		btnBack.setIcon(new ImageIcon(SpriteBar.class.getResource("/pic/menu/Back.png")));
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(menuBar == null)
					menuBar = new MenuBar(sprite);
				else
					menuBar.updateSprite(sprite);
				menuBar.main();
				frame.dispose();
			}
		});
		btnBack.setIcon(new ImageIcon(MenuBar.class.getResource("/pic/menu/back_1.png")));
		btnBack.setRolloverIcon(new ImageIcon(MenuBar.class.getResource("/pic/menu/back_2.png")));
		btnBack.setBorderPainted(false);
		btnBack.setOpaque(false);	
		btnBack.setBounds(36, 567, 110, 59);
		frame.getContentPane().add(btnBack);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(SkillBar.class.getResource("/pic/common/nevermore.jpg")));
		label.setBounds(0, 0, 1024, 768);
		frame.getContentPane().add(label);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setAlwaysOnTop(true);
		frame.setResizable(false);
		frame.setUndecorated(true);
		frame.setType(Type.UTILITY);
		frame.setBounds(100, 100, 800, 640);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void updateSprite(Sprite sprite) {
		this.sprite = sprite;
	}
}
