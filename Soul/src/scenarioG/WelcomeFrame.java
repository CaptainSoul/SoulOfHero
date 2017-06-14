package scenarioG;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import UI.MainApp;
import UI.StartFrame;

public class WelcomeFrame {
	public static int count = 0;
	public static void main(String[] args) {
		Dialog dialog = new Dialog();
		dialog.setAsideTxt("Welcome to Soul Of Hero!");
		dialog.setVisible(true);
		dialog.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println(1);
				if(e.getKeyCode() == KeyEvent.VK_SPACE) {
					if(count == 0)
						dialog.setTxt("This is a world you seems met it somewhere");
					else if(count == 1)
						dialog.setTxt("Try to find truth!!");
					else if(count == 2)
						dialog.setTxt("(UP DOWN LEFT RIGHT could control sprite)");
					else if(count == 3)
						dialog.setTxt("(ESC invoke menu)");
					else if(count == 4)
						dialog.setTxt("(SPACE invoke communication)");
					else if(count == 5)
						dialog.setTxt("Now! Have a good game!!!");
					else if(count == 6) {
						MainApp.mainView = true;
						MainApp.loadMain = true;
						StartFrame.frmSoulOfHero.dispose();
						dialog.dispose();
					}
					count++;
				}
			}
		});
	}
}
