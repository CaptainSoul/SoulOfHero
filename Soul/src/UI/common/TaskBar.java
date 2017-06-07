package UI.common;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Window.Type;
import java.awt.Color;

public class TaskBar {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TaskBar window = new TaskBar();
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
	public TaskBar() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setType(Type.UTILITY);
		frame.setResizable(false);
		frame.setBounds(100, 100, 1600, 892);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnTask1 = new JButton("");
		btnTask1.setBackground(Color.WHITE);
		btnTask1.setBounds(47, 46, 345, 77);
		btnTask1.setIcon(new ImageIcon(TaskBar.class.getResource("/pic/common/Task1.png")));
		btnTask1.setOpaque(false);
		btnTask1.setBorderPainted(false);
		frame.getContentPane().add(btnTask1);
		
		JButton btnDes1 = new JButton("");
		btnDes1.setIcon(new ImageIcon(TaskBar.class.getResource("/pic/common/TDes1.png")));
		btnDes1.setBackground(Color.WHITE);
		btnDes1.setBounds(445, 13, 1149, 143);
		btnDes1.setOpaque(false);
		btnDes1.setBorderPainted(false);
		frame.getContentPane().add(btnDes1);
		
		JButton btnTask2 = new JButton("");
		btnTask2.setBackground(Color.WHITE);
		btnTask2.setBounds(47, 218, 345, 77);
		btnTask2.setIcon(new ImageIcon(TaskBar.class.getResource("/pic/common/Task2.png")));
		btnTask2.setOpaque(false);
		btnTask2.setBorderPainted(false);
		frame.getContentPane().add(btnTask2);
		
		JButton btnDes2 = new JButton("");
		btnDes2.setIcon(new ImageIcon(TaskBar.class.getResource("/pic/common/TDes1.png")));
		btnDes2.setBackground(Color.WHITE);
		btnDes2.setBounds(445, 185, 1149, 143);
		btnDes2.setOpaque(false);
		btnDes2.setBorderPainted(false);
		frame.getContentPane().add(btnDes2);
		
		JButton btnTask3 = new JButton("");
		btnTask3.setBackground(Color.WHITE);
		btnTask3.setBounds(47, 390, 345, 77);
		btnTask3.setIcon(new ImageIcon(TaskBar.class.getResource("/pic/common/Task3.png")));
		btnTask3.setOpaque(false);
		btnTask3.setBorderPainted(false);
		frame.getContentPane().add(btnTask3);
		
		JButton btnDes3 = new JButton("");
		btnDes3.setIcon(new ImageIcon(TaskBar.class.getResource("/pic/common/TDes1.png")));
		btnDes3.setBackground(Color.WHITE);
		btnDes3.setBounds(445, 357, 1149, 143);
		btnDes3.setOpaque(false);
		btnDes3.setBorderPainted(false);
		frame.getContentPane().add(btnDes3);
		
		JButton btnTask4 = new JButton("");
		btnTask4.setBackground(Color.WHITE);
		btnTask4.setBounds(47, 563, 345, 75);
		btnTask4.setIcon(new ImageIcon(TaskBar.class.getResource("/pic/common/Task4.png")));
		btnTask4.setOpaque(false);
		btnTask4.setBorderPainted(false);		
		frame.getContentPane().add(btnTask4);
		
		JButton btnDes4 = new JButton("");
		btnDes4.setIcon(new ImageIcon(TaskBar.class.getResource("/pic/common/TDes1.png")));
		btnDes4.setBackground(Color.WHITE);
		btnDes4.setBounds(445, 529, 1149, 143);
		btnDes4.setOpaque(false);
		btnDes4.setBorderPainted(false);
		frame.getContentPane().add(btnDes4);
		
		JButton btnTask5 = new JButton("");
		btnTask5.setBackground(Color.WHITE);
		btnTask5.setBounds(47, 735, 345, 75);
		btnTask5.setIcon(new ImageIcon(TaskBar.class.getResource("/pic/common/Task5.png")));
		btnTask5.setOpaque(false);
		btnTask5.setBorderPainted(false);
		frame.getContentPane().add(btnTask5);
		
		JButton btnDes5 = new JButton("");
		btnDes5.setIcon(new ImageIcon(TaskBar.class.getResource("/pic/common/TDes1.png")));
		btnDes5.setBackground(Color.WHITE);
		btnDes5.setBounds(445, 701, 1149, 143);
		btnDes5.setOpaque(false);
		btnDes5.setBorderPainted(false);
		frame.getContentPane().add(btnDes5);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(TaskBar.class.getResource("/pic/map/demon.jpg")));
		label.setBounds(0, 0, 1600, 892);
		frame.getContentPane().add(label);
		
	}
}
