package View;

import Controller.ImageController;
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
		imageView.setImage(image);
		System.out.println("Image chosen");
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
            display(imageModel.getImage());
			if(imageModel.getImage() == null) {
				System.out.println("No image");
			}
			System.out.println(imageModel.getPath());
        }
	}
	
}
