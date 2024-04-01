package Model;

import javafx.geometry.Point2D;

public class PerspectiveModel extends Observable {
	
	private Double scale;
	private Point2D translation, mouseClickPosition;

	public Double getScale() {
		return scale;
	}

	public void setScale(Double scale) {
		this.scale = scale;
		notifyObserver();
	}

	public Point2D getTranslation() {
		return translation;
	}

	public void setTranslation(Point2D translation) {
		this.translation = translation;
		notifyObserver();
	}

	public Point2D getMouseClickPosition() {
		return mouseClickPosition;
	}

	public void setMouseClickPosition(Point2D mouseClickPosition) {
		this.mouseClickPosition = mouseClickPosition;
		notifyObserver();
	}
	
}
