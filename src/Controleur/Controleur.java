package Controleur;

import java.io.File;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class Controleur {
    

    public void recevoirAction(String event) {
        if(event.equals("Ouvrir")) {
            ouvrir();
        } else if(event.equals("Sauvegarder")) {
            sauvegarder();
        }
    }

    public void ouvrir() {
        FileChooser fileChooser = new FileChooser();
		//fileChooser.setInitialDirectory(new File(System.getProperty("user.home"), "Pictures"));
		//FileChooser.ExtensionFilter pngFilter = new ExtensionFilter("PNG", "*.png");
		//FileChooser.ExtensionFilter jpegFilter = new ExtensionFilter("JPEG", "*.jpeg", "*.jpg");
		FileChooser.ExtensionFilter pictureFilter = new ExtensionFilter("Images PNG & JPG", "*.png","*.jpeg", "*.jpg");
		//fileChooser.getExtensionFilters().addAll(pngFilter, jpegFilter);
		fileChooser.getExtensionFilters().add(pictureFilter);

		File fichier = fileChooser.showOpenDialog(null);
    }

    public void sauvegarder() {
        System.out.println("Sauvegarder fichier");
    }
}
