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
	private static int heavenA = 1;
	private static int heavenB = 1;
	private static int church = 1;
	private static boolean find = false;
	public static boolean onCom = false;
	public static void Check() {
		if(!onCom) {
			onCom = true;
			GamePanel.canMove = false;
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
			else if(progress == 6)
				heavenA();
			else if(progress == 7)
				heavenB();
			else if(progress == 8)
				church();
		}
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
						GamePanel.canMove = true;
						onCom = false;
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
						GamePanel.canMove = true;
						onCom = false;
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
						GamePanel.canMove = true;
						onCom = false;
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
						GamePanel.canMove = true;
						find = false;
						onCom = false;
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
						GamePanel.canMove = true;
						onCom = false;
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
						GamePanel.canMove = true;
						onCom = false;
						room = 0;
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
						GamePanel.npcUI[1].moveRight(GamePanel.canvas.iterator());
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
						dialog.setCommonTxt("To find the TRUTH??");
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
						GamePanel.npcUI[1].setX(1600);
						GamePanel.npcUI[1].setY(900);
					} else if(roomA == 14)
						dialog.setAsideTxt("She is gone.....");
					else if(roomA == 15) {
						GamePanel.canMove = true;
						onCom = false;
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
						GamePanel.canMove = true;
						onCom = false;
						progress++;
						dialog.dispose();
					}
					heaven++;
				}
			}
		});
	}
	
	public static void heavenA() {
		Dialog dialog = new Dialog();
		dialog.setNpcTxt("Hello");
		dialog.setHeadIcon("/pic/head/m6t.png");
		GamePanel.npcUI[3].moveRight(GamePanel.canvas.iterator());
		dialog.setVisible(true);
		dialog.requestFocus();
		dialog.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_SPACE) {
					if(heavenA == 1) {
						GamePanel.spriteUI.moveLeft(GamePanel.canvas.iterator());
						dialog.setCommonTxt("Hello?");
					} else if(heavenA == 2) {
						dialog.setTxt("Who are you?");
					} else if(heavenA == 3) {
						dialog.setHeadIcon("/pic/head/m6t.png");
						dialog.setNpcTxt("I'm a girl!");
					} else if(heavenA == 4) {
						dialog.setCommonTxt("...");
					} else if(heavenA == 5) {
						dialog.setHeadIcon("/pic/head/m6t.png");
						dialog.setNpcTxt("To find a man in front of the monument..");
					} else if(heavenA == 6) {
						dialog.setTxt("He will tell you something");
					} else if(heavenA == 7) {
						dialog.setCommonTxt("Thanks");
					} else if(heavenA == 8) {
						GamePanel.canMove = true;
						onCom = false;
						progress++;
						dialog.dispose();
					}
					heavenA++;
				}
			}
		});
	}
	
	public static void heavenB() {
		Dialog dialog = new Dialog();
		dialog.setHeadIcon("/pic/head/f1t.png");
		dialog.setNpcTxt("My sister !!!");
		dialog.setVisible(true);
		dialog.requestFocus();
		dialog.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_SPACE) {
					if(heavenB == 1) {
						dialog.setTxt("How are you?");
					} else if(heavenB == 2) {
						dialog.setTxt("You've been away for three years");
					} else if(heavenB == 3) {
						dialog.setTxt("These days, I always wanted to accompany you..");
					} else if(heavenB == 4) {
						dialog.setTxt("I am missing you at present");
					} else if(heavenB == 5) {
						dialog.setTxt("I miss you at all my left life");
					} else if(heavenB == 6) {
						dialog.setTxt("Sometimes, I dreamed you. You told me you were miserable");
					} else if(heavenB == 7) {
						dialog.setTxt("I wanted to release you..");
					} else if(heavenB == 8) {
						dialog.setTxt("But I cann't move!");
					} else if(heavenB == 9) {
						dialog.setTxt("I can only see your suffering!");
					} else if(heavenB == 10) {
						dialog.setTxt("However!!!");
					} else if(heavenB == 11) {
						dialog.setTxt("Soon I will ...");
					} else if(heavenB == 12) {
						dialog.setTxt("Who is there!!??");
					} else if(heavenB == 13) {
						dialog.setAsideTxt("The man stare at you");
					} else if(heavenB == 14) {
						dialog.setHeadIcon("/pic/head/f1t.png");
						dialog.setNpcTxt("Well! " + GamePanel.sprite.getName() + "!!");
					} else if(heavenB == 15) {
						dialog.setTxt("How are you?");
					} else if(heavenB == 16) {
						dialog.setTxt("You slept three days, I was so worried..");
					} else if(heavenB == 17) {
						dialog.setCommonTxt("I'm fine..Just a little headache..");
					} else if(heavenB == 18) {
						dialog.setHeadIcon("/pic/head/f1t.png");
						dialog.setNpcTxt("Headache? Alright, you got headache");
					} else if(heavenB == 19) {
						dialog.setCommonTxt("??");
					} else if(heavenB == 20) {
						dialog.setHeadIcon("/pic/head/f1t.png");
						dialog.setNpcTxt("Oh, I mean so that's why you slept three days..");
					} else if(heavenB == 21) {
						dialog.setCommonTxt("..");
					} else if(heavenB == 22) {
						dialog.setHeadIcon("/pic/head/f1t.png");
						dialog.setNpcTxt("May be you found that something strange?");
					} else if(heavenB == 23) {
						dialog.setTxt("Go up and along the path, a saintess could help you");
					} else if(heavenB == 24) {
						dialog.setCommonTxt("Thanks..");
					} else if(heavenB == 25) {
						GamePanel.canMove = true;
						onCom = false;
						progress++;
						dialog.dispose();
					}
					heavenB++;
				}
			}
		});
	}
	
	public static void church() {
		Dialog dialog = new Dialog();
		dialog.setCommonTxt("Hello..");
		dialog.setVisible(true);
		dialog.requestFocus();
		dialog.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_SPACE) {
					if(church == 1) {
						GamePanel.npcUI[1].moveDown(GamePanel.canvas.iterator());
						dialog.setHeadIcon("/pic/head/o40t.png");
						dialog.setNpcTxt("Hello, " + GamePanel.sprite.getName());
					} else if(church == 2) {
						dialog.setTxt("Did you meet Mr.Yao?");
					} else if(church == 3) {
						dialog.setCommonTxt("Mr.Yao?");
					} else if(church == 4) {
						dialog.setTxt("If he is a man in front of the monument");
					} else if(church == 5) {
						dialog.setHeadIcon("/pic/head/o40t.png");
						dialog.setNpcTxt("Yes, he is");
					} else if(church == 6) {
						dialog.setTxt("I know you are puzzled by many questions");
					} else if(church == 7) {
						dialog.setTxt("But remember a key:");
					} else if(church == 8) {
						dialog.setTxt("Always remember find the truth!");
					} else if(church == 9) {
						dialog.setCommonTxt("Always remember find the truth");
					} else if(church == 10) {
						dialog.setHeadIcon("/pic/head/o40t.png");
						dialog.setNpcTxt("Now please go to the cave located at northeast");
					} else if(church == 11) {
						dialog.setTxt("There is a item can awake earth-man's strength");
					} else if(church == 12) {
						dialog.setCommonTxt("Earth!!");
					} else if(church == 13) {
						dialog.setTxt("That's right. Find it and go back here");
					} else if(church == 14) {
						dialog.setTxt("I will help you");
					} else if(church == 15) {
						dialog.setTxt("Now please go to the cave located at northeast! My hero!!");
					} else if(church == 16) {
						dialog.setCommonTxt("Okay...");
					} else if(church == 17) {
						GamePanel.canMove = true;
						onCom = false;
						progress++;
						dialog.dispose();
					}
					church++;
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
