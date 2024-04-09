package Controller;

import Model.CopyStrategy;
import Model.PerspectiveModel;

public class CopyController {
	public void copy(PerspectiveModel source, PerspectiveController destination, CopyStrategy strategy) {
		strategy.copy(source, destination);
	}
}
