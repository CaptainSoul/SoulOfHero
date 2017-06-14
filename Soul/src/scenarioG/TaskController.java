package scenarioG;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import UI.common.GamePanel;

public class TaskController {
	private static int progress = 0;
	private static int main1 = 1;
	private static int main1A = 1;
	private static int main1B = 1;
	private static int main1C = 1;
	private static int main1D = 1;
	private static int room = 1;
	private static int roomA = 1;
	private static int heaven = 1;
	private static boolean find = false;
	public static void Check() {
		if(progress == 0)
			start();
		else if(progress == 1)
			main1A();
		else if(progress == 2 && find != true)
			main1B();
		else if(progress == 2 && find == true)
			main1C();
		else if(progress == 3)
			main1D();
		else if(progress == 4 && find != true)
			room();
		else if(progress == 4 && find == true)
			roomA();
		else if(progress == 5)
			heaven();
	}
	
	public static void start() {
		Dialog dialog = new Dialog();
		dialog.setCommonTxt("Ah...");
		dialog.setVisible(true);
		dialog.requestFocus();
		dialog.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_SPACE) {
					if(main1 == 1)
						dialog.setTxt("Where is here?");
					else if(main1 == 2)
						dialog.setTxt("Who am i?");
					else if(main1 == 3)
						dialog.setTxt("Use UP, DOWN, LEFT, RIGHT to control character's move...");
					else if(main1 == 4)
						dialog.setTxt("Esc invokes menu bar and o invokes status bar...");
					else if(main1 == 5)
						dialog.setTxt("What did I say?");
					else if(main1 == 6)
						dialog.setHintTxt("I should be taking my Software Enginering course!!");
					else if(main1 == 7)
						dialog.setCommonTxt("How odd!");
					else if(main1 == 8) {
						GamePanel.canComm = true;
						progress++;
						dialog.dispose();
					}
				main1++;
				}
			}
		});
	}
	
	public static void main1A() {
		Dialog dialog = new Dialog();
		dialog.setHeadIcon("/pic/head/o1t.png");
		dialog.setNpcTxt("..........");
		dialog.setVisible(true);
		dialog.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_SPACE) {
					if(main1A == 1)
						dialog.setTxt("...");
					else if(main1A == 2)
						dialog.setTxt(".....");
					else if(main1A == 3)
						dialog.setTxt(GamePanel.sprite.getName() + "...");
					else if(main1A == 4)
						dialog.setTxt("........");
					else if(main1A == 5)
						dialog.setTxt(GamePanel.sprite.getName() + "............");
					else if(main1A == 6)
						dialog.setTxt("................");
					else if(main1A == 7)
						dialog.setTxt("I'm here....");
					else if(main1A == 8)
						dialog.setTxt("............");
					else if(main1A == 9)
						dialog.setTxt("I'm here.............");
					else if(main1A == 10)
						dialog.setAsideTxt("no voice yet");
					else if(main1A == 11)
						dialog.setCommonTxt("Who is here???");
					else if(main1A == 12)
						dialog.setTxt("Hello??");
					else if(main1A == 13)
						dialog.setHintTxt("(Maybe I should have a check)");
					else if(main1A == 14)
						dialog.setAsideTxt("(Try to find the voice)");
					else if(main1A == 15) {
						GamePanel.canComm = true;
						progress++;
						dialog.dispose();
					}
					main1A++;
				}
			}
		});
	}
	
	public static void main1B() {
		Dialog dialog = new Dialog();
		dialog.setCommonTxt("Who are you?");
		dialog.setVisible(true);
		dialog.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_SPACE) {
					if(main1B == 1)
						dialog.setTxt("Where are you?");
					else if(main1B == 2)
						dialog.setTxt("What's the matter?");
					else if(main1B == 3)
						dialog.setAsideTxt("(Try to find the man)");
					else if(main1B == 4) {
						GamePanel.canComm = true;
						main1B = 0;
						dialog.dispose();
					}
					main1B++;
				}
			}
		});
	}
	
	public static void main1C() {
		Dialog dialog = new Dialog();
		dialog.setCommonTxt("Did you call me?");
		GamePanel.spriteUI.moveRight(GamePanel.canvas.iterator());
		dialog.setVisible(true);
		dialog.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_SPACE) {
					if(main1C == 1) {
						dialog.setHeadIcon("/pic/head/o1t.png");
						GamePanel.npcUI[0].moveLeft(GamePanel.canvas.iterator());
						dialog.setNpcTxt("Yes, I called you");
					} else if(main1C == 2)
						dialog.setTxt("You are not this world's person!");
					else if(main1C == 3)
						dialog.setTxt("Even not this universe!");
					else if(main1C == 4)
						dialog.setTxt("The only way to get out of this world is ....");
					else if(main1C == 5)
						dialog.setTxt("Kill the demon!");
					else if(main1C == 6)
						dialog.setCommonTxt("WTF??");
					else if(main1C == 7)
						dialog.setTxt("Okay, I am not know what I could do");
					else if(main1C == 8)
						dialog.setTxt("But I know I have strong body and I do feel....");
					else if(main1C == 9)
						dialog.setHintTxt("I am not a man in the world...");
					else if(main1C == 10)
						dialog.setCommonTxt("So I would go to KILL DEMON and go back to my world....");
					else if(main1C == 11) {
						dialog.setHeadIcon("/pic/head/o1t.png");
						dialog.setNpcTxt("Go up along the path and kill DEMON!! My hero!!!");
					} else if(main1C == 12)
						dialog.setAsideTxt("(Go UP and kill DEMON)");
					else if(main1C == 13) {
						find = false;
						progress++;
						dialog.dispose();
					}
					main1C++;
				}
			}
		});
	}
	
	public static void main1D() {
		Dialog dialog = new Dialog();
		dialog.setCommonTxt("I should kill demons....");
		dialog.setVisible(true);
		dialog.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_SPACE) {
					if(main1D == 1)
						dialog.setTxt("Where are demons?");
					else if(main1D == 2) {
						dialog.setHeadIcon("/pic/head/o1t.png");
						dialog.setNpcTxt("What's the matter?");
					} else if(main1D == 3)
						dialog.setTxt("Go up along the path and kill DEMON!! My hero!!!");
					else if(main1D == 4) {
						GamePanel.canComm = true;
						main1D = 0;
						dialog.dispose();
					}
					main1D++;
				}
			}
		});
	}
	
	public static void room() {
		Dialog dialog = new Dialog();
		dialog.setCommonTxt("Well....");
		dialog.setVisible(true);
		dialog.requestFocus();
		dialog.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_SPACE) {
					if(room == 1)
						dialog.setTxt("Where is here?");
					else if(room == 2)
						dialog.setTxt("What happened??");
					else if(room == 3)
						dialog.setTxt("My head.....");
					else if(room == 4) {
						dialog.dispose();
					}
					room++;
				}
			}
		});
	}
	
	public static void roomA() {
		Dialog dialog = new Dialog();
		dialog.setCommonTxt("..........");
		dialog.setVisible(true);
		dialog.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_SPACE) {
					if(roomA == 1) {
						dialog.setHeadIcon("/pic/head/o40t.png");
						GamePanel.npcUI[0].moveRight(GamePanel.canvas.iterator());
						dialog.setNpcTxt("Hello~~~~");
					} else if(roomA == 2) {
						GamePanel.spriteUI.moveLeft(GamePanel.canvas.iterator());
						dialog.setTxt("How are you???");
					} else if(roomA == 3)
						dialog.setCommonTxt("I'm .....");
					else if(roomA == 4)
						dialog.setTxt("........");
					else if(roomA == 5)
						dialog.setTxt("I'm Dec, where is here? What happened? Why I am here?");
					else if(roomA == 6) {
						dialog.setHeadIcon("/pic/head/o40t.png");
						dialog.setNpcTxt("hahaha...");
					} else if(roomA == 7)
						dialog.setTxt("To find the TRUTH");
					else if(roomA == 8)
						dialog.setHintTxt("To find the TRUTH??");
					else if(roomA == 9) {
						dialog.setHeadIcon("/pic/head/o40t.png");
						dialog.setNpcTxt("Come on~~~");
					} else if(roomA == 10)
						dialog.setCommonTxt("Ah...");
					else if(roomA == 11)
						dialog.setTxt("Wait!!");
					else if(roomA == 12)
						dialog.setTxt("Please tell me....");
					else if(roomA == 13) {
						dialog.setHeadIcon("/pic/head/o40t.png");
						dialog.setNpcTxt("Go out and find the truth~~~~~");
						GamePanel.npcUI[0].setX(1600);
						GamePanel.npcUI[0].setY(900);
					} else if(roomA == 14)
						dialog.setAsideTxt("She is gone.....");
					else if(roomA == 15) {
						progress++;
						dialog.dispose();
					}
					roomA++;
				}
			}
		});
	}
	
	public static void heaven() {
		Dialog dialog = new Dialog();
		dialog.setCommonTxt("!!!!!");
		dialog.setVisible(true);
		dialog.requestFocus();
		dialog.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_SPACE) {
					if(heaven == 1)
						dialog.setTxt("Where is here?");
					else if(heaven == 2)
						dialog.setTxt("I just walked out from a room");
					else if(heaven == 3)
						dialog.setTxt("What happened??");
					else if(heaven == 4)
						dialog.setTxt("How odd!!!");
					else if(heaven == 5) {
						progress++;
						dialog.dispose();
					}
					heaven++;
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
