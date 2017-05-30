package UI.common;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Font;

public class Talk extends JDialog {
	static Talk dialog;
	private final JPanel contentPanel = new JPanel();
	JLabel lblTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			dialog = new Talk();
			Dimension screenSize=java.awt.Toolkit.getDefaultToolkit().getScreenSize();
			Dimension frameSize= dialog.getSize();
			dialog.setLocation((screenSize.width-frameSize.width)/2,(screenSize.height-frameSize.height)/2);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Talk() {
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				if(key == KeyEvent.VK_ENTER || key == KeyEvent.VK_SPACE)
					dialog.dispose();
			}
		});
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Talk.class.getResource("/UI/Welcome7.jpg")));
		setAlwaysOnTop(true);
		setBounds(100, 100, 504, 121);
		getContentPane().setLayout(new BorderLayout());

		contentPanel.setForeground(Color.BLACK);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblTxt = new JLabel("Don't go out!!!");
		lblTxt.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));
		lblTxt.setBounds(39, 13, 176, 63);
		contentPanel.add(lblTxt);
	}
	
	public void setText(String txt) {
		lblTxt.setText(txt);
	}
	
}
