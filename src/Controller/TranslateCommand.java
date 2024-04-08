package Controller;

import javafx.geometry.Point2D;
import javafx.scene.image.ImageView;

public class TranslateCommand extends Command {

	private ImageView imageView;
	private Point2D translation, location;

	/*public TranslateCommand(ImageView imageView, Point2D translation) {
		this.imageView = imageView;
		this.translation = translation;
		location = new Point2D(imageView.getTranslateX() + translation.getX(), imageView.getTranslateY() + translation.getY());
	}

	@Override
	public void execute() {
		imageView.setTranslateX(location.getX());
		imageView.setTranslateY(location.getY());
	}

	public Point2D getLocation() {
		return this.location;
	}

	@Override
	public void undo() {
		location = new Point2D(imageView.getTranslateX() - translation.getX(), imageView.getTranslateY() - translation.getY());
		imageView.setTranslateX(location.getX());
		imageView.setTranslateY(location.getY());
	}*/
	
	public TranslateCommand(PerspectiveController controller, Point2D translation) {
		this.perspectiveController = controller;
		this.translation = translation;
		location = new Point2D(perspectiveController.getPerspectiveModel().getX() + translation.getX(), perspectiveController.getPerspectiveModel().getY() + translation.getY());
	}

	@Override
	public void execute() {
		perspectiveController.getPerspectiveModel().setX(location.getX());
		perspectiveController.getPerspectiveModel().setY(location.getY());
	}

	public Point2D getLocation() {
		return this.location;
	}

	@Override
	public void undo() {
		location = new Point2D(perspectiveController.getPerspectiveModel().getX() - translation.getX(), perspectiveController.getPerspectiveModel().getY() - translation.getY());
		perspectiveController.getPerspectiveModel().setX(location.getX());
		perspectiveController.getPerspectiveModel().setY(location.getY());
	}
}
