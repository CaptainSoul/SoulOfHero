package UI;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import archive.Archive;
import databaseService.ArchiveService;
import scenario.WelcomeFrame;

import javax.swing.ImageIcon;
import java.awt.Window.Type;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseMotionAdapter;

public class StartFrame {

	public static JFrame frmSoulOfHero;
	private JButton btnStart;
	private JButton btnContinue;
	private JButton btnExit;
	private JLabel label_1;

	/**
	 * Launch the application.
	 */
	public void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartFrame window = new StartFrame();
					window.frmSoulOfHero.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the application.
	 */
	public StartFrame() {
		initialize();
		Dimension screenSize=java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize= frmSoulOfHero.getSize();
		frmSoulOfHero.setLocation((screenSize.width-frameSize.width)/2,(screenSize.height-frameSize.height)/2);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		BGM.bgmStart = true;
		frmSoulOfHero = new JFrame();
		frmSoulOfHero.setType(Type.NORMAL);
		frmSoulOfHero.setResizable(false);
		frmSoulOfHero.setTitle("Soul of Hero");
		frmSoulOfHero.setBounds(100, 100, 1600, 892);
		frmSoulOfHero.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSoulOfHero.getContentPane().setLayout(null);
		frmSoulOfHero.requestFocusInWindow();
		btnStart = new JButton("");
		btnStart.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				btnContinue.setSelected(false);
				btnExit.setSelected(false);
				btnStart.setSelected(true);
				btnStart.requestFocus();
			}
		});
		btnStart.setSelected(true);
		btnStart.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				if(key == KeyEvent.VK_DOWN) {
					btnStart.setSelected(false);
					btnContinue.setSelected(true);
					btnContinue.requestFocus();
				} else if(key == KeyEvent.VK_ENTER) {
					Archive archive = new Archive("Default");
					ArchiveService archiveService = new ArchiveService();
					archiveService.add(archive);
					WelcomeFrame.main(null);
				}
			}
		});
		btnStart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Archive archive = new Archive("Default");
				ArchiveService archiveService = new ArchiveService();
				archiveService.add(archive);
				WelcomeFrame.main(null);
			}
		});
		btnStart.setIcon(new ImageIcon(StartFrame.class.getResource("/pic/menu/Start.png")));
		btnStart.setRolloverIcon(new ImageIcon(StartFrame.class.getResource("/pic/menu/StartR.png")));
		btnStart.setSelectedIcon(new ImageIcon(StartFrame.class.getResource("/pic/menu/StartR.png")));
		btnStart.setBorderPainted(false);
		btnStart.setOpaque(false);
		btnStart.setBackground(new Color(0, 51, 51));
		btnStart.setBounds(616, 428, 321, 112);
		frmSoulOfHero.getContentPane().add(btnStart);
		
		btnContinue = new JButton("");
		btnContinue.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				WelcomeFrame.main(null);
				frmSoulOfHero.dispose();
			}
		});
		btnContinue.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				if(key == KeyEvent.VK_UP) {
					btnStart.setSelected(true);	
					btnStart.requestFocus();
				} else if(key == KeyEvent.VK_DOWN) {
					btnExit.setSelected(true);
					btnExit.requestFocus();
				} else if(key == KeyEvent.VK_ENTER) {
					WelcomeFrame.main(null);
					frmSoulOfHero.dispose();
				}
				btnContinue.setSelected(false);
			}
		});
		btnContinue.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				btnContinue.setSelected(true);
				btnExit.setSelected(false);
				btnStart.setSelected(false);
				btnContinue.requestFocus();
			}
		});
		btnContinue.setIcon(new ImageIcon(StartFrame.class.getResource("/pic/menu/Continue.png")));
		btnContinue.setRolloverIcon(new ImageIcon(StartFrame.class.getResource("/pic/menu/ContinueR.png")));
		btnContinue.setSelectedIcon(new ImageIcon(StartFrame.class.getResource("/pic/menu/ContinueR.png")));
		btnContinue.setBorderPainted(false);
		btnContinue.setOpaque(false);
		btnContinue.setBackground(new Color(0, 51, 51));
		btnContinue.setBounds(616, 567, 321, 112);
		frmSoulOfHero.getContentPane().add(btnContinue);
		
		btnExit = new JButton("");
		btnExit.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				if(key == KeyEvent.VK_UP) {
					btnContinue.requestFocus();
					btnContinue.setSelected(true);
					btnExit.setSelected(false);
				} else if(key == KeyEvent.VK_ENTER) {
					frmSoulOfHero.dispose();
				}
			}
		});
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmSoulOfHero.dispose();
			}
		});
		btnExit.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				btnContinue.setSelected(false);
				btnExit.setSelected(true);
				btnStart.setSelected(false);
				btnExit.requestFocus();
			}
		});
		btnExit.setIcon(new ImageIcon(StartFrame.class.getResource("/pic/menu/Exit.png")));
		btnExit.setRolloverIcon(new ImageIcon(StartFrame.class.getResource("/pic/menu/ExitR.png")));
		btnExit.setSelectedIcon(new ImageIcon(StartFrame.class.getResource("/pic/menu/ExitR.png")));
		btnExit.setBorderPainted(false);
		btnExit.setOpaque(false);
		btnExit.setBackground(new Color(0, 51, 51));
		btnExit.setBounds(616, 707, 321, 112);
		frmSoulOfHero.getContentPane().add(btnExit);
		
		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(StartFrame.class.getResource("/pic/common/Soul of Hero.png")));
		label_1.setBounds(373, 223, 903, 86);
		frmSoulOfHero.getContentPane().add(label_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(StartFrame.class.getResource("/pic/common/dragon.jpg")));
		label.setBounds(0, 0, 1600, 892);
		frmSoulOfHero.getContentPane().add(label);
	}
	
	public static void dispose() {
		frmSoulOfHero.dispose();
	}
}
