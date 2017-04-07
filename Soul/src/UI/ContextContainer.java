package UI;

import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;

public class ContextContainer extends AnimationTimer {
	private Canvas canas;
	private Node controller;
	private Group root;
	private ViewResolver resolver;
	
	public ContextContainer(Controller boot, Canvas canvas) {
		this.canas = canvas;
		this.resolver = new ViewResolver(boot);
		this.controller = resolver.getControlBar();
	}
	
	public void processEvent() {
		
	}
	
}
