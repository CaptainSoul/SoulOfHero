package scenarioG;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import UI.MainApp;
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
	private static int cave = 1;
	private static int caveA = 1;
	private static int caveB = 1;
	private static int caveC = 1;
	private static int caveD = 1;
	private static int churchA = 1;
	private static int fort = 1;
	private static int woodenTown = 1;
	private static int woodenTownA = 1;
	private static int boss = 1;
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
			else if(progress == 9)
				cave();
			else if(progress == 10)
				caveA();
			else if(progress == 11)
				caveB();
			else if(progress == 12)
				caveC();
			else if(progress == 13)
				caveD();
			else if(progress == 14)
				churchA();
			else if(progress == 15)
				fort();
			else if(progress == 16)
				woodenTown();
			else if(progress == 17)
				woodenTownA();
			else if(progress == 29)
				boss();
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
						dialog.setTxt("I'm " + GamePanel.sprite.getName() + ", where is here? What happened? Why I am here?");
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
						dialog.setHeadIcon("/pic/head/o40t.png");
						dialog.setNpcTxt("That's right. Find it and go back here");
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
	
	public static void cave() {
		Dialog dialog = new Dialog();
		dialog.setCommonTxt("Black..");
		dialog.setVisible(true);
		dialog.requestFocus();
		dialog.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_SPACE) {
					if(cave == 1) {
						dialog.setTxt("Where I could awake the power?");
					} else if(cave == 2) {
						dialog.setTxt("Firstly");
					} else if(cave == 3) {
						dialog.setTxt("Try to look around..");
					} else if(cave == 4) {
						GamePanel.canComm = true;
						GamePanel.canMove = true;
						onCom = false;
						progress++;
						dialog.dispose();
					}
				cave++;
				}
			}
		});
	}
	
	public static void caveA() {
		Dialog dialog = new Dialog();
		dialog.setHeadIcon("/pic/head/vx034.png");
		dialog.setNpcTxt("...");
		dialog.setVisible(true);
		dialog.requestFocus();
		dialog.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_SPACE) {
					if(caveA == 1) {
						dialog.setTxt("You are ...");
					} else if(caveA == 2) {
						dialog.setTxt("Go to hell!!!!");
					} else if(cave == 3) {
						dialog.setCommonTxt("??!!");
					} else if(caveA == 4) {
						GamePanel.canComm = true;
						GamePanel.canMove = true;
						onCom = false;
						progress++;
						MainApp.fightView = true;
						MainApp.fightCave = true;
						dialog.dispose();
					}
				caveA++;
				}
			}
		});
	}
	
	public static void caveB() {
		Dialog dialog = new Dialog();
		dialog.setHeadIcon("/pic/head/vx034.png");
		dialog.setNpcTxt("...");
		dialog.setVisible(true);
		dialog.requestFocus();
		dialog.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_SPACE) {
					if(caveB == 1) {
						dialog.setTxt("You must go out!!");
					} else if(caveB == 2) {
						dialog.setCommonTxt("What did you said?");
					} else if(caveB == 3) {
						dialog.setTxt("Wait!!");
					} else if(caveB == 4) {
						dialog.setAsideTxt("Soud of wind passed from the end of path....");
					} else if(caveB == 5) {
						GamePanel.canMove = true;
						onCom = false;
						progress++;
						dialog.dispose();
					}
				caveB++;
				}
			}
		});
	}
	
	public static void caveC() {
		Dialog dialog = new Dialog();
		dialog.setCommonTxt("Here..");
		dialog.setVisible(true);
		dialog.requestFocus();
		dialog.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_SPACE) {
					if(caveC == 1) {
						dialog.setTxt("It's my class!!");
					} else if(caveC == 2) {
						dialog.setTxt("I just had a dream??");
					} else if(caveC == 3) {
						dialog.setTxt("Ahhhh!!!!");
					} else if(caveC == 4) {
						dialog.setAsideTxt("I get a headache again!!!!");
					} else if(caveC == 5) {
						dialog.setTxt("Ahhhh!!!!");
					} else if(caveC == 6) {
						GamePanel.canComm = true;
						GamePanel.canMove = true;
						onCom = false;
						progress++;
						GamePanel.loadCave();
						dialog.dispose();
					}
				caveC++;
				}
			}
		});
	}

	public static void caveD() {
		Dialog dialog = new Dialog();
		dialog.setCommonTxt("My head....");
		dialog.setVisible(true);
		dialog.requestFocus();
		dialog.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_SPACE) {
					if(caveD == 1) {
						dialog.setTxt("My head don't feel pain now...");
					} else if(caveD == 2) {
						dialog.setTxt("All of these are illusions of my prospection???");
					} else if(caveD == 3) {
						dialog.setTxt("I feel power in my body....");
					} else if(caveD == 4) {
						dialog.setAsideTxt("Maybe I have been awaken...");
					} else if(caveD == 5) {
						dialog.setTxt("I should go back to the church and ask that girl now..");
					} else if(caveD == 6) {
						GamePanel.canComm = true;
						GamePanel.canMove = true;
						onCom = false;
						progress++;
						dialog.dispose();
					}
				caveD++;
				}
			}
		});
	}
	
	public static void churchA() {
		Dialog dialog = new Dialog();
		dialog.setCommonTxt("Hello..");
		dialog.setVisible(true);
		dialog.requestFocus();
		dialog.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_SPACE) {
					if(churchA == 1) {
						GamePanel.npcUI[1].moveDown(GamePanel.canvas.iterator());
						dialog.setHeadIcon("/pic/head/o40t.png");
						dialog.setNpcTxt("I see the power with you");
					} else if(churchA == 2) {
						dialog.setCommonTxt("That's right, I do feel something different");
					} else if(churchA == 3) {
						dialog.setHeadIcon("/pic/head/o40t.png");
						dialog.setNpcTxt("Now, please find Mr.Chen in Wooden Town");
					} else if(churchA == 4) {
						dialog.setTxt("This man will direct you");
					} else if(churchA == 5) {
						dialog.setCommonTxt("Okay, and...");
					} else if(churchA == 6) {
						dialog.setTxt("Could you tell me your name??");
					} else if(churchA == 7) {
						dialog.setTxt("I still don't know your name..");
					} else if(churchA == 8) {
						dialog.setHeadIcon("/pic/head/o40t.png");
						dialog.setNpcTxt("Diana!! Call me Diana!!");
						dialog.setName("Diana");
					} else if(churchA == 9) {
						dialog.setCommonTxt("Diana...");
					} else if(churchA == 10) {
						dialog.setTxt("Thank you, Diana..");
					} else if(churchA == 11) {
						dialog.setHeadIcon("/pic/head/o40t.png");
						dialog.setNpcTxt("Go down to the fort and go right you can arrive the Wooden Town");
						dialog.setName("Diana");
					} else if(churchA == 12) {
						GamePanel.canComm = true;
						GamePanel.canMove = true;
						onCom = false;
						progress++;
						dialog.dispose();
					}
				churchA++;
				}
			}
		});
	}
	
	public static void fort() {
		Dialog dialog = new Dialog();
		dialog.setCommonTxt("Em...");
		dialog.setVisible(true);
		dialog.requestFocus();
		dialog.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_SPACE) {
					if(fort == 1) {
						dialog.setTxt("Go right arrive the Wooden Town....");
					} else if(fort == 2) {
						GamePanel.canComm = true;
						GamePanel.canMove = true;
						fort = 0;
						onCom = false;
						dialog.dispose();
					}
				fort++;
				}
			}
		});
	}
	
	public static void woodenTown() {
		Dialog dialog = new Dialog();
		dialog.setCommonTxt("Em...");
		dialog.setVisible(true);
		dialog.requestFocus();
		dialog.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_SPACE) {
					if(woodenTown == 1) {
						dialog.setTxt("Find Mr.Chen");
					} else if(woodenTown == 2) {
						GamePanel.canComm = true;
						GamePanel.canMove = true;
						woodenTown = 0;
						onCom = false;
						dialog.dispose();
					}
					woodenTown++;
				}
			}
		});
	}
	
	public static void woodenTownA() {
		Dialog dialog = new Dialog();
		dialog.setNpcTxt(GamePanel.sprite.getName() + "!!");
		dialog.setHeadIcon("/pic/head/l2t.png");
		GamePanel.npcUI[5].moveLeft(GamePanel.canvas.iterator());
		dialog.setVisible(true);
		dialog.requestFocus();
		dialog.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_SPACE) {
					if(woodenTownA == 1) {
						dialog.setCommonTxt("You are Mr.Chen??");
					} else if(woodenTownA == 2) {
						dialog.setNpcTxt("I am");
						dialog.setHeadIcon("/pic/head/l2t.png");
						dialog.setName("Mr.Chen");
					} else if(woodenTownA == 3) {
						dialog.setNpcTxt("I will tell you a secret..");
						dialog.setName("Mr.Chen");
					} else if(woodenTownA == 4) {
						GamePanel.canComm = true;
						GamePanel.canMove = true;
						onCom = false;
						dialog.dispose();
					}
					woodenTownA++;
				}
			}
		});
	}
	
	public static void boss() {
		Dialog dialog = new Dialog();
		dialog.setNpcTxt(GamePanel.sprite.getName() + "!!");
		dialog.setHeadIcon("/pic/head/bearSet.png");
		dialog.setName("Mr.BEAR");
		dialog.setVisible(true);
		dialog.requestFocus();
		dialog.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_SPACE) {
					if(boss == 1) {
						dialog.setNpcTxt("You're finally here..");
						dialog.setName("Mr.BEAR");
					} else if(boss == 2) {
						dialog.setNpcTxt("My master....");
						dialog.setName("Mr.BEAR");
					} else if(boss == 3) {
						dialog.setCommonTxt("...");
					} else if(boss == 4) {
						dialog.setTxt("I am coming for you..");
					} else if(boss == 5) {
						dialog.setNpcTxt("Shut up!!");
						dialog.setHeadIcon("/pic/head/bearSet.png");
						dialog.setName("Mr.BEAR");
					} else if(boss == 6) {
						dialog.setNpcTxt("My master...");
						dialog.setName("Mr.BEAR");
					} else if(boss == 7) {
						dialog.setNpcTxt("I miss the time we played together fourteen years ago...");
						dialog.setName("Mr.BEAR");
					} else if(boss == 8) {
						dialog.setNpcTxt("At that time, you haven't left me...");
						dialog.setName("Mr.BEAR");
					} else if(boss == 9) {
						dialog.setNpcTxt("You are so cute and clever..");
						dialog.setName("Mr.BEAR");
					} else if(boss == 10) {
						dialog.setNpcTxt("And also...");
						dialog.setName("Mr.BEAR");
					} else if(boss == 11) {
						dialog.setNpcTxt("I still remember...");
						dialog.setName("Mr.BEAR");
					} else if(boss == 12) {
						dialog.setCommonTxt("Em...");
					} else if(boss == 13) {
						dialog.setNpcTxt("My master....");
						dialog.setName("Mr.BEAR");
						dialog.setHeadIcon("/pic/head/bearSet.png");
					} else if(boss == 14) {
						dialog.setNpcTxt("You didn't forget me in that fire...");
						dialog.setName("Mr.BEAR");
					} else if(boss == 15) {
						dialog.setNpcTxt("Although you have escaped...");
						dialog.setName("Mr.BEAR");
					} else if(boss == 16) {
						dialog.setNpcTxt("You run back in a panic...");
						dialog.setName("Mr.BEAR");
					} else if(boss == 17) {
						dialog.setNpcTxt("You rummaged, rummaged and rummaged...");
						dialog.setName("Mr.BEAR");
					} else if(boss == 18) {
						dialog.setNpcTxt("From living room to kitchen....");
						dialog.setName("Mr.BEAR");
					} else if(boss == 19) {
						dialog.setNpcTxt("From kitchen to bedroom...");
						dialog.setName("Mr.BEAR");
					} else if(boss == 20) {
						dialog.setNpcTxt("From bedroom to....");
						dialog.setName("Mr.BEAR");
					} else if(boss == 21) {
						dialog.setNpcTxt("Finally, you found me...");
						dialog.setName("Mr.BEAR");
					} else if(boss == 22) {
						dialog.setNpcTxt("Fire stronger...");
						dialog.setName("Mr.BEAR");
					} else if(boss == 23) {
						dialog.setNpcTxt("You also stronger in my mind...");
						dialog.setName("Mr.BEAR");
					} else if(boss == 24) {
						dialog.setNpcTxt("BUT!!!!!!!!");
						dialog.setName("Mr.BEAR");
					} else if(boss == 25) {
						dialog.setNpcTxt("You forgot me!!!!!");
						dialog.setName("Mr.BEAR");
					} else if(boss == 26) {
						dialog.setNpcTxt("I was always long for you...");
						dialog.setName("Mr.BEAR");
					} else if(boss == 27) {
						dialog.setNpcTxt("I lost hope over and over in the carton...");
						dialog.setName("Mr.BEAR");
					} else if(boss == 28) {
						dialog.setNpcTxt("You was really forgot me!!!!!");
						dialog.setName("Mr.BEAR");
					} else if(boss == 29) {
						dialog.setNpcTxt("Slowly despair...");
						dialog.setName("Mr.BEAR");
					} else if(boss == 30) {
						dialog.setCommonTxt("Little bear, I am not...");
					} else if(boss == 31) {
						dialog.setTxt("I just");
					} else if(boss == 32) {
						dialog.setNpcTxt("My master....");
						dialog.setName("Mr.BEAR");
						dialog.setHeadIcon("/pic/head/bearSet.png");
					} else if(boss == 33) {
						dialog.setNpcTxt("Stay with me forever!!");
						dialog.setName("Mr.BEAR");
					} else if(boss == 34) {
						dialog.setCommonTxt("...");
					} else if(boss == 35) {
						dialog.setNpcTxt("Answer me!!!");
						dialog.setName("Mr.BEAR");
						dialog.setHeadIcon("/pic/head/bearSet.png");
					} else if(boss == 36) {
						dialog.setNpcTxt("You do!!!");
						dialog.setName("Mr.BEAR");
					} else if(boss == 37) {
						dialog.setCommonTxt("Little bear...");
					} else if(boss == 38) {
						dialog.setTxt("I cannot..");
					} else if(boss == 39) {
						dialog.setTxt("You have impacted so many people...");
					} else if(boss == 40) {
						dialog.setTxt("Make every thing return to normal...");
					} else if(boss == 41) {
						dialog.setNpcTxt("My master!!!");
						dialog.setName("Mr.BEAR");
						dialog.setHeadIcon("/pic/head/bearSet.png");
					} else if(boss == 42) {
						dialog.setNpcTxt("Coming to me!!!!");
						dialog.setName("Mr.BEAR");
					} else if(boss == 43) {
						GamePanel.canComm = true;
						GamePanel.canMove = true;
						onCom = false;
						MainApp.fightView = true;
						MainApp.fightBoss = true;
						dialog.dispose();
					}
					boss++;
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
