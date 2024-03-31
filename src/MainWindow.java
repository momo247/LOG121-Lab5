import Controller.ImageController;
import Controller.PerspectiveController;
import Model.ImageModel;
import Model.PerspectiveModel;
import View.PersepectiveImageView;
import View.ThumbnailImageView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class MainWindow extends Application {

	private ImageModel iModel;
	private PerspectiveModel pModel1, pModel2;
	private ThumbnailImageView tImageView;
	private PersepectiveImageView pImageView1, pImageView2;
	private ImageController iController;
	private PerspectiveController pController1, pController2;
	private MenuBar menuBar;
	BorderPane root = new BorderPane();

	@Override
	public void start(Stage primaryStage) {
		iModel = new ImageModel();
		tImageView = new ThumbnailImageView();
		iController = new ImageController(iModel, tImageView);
		iModel.addObserver(tImageView);

		menuBar = new MenuBar();
		Menu fileMenu = new Menu("File");
		MenuItem saveItem = new MenuItem("Save");
		MenuItem openItem = new MenuItem("Open");
		MenuItem exitItem = new MenuItem("Exit");
		fileMenu.getItems().addAll(openItem, saveItem, new SeparatorMenuItem(), exitItem);
		menuBar.getMenus().add(fileMenu);

		openItem.setOnAction(e -> iController.selectImage());

		//BorderPane root = new BorderPane();
		
		root.setTop(menuBar);
		HBox box = new HBox();
		box.getChildren().add(tImageView.getImageView());
		root.setCenter(box);
		//root.setCenter(tImageView.getImageView());
		//root.setCenter(new ImageView(iModel.getPath()));
		


		Scene scene = new Scene(root, 750, 600);

		primaryStage.setScene(scene);
		primaryStage.setTitle("Image viewer");
		primaryStage.setResizable(false);
		primaryStage.show();
		//openImage("");
	}

	public void saveModels() {

	}

	public void loadModels(String path) {

	}

	public void openImage(String path) {
		root.setRight(tImageView.getImageView());
	}

	public static void main(String[] args) {
		launch(args);
	}
}
