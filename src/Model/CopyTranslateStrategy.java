package Model;

import Controller.PerspectiveController;

public class CopyTranslateStrategy implements CopyStrategy {
	@Override
	public void copy(PerspectiveModel source, PerspectiveController destination) {
		destination.getPerspectiveModel().setX(source.getX());
		destination.getPerspectiveModel().setY(source.getY());
	}
}
