package Controller;

import Model.PerspectiveModel;

public class ZoomCommand extends Command {

	private double scale;

	public ZoomCommand(double scale, PerspectiveModel model) {
		this.scale = scale;
		this.model = model;
	}

	@Override
	public void execute() {
		this.model.setScale(this.model.getScale() * scale);
	}

	@Override
	public void undo() {
		this.model.setScale(this.model.getScale() / scale);
	}

}
