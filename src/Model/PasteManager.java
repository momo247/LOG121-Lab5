package Model;

public class PasteManager {

	private PerspectiveModel source, destination;
	private CopyStrategy strategy;

	public PasteManager(PerspectiveModel source, PerspectiveModel destination, CopyStrategy strategy) {
		this.source = source;
		this.destination = destination;
		this.strategy = strategy;
	}

	public void paste() {
		strategy.copy(source, destination);
	}
}
