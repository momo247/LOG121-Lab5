package Controller;

import Model.PerspectiveModel;
import View.PersepectiveImageView;
import javafx.geometry.Point2D;
import javafx.scene.Cursor;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;

public class PerspectiveController {

	private static final double ZOOM_FACTOR = 0.1;
	private CommandManager commandManager;
	private PersepectiveImageView imageView;
	private double totalZoom = 1, initialX, initialY;
	private PerspectiveModel model;

	public PerspectiveController(PerspectiveModel model, PersepectiveImageView imageView) {
		this.commandManager = CommandManager.getInstance();
		this.imageView = imageView;
		this.model = new PerspectiveModel();
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
		if(event.getX() != initialX && event.getY() != initialY) {
			addTranslate(event);
		}
	}

	public void addTranslate(MouseEvent event) {
		double deltaX = event.getX() - initialX;
    	double deltaY = event.getY() - initialY;
    	Point2D translation = new Point2D(deltaX, deltaY);
		model.setX(translation.getX());
		model.setY(translation.getY());
		Command command = new TranslateCommand(imageView.getImageView(), translation);
		commandManager.addCommand(command);
		commandManager.executeCommand(command);
	}

	public void handleMouseDragged(MouseEvent event) {
		/*double deltaX = event.getX() - previousX;
    	double deltaY = event.getY() - previousY;
    	Point2D translation = new Point2D(deltaX, deltaY);
		Command command = new TranslateCommand(imageView.getImageView(), translation);
		this.command = command;
		commandManager.addCommand(command);
    	commandManager.executeCommand(command);*/
	}

	public void handleMouseScrolled(ScrollEvent event) {
		double deltaY = event.getDeltaY();
		double zoom;

		if(deltaY > 0) {
			zoom = 1 + ZOOM_FACTOR;
		} else {
			zoom = 1 - ZOOM_FACTOR;
		}

		totalZoom *= zoom;

		if(totalZoom < 0.5) {
			totalZoom /= zoom;
			return;
		}
		
		model.setScale(totalZoom);
		Command command = new ZoomCommand(imageView.getImageView(), zoom);
		commandManager.addCommand(command);
		commandManager.executeCommand(command);
	}

	public void loadModel(PerspectiveModel model) {
		this.model.setX(model.getX());
		this.model.setY(model.getY());
		this.model.setScale(model.getScale());
		imageView.getImageView().setScaleX(model.getScale());
		imageView.getImageView().setScaleY(model.getScale());
		imageView.getImageView().setTranslateX(model.getX());
		imageView.getImageView().setTranslateY(model.getY());
		totalZoom = model.getScale();
	}

	public PerspectiveModel getPerspectiveModel() {
		return this.model;
	}

	public void undo() {
		commandManager.undo();
	}

	public void redo() {
		commandManager.redo();
	}

	/*public void zoom(Double scale) {

	}

	public void translate(Point2D translation) {

	}*/
	
}
