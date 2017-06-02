package io;

import com.sun.javafx.tk.FontMetrics;
import com.sun.javafx.tk.Toolkit;

import UI.BaseObject;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;

public class TextObject extends BaseObject {
	private String text;
	private Font font = Font.getDefault();
	private double fontSize = Font.getDefault().getSize();
	private Paint color = Color.BLACK;
	
	public TextObject(){
	}
	
	public TextObject(String text) {
		this.text = text;
	}
	
	@Override
	public void draw(GraphicsContext gContext) {
		gContext.save();
		gContext.setFont(font);
		gContext.setFill(color);
		if(text != null) {
			gContext.fillText(text, getX(), getY());
		}
		gContext.restore();
	}

	@Override
	public void update() {
		
	}
	
	@Override
	public boolean isCollisionWith(double x, double y) {
		if(x > getX() && y > getY() - getHeight() && x < getX() + getWidth() && y < getY() - getHeight() + getHeight()) {
			return true;
		}
		return false;
	}
	
	@Override
	public double getWidth() {
		FontMetrics fm = Toolkit.getToolkit().getFontLoader().getFontMetrics(font);
		return fm.computeStringWidth(text);
	}
	
	@Override
	public double getHeight() {
		FontMetrics fm = Toolkit.getToolkit().getFontLoader().getFontMetrics(font);
		return fm.getLineHeight();
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public Font getFont() {
		return font;
	}
	
	public void setFont(Font font) {
		this.font = font;
	}
	
	public Paint getColor() {
		return color;
	}
	
	public void setColor(Paint color) {
		this.color = color;
	}
	
	public double getFontSize() {
		return fontSize;
	}
	
	public void setFontSize(double fontSize) {
		this.fontSize = fontSize;
		this.font = new Font(font.getFamily(), fontSize);
	}
	
}
