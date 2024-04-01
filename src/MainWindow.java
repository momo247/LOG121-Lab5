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
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainWindow extends Application {
	public static final double HEIGHT = 600;
	public static final double WIDTH = 750;

	private ImageModel iModel1, iModel2, iModel3;
	private PerspectiveModel pModel1, pModel2;
	private ThumbnailImageView tImageView;
	private PersepectiveImageView pImageView1, pImageView2;
	private ImageController iController;
	private PerspectiveController pController1, pController2;
	private MenuBar menuBar;
	BorderPane root = new BorderPane();

	@Override
	public void start(Stage primaryStage) {
		iModel1 = new ImageModel();
		iModel2 = new ImageModel();
		iModel3 = new ImageModel();
		pModel1 = new PerspectiveModel();
		pModel2 = new PerspectiveModel();
		tImageView = new ThumbnailImageView();
		pImageView1 = new PersepectiveImageView();
		pImageView2 = new PersepectiveImageView();
		iController = new ImageController(iModel1, iModel2, iModel3, tImageView);
		iModel1.addObserver(tImageView);
		iModel2.addObserver(pImageView1);
		iModel3.addObserver(pImageView2);

		menuBar = new MenuBar();
		Menu fileMenu = new Menu("File");
		MenuItem saveItem = new MenuItem("Save");
		MenuItem openItem = new MenuItem("Open");
		MenuItem exitItem = new MenuItem("Exit");
		fileMenu.getItems().addAll(openItem, saveItem, new SeparatorMenuItem(), exitItem);
		menuBar.getMenus().add(fileMenu);

		openItem.setOnAction(e -> iController.selectImage());

		//BorderPane root = new BorderPane();
		Pane imagePane = new Pane();
		ImageView test1 = tImageView.getImageView();
		ImageView test2 = pImageView1.getImageView();
		ImageView test3 = pImageView2.getImageView();
		test1.setFitHeight(150);
		test1.setFitWidth(200);
		test1.setPreserveRatio(true);

		test2.setFitHeight(350);
		test2.setFitWidth(350);
		test2.setPreserveRatio(true);

		test3.setFitHeight(350);
		test3.setFitWidth(350);
		test3.setPreserveRatio(true);

		test1.setLayoutX((WIDTH - test1.getBoundsInLocal().getWidth()) / 2);
		test2.setLayoutY((HEIGHT - test2.getFitHeight()) / 2 + 50);
		test2.setLayoutX(WIDTH - test2.getFitWidth());
		test3.setLayoutY((HEIGHT - test2.getFitHeight()) / 2 + 50);

		imagePane.getChildren().addAll(test1, test2, test3);
		
		root.setTop(menuBar);
		root.setCenter(imagePane);

		Scene scene = new Scene(root, WIDTH, HEIGHT);

		primaryStage.setScene(scene);
		primaryStage.setTitle("Image viewer");
		primaryStage.setResizable(false);
		primaryStage.show();
	}

	public void saveModels() {

	}

	public void loadModels(String path) {

	}

	public void openImage(String path) {

	}

	public static void main(String[] args) {
		launch(args);
	}
}
