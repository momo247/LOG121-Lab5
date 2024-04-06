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
	private double previousX, previousY, totalZoom = 1;
	private PerspectiveModel model;

	public PerspectiveController(CommandManager commandManager, PersepectiveImageView imageView) {
		this.commandManager = commandManager;
		this.imageView = imageView;
		previousX = 0;
		previousY = 0;
		model = new PerspectiveModel();
		model.addObserver(imageView);
	}

	public void handleMouseEntered() {
		imageView.getImageView().setCursor(Cursor.OPEN_HAND);
	}
    
	public void handleMousePressed(MouseEvent event) {
		imageView.getImageView().setCursor(Cursor.CLOSED_HAND);
		previousX = event.getX();
		previousY = event.getY();
	}

	public void handleMouseReleased() {
		imageView.getImageView().setCursor(Cursor.OPEN_HAND);
	}

	public void handleMouseDragged(MouseEvent event) {
		double deltaX = event.getX() - previousX;
    	double deltaY = event.getY() - previousY;
    	Point2D translation = new Point2D(deltaX, deltaY);
		Point2D location  = new Point2D(imageView.getImageView().localToScene(0,0).getX() + translation.getX(), imageView.getImageView().localToScene(0,0).getY() + translation.getY());
		model.setLocation(location);
    	commandManager.executeCommand(new TranslateCommand(imageView.getImageView(), translation));
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
		if(totalZoom > 0.5) {
			model.setScale(totalZoom);
			commandManager.executeCommand(new ZoomCommand(imageView.getImageView(), zoom));
		}
	}

	/*public void zoom(Double scale) {

	}

	public void translate(Point2D translation) {

	}*/
	
}
