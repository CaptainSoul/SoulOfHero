package databaseFrame.delete;

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

import databaseMain.Delete;
import databaseService.FoodService;
import databaseService.ItemService;
import inventory.Food;
import inventory.Item;

public class FoodDelete {

	private JFrame frame;
	private JPanel contentPane;	
	private JTextField code;
	private JTextField name;
	private JTextField description;
	private JTextField inventorycode;
	private JTextField hp;
	private JTextField mp;
	
	private ItemService itemService;
	private FoodService foodService;

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
			FoodDelete window = new FoodDelete();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the application.
	 */
	public FoodDelete() {
		initialize();
		foodService = new FoodService();
		itemService = new ItemService();
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
			
			JLabel lblFood = new JLabel("Food");
			lblFood.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
			lblFood.setForeground(new Color(51, 102, 153));
			lblFood.setBackground(Color.BLACK);
			lblFood.setBounds(26, 25, 106, 18);
			contentPane.add(lblFood);
			
			JLabel lblCode = new JLabel("Code:");
			lblCode.setForeground(new Color(0, 0, 153));
			lblCode.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			lblCode.setBounds(26, 61, 57, 18);
			contentPane.add(lblCode);
			
			code = new JTextField();
			code.setBounds(91, 56, 163, 24);
			contentPane.add(code);
			code.setColumns(10);
			
			JLabel lblName = new JLabel("Name:");
			lblName.setForeground(new Color(0, 0, 153));
			lblName.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			lblName.setBounds(26, 92, 65, 18);
			contentPane.add(lblName);
			
			name = new JTextField();
			name.setBounds(91, 91, 86, 24);
			contentPane.add(name);
			name.setColumns(10);
			
			JLabel lblDescription = new JLabel("Description:");
			lblDescription.setForeground(new Color(0, 0, 153));
			lblDescription.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			lblDescription.setBounds(26, 128, 100, 18);
			contentPane.add(lblDescription);
			
			description = new JTextField();
			description.setBounds(316, 91, 86, 24);
			contentPane.add(description);
			description.setColumns(10);
			
			JLabel lblInventorycode = new JLabel("Inventorycode:");
			lblInventorycode.setForeground(new Color(0, 0, 153));
			lblInventorycode.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			lblInventorycode.setBounds(26, 159, 134, 18);
			contentPane.add(lblInventorycode);
			
			inventorycode = new JTextField();
			inventorycode.setBounds(179, 127, 163, 24);
			contentPane.add(inventorycode);
			inventorycode.setColumns(10);
			
			JLabel lblHp = new JLabel("Hp:");
			lblHp.setForeground(new Color(0, 0, 153));
			lblHp.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			lblHp.setBounds(263, 92, 39, 18);
			contentPane.add(lblHp);
			
			hp = new JTextField();
			hp.setBounds(316, 55, 86, 24);
			contentPane.add(hp);
			hp.setColumns(10);
			
			JLabel lblMp = new JLabel("Mp:");
			lblMp.setForeground(new Color(0, 0, 153));
			lblMp.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			lblMp.setBounds(263, 61, 39, 18);
			contentPane.add(lblMp);
			
			mp = new JTextField();
			mp.setBounds(179, 158, 163, 24);
			contentPane.add(mp);
			mp.setColumns(10);
			
			JButton btnDelete = new JButton("DELETE");
			btnDelete.setFont(new Font("Arial Black", Font.PLAIN, 15));
			btnDelete.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent event) {
					int code2 = Integer.parseInt(code.getText());
					Item item = itemService.query(code2);
					item.setName(name.getText());
					item.setDescription(description.getText());
					item.setInventoryCode(Integer.parseInt(inventorycode.getText()));
					Food food = foodService.query(code2);
					food.setHp(Integer.parseInt(hp.getText()));
					food.setMp(Integer.parseInt(mp.getText()));
					itemService.delete(item);
					foodService.delete(food);
					JOptionPane.showMessageDialog(null, "Delete success", "message", JOptionPane.INFORMATION_MESSAGE);
				}
			});
			btnDelete.setBounds(162, 213, 113, 27);
			contentPane.add(btnDelete);
			
			JButton btnBack = new JButton("BACK");
			btnBack.setFont(new Font("Arial Black", Font.PLAIN, 15));
			btnBack.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					Delete delete = new Delete();
					delete.run();
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
