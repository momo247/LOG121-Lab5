package Controller;

import Model.PerspectiveModel;
import View.PersepectiveImageView;
import javafx.geometry.Point2D;
import javafx.scene.Cursor;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;

public class PerspectiveController {

	private static final double ZOOM_FACTOR = 0.1;
	private PersepectiveImageView imageView;
	private double initialX, initialY;
	private PerspectiveModel model;

	public PerspectiveController(PerspectiveModel model, PersepectiveImageView imageView) {
		this.imageView = imageView;
		this.model = model;
	}

	public void handleMouseEntered() {
		imageView.getImageView().setCursor(Cursor.OPEN_HAND);
	}
    
	public void handleMousePressed(MouseEvent event) {
		imageView.getImageView().setCursor(Cursor.CLOSED_HAND);
		initialX = event.getX();
		initialY = event.getY();
	}

	public void handleMouseReleased(MouseEvent event) {
		imageView.getImageView().setCursor(Cursor.OPEN_HAND);
		addTranslate(event);
	}

	public void addTranslate(MouseEvent event) {
		double deltaX = event.getX() - initialX;
    	double deltaY = event.getY() - initialY;
    	Point2D translation = new Point2D(deltaX, deltaY);
		
		Command command = new TranslateCommand(translation, model);
		CommandManager.getInstance().addCommand(command);
		CommandManager.getInstance().executeCommand(command);
	}

	public void handleMouseScrolled(ScrollEvent event) {
		double deltaY = event.getDeltaY();
		double zoom;

		if(deltaY > 0) {
			zoom = 1 + ZOOM_FACTOR;
		} else {
			zoom = 1 - ZOOM_FACTOR;
		}
		
		Command command = new ZoomCommand(zoom, model);
		CommandManager.getInstance().addCommand(command);
		CommandManager.getInstance().executeCommand(command);
	}

	public void loadModel(PerspectiveModel model) {
		if(this.model.getX() != model.getX()) {
			this.model.setX(model.getX());
		}
		if(this.model.getY() != model.getY()) {
			this.model.setY(model.getY());
		}
		if(this.model.getScale() != model.getScale()) {
			this.model.setScale(model.getScale());
		}
	}

	public PerspectiveModel getPerspectiveModel() {
		return this.model;
	}

	public void undo() {
		CommandManager.getInstance().undo();
	}

	public void redo() {
		CommandManager.getInstance().redo();
	}
	
}
