package application;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Controller {

	@FXML
	Pane PanneauImages;
	@FXML
	MenuBar barDeMenu;
	@FXML
	ImageView vueImage1;
	@FXML
	ImageView vueImage2;
	@FXML
	ImageView vueImage3;

	private Image image;

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
						if (fichier != null) {
							ouvrirFichier(fichier);
							if (fichier.getName().contains(".png") || fichier.getName().contains(".jpg")) {
								image = new Image(fichier.toURI().toString());
								vueImage1.setImage(image);
								vueImage2.setImage(image);
								vueImage3.setImage(image);
							}
						}

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
		fileChooser.setInitialDirectory(new File(System.getProperty("user.dir")));
		fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("All Images", "*.*"),
				new FileChooser.ExtensionFilter("JPG", "*.jpg"), new FileChooser.ExtensionFilter("PNG", "*.png"),
				new FileChooser.ExtensionFilter("SER", "*.ser"));

	}

	private void ouvrirFichier(File fichier) {
		try {
			desktop.open(fichier);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	protected void setStage(Stage stage) {
		this.stage = stage;
	}
}
