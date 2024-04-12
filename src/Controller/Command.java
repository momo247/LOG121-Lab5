package Controller;

import Model.PerspectiveModel;

public abstract class Command {

	protected PerspectiveModel model;

	public abstract void execute();
	public abstract void undo();
}
