package Model;

import javafx.geometry.Point2D;

public class ImageViewMemento {

	private Point2D translation;
	private double scale;

	public ImageViewMemento(Point2D translation, double scale) {
		this.translation = translation;
		this.scale = scale;
	}

	public Point2D getTranslation() {
		return translation;
	}

	public double getScale() {
		return scale;
	}

	public void setTranslation(Point2D translation) {
		this.translation = translation;
	}

	public void setScale(double scale) {
		this.scale = scale;
	}
	
}
