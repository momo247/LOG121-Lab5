package Controller;

import Model.ImageViewMemento;
import javafx.geometry.Point2D;
import javafx.scene.image.ImageView;

public class ZoomCommand extends Command {

	private ImageView imageView;
	private double scale;
	private ImageViewMemento memento;


	public ZoomCommand(ImageView imageView, double scale) {
		this.imageView = imageView;
		this.scale = scale;
	}

	@Override
	public void execute() {
		memento = new ImageViewMemento(new Point2D(imageView.getTranslateX(), imageView.getTranslateX()), scale);
		imageView.setScaleX(imageView.getScaleX() * scale);		
		imageView.setScaleY(imageView.getScaleY() * scale);
	}

	@Override
	public void undo() {
		if(memento != null) {
			//imageView.setTranslateX(memento.getTr);
		}
	}
	
}
