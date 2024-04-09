package Model;

import Controller.PerspectiveController;

public class PasteManager {

	private PerspectiveModel source;
	private PerspectiveController destination;
	private CopyStrategy strategy;

	public PasteManager(PerspectiveModel source, PerspectiveController destination, CopyStrategy strategy) {
		this.source = source;
		this.destination = destination;
		this.strategy = strategy;
	}

	public void paste() {
		strategy.copy(source, destination);
	}
}
