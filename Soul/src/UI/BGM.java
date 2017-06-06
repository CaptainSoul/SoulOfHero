package UI;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class BGM {
	private String bgmStartURL = "/bgm/MainTitle.mp3";
	private String bgmMainURL = "/bgm/Theme1.mp3";
	private String bgmNervousURL = "/bgm/.mp3";
	private String bgmEpicURL = "/bgm/.mp3";
	private String bgmTerrorURL = "/bgm/GameOfThrones.mp3";
	private String bgmBattleURL = "/bgm/.mp3";
	private String bgmBattle2URL = "/bgm/.mp3";
	private String bgmBattleBossURL = "/bgm/.mp3";
	private String bgmBazaarURL = "/bgm/NassauShores.mp3";
	
	public boolean bgmStart = false;
	public boolean bgmMain = false;
	public boolean bgmNervous = false;
	public boolean bgmTerror = false;
	public boolean bgmBattleBoss = false;
	
	private String url = getClass().getResource(bgmStartURL).toString();
	private Media media = new Media(url);
	private MediaPlayer player = new MediaPlayer(media);
	private static BGM bgm;
	
	public void loadBgmStart() {
		loadMusic(bgmStartURL);
	}
	
	public void loadBgmMain() {
		loadMusic(bgmMainURL);
	}
	
	public void loadBgmNervous() {
		loadMusic(bgmNervousURL);
	}
	
	public void loadBgmEpic() {
		loadMusic(bgmEpicURL);
	}
	
	public void loadBgmTerro() {
		loadMusic(bgmTerrorURL);
	}
	
	public void loadBgmBattle() {
		loadMusic(bgmBattleURL);
	}
	
	private BGM() {
	}
	
	public static BGM getBGM() {
		if(bgm == null)
			bgm = new BGM();
		return bgm;
	}
	
	private void loadMusic(String name) {
		player.stop();
		url = getClass().getResource(name).toString();
		media = new Media(url);
		player = new MediaPlayer(media);
		player.play();
	}
	
	public void setAutoPlay() {
		player.setAutoPlay(true);
		player.setCycleCount(20);
	}
	
	public void stop() {
		player.stop();
	}
	

}
