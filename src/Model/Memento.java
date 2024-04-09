package Model;

public class Memento {
	private PerspectiveModel model;

	public Memento(PerspectiveModel model) {
		this.model = new PerspectiveModel(model);
	}

	public PerspectiveModel getModel() {
		return model;
	}
}
