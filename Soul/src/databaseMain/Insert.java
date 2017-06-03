package databaseMain;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


import databaseFrame.insert.*;

public class Insert {
	private JFrame frame;
	private JPanel contentPane;
	private JButton btnInventory;
	private JButton btnItem;
	private JButton btnArmor;
	private JButton btnWeapon;
	private JButton btnFood;
	private JButton btnSkill;
	private JButton btnSkillBase;
	private JButton btnSprite;
	private JButton btnBack;
	private JButton btnExit;
	private JLabel lblEntity;

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
			Insert window = new Insert();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the application.
	 */
	public Insert() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 340);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(getContentPane());
		frame.getContentPane().setLayout(null);
		Dimension screenSize=java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize= frame.getSize();
		frame.setLocation((screenSize.width-frameSize.width)/2,(screenSize.height+frameSize.height)/2);
		frame.setResizable(false);
	}
	
	private JPanel getContentPane() {
		if(contentPane == null) {
			contentPane = new JPanel();
			contentPane.setBackground(new Color(102, 153, 204));
			contentPane.setForeground(new Color(0, 0, 0));
			contentPane.add(getBtnInventory());
			contentPane.add(getBtnItem());
			contentPane.add(getBtnArmor());
			contentPane.add(getBtnWeapon());
			contentPane.add(getBtnFood());
			contentPane.add(getBtnSkill());
			contentPane.add(getBtnSkillBase());
			contentPane.add(getBtnSprite());
			contentPane.add(getBtnBack());
			contentPane.add(getBtnExit());
			contentPane.add(getLblEntity());
		}
		return contentPane;
	}
	private JButton getBtnInventory() {
		if (btnInventory == null) {
			btnInventory = new JButton("Inventory");
			btnInventory.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			btnInventory.setFont(new Font("Arial Black", Font.BOLD, 15));
			btnInventory.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					InventoryInsert inventoryInsert = new InventoryInsert();
					inventoryInsert.run();
					frame.dispose();
				}
			});
			btnInventory.setBounds(249, 55, 132, 27);
		}
		return btnInventory;
	}
	private JButton getBtnItem() {
		if (btnItem == null) {
			btnItem = new JButton("Item");
			btnItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			btnItem.setFont(new Font("Arial Black", Font.BOLD, 15));
			btnItem.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					ItemInsert itemInsert = new ItemInsert();
					itemInsert.run();
					frame.dispose();
				}
			});
			btnItem.setBounds(57, 95, 132, 27);
		}
		return btnItem;
	}
	private JButton getBtnArmor() {
		if (btnArmor == null) {
			btnArmor = new JButton("Armor");
			btnArmor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			btnArmor.setFont(new Font("Arial Black", Font.BOLD, 15));
			btnArmor.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					ArmorInsert armorInsert = new ArmorInsert();
					armorInsert.run();
					frame.dispose();
				}
			});
			btnArmor.setBounds(249, 135, 132, 27);
		}
		return btnArmor;
	}
	private JButton getBtnWeapon() {
		if (btnWeapon == null) {
			btnWeapon = new JButton("Weapon");
			btnWeapon.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			btnWeapon.setFont(new Font("Arial Black", Font.BOLD, 15));
			btnWeapon.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					WeaponInsert weaponInsert = new WeaponInsert();
					weaponInsert.run();
					frame.dispose();
				}
			});
			btnWeapon.setBounds(57, 135, 132, 27);
		}
		return btnWeapon;
	}
	private JButton getBtnFood() {
		if (btnFood == null) {
			btnFood = new JButton("Food");
			btnFood.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			btnFood.setFont(new Font("Arial Black", Font.BOLD, 15));
			btnFood.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					FoodInsert foodInsert = new FoodInsert();
					foodInsert.run();
					frame.dispose();
				}
			});
			btnFood.setBounds(249, 95, 132, 27);
		}
		return btnFood;
	}
	private JButton getBtnSkill() {
		if (btnSkill == null) {
			btnSkill = new JButton("Skill");
			btnSkill.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			btnSkill.setFont(new Font("Arial Black", Font.BOLD, 15));
			btnSkill.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					SkillInsert skillInsert = new SkillInsert();
					skillInsert.run();
					frame.dispose();
				}
			});
			btnSkill.setBounds(57, 175, 132, 27);
		}
		return btnSkill;
	}
	private JButton getBtnSkillBase() {
		if (btnSkillBase == null) {
			btnSkillBase = new JButton("SkillBase");
			btnSkillBase.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			btnSkillBase.setFont(new Font("Arial Black", Font.BOLD, 15));
			btnSkillBase.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					SkillBaseInsert skillBaseInsert = new SkillBaseInsert();
					skillBaseInsert.run();
					frame.dispose();
				}
			});
			btnSkillBase.setBounds(249, 175, 132, 27);
		}
		return btnSkillBase;
	}
	private JButton getBtnSprite() {
		if (btnSprite == null) {
			btnSprite = new JButton("Sprite");
			btnSprite.setFont(new Font("Arial Black", Font.BOLD, 15));
			btnSprite.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			btnSprite.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					SpriteInsert spriteInsert = new SpriteInsert();
					spriteInsert.run();
					frame.dispose();
				}
			});
			btnSprite.setBounds(57, 55, 132, 27);
		}
		return btnSprite;
	}
	private JButton getBtnBack() {
		if (btnBack == null) {
			btnBack = new JButton("BACK");
			btnBack.setFont(new Font("Arial Black", Font.BOLD, 15));
			btnBack.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					Enter enter = new Enter();
					enter.run();
					frame.dispose();
				}
			});
			btnBack.setBounds(14, 241, 113, 27);
		}
		return btnBack;
	}
	private JButton getBtnExit() {
		if (btnExit == null) {
			btnExit = new JButton("EXIT");
			btnExit.setFont(new Font("Arial Black", Font.BOLD, 15));
			btnExit.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					frame.dispose();
				}
			});
			btnExit.setBounds(305, 241, 113, 27);
		}
		return btnExit;
	}
	
	private JLabel getLblEntity() {
		if (lblEntity == null) {
			lblEntity = new JLabel("Entity");
			lblEntity.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
			lblEntity.setBounds(27, 24, 61, 18);
		}
		return lblEntity;
	}
}
