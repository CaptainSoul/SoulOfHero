package scenario;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
		setTitle("");
		setType(Type.UTILITY);
		setResizable(false);
		setBounds(100, 100, 946, 298);
		getContentPane().setLayout(null);
		Dimension screenSize=java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize= this.getSize();
		this.setLocation((screenSize.width-frameSize.width)/2,(screenSize.height-frameSize.height)/2);
		
		head = new JLabel("");
		head.setIcon(new ImageIcon(Dialog.class.getResource("/pic/head/o54tA.png")));
		head.setBounds(14, 28, 180, 246);
		getContentPane().add(head);
		
		lblTxt = new JLabel("Welcome to Soul of Hero!!");	
		lblTxt.setForeground(new Color(51, 51, 102));
		lblTxt.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		lblTxt.setBounds(192, 46, 631, 208);
		getContentPane().add(lblTxt);
		
		lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon(Dialog.class.getResource("/pic/common/treeA.png")));
		lblBackground.setBounds(0, 0, 946, 318);
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
		head.setIcon(new ImageIcon(Dialog.class.getResource("/pic/head/o54tA.png")));
		lblTxt.setForeground(new Color(204, 51, 0));
		lblTxt.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		setTxt(txt);
	}
	
	public void setCommonTxt(String txt) {
		head.setIcon(new ImageIcon(Dialog.class.getResource("/pic/head/o54tA.png")));
		lblTxt.setForeground(new Color(51, 51, 102));
		lblTxt.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		setTxt(txt);
	}
	
	public void setAsideTxt(String txt) {
		clearHeadIcon();
		lblTxt.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
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
