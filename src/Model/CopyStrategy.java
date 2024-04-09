package Model;

import Controller.PerspectiveController;

public interface CopyStrategy {
	public void copy(PerspectiveModel source, PerspectiveController destination);
}
