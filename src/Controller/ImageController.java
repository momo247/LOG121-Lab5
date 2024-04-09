package Controller;

import java.io.File;
import Model.ImageModel;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;

public class ImageController {

	private ImageModel imageModel;

    public ImageController(ImageModel imageModel) {
        this.imageModel = imageModel;
    }

	public void selectImage() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Image File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg"));
        File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            imageModel.setPath(file.toURI().toString());

        }
    }
	
	public void loadImage(String path) {

	}
	
}
