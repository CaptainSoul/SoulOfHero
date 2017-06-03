package databaseFrame.update;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import character.Sprite;
import character.Sprite.Group;
import databaseMain.Update;
import databaseService.SpriteService;

public class SpriteUpdate {

	private JFrame frame;
	private JPanel contentPane;
	private JTextField code;
	private JTextField name;
	private JTextField hp;
	private JTextField mp;
	private JTextField strength;
	private JTextField defence;
	private JTextField exp;
	private JTextField level;
	private JTextField gold;
	private JTextField move;
	private JTextField group; 	//	 enum
	private JTextField armorCode;
	private JTextField weaponCode;
	private JTextField inventoryCode;
	
	private SpriteService spriteService;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				run();
			}
		});
	}
	
	public void run() {
		try {
			SpriteUpdate window = new SpriteUpdate();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the application.
	 */
	public SpriteUpdate() {
		initialize();
		spriteService = new SpriteService();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 475);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(getContentPane());
		frame.getContentPane().setLayout(null);
		Dimension screenSize=java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize= frame.getSize();
		frame.setLocation((screenSize.width-frameSize.width)/2,(screenSize.height+frameSize.height)/3);
		frame.setResizable(false);
	}
	
	private JPanel getContentPane() {
		if(contentPane == null) {
			contentPane = new JPanel();
			contentPane.setBackground(new Color(153, 204, 102));
			
			JLabel lblSprite = new JLabel("Sprite");
			lblSprite.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
			lblSprite.setForeground(new Color(51, 102, 153));
			lblSprite.setBackground(Color.BLACK);
			lblSprite.setBounds(32, 25, 106, 18);
			contentPane.add(lblSprite);
			
			JLabel lblCode = new JLabel("Code:");
			lblCode.setForeground(new Color(0, 0, 153));
			lblCode.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			lblCode.setBounds(14, 56, 48, 18);
			contentPane.add(lblCode);
			
			code = new JTextField();
			code.setBounds(91, 53, 163, 24);
			contentPane.add(code);
			code.setColumns(10);
			
			JLabel lblName = new JLabel("Name:");
			lblName.setForeground(new Color(0, 0, 153));
			lblName.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			lblName.setBounds(14, 89, 57, 18);
			contentPane.add(lblName);
			
			name = new JTextField();
			name.setBounds(91, 88, 86, 24);
			contentPane.add(name);
			name.setColumns(10);
			
			JLabel lblHp = new JLabel("Hp:");
			lblHp.setForeground(new Color(0, 0, 153));
			lblHp.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			lblHp.setBounds(14, 125, 50, 18);
			contentPane.add(lblHp);
			
			hp = new JTextField();
			hp.setBounds(273, 88, 86, 24);
			contentPane.add(hp);
			hp.setColumns(10);
			
			JLabel lblMp = new JLabel("Mp:");
			lblMp.setForeground(new Color(0, 0, 153));
			lblMp.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			lblMp.setBounds(203, 125, 41, 18);
			contentPane.add(lblMp);
			
			mp = new JTextField();
			mp.setBounds(273, 124, 86, 24);
			contentPane.add(mp);
			mp.setColumns(10);

			JLabel lblStrength = new JLabel("Strength:");
			lblStrength.setForeground(new Color(0, 0, 153));
			lblStrength.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			lblStrength.setBounds(14, 162, 76, 18);
			contentPane.add(lblStrength);
			
			strength = new JTextField();
			strength.setBounds(273, 161, 86, 24);
			contentPane.add(strength);
			strength.setColumns(10);
			
			JLabel lblDefence = new JLabel("Defence:");
			lblDefence.setForeground(new Color(0, 0, 153));
			lblDefence.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			lblDefence.setBounds(203, 162, 65, 18);
			contentPane.add(lblDefence);
			
			defence = new JTextField();
			defence.setBounds(273, 203, 86, 24);
			contentPane.add(defence);
			defence.setColumns(10);
			
			JLabel lblExp = new JLabel("Exp:");
			lblExp.setForeground(new Color(0, 0, 153));
			lblExp.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			lblExp.setBounds(203, 204, 41, 18);
			contentPane.add(lblExp);
			
			exp = new JTextField();
			exp.setBounds(91, 161, 86, 24);
			contentPane.add(exp);
			exp.setColumns(10);
			
			JLabel lblLevel = new JLabel("Level:");
			lblLevel.setForeground(new Color(0, 0, 153));
			lblLevel.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			lblLevel.setBounds(203, 89, 54, 18);
			contentPane.add(lblLevel);
			
			level = new JTextField();
			level.setBounds(91, 203, 86, 24);
			contentPane.add(level);
			level.setColumns(10);
			
			JLabel lblGold = new JLabel("Gold:");
			lblGold.setForeground(new Color(0, 0, 153));
			lblGold.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			lblGold.setBounds(14, 204, 48, 18);
			contentPane.add(lblGold);
			
			gold = new JTextField();
			gold.setBounds(177, 279, 163, 24);
			contentPane.add(gold);
			gold.setColumns(10);
			
			JLabel lblMove = new JLabel("Move:");
			lblMove.setForeground(new Color(0, 0, 153));
			lblMove.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			lblMove.setBounds(14, 243, 57, 18);
			contentPane.add(lblMove);
			
			move = new JTextField();
			move.setBounds(177, 316, 163, 24);
			contentPane.add(move);
			move.setColumns(10);
			
			JLabel lblArmorCode = new JLabel("ArmorCode:");
			lblArmorCode.setForeground(new Color(0, 0, 153));
			lblArmorCode.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			lblArmorCode.setBounds(14, 354, 113, 18);
			contentPane.add(lblArmorCode);
			
			armorCode = new JTextField();
			armorCode.setBounds(177, 353, 163, 24);
			contentPane.add(armorCode);
			armorCode.setColumns(10);
			
			JLabel lblWeaponCode = new JLabel("WeaponCode:");
			lblWeaponCode.setForeground(new Color(0, 0, 153));
			lblWeaponCode.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			lblWeaponCode.setBounds(14, 317, 174, 18);
			contentPane.add(lblWeaponCode);
			
			weaponCode = new JTextField();
			weaponCode.setBounds(91, 242, 86, 24);
			contentPane.add(weaponCode);
			weaponCode.setColumns(10);
			
			JLabel lblInventory = new JLabel("InventoryCode:");
			lblInventory.setForeground(new Color(0, 0, 153));
			lblInventory.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			lblInventory.setBounds(14, 280, 124, 18);
			contentPane.add(lblInventory);
			
			inventoryCode = new JTextField();
			inventoryCode.setBounds(273, 242, 86, 24);
			contentPane.add(inventoryCode);
			inventoryCode.setColumns(10);
			
			JLabel lblGroup = new JLabel("Group:");
			lblGroup.setForeground(new Color(0, 0, 153));
			lblGroup.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			lblGroup.setBounds(203, 243, 86, 18);
			contentPane.add(lblGroup);
			
			group = new JTextField();
			group.setBounds(91, 122, 86, 24);
			contentPane.add(group);
			group.setColumns(10);
			
			JButton btnUpdate = new JButton("UPDATE");
			btnUpdate.setFont(new Font("Arial Black", Font.PLAIN, 15));
			btnUpdate.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent event) {
					int code2 = Integer.parseInt(code.getText());
					Sprite sprite = spriteService.query(code2);
					sprite.setName(name.getText());
					sprite.setHp(Integer.parseInt(hp.getText()));
					sprite.setMp(Integer.parseInt(mp.getText()));
					sprite.setStrength(Integer.parseInt(strength.getText()));
					sprite.setDefence(Integer.parseInt(defence.getText()));
					sprite.setExp(Integer.parseInt(exp.getText()));
					sprite.setLevel(Integer.parseInt(level.getText()));
					sprite.setGold(Integer.parseInt(gold.getText()));
					sprite.setMove(Integer.parseInt(move.getText()));
					sprite.setArmorCode(Integer.parseInt(armorCode.getText()));
					sprite.setWeaponCode(Integer.parseInt(weaponCode.getText()));
					sprite.setInventoryCode(Integer.parseInt(inventoryCode.getText()));
					try{
						if(group.getText().equals("COMMON")) {
							sprite.setGroup(Group.COMMON);
						} else if(group.getText().equals("ENEMY")) {
							sprite.setGroup(Group.ENEMY);
						} else if(group.getText().equals("PLAYER")) {
							sprite.setGroup(Group.PLAYER);
						}
					} catch(Exception e) {
						e.printStackTrace();
					}
					spriteService.update(sprite);
					JOptionPane.showMessageDialog(null, "Update success", "message", JOptionPane.INFORMATION_MESSAGE);
				}
			});
			btnUpdate.setBounds(164, 390, 113, 27);
			contentPane.add(btnUpdate);
			
			JButton btnBack = new JButton("BACK");
			btnBack.setFont(new Font("Arial Black", Font.PLAIN, 15));
			btnBack.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					Update update = new Update();
					update.run();
					frame.dispose();
				}
			});
			btnBack.setBounds(32, 390, 113, 27);
			contentPane.add(btnBack);
			
			JButton btnExit = new JButton("EXIT");
			btnExit.setFont(new Font("Arial Black", Font.PLAIN, 15));
			btnExit.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					frame.dispose();
				}
			});
			btnExit.setBounds(305, 390, 113, 27);
			contentPane.add(btnExit);
		}
		return contentPane;
	}
}

