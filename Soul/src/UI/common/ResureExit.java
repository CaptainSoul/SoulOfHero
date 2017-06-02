package UI.common;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Window.Type;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import UI.MainApp;
import character.Sprite;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ResureExit {

	private JFrame frame;
	private JLabel lblSure;
	private Sprite sprite;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResureExit window = new ResureExit(new Sprite("Dec"));
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
					ResureExit window = new ResureExit(sprite);
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
	public ResureExit(Sprite sprite) {
		this.sprite = sprite;
		initialize();
		Dimension screenSize=java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize= frame.getSize();
		frame.setLocation((screenSize.width-frameSize.width)/2,(screenSize.height-frameSize.height)/2);
		frame.getContentPane().setLayout(null);
		
		JButton btnYes = new JButton("");
		btnYes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainApp.loginView = true;
				frame.dispose();
			}
		});
		btnYes.setBackground(new Color(0, 0, 0));
		btnYes.setForeground(new Color(0, 0, 0));
		btnYes.setIcon(new ImageIcon(ResureExit.class.getResource("/pic/menu/Yes_1.png")));
		btnYes.setRolloverIcon(new ImageIcon(MenuBar.class.getResource("/pic/menu/Yes_2.png")));
		btnYes.setBorderPainted(false);
		btnYes.setOpaque(false);	
		btnYes.setBounds(46, 142, 65, 45);
		frame.getContentPane().add(btnYes);
		
		JButton btnNo = new JButton("");
		btnNo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuBar menuBar = new MenuBar(sprite);
				menuBar.main();
				frame.dispose();
			}
		});
		btnNo.setBackground(new Color(0, 0, 0));
		btnNo.setForeground(new Color(0, 0, 0));
		btnNo.setIcon(new ImageIcon(ResureExit.class.getResource("/pic/menu/No_1.png")));
		btnNo.setRolloverIcon(new ImageIcon(MenuBar.class.getResource("/pic/menu/No_2.png")));
		btnNo.setBorderPainted(false);
		btnNo.setOpaque(false);	
		btnNo.setBounds(165, 142, 65, 45);
		frame.getContentPane().add(btnNo);
		
		JLabel lblSure = new JLabel("Exit Game?");
		lblSure.setFont(new Font("Comic Sans MS", Font.BOLD, 21));
		lblSure.setForeground(new Color(173, 255, 47));
		lblSure.setBackground(new Color(0, 0, 0));
		lblSure.setBounds(39, 34, 221, 95);
		frame.getContentPane().add(lblSure);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ResureExit.class.getResource("/pic/common/nevermore.jpg")));
		label.setBounds(0, 0, 280, 200);
		frame.getContentPane().add(label);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setAlwaysOnTop(true);
		frame.setResizable(false);
		frame.setType(Type.UTILITY);
		frame.setBounds(100, 100, 280, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true);
	}
	
	public void updateSprite(Sprite sprite) {
		this.sprite = sprite;
	}
	
	public void setTxt(String txt) {
		lblSure.setText(txt);
	}

}
