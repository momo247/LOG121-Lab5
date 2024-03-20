package Vues;

import Controleur.Controleur;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;

public class BarNavig extends HBox {
	private Controleur controleur;

	public BarNavig(Controleur controleur) {
		this.controleur = controleur;
		init();
	}

	public void init() {
		String[] items = { "Fichier", "Ouvrir", "Sauvegarder" };
		ComboBox<String> box = new ComboBox<>();
		box.getItems().addAll(items);
		box.setValue("Fichier");

		this.getChildren().add(box);
		box.setOnAction(e -> controleur.recevoirAction(box.getValue()));
	}
}
