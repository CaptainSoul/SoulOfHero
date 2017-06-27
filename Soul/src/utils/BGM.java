package utils;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class BGM {
	private String bgmStartURL = "/bgm/MainTitle.mp3";
	private String bgmHeavenURL = "/bgm/Theme1.mp3";
	private String bgmChurchURL = "/bgm/CruellyEyes.mp3";
	private String bgmNervousURL = "/bgm/Illusions.mp3";
	private String bgmNervous2URL = "/bgm/HumanoidPavilion.mp3";
	private String bgmEpicURL = "/bgm/GameOfThrones.mp3";
	private String bgmSoulURL = "/bgm/LastReunion.mp3";
	private String bgmBattleURL = "/bgm/Battle.mp3";
	private String bgmBattleBossURL = "/bgm/BattleBoss.mp3";
	private String bgmBazaarURL = "/bgm/NassauShores.mp3";
	
	public static boolean bgmStart = false;
	public static boolean bgmHeaven = false;
	public static boolean bgmChurch = false;
	public static boolean bgmNervous = false;
	public static boolean bgmNervous2 = false;
	public static boolean bgmBattle = false;
	public static boolean bgmBattleBoss = false;
	
	private String url;
	private Media media;
	public MediaPlayer player;
	private static BGM bgm;
	
	public void checkBgm() {
		if(bgmStart) {
			loadBgmStart();
			bgmStart = false;
		} else if(bgmNervous) {
			loadBgmNervous();
			bgmNervous = false;
		} else if(bgmNervous2) {
			loadBgmNervous2();
			bgmNervous2 = false;
		} else if(bgmBattle) {
			loadBgmBattle();
			bgmBattle = false;
		} else if(bgmBattleBoss) {
			loadBgmBattleBoss();
			bgmBattleBoss = false;
		} else if(bgmHeaven) {
			loadBgmHeaven();
			bgmHeaven = false;
		} else if(bgmChurch) {
			loadBgmChurch();
			bgmChurch = false;
		}
	}
	
	public void loadBgmStart() {
		loadMusic(bgmStartURL);
	}
	
	public void loadBgmHeaven() {
		loadMusic(bgmHeavenURL);
	}
	
	public void loadBgmChurch() {
		loadMusic(bgmChurchURL);
	}
	
	public void loadBgmNervous() {
		loadMusic(bgmNervousURL);
	}
	
	public void loadBgmNervous2() {
		loadMusic(bgmNervous2URL);
	}
	
	public void loadBgmEpic() {
		loadMusic(bgmEpicURL);
	}
	
	public void loadBgmBattle() {
		loadMusic(bgmBattleURL);
	}
	
	public void loadBgmBazaar() {
		loadMusic(bgmBazaarURL);
	}
	
	public void loadBgmSoul() {
		loadMusic(bgmSoulURL);
	}
	
	public void loadBgmBattleBoss() {
		loadMusic(bgmBattleBossURL);
	}
	
	private BGM() {
	}
	
	public static BGM getBGM() {
		if(bgm == null)
			bgm = new BGM();
		return bgm;
	}
	
	private void loadMusic(String name) {
		if(player != null)
			player.stop();
		url = getClass().getResource(name).toString();
		media = new Media(url);
		player = new MediaPlayer(media);
		setAutoPlay();
	}
	
	public void setAutoPlay() {
		player.setAutoPlay(true);
		player.setCycleCount(20);
	}
	
	public void stop() {
		player.stop();
	}
	

}
