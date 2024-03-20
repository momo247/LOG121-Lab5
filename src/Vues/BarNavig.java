package Vues;

import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;

public class BarNavig extends HBox {

	public BarNavig() {
		String[] items = { "Fichier", "Ouvrir", "Sauvegarder" };
		ComboBox<String> box = new ComboBox<>();
		box.getItems().addAll(items);
		box.setValue("Fichier");

		this.getChildren().add(box);
		box.setOnAction(e -> gererAction(box.getValue()));
	}

	public void gererAction(String event) {
		System.out.println(event);
	}
}
