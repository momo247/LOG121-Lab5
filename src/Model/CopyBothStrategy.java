package Model;

import Controller.PerspectiveController;

public class CopyBothStrategy implements CopyStrategy {
	@Override
	public void copy(PerspectiveModel source, PerspectiveController destination) {
		destination.getPerspectiveModel().setScale(source.getScale());
		destination.getPerspectiveModel().setX(source.getX());
		destination.getPerspectiveModel().setY(source.getY());
	}
}
