package Controller;

import Model.PerspectiveModel;

public abstract class Command {

	//protected PerspectiveModel model;

	public abstract void execute(PerspectiveModel model);
	public abstract void undo();
}
