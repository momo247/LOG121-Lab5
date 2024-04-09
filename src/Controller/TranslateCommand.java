package Controller;

import Model.PerspectiveModel;
import javafx.geometry.Point2D;

public class TranslateCommand extends Command {

	private Point2D translation, location;
	
	public TranslateCommand(Point2D translation) {
		this.translation = translation;
	}

	@Override
	public void execute(PerspectiveModel model) {
		location = new Point2D(model.getX() + translation.getX(), model.getY() + translation.getY());
		model.setX(location.getX());
		model.setY(location.getY());
	}

	public Point2D getLocation() {
		return this.location;
	}

	@Override
	public void undo() {
		/*location = new Point2D(model.getX() - translation.getX(), model.getY() - translation.getY());
		model.setX(location.getX());
		model.setY(location.getY());*/
	}
}
