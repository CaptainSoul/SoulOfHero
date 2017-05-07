package UI.fight;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import UI.MainApp;
import character.Sprite;
import character.Sprite.Group;
import dsa.impl.Point2D;
import dsa.impl.WNode;
import dsa.impl.WPath;
import io.ActionMenu;
import io.PropertyMenu;
import io.WTimer;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import map.Map;

public class FightCanvas extends Canvas {
	private enum Status {
		NONE, SHOW_ENEMY_PROPERTY, SHOW_MENU, PREPARE_MOVE, MOVE, PREPARE_ATTACK, ATTACK, WAIT, GAME_WIN, GAME_OVER
	}
	private enum GameTurn {
		PLAYER, ENEMY
	}
	private Status nowStatus = Status.NONE;
	private GameTurn nowTurn = GameTurn.PLAYER;
	private Map map;
	private GraphicsContext gContext;
	private Image imageMap;
	private ActionMenu actionMenu;
	private PropertyMenu propertyMenu;
	public static final int tileWidth = 32;
	public static final int tileHeight = 32;
	
	private List<Sprite> players = new ArrayList<>();
	private List<Sprite> enemys = new ArrayList<>();
	private boolean isRunning = true;
	private long sleep = 100;
	
	private WTimer moveTimer;
	private WTimer actioTimer;
	private Sprite nowControllPlayer;
	private Sprite nowBeAttackedPlayer;
	private int nowActionIndex = 0;
	private int moveToX, moveToY;
	private boolean isCanMove = false;
	private WPath path;
	
