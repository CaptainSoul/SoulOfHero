package utils;

import java.util.List;

import UI.fight.FightCanvas;
import character.AbstractCharacter;
import character.NPC;
import character.Player;
import javafx.scene.image.Image;

public class InitCharacter {
	public void initPlayers(List<AbstractCharacter> players) {
		Image playerImage1 = new Image(getClass().getResourceAsStream("player1.png"));
		Player player1 = new Player("player1");
		player1.setImage(playerImage1);
		player1.setXY(10 * FightCanvas.tileWidth, 8 * FightCanvas.tileHeight);
		
		Image playerImage2 = new Image(getClass().getResourceAsStream("player1.png"));
		Player player2 = new Player("player2");
		player2.setImage(playerImage1);
		player2.setXY(15 * FightCanvas.tileWidth, 8 * FightCanvas.tileHeight);
		
		players.add(player1);
		players.add(player2);
	}
	
	public void initEnemy(List<AbstractCharacter> enemys) {
		Image enemyImage1 = new Image(getClass().getResourceAsStream("npc1.png"));
		int[][] locations = {{3,3}, {3,5}, {5,3}};
		for(int i = 0; i < locations.length; i++) {
			NPC npc = new NPC("npcA");
			npc.setImage(enemyImage1);
			npc.setXY(locations[i][0] * FightCanvas.tileWidth, locations[i][1] * FightCanvas.tileHeight);
			enemys.add(npc);
		}
	}
}
