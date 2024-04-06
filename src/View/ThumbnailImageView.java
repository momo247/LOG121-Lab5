package View;

import Model.ImageModel;
import Model.Observable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ThumbnailImageView implements Observer {

	private ImageView imageView;

	public ThumbnailImageView() {
        imageView = new ImageView();
    }

	public void display(Image image) {

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
		if (observable instanceof ImageModel) {
            ImageModel imageModel = (ImageModel) observable;
            this.setImage(imageModel.getImage());
        }
	}
	
}
