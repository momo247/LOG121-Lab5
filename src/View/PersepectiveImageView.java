package View;

import Model.ImageModel;
import Model.Observable;
import Model.PerspectiveModel;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PersepectiveImageView implements Observer {

	private ImageView imageView;

	public PersepectiveImageView() {
		imageView = new ImageView();
	}

	public void display(Image image) {
		imageView.setImage(image);
	}

	public ImageView getImageView() {
		return imageView;
	}

	public void initView() {
		
	}

	public void setImage(Image image) {
		imageView.setImage(image);
	}

	@Override
	public void update(Observable observable) {
		if(observable instanceof ImageModel) {
			ImageModel iModel = (ImageModel) observable;
			this.setImage(iModel.getImage());
		} else if (observable instanceof PerspectiveModel) {
            PerspectiveModel model = (PerspectiveModel) observable;
			
			System.out.println(model.getLocation());
			System.out.println(model.getScale());
        }
	}
	
}
