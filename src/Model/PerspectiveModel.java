package Model;

import java.io.Serializable;
import javafx.geometry.Point2D;

public class PerspectiveModel extends Observable implements Serializable {
	
	private double scale = 1;
	private transient Point2D location = new Point2D(0, 0);
	private double x, y;
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
		x = location.getX();
		y = location.getY();
		notifyObserver();
	}

	public double getX() {
		return this.x;
	}

	public double getY() {
		return this.y;
	}

}
