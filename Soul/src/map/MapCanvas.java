package map;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MapCanvas extends Canvas {
	private Map map;
	private GraphicsContext gContext;
	private Image imageMap;
	private int tileWidth = 32;
	private int tileHeight = 32;
	
	public MapCanvas(double width, double height) {
		super(width, height);
		imageMap = new Image(getClass().getResourceAsStream("map0.png"));
		gContext = getGraphicsContext2D();
		map = new Map(tileWidth, tileHeight, imageMap);
		draw();
	}
	
	public static Stage mapStage() {
		Stage stage = new Stage();
		AnchorPane root = new AnchorPane();
		Scene scene = new Scene(root, 640, 480);
		MapCanvas mapCanvas = new MapCanvas(640, 480);
		root.getChildren().add(mapCanvas);
		stage.setScene(scene);
		return stage;
	}
	
	public void draw() {
		map.drawMap(gContext);
	}
	
	public void update() {
		
	}
}
