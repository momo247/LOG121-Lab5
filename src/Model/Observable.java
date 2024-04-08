package Model;

import View.Observer;

public abstract class Observable {

	private Observer observer;

	public void addObserver(Observer observer) {
		this.observer = observer;
	}

	public void removeObserver() {
		this.observer = null;
	}

	public void notifyObserver() {
		if(observer != null) {
			observer.update(this);
			System.out.println("Perspective model updated!");
		}
		
	}
	
}
