package Controller;

import Model.PerspectiveModel;
import javafx.geometry.Point2D;

public class TranslateCommand extends Command {

	private Point2D translation, location;
	private PerspectiveModel model;
	
	public TranslateCommand(Point2D translation, PerspectiveModel model) {
		this.translation = translation;
		this.model = model;
	}

	@Override
	public void execute() {
		location = new Point2D(this.model.getX() + translation.getX(), this.model.getY() + translation.getY());
		this.model.setX(location.getX());
		this.model.setY(location.getY());
	}

	@Override
	public void undo() {
		location = new Point2D(this.model.getX() - translation.getX(), this.model.getY() - translation.getY());
		this.model.setX(location.getX());
		this.model.setY(location.getY());
	}

}
