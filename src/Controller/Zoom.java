package Controller;

import javafx.scene.image.ImageView;

public class Zoom extends Operation {

	private ImageView imageView;
	private double scale;

	public Zoom(ImageView imageView, double scale) {
		this.imageView = imageView;
		this.scale = scale;
	}

	@Override
	public void execute() {
		imageView.setScaleX(imageView.getScaleX() * scale);
		//imageView.setFitWidth(imageView.getFitHeight() * scale);
		
		imageView.setScaleY(imageView.getScaleY() * scale);
		//imageView.setFitHeight(imageView.getFitHeight() * scale);
		
	}

	@Override
	public void undo() {
		
	}
	
}
