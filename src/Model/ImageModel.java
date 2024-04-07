package Model;

import javafx.scene.image.Image;

public class ImageModel extends Observable {
    
	private String path;
	private Image image;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
		notifyObserver();
		System.out.println(path);
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
		notifyObserver();
		System.out.println(image.toString());
	}
	
}
