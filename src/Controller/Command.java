package Controller;

public abstract class Command {

	protected PerspectiveController perspectiveController;

	public abstract void execute();
	public abstract void undo();
}
