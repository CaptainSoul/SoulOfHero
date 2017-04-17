package UI;

import character.AbstractCharacter;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class PropertyMenu extends BaseObject {
	private TextObject[] textObjects;
	private Paint color = Color.BLACK;
	private int spaceline = 5;
	
	public PropertyMenu(int width, int height) {
		setWidth(width);
		setHeight(height);
		textObjects = new TextObject[7];
		for(int i = 0; i < textObjects.length; i++) {
			textObjects[i] = new TextObject();
			textObjects[i].setColor(Color.WHITE);
		}
	}
	
	public void initPlayer(AbstractCharacter player) {
		
	}
	
	@Override
	public void draw(GraphicsContext gContext) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
