package Controller;

import java.io.File;

import Model.ImageModel;
import View.ThumbnailImageView;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;

public class ImageController {

	private ImageModel model;
    private ThumbnailImageView thumbnailView;

    public ImageController(ImageModel model, ThumbnailImageView thumbnailView) {
        this.model = model;
        this.thumbnailView = thumbnailView;
    }

	public void selectImage() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Image File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg"));
        File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            model.setPath(file.getAbsolutePath());
			model.setImage(new Image(file.toURI().toString()));
        }
    }
	
	public void loadImage(String path) {

	}
	
}
