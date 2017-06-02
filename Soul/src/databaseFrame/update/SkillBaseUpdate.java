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
import databaseService.SkillBaseService;
import skill.SkillBase;

public class SkillBaseUpdate {

	private JFrame frame;
	private JPanel contentPane;
	private JTextField code;
	private JTextField skillCode;
	private JTextField spriteCode;
	
	private SkillBaseService skillBaseService;

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
			SkillBaseUpdate window = new SkillBaseUpdate();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the application.
	 */
	public SkillBaseUpdate() {
		initialize();
		skillBaseService = new SkillBaseService();
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
			
			JLabel lblSkillBase = new JLabel("SkillBase");
			lblSkillBase.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
			lblSkillBase.setForeground(new Color(51, 102, 153));
			lblSkillBase.setBackground(Color.BLACK);
			lblSkillBase.setBounds(32, 25, 106, 18);
			contentPane.add(lblSkillBase);
			
			JLabel lblCode = new JLabel("Code:");
			lblCode.setForeground(new Color(0, 0, 153));
			lblCode.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			lblCode.setBounds(32, 56, 57, 18);
			contentPane.add(lblCode);
			
			code = new JTextField();
			code.setBounds(196, 55, 163, 24);
			contentPane.add(code);
			code.setColumns(10);
			
			JLabel lblSkillCode = new JLabel("SkillCode:");
			lblSkillCode.setForeground(new Color(0, 0, 153));
			lblSkillCode.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			lblSkillCode.setBounds(32, 92, 95, 18);
			contentPane.add(lblSkillCode);
			
			skillCode = new JTextField();
			skillCode.setBounds(196, 91, 163, 24);
			contentPane.add(skillCode);
			skillCode.setColumns(10);
			
			JLabel lblSpriteCode = new JLabel("SpriteCode:");
			lblSpriteCode.setForeground(new Color(0, 0, 153));
			lblSpriteCode.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			lblSpriteCode.setBounds(32, 131, 145, 18);
			contentPane.add(lblSpriteCode);
			
			spriteCode = new JTextField();
			spriteCode.setBounds(196, 130, 163, 24);
			contentPane.add(spriteCode);
			spriteCode.setColumns(10);

			JButton btnUpdate = new JButton("UPDATE");
			btnUpdate.setFont(new Font("Arial Black", Font.BOLD, 15));
			btnUpdate.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent event) {
					int code2 = Integer.parseInt(code.getText());
					SkillBase skillBase = skillBaseService.query(code2);
					skillBase.setSkillCode(Integer.parseInt(skillCode.getText()));
					skillBase.setSpriteCode(Integer.parseInt(spriteCode.getText()));
					skillBaseService.update(skillBase);
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


