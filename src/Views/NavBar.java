package Views;

import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;

public class NavBar extends HBox {

	public NavBar() {
		String[] items = { "File", "Open", "Save" };
		ComboBox<String> box = new ComboBox<>();
		box.getItems().addAll(items);
		box.setValue("File");

		this.getChildren().add(box);
	}
}
