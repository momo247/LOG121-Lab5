package Controller;

import javafx.scene.image.ImageView;

public class ZoomCommand extends Command {

	//private ImageView imageView;
	private double scale;


	/*public ZoomCommand(ImageView imageView, double scale) {
		this.imageView = imageView;
		this.scale = scale;
	}

	@Override
	public void execute() {
		imageView.setScaleX(imageView.getScaleX() * scale);		
		imageView.setScaleY(imageView.getScaleY() * scale);
	}

	@Override
	public void undo() {
		imageView.setScaleX(imageView.getScaleX() / scale);		
		imageView.setScaleY(imageView.getScaleY() / scale);
	}*/

	public ZoomCommand(PerspectiveController controller, double scale) {
		perspectiveController = controller;
		this.scale = scale;
	}

	@Override
	public void execute() {
		perspectiveController.getPerspectiveModel().setScale(scale);
	}

	@Override
	public void undo() {
		perspectiveController.getPerspectiveModel().setScale(1 / scale);
	}
	
}
