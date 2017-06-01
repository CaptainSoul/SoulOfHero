package UI.common;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import character.Sprite;

import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SpriteBar {
	
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
					SpriteBar window = new SpriteBar(new Sprite("Dec"));
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
					SpriteBar window = new SpriteBar(sprite);
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
	public SpriteBar(Sprite sprite) {
		this.sprite = sprite;
		initialize();
		Dimension screenSize=java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize= frame.getSize();
		frame.setLocation((screenSize.width-frameSize.width)/2,(screenSize.height-frameSize.height)/2);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setAlwaysOnTop(true);
		frame.setResizable(false);
		frame.setUndecorated(true);
		frame.setBounds(100, 100, 587, 465);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBackground(Color.WHITE);
		lblName.setForeground(new Color(102, 102, 51));
		lblName.setFont(new Font("Comic Sans MS", Font.ITALIC, 23));
		lblName.setBounds(43, 65, 100, 40);
		frame.getContentPane().add(lblName);
		
		JLabel lblLevel = new JLabel("Level:");
		lblLevel.setBackground(Color.WHITE);
		lblLevel.setForeground(new Color(102, 102, 51));
		lblLevel.setFont(new Font("Comic Sans MS", Font.ITALIC, 23));
		lblLevel.setBounds(43, 110, 100, 40);
		frame.getContentPane().add(lblLevel);
		
		JLabel lblHp = new JLabel("HP:");
		lblHp.setBackground(Color.WHITE);
		lblHp.setForeground(new Color(102, 102, 51));
		lblHp.setFont(new Font("Comic Sans MS", Font.ITALIC, 23));	
		lblHp.setBounds(43, 155, 100, 40);
		frame.getContentPane().add(lblHp);
		
		JLabel lblMp = new JLabel("MP:");
		lblMp.setBackground(Color.WHITE);
		lblMp.setForeground(new Color(102, 102, 51));
		lblMp.setFont(new Font("Comic Sans MS", Font.ITALIC, 23));
		lblMp.setBounds(43, 200, 100, 40);
		frame.getContentPane().add(lblMp);
		
		JLabel lblStrength = new JLabel("Strength:");
		lblStrength.setBackground(Color.WHITE);
		lblStrength.setForeground(new Color(102, 102, 51));
		lblStrength.setFont(new Font("Comic Sans MS", Font.ITALIC, 23));
		lblStrength.setBounds(43, 250, 110, 40);
		frame.getContentPane().add(lblStrength);
		
		JLabel lblAttack = new JLabel("Attack:");
		lblAttack.setBackground(Color.WHITE);
		lblAttack.setForeground(new Color(102, 102, 51));
		lblAttack.setFont(new Font("Comic Sans MS", Font.ITALIC, 23));
		lblAttack.setBounds(43, 295, 110, 40);
		frame.getContentPane().add(lblAttack);
		
		JLabel lblDefence = new JLabel("Defence:");
		lblDefence.setBackground(Color.WHITE);
		lblDefence.setForeground(new Color(102, 102, 51));
		lblDefence.setFont(new Font("Comic Sans MS", Font.ITALIC, 23));
		lblDefence.setBounds(43, 340, 110, 40);
		frame.getContentPane().add(lblDefence);
		
		JLabel name = new JLabel("name");
		name.setText(sprite.getName());
		name.setFont(new Font("Comic Sans MS", Font.PLAIN, 21));
		name.setForeground(new Color(204, 204, 204));
		name.setBounds(163, 76, 72, 18);
		frame.getContentPane().add(name);
		
		JLabel level = new JLabel("level");
		level.setText("" + sprite.getLevel());
		level.setForeground(new Color(204, 204, 204));
		level.setFont(new Font("Comic Sans MS", Font.PLAIN, 21));
		level.setBounds(163, 122, 72, 18);
		frame.getContentPane().add(level);
		
		JLabel hp = new JLabel("hp");
		hp.setText(sprite.getHp() + "/" + sprite.getMaxHp());
		hp.setForeground(new Color(204, 204, 204));
		hp.setFont(new Font("Comic Sans MS", Font.PLAIN, 21));
		hp.setBounds(163, 165, 110, 18);
		frame.getContentPane().add(hp);
		
		JLabel mp = new JLabel("mp");
		mp.setText(sprite.getMp() + "/" + sprite.getMaxMp());
		mp.setForeground(new Color(204, 204, 204));
		mp.setFont(new Font("Comic Sans MS", Font.PLAIN, 21));
		mp.setBounds(163, 214, 110, 18);
		frame.getContentPane().add(mp);
		
		JLabel strength = new JLabel("strength");
		strength.setText("" + sprite.getStrength());
		strength.setForeground(new Color(204, 204, 204));
		strength.setFont(new Font("Comic Sans MS", Font.PLAIN, 21));
		strength.setBounds(163, 263, 72, 18);
		frame.getContentPane().add(strength);
		
		JLabel attack = new JLabel("attack");
		attack.setText("" + sprite.getAttack());
		attack.setForeground(new Color(204, 204, 204));
		attack.setFont(new Font("Comic Sans MS", Font.PLAIN, 21));
		attack.setBounds(163, 308, 72, 18);
		frame.getContentPane().add(attack);
		
		JLabel defence = new JLabel("defence");
		defence.setText("" + sprite.getDefence());
		defence.setForeground(new Color(204, 204, 204));
		defence.setFont(new Font("Comic Sans MS", Font.PLAIN, 21));
		defence.setBounds(163, 353, 72, 18);
		frame.getContentPane().add(defence);
		
		JButton btnBack = new JButton("Back");
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
		btnBack.setBackground(Color.WHITE);
	/*	btnBack.setIcon(new ImageIcon(MenuBar.class.getResource("/pic/menu/Inventory.png")));
		btnBack.setRolloverIcon(new ImageIcon(MenuBar.class.getResource("/pic/menu/InventoryR.png")));
	*/	btnBack.setBorderPainted(false);
		btnBack.setOpaque(false);	
		btnBack.setBounds(14, 393, 110, 40);
		frame.getContentPane().add(btnBack);
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon(SpriteBar.class.getResource("/pic/common/demo1.png")));
		lblBackground.setBounds(0, 0, 587, 465);
		frame.getContentPane().add(lblBackground);
	}
	
	public void updateSprite(Sprite sprite) {
		this.sprite = sprite;
	}
	
	public Sprite getSprite() {
		return sprite;
	}
}
