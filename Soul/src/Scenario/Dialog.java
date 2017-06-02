package scenario;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Dialog extends JDialog {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3176963632624527458L;
	private JLabel head;
	private JLabel lblTxt;
	private JLabel lblBackground;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Dialog dialog = new Dialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Dialog() {
		setUndecorated(true);
		setTitle(" ");
		setType(Type.UTILITY);
		setResizable(false);
		setBounds(100, 100, 537, 138);
		getContentPane().setLayout(null);
		Dimension screenSize=java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize= this.getSize();
		this.setLocation((screenSize.width-frameSize.width)/2,(screenSize.height-frameSize.height)/2);
		
		head = new JLabel("");
		head.setIcon(new ImageIcon(Dialog.class.getResource("/pic/head/vx013.png")));
		head.setBounds(14, 20, 100, 100);
		getContentPane().add(head);
		
		lblTxt = new JLabel("Welcome to Soul of Hero!!");	
		lblTxt.setForeground(new Color(51, 51, 102));
		lblTxt.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lblTxt.setBounds(128, 13, 409, 106);
		getContentPane().add(lblTxt);
		
		lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon(Dialog.class.getResource("/UI/fight/fight1.jpg")));
		lblBackground.setBounds(0, 0, 537, 137);
		getContentPane().add(lblBackground);
		setAlwaysOnTop(true);
		setAutoRequestFocus(true);
	}
	
	public void setCloseListener() {
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				if(key == KeyEvent.VK_ENTER || key == KeyEvent.VK_SPACE) {
					dispose();
				}
			}
		});
	}
	
	public void setHintTxt(String txt) {
		clearHeadIcon();
		lblTxt.setForeground(new Color(204, 51, 0));
		lblTxt.setFont(new Font("Comic Sans MS", Font.BOLD, 21));
		setTxt(txt);
	}
	
	public void setCommonTxt(String txt) {
		head.setIcon(new ImageIcon(Dialog.class.getResource("/pic/head/vx013.png")));
		lblTxt.setForeground(new Color(51, 51, 102));
		lblTxt.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		setTxt(txt);
	}
	
	public void setAsideTxt(String txt) {
		clearHeadIcon();
		lblTxt.setFont(new Font("Comic Sans MS", Font.BOLD, 23));
		lblTxt.setForeground(new Color(153, 0, 0));
		setTxt(txt);
	}
	
	public void setHeadIcon(String url) {
		head.setIcon(new ImageIcon(Dialog.class.getResource(url)));
	}
	
	public void clearHeadIcon() {
		head.setIcon(null);
	}
	
	public void setTxt(String text) {
		lblTxt.setText(text);
	}
	
	public void setBackgroundIcon(String url) {
		lblBackground.setIcon(new ImageIcon(Dialog.class.getResource(url)));
	}
	
	
}
