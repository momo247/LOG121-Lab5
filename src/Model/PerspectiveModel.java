package Model;

import java.io.Serializable;

public class PerspectiveModel extends Observable implements Serializable {
	
	private double scale = 1;
	private double x, y;

	public double getScale() {
		return scale;
	}

	public void setScale(double scale) {
		this.scale = scale;
		notifyObservers();
	}

	public void setX(double x) {
		this.x = x;
		notifyObservers();
	}

	public void setY(double y) {
		this.y = y;
		notifyObservers();
	}

	public double getX() {
		return this.x;
	}

	public double getY() {
		return this.y;
	}

}
