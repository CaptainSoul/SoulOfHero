package scenario;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import UI.MainApp;
import UI.StartFrame;

public class FightEnd {
	public static int count = 0;
	public void main() {
		Dialog dialog = new Dialog();
		dialog.setAsideTxt("All DEMONs have been killed!!!");
		dialog.setVisible(true);
		dialog.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(count == 0)
					dialog.setCommonTxt("Okay!!");
				else if(count == 1)
					dialog.setTxt(" I did it!!!");
				else if(count == 2)
						dialog.setTxt("Now I can go back my world??");
				else if(count == 3)
					dialog.setAsideTxt("BOOM BOOM BOOM BOOM  &%*#%&#*");
				else if(count == 4)
					dialog.setAsideTxt("$&@#^%#&%^#(%");
				else if(count == 5)
					dialog.setCommonTxt("I have a headache!!!!");
				else if(count == 6)
					dialog.setCommonTxt("Stop!!!");
				else if(count == 7)
					dialog.setCommonTxt("Shut Up!!!!");
				else if(count == 8)
					dialog.setAsideTxt("%^#@%^#@&$(#$&#*");
				else if(count == 9)
					dialog.setCommonTxt("I have a headache!!!!");
				else if(count == 10)
					dialog.setCommonTxt("Ahhhhhhhhhh!!!!!");
				else if(count == 11) {
					MainApp.mainView = true;
					dialog.dispose();
				}
				count++;
			}
		});
	}
}
