package Controller;

public abstract class Operation {

	protected PerspectiveController perspectiveController;

	public abstract void execute();
	public abstract void undo();
}
