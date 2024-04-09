package Model;

import java.io.Serializable;

public class PerspectiveModel extends Observable implements Serializable {
	
	private double scale = 1;
	private double x, y;

	public PerspectiveModel() {

	}

	public PerspectiveModel(PerspectiveModel model) {
		this.x = model.getX();
		this.y = model.getY();
		this.scale = model.getScale();
	}

	public double getScale() {
		return scale;
	}

	public void setScale(double scale) {
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

	public Memento createMemento() {
		return new Memento(this);
	}

	public void restoreFromMemento(Memento memento) {
		setX(memento.getModel().getX());
		setY(memento.getModel().getY());
		setScale(memento.getModel().getScale());
		System.out.println("Restoring scale : " + memento.getModel().getScale());
	}
}
