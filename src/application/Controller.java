package application;

import java.awt.Desktop;
import java.io.File;
import java.util.Iterator;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Controller {

	@FXML
	MenuBar barDeMenu;

	private Desktop desktop = Desktop.getDesktop();
	private final FileChooser fileChooser = new FileChooser();
	private Stage stage;

	public void initialize() {
		setUpBarDeMenu();
	}

	public void setUpBarDeMenu() {
		ObservableList<Menu> menus = this.barDeMenu.getMenus();
		Iterator<Menu> iter = menus.iterator();

		while (iter.hasNext()) {
			Menu menu = iter.next();
			if (menu.getText().equalsIgnoreCase("File")) {
				MenuItem itemOpen = new MenuItem("Open");
				MenuItem itemSave = new MenuItem("Save");
				itemOpen.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent e) {
						System.out.println("File is opened");
						configurerFileChooser(fileChooser);
						File fichier = fileChooser.showOpenDialog(stage);

					}

				});
				itemSave.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent e) {
						System.out.println("File is saved");

					}

				});
				menu.getItems().get(0).setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent e) {
						System.out.println("File is closed");

					}

				});
				menu.getItems().add(itemOpen);
				menu.getItems().add(itemSave);
			}
		}
		menus.remove(2);
	}

	private void configurerFileChooser(final FileChooser filechooser) {
		fileChooser.setTitle("Files");

	}

	protected void setStage(Stage stage) {
		this.stage = stage;
	}
}
