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

import databaseMain.Update;
import databaseService.SkillService;
import skill.Skill;

public class SkillUpdate {

	private JFrame frame;
	private JPanel contentPane;
	private JTextField code;
	private JTextField name;
	private JTextField description;
	private JTextField damage;
	
	private SkillService skillService;

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
			SkillUpdate window = new SkillUpdate();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the application.
	 */
	public SkillUpdate() {
		initialize();
		skillService = new SkillService();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
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
			contentPane.setBackground(new Color(153, 204, 102));
			
			JLabel lblSkill = new JLabel("Skill");
			lblSkill.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
			lblSkill.setForeground(new Color(51, 102, 153));
			lblSkill.setBackground(Color.BLACK);
			lblSkill.setBounds(32, 25, 106, 18);
			contentPane.add(lblSkill);
			
			JLabel lblCode = new JLabel("Code:");
			lblCode.setForeground(new Color(0, 0, 153));
			lblCode.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			lblCode.setBounds(32, 61, 57, 18);
			contentPane.add(lblCode);
			
			code = new JTextField();
			code.setBounds(103, 60, 191, 24);
			contentPane.add(code);
			code.setColumns(10);
			
			JLabel lblName = new JLabel("Name:");
			lblName.setForeground(new Color(0, 0, 153));
			lblName.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			lblName.setBounds(32, 99, 57, 18);
			contentPane.add(lblName);
			
			name = new JTextField();
			name.setBounds(101, 98, 86, 24);
			contentPane.add(name);
			name.setColumns(10);
			
			JLabel lblDescription = new JLabel("Description:");
			lblDescription.setForeground(new Color(0, 0, 153));
			lblDescription.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			lblDescription.setBounds(32, 135, 92, 18);
			contentPane.add(lblDescription);
			
			description = new JTextField();
			description.setBounds(138, 135, 144, 24);
			contentPane.add(description);
			description.setColumns(10);
			
			JLabel lblDamage = new JLabel("Damage:");
			lblDamage.setForeground(new Color(0, 0, 153));
			lblDamage.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			lblDamage.setBounds(211, 99, 86, 18);
			contentPane.add(lblDamage);
			
			damage = new JTextField();
			damage.setBounds(290, 98, 86, 24);
			contentPane.add(damage);
			damage.setColumns(10);
			
			JButton btnUpdate = new JButton("UPDATE");
			btnUpdate.setFont(new Font("Arial Black", Font.PLAIN, 15));
			btnUpdate.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent event) {
					int code2 = Integer.parseInt(code.getText());
					Skill skill = skillService.query(code2);
					skill.setName(name.getText());
					skill.setDescription(description.getText());
					skill.setDamage(Double.parseDouble(damage.getText()));
					skillService.update(skill);
					JOptionPane.showMessageDialog(null, "Update success", "message", JOptionPane.INFORMATION_MESSAGE);
				}
			});
			btnUpdate.setBounds(162, 213, 113, 27);
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
			btnBack.setBounds(14, 213, 113, 27);
			contentPane.add(btnBack);
			
			JButton btnExit = new JButton("EXIT");
			btnExit.setFont(new Font("Arial Black", Font.PLAIN, 15));
			btnExit.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					frame.dispose();
				}
			});
			btnExit.setBounds(305, 213, 113, 27);
			contentPane.add(btnExit);
		}
		return contentPane;
	}
}

