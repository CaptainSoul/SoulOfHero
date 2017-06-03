package UI.common;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Window.Type;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import character.Sprite;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuBar {

	private JFrame frame;
	private Sprite sprite;
	private SpriteBar spriteBar;
	private SkillBar skillBar;
	private ResureExit resureExit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuBar window = new MenuBar(new Sprite("Dec"));
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
					MenuBar window = new MenuBar(sprite);
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
	public MenuBar(Sprite sprite) {
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
		frame.setType(Type.UTILITY);
		frame.setBounds(100, 100, 230, 360);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true);
		frame.getContentPane().setLayout(null);
		
		JButton btnBack = new JButton("");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
			}
		});
		btnBack.setBackground(Color.WHITE);
		btnBack.setIcon(new ImageIcon(MenuBar.class.getResource("/pic/menu/Back.png")));
		btnBack.setRolloverIcon(new ImageIcon(MenuBar.class.getResource("/pic/menu/BackR.png")));
		btnBack.setBorderPainted(false);
		btnBack.setOpaque(false);
		btnBack.setBounds(0, 0, 230, 60);
		frame.getContentPane().add(btnBack);
		
		JButton btnSprite = new JButton("");
		btnSprite.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(spriteBar == null)
					spriteBar = new SpriteBar(sprite);
				else
					spriteBar.updateSprite(sprite);
				spriteBar.main();
				frame.dispose();
			}
		});
		btnSprite.setBackground(Color.WHITE);
		btnSprite.setIcon(new ImageIcon(MenuBar.class.getResource("/pic/menu/Sprite.png")));
		btnSprite.setRolloverIcon(new ImageIcon(MenuBar.class.getResource("/pic/menu/SpriteR.png")));
		btnSprite.setBorderPainted(false);
		btnSprite.setOpaque(false);
		btnSprite.setBounds(0, 60, 230, 60);
		frame.getContentPane().add(btnSprite);
		
		
		JButton btnSkill = new JButton("");
		btnSkill.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(skillBar == null)
					skillBar = new SkillBar(sprite);
				else
					skillBar.updateSprite(sprite);
				skillBar.main();
				frame.dispose();
			}
		});
		btnSkill.setBackground(Color.WHITE);
		btnSkill.setIcon(new ImageIcon(MenuBar.class.getResource("/pic/menu/Skill.png")));
		btnSkill.setRolloverIcon(new ImageIcon(MenuBar.class.getResource("/pic/menu/SkillR.png")));
		btnSkill.setBorderPainted(false);
		btnSkill.setOpaque(false);
		btnSkill.setBounds(0, 120, 230, 60);
		frame.getContentPane().add(btnSkill);
		
		JButton btnInventory = new JButton("");
		btnSkill.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(skillBar == null)
					skillBar = new SkillBar(sprite);
				else
					skillBar.updateSprite(sprite);
				skillBar.main();
				frame.dispose();
			}
		});
		btnInventory.setBackground(Color.WHITE);
		btnInventory.setIcon(new ImageIcon(MenuBar.class.getResource("/pic/menu/Inventory.png")));
		btnInventory.setRolloverIcon(new ImageIcon(MenuBar.class.getResource("/pic/menu/InventoryR.png")));
		btnInventory.setBorderPainted(false);
		btnInventory.setOpaque(false);
		btnInventory.setBounds(0, 180, 230, 60);
		frame.getContentPane().add(btnInventory);
		
		JButton btnSave = new JButton("");
		btnSkill.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		btnSave.setBackground(Color.WHITE);
		btnSave.setIcon(new ImageIcon(MenuBar.class.getResource("/pic/menu/Save.png")));
		btnSave.setRolloverIcon(new ImageIcon(MenuBar.class.getResource("/pic/menu/SaveR.png")));
		btnSave.setBorderPainted(false);
		btnSave.setOpaque(false);
		btnSave.setBounds(0, 240, 115, 60);
		frame.getContentPane().add(btnSave);
		
		JButton btnLoad = new JButton("");
		btnLoad.setBackground(Color.WHITE);
		btnLoad.setIcon(new ImageIcon(MenuBar.class.getResource("/pic/menu/Load.png")));
		btnLoad.setRolloverIcon(new ImageIcon(MenuBar.class.getResource("/pic/menu/LoadR.png")));
		btnLoad.setBorderPainted(false);
		btnLoad.setOpaque(false);
		btnLoad.setBounds(115, 240, 115, 60);
		frame.getContentPane().add(btnLoad);
		
		JButton btnExit = new JButton("");
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(resureExit == null)
					resureExit = new ResureExit(sprite);
				else
					resureExit.updateSprite(sprite);
				resureExit.main();
				frame.dispose();
			}
		});
		btnExit.setBackground(Color.WHITE);
		btnExit.setIcon(new ImageIcon(MenuBar.class.getResource("/pic/menu/ExitM.png")));
		btnExit.setRolloverIcon(new ImageIcon(MenuBar.class.getResource("/pic/menu/ExitMR.png")));
		btnExit.setBorderPainted(false);
		btnExit.setOpaque(false);
		btnExit.setBounds(0, 300, 230, 60);
		frame.getContentPane().add(btnExit);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(MenuBar.class.getResource("/pic/common/demon.jpg")));
		label.setBounds(0, 0, 230, 360);
		frame.getContentPane().add(label);
	}
	
	public void updateSprite(Sprite sprite) {
		this.sprite = sprite;
	}
	
	public Sprite getSprite() {
		return sprite;
	}
}
