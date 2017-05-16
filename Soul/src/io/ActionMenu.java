package io;

import UI.BaseObject;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class ActionMenu extends BaseObject{
	private TextObject[] textObjects;
	private Paint color = Color.BLACK;
	private int spaceLine = 5;
	
	private OnMenuItemClickListener onMenuItemClickListener;
	
	public ActionMenu(String[] strs, int width, int height) {
		setWidth(width);
		setHeight(height);
		textObjects = new TextObject[strs.length];
		for(int i = 0; i < textObjects.length; i++) {
			textObjects[i] = new TextObject();
			textObjects[i].setText(strs[i]);
			textObjects[i].setColor(Color.WHITE);
			textObjects[i].setFontSize(16);
		}
	}
	
	public void onMousePressed(MouseEvent e) {
		if(onMenuItemClickListener != null) {
			for(int i = 0; i < textObjects.length; i++) {
				if(textObjects[i].isCollisionWith(e.getX(), e.getY())) {
					onMenuItemClickListener.onMenuItemClick(i);
				}
			}
		}
	}
	
	@Override
	public void draw(GraphicsContext gContext) {
		gContext.save();
		gContext.setGlobalAlpha(0.8f);
		gContext.setStroke(color);
		gContext.fillRect(x, y, width, height);
		for (int i = 0; i < textObjects.length; i++) {
			textObjects[i].setX((getWidth() - textObjects[i].getWidth()) / 2 + getX());
			textObjects[i].setY(getY() + spaceLine * (i + 1) + textObjects[i].getHeight() * (i + 1));
			textObjects[i].draw(gContext);
		}
		gContext.restore();
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
	public TextObject[] getTextObjects() {
		return textObjects;
	}
	
	public void setTextObjects(TextObject[] textObjects) {
		this.textObjects = textObjects;
	}
	
	public OnMenuItemClickListener getOnMenuItemClickListener() {
		return onMenuItemClickListener;
	}
	
	public void setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
		this.onMenuItemClickListener = onMenuItemClickListener;
	}
	
	public interface OnMenuItemClickListener {
		public void onMenuItemClick(int index);
	}

}
