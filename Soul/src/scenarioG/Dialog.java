package scenarioG;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextArea;

import UI.common.GamePanel;

public class Dialog extends JDialog {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3176963632624527458L;
	private JLabel head;
	private JTextArea txt;
	private JLabel lblBackground;
	private JLabel lblName;
	private JLabel label;

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
		setBounds(100, 100, 1600, 491);
		getContentPane().setLayout(null);
		getRootPane().setOpaque(false);
		getContentPane().setBackground(new Color(0,0,0,0));
		setBackground(new Color(0,0,0,0));
		Dimension screenSize=java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize= this.getSize();
		this.setLocation((screenSize.width-frameSize.width)/2,(screenSize.height-frameSize.height)/2);
		
		lblName = new JLabel();
		lblName.setBackground(new Color(0, 0, 0));
		lblName.setForeground(new Color(204, 255, 153));
		lblName.setFont(new Font("Comic Sans MS", Font.BOLD, 36));
		lblName.setText("Dec");
		lblName.setBounds(406, 258, 172, 49);
		lblName.setOpaque(false);
		lblName.setBorder(null);
		getContentPane().add(lblName);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(Dialog.class.getResource("/pic/common/nameSub.png")));
		label.setBounds(369, 292, 246, 39);
		getContentPane().add(label);
		
		head = new JLabel("");
		head.setIcon(new ImageIcon(Dialog.class.getResource("/pic/head/o54t.png")));
		head.setBounds(66, 13, 312, 478);
		getContentPane().add(head);
		
		txt = new JTextArea();
		txt.setEnabled(false);
		txt.setFont(new Font("Comic Sans MS", Font.PLAIN, 32));
		txt.setForeground(new Color(255, 255, 255));
		txt.setLineWrap(true);
		txt.setText("I AM HERO I AM HERO I AM HERO I AM HERO I AM HERO I AM HERO I AM HERO I AM HERO I AM HERO");
		txt.setBounds(377, 336, 1161, 142);
		txt.setOpaque(false);
		getContentPane().add(txt);
		txt.setEditable(false);
		
		lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon(Dialog.class.getResource("/pic/common/dialog.png")));
		lblBackground.setBounds(0, 241, 1600, 250);
		getContentPane().add(lblBackground);
		setAlwaysOnTop(true);
		setAutoRequestFocus(true);
	}
	
	public void setPlayerDialog() {
		head.setBounds(66, 13, 312, 478);
		lblName.setBounds(406, 258, 172, 49);
		lblName.setText(GamePanel.sprite.getName());
		label.setBounds(369, 292, 246, 39);
		label.setIcon(new ImageIcon(Dialog.class.getResource("/pic/common/nameSub.png")));
		txt.setBounds(377, 336, 1161, 142);
		lblBackground.setBounds(0, 241, 1600, 250);
	}
	
	public void setNpcDialog() {
		head.setBounds(1054, 26, 490, 465);
		lblName.setBounds(960, 258, 172, 49);
		lblName.setText("???");
		label.setBounds(923, 292, 246, 39);
		label.setIcon(new ImageIcon(Dialog.class.getResource("/pic/common/nameSub.png")));
		txt.setBounds(310, 336, 804, 142);
		lblBackground.setBounds(0, 241, 1600, 250);
	}
	
	public void setAsideDialog() {
		lblName.setText("");
		label.setIcon(null);
		txt.setBounds(325, 336, 950, 142);
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
	
	public void setHintTxt(String text) {
		head.setIcon(new ImageIcon(Dialog.class.getResource("/pic/head/o54t.png")));
		txt.setFont(new Font("Comic Sans MS", Font.BOLD, 35));
		setTxt(text);
	}
	
	public void setCommonTxt(String text) {
		head.setIcon(new ImageIcon(Dialog.class.getResource("/pic/head/o54t.png")));
		setPlayerDialog();
		txt.setFont(new Font("Comic Sans MS", Font.PLAIN, 32));
		setTxt(text);
	}
	
	public void setNpcTxt(String text) {
		setNpcDialog();
		txt.setFont(new Font("Comic Sans MS", Font.PLAIN, 32));
		setTxt(text);
	}
	
	public void setAsideTxt(String text) {
		setAsideDialog();
		clearHeadIcon();
		txt.setFont(new Font("Comic Sans MS", Font.PLAIN, 32));
		setTxt(text);
	}

	
	public void setHeadIcon(String url) {
		head.setIcon(new ImageIcon(Dialog.class.getResource(url)));
	}
	
	public void clearHeadIcon() {
		head.setIcon(null);
	}

	public void setTxt(String text) {
		txt.setText(text);
	}
	
	public void setName(String name) {
		lblName.setText(name);
	}
	
	public void setBackgroundIcon(String url) {
		lblBackground.setIcon(new ImageIcon(Dialog.class.getResource(url)));
	}
}
