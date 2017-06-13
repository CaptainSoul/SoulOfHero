package scenarioG;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import UI.common.GamePanel;

public class TaskController {
	private static int progress = 0;
	private static int start1 = 1;
	private static int start1A = 1;
	private static int start1B = 1;
	private static int start1C = 1;
	private static int start1D = 1;
	private static int start2 = 1;
	private static int start2A = 1;
	private static boolean find = false;
	public static void Check() {
		if(progress == 0)
			start();
		else if(progress == 1)
			start1A();
		else if(progress == 2 && find != true)
			start1B();
		else if(progress == 2 && find == true)
			start1C();
		else if(progress == 3)
			start1D();
		else if(progress == 4 && find != true)
			start2();
		else if(progress == 4 && find == true)
			start2A();
	}
	
	public static void start() {
		Dialog dialog = new Dialog();
		dialog.setTxt("Ah...");
		dialog.setVisible(true);
		dialog.requestFocus();
		dialog.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_SPACE) {
					if(start1 == 1)
						dialog.setTxt("Where is this?");
					else if(start1 == 2)
						dialog.setTxt("Who am i?");
					else if(start1 == 3)
						dialog.setTxt("Use UP, DOWN, LEFT, RIGHT to control character's move...");
					else if(start1 == 4)
						dialog.setTxt("Esc invokes menu bar and o invokes status bar...");
					else if(start1 == 5)
						dialog.setTxt("What did I say?");
					else if(start1 == 6)
						dialog.setHintTxt("I should be taking my Software Enginering course!!");
					else if(start1 == 7)
						dialog.setTxt("How odd!");
					else if(start1 == 8) {
						GamePanel.canComm = true;
						progress++;
						dialog.dispose();
					}
				start1++;
				}
			}
		});
	}
	
	public static void start1A() {
		Dialog dialog = new Dialog();
		dialog.setHeadIcon("/pic/head/o1tA.png");
		dialog.setTxt("..........");
		dialog.setVisible(true);
		dialog.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_SPACE) {
					if(start1A == 1)
						dialog.setTxt("...");
					else if(start1A == 2)
						dialog.setTxt(".....");
					else if(start1A == 3)
						dialog.setTxt("Dec...");
					else if(start1A == 4)
						dialog.setTxt("........");
					else if(start1A == 5)
						dialog.setTxt("Dec............");
					else if(start1A == 6)
						dialog.setTxt("................");
					else if(start1A == 7)
						dialog.setTxt("I'm here....");
					else if(start1A == 8)
						dialog.setTxt("............");
					else if(start1A == 9)
						dialog.setTxt("I'm here.............");
					else if(start1A == 10)
						dialog.setAsideTxt("(no voice yet)");
					else if(start1A == 11)
						dialog.setCommonTxt("Who is here???");
					else if(start1A == 12)
						dialog.setTxt("Hello??");
					else if(start1A == 13)
						dialog.setHintTxt("(Maybe I should have a check)");
					else if(start1A == 14)
						dialog.setAsideTxt("(Try to find the voice)");
					else if(start1A == 15)
						dialog.setCommonTxt("...");
					else if(start1A == 16) {
						GamePanel.canComm = true;
						progress++;
						dialog.dispose();
					}
					start1A++;
				}
			}
		});
	}
	
	public static void start1B() {
		Dialog dialog = new Dialog();
		dialog.setTxt("Who are you?");
		dialog.setVisible(true);
		dialog.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_SPACE) {
					if(start1B == 1)
						dialog.setTxt("Where are you?");
					else if(start1B == 2)
						dialog.setTxt("What's the matter?");
					else if(start1B == 3)
						dialog.setAsideTxt("(Try to find the man)");
					else if(start1B == 4) {
						GamePanel.canComm = true;
						start1B = 0;
						dialog.dispose();
					}
					start1B++;
				}
			}
		});
	}
	
	public static void start1C() {
		Dialog dialog = new Dialog();
		dialog.setTxt("Did you call me?");
		GamePanel.spriteUI.moveRight(GamePanel.canvas.iterator());
		dialog.setVisible(true);
		dialog.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_SPACE) {
					if(start1C == 1) {
						dialog.setHeadIcon("/pic/head/o1tA.png");
						GamePanel.npcUI[0].moveLeft(GamePanel.canvas.iterator());
						dialog.setTxt("Yes, I called you");
					} else if(start1C == 2)
						dialog.setTxt("You are not this world's person!");
					else if(start1C == 3)
						dialog.setTxt("Even not this universe!");
					else if(start1C == 4)
						dialog.setTxt("The only way to get out of this world is ....");
					else if(start1C == 5)
						dialog.setTxt("Kill the demon!");
					else if(start1C == 6)
						dialog.setCommonTxt("WTF??");
					else if(start1C == 7)
						dialog.setTxt("Okay, I am not know what I could do");
					else if(start1C == 8)
						dialog.setTxt("But I know I have strong body and I do feel....");
					else if(start1C == 9)
						dialog.setHintTxt("I am not a man in the world...");
					else if(start1C == 10)
						dialog.setCommonTxt("So I would go to KILL DEMON and go back to my world....");
					else if(start1C == 11) {
						dialog.setHeadIcon("/pic/head/o1tA.png");
						dialog.setTxt("Go up along the path and kill DEMON!! My hero!!!");
					} else if(start1C == 12)
						dialog.setAsideTxt("(Go UP and kill DEMON)");
					else if(start1C == 13) {
						find = false;
						progress++;
						dialog.dispose();
					}
					start1C++;
				}
			}
		});
	}
	
	public static void start1D() {
		Dialog dialog = new Dialog();
		dialog.setTxt("I should kill demons....");
		dialog.setVisible(true);
		dialog.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_SPACE) {
					if(start1D == 1)
						dialog.setTxt("Where are demons?");
					else if(start1D == 2) {
						dialog.setHeadIcon("/pic/head/o1tA.png");
						dialog.setTxt("What's the matter?");
					} else if(start1D == 3)
						dialog.setAsideTxt("Go up along the path and kill DEMON!! My hero!!!");
					else if(start1D == 4) {
						GamePanel.canComm = true;
						start1D = 0;
						dialog.dispose();
					}
					start1D++;
				}
			}
		});
	}
	public static void start2() {
		Dialog dialog = new Dialog();
		dialog.setTxt("Well....");
		dialog.setVisible(true);
		dialog.requestFocus();
		dialog.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_SPACE) {
					if(start2 == 1)
						dialog.setTxt("Where is this?");
					else if(start2 == 2)
						dialog.setTxt("What happened??");
					else if(start2 == 3)
						dialog.setTxt("My head.....");
					else if(start2 == 4) {
						dialog.dispose();
					}
					start2++;
				}
			}
		});
	}
	
	public static void start2A() {
		Dialog dialog = new Dialog();
		dialog.setTxt("..........");
		dialog.setVisible(true);
		dialog.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_SPACE) {
					if(start2A == 1) {
						dialog.setHeadIcon("/pic/head/o40tA.png");
						GamePanel.npcUI[0].moveRight(GamePanel.canvas.iterator());
						dialog.setTxt("Hello~~~~");
					} else if(start2A == 2) {
						GamePanel.spriteUI.moveLeft(GamePanel.canvas.iterator());
						dialog.setTxt("How are you???");
					} else if(start2A == 3)
						dialog.setCommonTxt("I'm .....");
					else if(start2A == 4)
						dialog.setTxt("........");
					else if(start2A == 5)
						dialog.setTxt("I'm Dec, where is here? What happened? Why I am here?");
					else if(start2A == 6) {
						dialog.setHeadIcon("/pic/head/o40tA.png");
						dialog.setTxt("hahaha...");
					} else if(start2A == 7)
						dialog.setTxt("To find the TRUTH");
					else if(start2A == 8)
						dialog.setHintTxt("(To find the TRUTH??)");
					else if(start2A == 9) {
						dialog.setHeadIcon("/pic/head/o40tA.png");
						dialog.setTxt("Come on~~~");
					} else if(start2A == 10)
						dialog.setCommonTxt("Ah...");
					else if(start2A == 11)
						dialog.setTxt("Wait!!");
					else if(start2A == 12)
						dialog.setTxt("Please tell me....");
					else if(start2A == 13) {
						dialog.setHeadIcon("/pic/head/o40tA.png");
						dialog.setTxt("Go out and find the truth~~~~~");
						GamePanel.npcUI[0].setX(1600);
						GamePanel.npcUI[0].setY(900);
					} else if(start2A == 14)
						dialog.setCommonTxt("She is gone.....");
					else if(start2A == 15) {
						progress++;
						dialog.dispose();
					}
					start2A++;
				}
			}
		});
	}
	
	public static int getProgress() {
		return progress;
	}
	
	public static void setProgress(int progress) {
		TaskController.progress = progress;
	}
	
	public static boolean getFind() {
		return find;
	}
	
	public static void setFind(boolean find) {
		TaskController.find = find;
	}
}
