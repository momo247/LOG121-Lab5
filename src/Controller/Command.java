package Controller;

import Model.PerspectiveModel;

public abstract class Command {

	public abstract void execute(PerspectiveModel model);
}
