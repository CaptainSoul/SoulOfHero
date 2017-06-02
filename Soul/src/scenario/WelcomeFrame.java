package scenario;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import UI.MainApp;

public class WelcomeFrame {
	public static int count = 0;
	public static void main(String[] args) {
		Dialog dialog = new Dialog();
		dialog.setAsideTxt("Welcome to Soul Of Hero!");
		dialog.setVisible(true);
		dialog.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(count == 0)
					dialog.setAsideTxt("This is a world you seems met it somewhere");
				else if(count == 1)
					dialog.setAsideTxt("Try to find truth!!");
				else if(count == 2)
						dialog.setAsideTxt("(UP DOWN LEFT RIGHT could control sprite)");
				else if(count == 3)
					dialog.setAsideTxt("(ESC invoke menu)");
				else if(count == 4)
					dialog.setAsideTxt("(SPACE invoke communication)");
				else if(count == 5)
					dialog.setAsideTxt("Now! Have a good game!!!");
				else if(count == 6) {
					MainApp.mainView = true;
					dialog.dispose();
				}
				count++;
			}
		});
	}
}
