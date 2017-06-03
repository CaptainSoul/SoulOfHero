package databaseFrame.insert;

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

import inventory.Inventory;
import databaseMain.Insert;
import databaseService.InventoryService;

public class InventoryInsert {

	private JFrame frame;
	private JPanel contentPane;
	private JTextField code;
	private JTextField maxitem;
	
	private InventoryService inventoryService;

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
			InventoryInsert window = new InventoryInsert();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the application.
	 */
	public InventoryInsert() {
		initialize();
		inventoryService = new InventoryService();
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
			contentPane.setForeground(new Color(0, 0, 153));
			
			JLabel lblInventory = new JLabel("Inventory");
			lblInventory.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
			lblInventory.setForeground(new Color(51, 102, 153));
			lblInventory.setBackground(Color.BLACK);
			lblInventory.setBounds(32, 25, 106, 18);
			contentPane.add(lblInventory);
			
			JLabel lblCode = new JLabel("Code:");
			lblCode.setForeground(new Color(0, 0, 153));
			lblCode.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			lblCode.setBounds(32, 56, 176, 18);
			contentPane.add(lblCode);
			
			code = new JTextField();
			code.setBounds(127, 55, 152, 24);
			contentPane.add(code);
			code.setColumns(10);
			
			JLabel lblMaxItem = new JLabel("MaxItem:");
			lblMaxItem.setForeground(new Color(0, 0, 153));
			lblMaxItem.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			lblMaxItem.setBounds(32, 87, 86, 18);
			contentPane.add(lblMaxItem);
			
			maxitem = new JTextField();
			maxitem.setBounds(127, 87, 152, 24);
			contentPane.add(maxitem);
			maxitem.setColumns(10);
			
			JButton btnInsert = new JButton("INSERT");
			btnInsert.setFont(new Font("Arial Black", Font.BOLD, 15));
			btnInsert.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent event) {
					Inventory inventory = new Inventory();
					inventory.setMaxItem(Integer.parseInt(maxitem.getText()));
					inventoryService.add(inventory);
					JOptionPane.showMessageDialog(null, "Insert success", "message", JOptionPane.INFORMATION_MESSAGE);
					
				}
			});
			btnInsert.setBounds(162, 213, 113, 27);
			contentPane.add(btnInsert);
			
			JButton btnBack = new JButton("BACK");
			btnBack.setFont(new Font("Arial Black", Font.BOLD, 15));
			btnBack.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					Insert insert = new Insert();
					insert.run();
					frame.dispose();
				}
			});
			btnBack.setBounds(14, 213, 113, 27);
			contentPane.add(btnBack);
			
			JButton btnExit = new JButton("EXIT");
			btnExit.setFont(new Font("Arial Black", Font.BOLD, 15));
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
