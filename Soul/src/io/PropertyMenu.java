package io;

import UI.BaseObject;
import character.AbstractCharacter;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class PropertyMenu extends BaseObject {
	private TextObject[] textObjects;
	private Paint color = Color.BLACK;
	private int spaceLine = 5;
	
	public PropertyMenu(int width, int height) {
		setWidth(width);
		setHeight(height);
		textObjects = new TextObject[8];
		for(int i = 0; i < textObjects.length; i++) {
			textObjects[i] = new TextObject();
			textObjects[i].setColor(Color.WHITE);
		}
	}
	
	public void initPlayer(AbstractCharacter player) {
		setProperty(textObjects[0], "name", player.getName());
		setProperty(textObjects[1], "level", String.valueOf(player.getLevel()));
		setProperty(textObjects[2], "hp", String.valueOf(player.getHp() + "/" + player.getMaxHp()));
		setProperty(textObjects[3], "mp", String.valueOf(player.getMp() + "/" + player.getMaxMp()));
		setProperty(textObjects[4], "attack", String.valueOf(player.getAttack()));
		setProperty(textObjects[5], "defence", String.valueOf(player.getDefence()));
		setProperty(textObjects[6], "exp", String.valueOf(player.getExp()));
		setProperty(textObjects[7], "gold", String.valueOf(player.getGold()));
		
	}
	
	public void setProperty(TextObject textObject, String propertyName, String value) {
		textObject.setText(propertyName + ": " + value);
		textObject.setFontSize(16);
	}
	
	@Override
	public void draw(GraphicsContext gContext) {
		gContext.save();
		gContext.setStroke(color);
		gContext.setGlobalAlpha(0.8f);
		gContext.fillRect(x, y, width, height);
		if(textObjects != null) {
			for(int i = 0; i < textObjects.length; i++) {
				textObjects[i].setX((getWidth() - textObjects[i].getWidth()) / 2 + getX());
				textObjects[i].setY(getY() + spaceLine * (i + 1) + textObjects[i].getHeight() * (i+1));
				textObjects[i].draw(gContext);
			}
		}
		gContext.restore();
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