	private Thread thread = new Thread(new Runnable() {

		@Override
		public void run() {
			while(isRunning) {
				Platform.runLater(new Runnable() {

					@Override
					public void run() {
						draw();
						update();
						
					}
				});
				try {
					Thread.sleep(sleep);
				} catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
		
	});
	
	public FightCanvas(double width, double height) {
		super(width, height);
		imageMap = new Image(getClass().getResourceAsStream("fight2.jpg"));
		gContext = getGraphicsContext2D();
		map = new Map(tileWidth, tileHeight, imageMap);
		thread.start();
		
		moveTimer = WTimer.createWTimer(50, new WTimer.OnTimerListener() {

			@Override
			public void onTimerRunning(WTimer mTimer) {
				if (nowStatus == Status.MOVE) {
					int nowPlayerX = (int) (nowControllPlayer.getX() / tileWidth);
					int nowPlayerY = (int) (nowControllPlayer.getY() / tileHeight);
					if (nowPlayerX != moveToX) {
						nowControllPlayer.moveX(nowPlayerX > moveToX ? -tileWidth : tileWidth);
					} else {
						if (nowPlayerY != moveToY) {
							nowControllPlayer.moveY(nowPlayerY > moveToY ? -tileHeight : tileHeight);
						} else {
							nowControllPlayer.setWaitToAttack(false);
							nowControllPlayer.setWaitToMove(false);
							nowControllPlayer.setCanMove(false);
							nowControllPlayer = null;
							nowStatus = Status.NONE;
							moveTimer.stop();
						}
					}
				}
			}
		});

		actioTimer = WTimer.createWTimer(50, new WTimer.OnTimerListener() {
			@Override
			public void onTimerRunning(WTimer mTimer) {
				if (nowTurn == GameTurn.ENEMY) {
					if (nowStatus == Status.NONE) {
						if (nowActionIndex < enemys.size()) {
							nowControllPlayer = enemys.get(nowActionIndex);
							nowControllPlayer.setChoose(true);
							if (!nowControllPlayer.isHasNearBP(players)) {
								if (nowControllPlayer.isCanMove()) {
									Sprite player = nowControllPlayer.getNearestBP(players);
									path.clear();
									// path.map_sprite = createMapSprite();
									LinkedList<WNode> nodeList = path.SearchMoveScan(
											new Point2D(nowControllPlayer.getX() / tileWidth, nowControllPlayer.getY()
													/ tileHeight), nowControllPlayer.getMove());
									List<WNode> deleteList = new ArrayList<>();
									for (WNode node : nodeList) {
										if (isPointHasPlayer((int) node.getPoint().getX(), (int) node.getPoint().getY())) {
											deleteList.add(node);
										}
									}
									for (WNode node : deleteList) {
										nodeList.remove(node);
									}
									nowControllPlayer.nodeList = nodeList;
									Point2D point = player.getNearestNode(nodeList);
									moveToX = (int) (point.getX());
									moveToY = (int) (point.getY());
									nowStatus = Status.MOVE;
									moveTimer.start();
								} else {
									nowStatus = Status.PREPARE_ATTACK;
								}
							} else {
								nowStatus = Status.PREPARE_ATTACK;
							}
						} else {
							nowStatus = Status.NONE;
							nowTurn = GameTurn.PLAYER;
							nowActionIndex = 0;
							for (Sprite enemy : enemys) {
								enemy.reset();
							}
						}
					} else if (nowStatus == Status.PREPARE_ATTACK) {
						if (nowControllPlayer.isHasNearBP(players)) {
							Sprite bp = nowControllPlayer.getNearestBP(players);
							nowControllPlayer.attack(bp);
							nowBeAttackedPlayer = bp;
							bp.setFlash(true);
							nowStatus = Status.ATTACK;
						} else {
							nowControllPlayer.setCanAction(false);
							nowActionIndex++;
							nowControllPlayer.setChoose(false);
							nowStatus = Status.NONE;
						}
					} else if (nowStatus == Status.ATTACK) {
						if (!nowBeAttackedPlayer.isFlash()) {
							if (nowBeAttackedPlayer.getHp() <= 0) {
								players.remove(nowBeAttackedPlayer);
							}
							nowControllPlayer.setCanAction(false);
							nowActionIndex++;
							nowControllPlayer.setChoose(false);
							nowStatus = Status.NONE;
							if (players.size() == 0) {
								nowStatus = Status.GAME_OVER;
								nowTurn = GameTurn.PLAYER;
							}
						}
					}
				} else if (nowTurn == GameTurn.PLAYER) {
					if (nowStatus == Status.ATTACK) {
						if (!nowBeAttackedPlayer.isFlash()) {
							if (nowBeAttackedPlayer.getHp() <= 0) {
								nowControllPlayer.putExp(nowBeAttackedPlayer.getExp());
								enemys.remove(nowBeAttackedPlayer);
							}
							waitToNextPlayer();
							if (enemys.size() == 0) {
								nowStatus = Status.GAME_WIN;
							}
						}
					}
				}
			}
		});
		actioTimer.start();
		
		actionMenu = new ActionMenu(new String[] { "move", "attack", "wait" }, 55, 90);
		actionMenu.setOnMenuItemClickListener(new ActionMenu.OnMenuItemClickListener() {
			@Override
			public void onMenuItemClick(int index) {
				if (nowTurn == GameTurn.PLAYER) {
					switch (index) {
					case 0: // move
						if (nowControllPlayer.isCanMove()) {
							nowStatus = Status.PREPARE_MOVE;
							
							nowControllPlayer.setWaitToMove(true);
							path.clear();
							// path.map_sprite = createMapSprite();
							LinkedList<WNode> nodeList = path.SearchMoveScan(new Point2D(nowControllPlayer.getX()
									/ tileWidth, nowControllPlayer.getY() / tileHeight), nowControllPlayer.getMove());

							List<WNode> deleteList = new ArrayList<>();
							for (WNode node : nodeList) {
								if (isPointHasPlayer((int) node.getPoint().getX(), (int) node.getPoint().getY())) {
									deleteList.add(node);
								}
							}
							for (WNode node : deleteList) {
								nodeList.remove(node);
							}
							nowControllPlayer.nodeList = nodeList;
						}
						break;
					case 1: // attack
						if (nowControllPlayer.isCanAttack()) {
							nowControllPlayer.setWaitToAttack(true);
							nowStatus = Status.PREPARE_ATTACK;
						}
						break;
					case 2: // wait
						waitToNextPlayer();
						break;
					}
				}
			}
		});

		propertyMenu = new PropertyMenu(120, 215);

		setOnMouseClicked(e -> {
			if (e.getButton() == MouseButton.PRIMARY) {
				switch (nowStatus) {
				case NONE:
					for (Sprite player : players) {

						if (player.isCollisionWith(e.getX(), e.getY())) {
							actionMenu.setXY(player.getX() + tileWidth, player.getY());
							actionMenu.getTextObjects()[0].setColor(player.isCanMove() != true ? Color.DARKGRAY
									: Color.WHITE);
							actionMenu.getTextObjects()[1].setColor(player.isCanAttack() != true ? Color.DARKGRAY
									: Color.WHITE);
							propertyMenu.initPlayer(player);
							nowControllPlayer = player;
							nowControllPlayer.setChoose(true);
							nowStatus = Status.SHOW_MENU;
						}
					}

					for (Sprite enemy : enemys) {
						if (enemy.isCollisionWith(e.getX(), e.getY())) {
							propertyMenu.initPlayer(enemy);
							nowStatus = Status.SHOW_ENEMY_PROPERTY;
						}
					}
					break;
				case SHOW_MENU:
					actionMenu.onMousePressed(e);
					break;
				case PREPARE_MOVE:
					moveToX = (int) (e.getX() / tileWidth);
					moveToY = (int) (e.getY() / tileHeight);
					isCanMove = false;

					if (!isPointHasPlayer(moveToX, moveToY)) {
						for (WNode node : nowControllPlayer.nodeList) {
							if (((int) node.getPoint().getX()) == moveToX && ((int) node.getPoint().getY()) == moveToY) {
								isCanMove = true;
							}
						}

						if (isCanMove) {
							nowStatus = Status.MOVE;
							moveTimer.start();
							nowControllPlayer.setChoose(false);
						}
					}
					break;
				case PREPARE_ATTACK:

					for (Sprite enemy : enemys) {
						if (enemy.isCollisionWith(e.getX(), e.getY())) {
							nowControllPlayer.attack(enemy);
							nowControllPlayer.setWaitToAttack(false);
							enemy.setFlash(true);
							nowBeAttackedPlayer = enemy;
							nowStatus = Status.ATTACK;
						}
					}
					break;
				default:
					break;
				}
			} else if (e.getButton() == MouseButton.SECONDARY) {

				if (nowControllPlayer != null) {
					nowControllPlayer.setChoose(false);
					nowControllPlayer.setWaitToAttack(false);
					nowControllPlayer.setWaitToMove(false);
				}
				nowStatus = Status.NONE;
				nowControllPlayer = null;
			}
		});
		path = new WPath(map.getMapIndex());

		path.valueMap.put(0, 1);
		path.valueMap.put(18, 2);

		initPlayers();
		initEnemy();
	}
	
	private void initPlayers() {
		Image player1Image = new Image(getClass().getResourceAsStream("vx025.png"));
		Sprite player1 = new Sprite("Wang");
		player1.setImage(player1Image);
		player1.putExp(150);
		player1.setXY(18 * tileWidth, 15 * tileHeight);

		Image player2Image = new Image(getClass().getResourceAsStream("vx02.png"));
		Sprite player2 = new Sprite("Dong");
		player2.setImage(player2Image);
		player2.setXY(18 * tileWidth, 12 * tileHeight);

		Image player3Image = new Image(getClass().getResourceAsStream("vx033.png"));
		Sprite player3 = new Sprite("Chen");
		player3.setImage(player3Image);
		player3.setXY(15 * tileWidth, 15 * tileHeight);

		players.add(player1);
		players.add(player2);
		players.add(player3);
	}

	private void waitToNextPlayer() {
		nowControllPlayer.setCanAction(false);
		nowControllPlayer.setChoose(false);
		nowStatus = Status.NONE;

		boolean isTurnOver = true;

		for (Sprite bPlayer : players) {
			if (bPlayer.isCanAction()) {
				isTurnOver = false;
			}
		}

		if (isTurnOver) {
			nowTurn = GameTurn.ENEMY;
			System.out.println("Enemy turn");
			for (Sprite bPlayer : players) {
				bPlayer.reset();
			}
		}
	}

	private void initEnemy() {
		Image orc = new Image(getClass().getResourceAsStream("vx05.png"));
		int[][] locations = { { 3, 3 }, { 3, 5 }, { 5, 3 } };
		for (int i = 0; i < 3; i++) {
			Sprite enemy = new Sprite("Enemy");
			enemy.setImage(orc);
			enemy.setGroup(Group.ENEMY);
			enemy.setMove(3);
			enemy.putExp(50);
			enemy.setXY(locations[i][0] * tileWidth, locations[i][1] * tileHeight);
			enemys.add(enemy);
		}
	}
	
	public static Stage fightStage() {
		Stage stage = new Stage();
		AnchorPane root = new AnchorPane();
		Scene scene = new Scene(root, 800, 600);
		FightCanvas mapCanvas = new FightCanvas(800, 600);
		root.getChildren().add(mapCanvas);
		stage.setScene(scene);
		return stage;
	}
	
	public void draw() {
		map.drawMap(gContext);
		drawPlayer();
		switch (nowStatus) {
		case SHOW_MENU:
			if (nowControllPlayer != null && nowControllPlayer.isCanAction()) {
				actionMenu.draw(gContext);
			}
			propertyMenu.draw(gContext);
			break;
		case SHOW_ENEMY_PROPERTY:
			propertyMenu.draw(gContext);
			break;
		case PREPARE_MOVE:

			break;
		case GAME_WIN:
			gContext.setFont(Font.font(18));
			gContext.setFill(Color.WHITE);
			gContext.fillText("Victory!", 250, 150);
			MainApp.mainView = true;
			break;
		case GAME_OVER:
			gContext.setFont(Font.font(18));
			gContext.setFill(Color.RED);
			gContext.fillText("Failure!", 250, 150);
			break;
		default:
			break;
		}
		gContext.save();
		gContext.setFont(Font.font(18));
		switch (nowTurn) {
		case PLAYER:
			gContext.setFill(Color.WHITE);
			gContext.fillText("Your turn", 15, getHeight() - 15);
			break;
		case ENEMY:
			gContext.setFill(Color.RED);
			gContext.fillText("Enemy turn", 15, getHeight() - 15);
			break;
		}
		gContext.restore();
	}
	
	public void update() {
		moveTimer.update();
		actioTimer.update();
		for (Sprite player : players) {
			player.update();
		}
		for (Sprite enemy : enemys) {
			enemy.update();
		}
	}
	
	public void drawPlayer() {
		for (Sprite player : players) {
			player.draw(gContext);
		}
		for (Sprite enemy : enemys) {
			enemy.draw(gContext);
		}
	}
	
	public boolean isPointHasPlayer(int x, int y) {
		for (Sprite player : players) {
			if (player.getX() / tileWidth == x && player.getY() / tileHeight == y) {
				return true;
			}
		}

		for (Sprite enemy : enemys) {
			if (enemy.getX() / tileWidth == x && enemy.getY() / tileHeight == y) {
				return true;
			}
		}
		return false;
	}

	public int[][] createMapSprite() {
		int[][] mapSprite = new int[map.getMapIndex().length][map.getMapIndex()[0].length];
		for (int y = 0; y < mapSprite.length; y++) {
			for (int x = 0; x < mapSprite.length; x++) {
				if (isPointHasPlayer(x, y)) {
					mapSprite[y][x] = 1;
				} else {
					mapSprite[y][x] = 0;
				}
			}
		}
		return mapSprite;
	}
	
}
