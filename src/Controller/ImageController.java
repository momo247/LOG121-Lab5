package Controller;

import java.io.File;
import Model.ImageModel;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;

public class ImageController {

	private ImageModel imageModel1, imageModel2, imageModel3;

    public ImageController(ImageModel imageModel1, ImageModel imageModel2, ImageModel imageModel3) {
        this.imageModel1 = imageModel1;
        this.imageModel2 = imageModel2;
        this.imageModel3 = imageModel3;
    }

	public void selectImage() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Image File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg"));
        File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            imageModel1.setPath(file.getAbsolutePath());
			imageModel1.setImage(new Image(file.toURI().toString()));

            imageModel2.setPath(file.getAbsolutePath());
			imageModel2.setImage(new Image(file.toURI().toString()));

            imageModel3.setPath(file.getAbsolutePath());
			imageModel3.setImage(new Image(file.toURI().toString()));

        }
    }
	
	public void loadImage(String path) {

	}
	
}
