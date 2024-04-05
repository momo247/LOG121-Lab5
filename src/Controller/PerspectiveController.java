package Controller;

import javafx.geometry.Point2D;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;

public class PerspectiveController {

	private static final double ZOOM_FACTOR = 0.1;
	private OperationManager operationManager;
	private ImageView imageView;
	private double previousX, previousY;

	public PerspectiveController(OperationManager operationManager, ImageView imageView) {
		this.operationManager = operationManager;
		this.imageView = imageView;
		previousX = 0;
		previousY = 0;
	}
    
	public void handleMousePressed(MouseEvent event) {
		previousX = event.getX();
		previousY = event.getY();
	}

	public void handleMouseDragged(MouseEvent event) {
		double deltaX = event.getX() - previousX;
    	double deltaY = event.getY() - previousY;
    	Point2D translation = new Point2D(deltaX, deltaY);
    	operationManager.executeOperation(new Translate(imageView, translation));
	}

	public void handleMouseScrolled(ScrollEvent event) {
		double deltaY = event.getDeltaY();
		double zoom;

		if(deltaY > 0) {
			zoom = 1 + ZOOM_FACTOR;
		} else {
			zoom = 1 - ZOOM_FACTOR;
		}

		operationManager.executeOperation(new Zoom(imageView, zoom));
	}

	/*public void zoom(Double scale) {

	}

	public void translate(Point2D translation) {

	}*/
	
}
