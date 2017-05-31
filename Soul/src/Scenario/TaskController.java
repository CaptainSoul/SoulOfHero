package Scenario;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TaskController {
	private static int progress = 0;
	private int task1A = 0;
	private int task1B = 0;
	
	public void Check() {
		if(progress == 0)
			task1A();
		else if(progress == 1)
			task1B();
			
	}
	
	public void task1A() {
		Dialog dialog = new Dialog();
		dialog.setHeadIcon("/pic/head/vx035_07.png");
		dialog.setTxt("..........");
		dialog.setVisible(true);
		dialog.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(task1A == 0)
					dialog.setTxt("...");
				else if(task1A == 1)
					dialog.setTxt(".....");
				else if(task1A == 2)
						dialog.setTxt("Dec...");
				else if(task1A == 3)
					dialog.setTxt("........");
				else if(task1A == 4)
						dialog.setTxt("Dec............");
				else if(task1A == 5)
					dialog.setTxt("................");
				else if(task1A == 6)
					dialog.setTxt("I'm here....");
				else if(task1A == 7)
					dialog.setTxt("............");
				else if(task1A == 8)
					dialog.setTxt("I'm here.............");
				else if(task1A == 9)
					dialog.setAsideTxt("(no voice yet)");
				else if(task1A == 10)
					dialog.setCommonTxt("Who is here???");
				else if(task1A == 11)
					dialog.setTxt("Hello??");
				else if(task1A == 12)
					dialog.setHintTxt("(Maybe I should have a check)");
				else if(task1A == 13)
					dialog.setAsideTxt("(Try to find the voice)");
				else if(task1A == 14)
					dialog.setCommonTxt("...");
				else if(task1A == 15) {
					progress++;
					dialog.dispose();
				}
				task1A++;
			}
		});
	}
	
	public void task1B() {
		Dialog dialog = new Dialog();
		dialog.setTxt("..........");
		dialog.setVisible(true);
		dialog.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(task1B == 0)
					dialog.setTxt("...");
				else if(task1B == 1)
					dialog.setTxt(".....");
				else if(task1B == 2)
						dialog.setTxt("Dec...");
				else if(task1B == 3)
					dialog.setTxt("........");
				else if(task1B == 4)
						dialog.setTxt("Dec............");
				else if(task1B == 5)
					dialog.setTxt("................");
				else if(task1B == 6)
					dialog.setTxt("I'm here....");
				else if(task1B == 7)
					dialog.setTxt("............");
				else if(task1B == 8)
					dialog.setTxt("I'm here.............");
				else if(task1B == 9)
					dialog.setAsideTxt("(no voice yet)");
				else if(task1B == 10)
					dialog.setCommonTxt("Who is here???");
				else if(task1B == 11)
					dialog.setTxt("Hello??");
				else if(task1B == 12)
					dialog.setHintTxt("(Maybe I should have a check)");
				else if(task1B == 13)
					dialog.setAsideTxt("(Try to find the voice)");
				else if(task1B == 14)
					dialog.setCommonTxt("...");
				else if(task1B == 15) {
					progress++;
					dialog.dispose();
				}
				task1B++;
			}
		});
	}
}
