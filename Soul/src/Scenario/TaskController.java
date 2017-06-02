package scenario;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TaskController {
	private int progress = 0;
	private int start1 = 0;
	private int start1A = 0;
	private int start1B = 0;
	
	public void Check() {
		if(progress == 0)
			start();
		else if(progress == 1)
			start1A();
		else if(progress == 2)
			start1B();
	}
	
	public void start() {
		Dialog dialog = new Dialog();
		dialog.setTxt("Ah...");
		dialog.setVisible(true);
		dialog.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(start1 == 0)
					dialog.setTxt("Where is this?");
				else if(start1 == 1)
					dialog.setTxt("Who am i?");
				else if(start1 == 2)
					dialog.setTxt("Use UP, DOWN, LEFT, RIGHT to control character's move...");
				else if(start1 == 3)
					dialog.setTxt("What did I say?");
				else if(start1 == 4)
					dialog.setTxt("How odd!");
				else if(start1 == 5) {
					progress++;
					dialog.dispose();
				}
				start1++;
					
			}
		});
	}
	
	public void start1A() {
		Dialog dialog = new Dialog();
		dialog.setHeadIcon("/pic/head/vx035_07.png");
		dialog.setTxt("..........");
		dialog.setVisible(true);
		dialog.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(start1A == 0)
					dialog.setTxt("...");
				else if(start1A == 1)
					dialog.setTxt(".....");
				else if(start1A == 2)
						dialog.setTxt("Dec...");
				else if(start1A == 3)
					dialog.setTxt("........");
				else if(start1A == 4)
						dialog.setTxt("Dec............");
				else if(start1A == 5)
					dialog.setTxt("................");
				else if(start1A == 6)
					dialog.setTxt("I'm here....");
				else if(start1A == 7)
					dialog.setTxt("............");
				else if(start1A == 8)
					dialog.setTxt("I'm here.............");
				else if(start1A == 9)
					dialog.setAsideTxt("(no voice yet)");
				else if(start1A == 10)
					dialog.setCommonTxt("Who is here???");
				else if(start1A == 11)
					dialog.setTxt("Hello??");
				else if(start1A == 12)
					dialog.setHintTxt("(Maybe I should have a check)");
				else if(start1A == 13)
					dialog.setAsideTxt("(Try to find the voice)");
				else if(start1A == 14)
					dialog.setCommonTxt("...");
				else if(start1A == 15) {
					progress++;
					dialog.dispose();
				}
				start1A++;
			}
		});
	}
	
	public void start1B() {
		Dialog dialog = new Dialog();
		dialog.setTxt("Who are you?");
		dialog.setVisible(true);
		dialog.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(start1B == 0)
					dialog.setTxt("Where are you?");
				else if(start1B == 1)
					dialog.setTxt("What's the matter?");
				else if(start1B == 2)
						dialog.setAsideTxt("(Try to find the man)");
				else if(start1B == 3) {
					start1B = 0;
					dialog.dispose();
				}
				start1B++;
			}
		});
	}
	
	public void start1C() {
		Dialog dialog = new Dialog();
		dialog.setTxt("Who are you?");
		dialog.setVisible(true);
		dialog.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(start1B == 0)
					dialog.setTxt("Where are you?");
				else if(start1B == 1)
					dialog.setTxt("What's the matter?");
				else if(start1B == 2)
						dialog.setAsideTxt("");
				else if(start1B == 3) {
					start1B = 0;
					dialog.dispose();
				}
				start1B++;
			}
		});
	}
	
	public int getProgress() {
		return progress;
	}
	
	public void setProgress(int progress) {
		this.progress = progress;
	}
}
