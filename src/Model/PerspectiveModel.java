package Model;

import javafx.geometry.Point2D;

public class PerspectiveModel extends Observable {
	
	private double scale = 1;
	private Point2D location;


	public double getScale() {
		return scale;
	}

	public void setScale(Double scale) {
		this.scale = scale;
		notifyObserver();
	}

	public Point2D getLocation() {
		return location;
	}

	public void setLocation(Point2D location) {
		this.location = location;
		notifyObserver();
	}

}
