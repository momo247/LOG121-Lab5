package Controller;

import Model.PerspectiveModel;

public class ZoomCommand extends Command {

	private double scale;

	public ZoomCommand(double scale) {
		this.scale = scale;
	}

	@Override
	public void execute(PerspectiveModel model) {
		model.setScale(scale);
	}

	@Override
	public void undo() {
		//model.setScale(1 / scale);
	}
	
}
