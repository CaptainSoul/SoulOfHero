package scenarioG;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FightFrame {
	public static int count = 0;
	public static void main(String[] args) {
		Dialog dialog = new Dialog();
		dialog.setHeadIcon("/pic/head/o1t.png");
		dialog.setNpcTxt("They are demons!");
		dialog.setVisible(true);
		dialog.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_SPACE) {
					if(count == 0)
						dialog.setTxt("Kill them!!");
					else if(count == 1)
						dialog.setAsideTxt("Try to kill demons!!");
					else if(count == 2)
						dialog.setTxt("Click your sprite and select action you want");
					else if(count == 3)
						dialog.setTxt("after action the sprite must wait)");
					else if(count == 4)
						dialog.setTxt("KILL ALL DEMONS");
					else if(count == 5)
						dialog.setTxt("KILL!!!!");
					else if(count == 6) {
						dialog.dispose();
					}
					count++;
				}
			}
		});
	}
}
