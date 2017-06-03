package databaseMain;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

import databaseUtils.InitUtils;

public class MainFrame {

	private JFrame frame;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame window = new MainFrame();
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
	public MainFrame() {
		initialize();
		Dimension screenSize=java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize= frame.getSize();
		frame.setLocation((screenSize.width-frameSize.width)/2,(screenSize.height+frameSize.height)/2);
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
		frame.setResizable(false);

	}
	
	private JPanel getContentPane() {
		if(contentPane == null) {
			contentPane = new JPanel();
			contentPane.setBackground(new Color(102, 153, 204));
			JButton btnNewDatabase = new JButton("New DataBase");
			btnNewDatabase.setFont(new Font("Arial Black", Font.PLAIN, 15));
			btnNewDatabase.setBackground(UIManager.getColor("Button.background"));
			btnNewDatabase.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					InitUtils.createDataBase();
				}
			});
			btnNewDatabase.setBounds(135, 26, 164, 27);
			contentPane.add(btnNewDatabase);
			
			JButton btnInitialize = new JButton("Initialize");
			btnInitialize.setFont(new Font("Arial Black", Font.PLAIN, 15));
			btnInitialize.setBackground(UIManager.getColor("Button.background"));
			btnInitialize.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent event) {
					InitUtils.initTables();
				}
			});
			btnInitialize.setBounds(135, 66, 164, 27);
			contentPane.add(btnInitialize);
			
			JButton btnDeleteDatabase = new JButton("Drop DataBase");
			btnDeleteDatabase.setFont(new Font("Arial Black", Font.PLAIN, 15));
			btnDeleteDatabase.setBackground(UIManager.getColor("Button.background"));
			btnDeleteDatabase.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					InitUtils.dropDatabase();
				}
			});
			btnDeleteDatabase.setBounds(135, 146, 164, 27);
			contentPane.add(btnDeleteDatabase);
			
			JButton btnEnterDatabase = new JButton("Enter Database");
			btnEnterDatabase.setFont(new Font("Arial Black", Font.PLAIN, 15));
			btnEnterDatabase.setBackground(UIManager.getColor("Button.background"));
			btnEnterDatabase.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					Enter window = new Enter();
					window.run();
					frame.dispose();
				}
			});
			btnEnterDatabase.setBounds(135, 106, 164, 27);
			contentPane.add(btnEnterDatabase);
			
			JButton btnExit = new JButton("exit");
			btnExit.setFont(new Font("Arial Black", Font.PLAIN, 15));
			btnExit.setBackground(UIManager.getColor("Button.background"));
			btnExit.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					frame.dispose();
				}
			});
			btnExit.setBounds(159, 186, 113, 27);
			contentPane.add(btnExit);
		}
		return contentPane;
	}
	
}
