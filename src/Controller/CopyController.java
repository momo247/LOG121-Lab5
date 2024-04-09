package Controller;

import Model.CopyStrategy;
import Model.PerspectiveModel;

public class CopyController {
	public void copy(PerspectiveModel source, PerspectiveModel destination, CopyStrategy strategy) {
		strategy.copy(source, destination);
	}
}
