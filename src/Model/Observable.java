package Model;

import java.util.ArrayList;

import View.Observer;

public abstract class Observable {

	private ArrayList<Observer> observers = new ArrayList<Observer>();

	public void addObserver(Observer observer) {
		observers.add(observer);
	}

	public void removeObserver(Observer observer) {
		observers.remove(observer);
	}

	public void notifyObserver() {
		for (Observer observer: observers) {
			observer.update(this);
		}
	}
}
