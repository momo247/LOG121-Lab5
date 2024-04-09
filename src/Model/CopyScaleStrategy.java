package Model;

import Controller.PerspectiveController;

public class CopyScaleStrategy implements CopyStrategy {
	@Override
	public void copy(PerspectiveModel source, PerspectiveController destination) {
		destination.getPerspectiveModel().setScale(source.getScale());
		destination.setTotalZoom(source.getScale());
		System.out.println("Source scale : " + source.getScale());
		System.out.println("Destination scale : " + destination.getPerspectiveModel().getScale());
	}
}
