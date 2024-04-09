package Model;

import java.io.Serializable;

public class ImageModel extends Observable implements Serializable{
    
	private String path;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
		notifyObserver();
	}
	
}
