package Model;

import java.io.Serializable;

public class PerspectiveModel extends Observable implements Serializable {
	
	private double scale = 1;
	private double x, y;

	public double getScale() {
		return scale;
	}

	public void setScale(Double scale) {
		this.scale = scale;
		notifyObserver();
	}

	public void setX(double x) {
		this.x = x;
		notifyObserver();
	}

	public void setY(double y) {
		this.y = y;
		notifyObserver();
	}

	public double getX() {
		return this.x;
	}

	public double getY() {
		return this.y;
	}

}
