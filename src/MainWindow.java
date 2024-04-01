import Controller.ImageController;
import Controller.OperationManager;
import Controller.PerspectiveController;
import Model.ImageModel;
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

	private ImageView test1, test2, test3;
	private ImageModel iModel1, iModel2, iModel3;
	private ThumbnailImageView tImageView;
	private PersepectiveImageView pImageView1, pImageView2;
	private ImageController iController;
	private PerspectiveController pController1, pController2;
	private MenuBar menuBar;
	BorderPane root = new BorderPane();

	@Override
	public void start(Stage primaryStage) {
		OperationManager operationManager = OperationManager.getInstance();
		iModel1 = new ImageModel();
		iModel2 = new ImageModel();
		iModel3 = new ImageModel();
		tImageView = new ThumbnailImageView();
		pImageView1 = new PersepectiveImageView();
		pImageView2 = new PersepectiveImageView();

		test1 = tImageView.getImageView();
		test2 = pImageView1.getImageView();
		test3 = pImageView2.getImageView();

		iController = new ImageController(iModel1, iModel2, iModel3, tImageView);
		pController1 = new PerspectiveController(operationManager, test2);
		pController2 = new PerspectiveController(operationManager, test3);
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
		root.setTop(menuBar);

		openItem.setOnAction(e -> openImage(""));

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
		iController.selectImage();
		Pane imagePane = new Pane();
		
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
		test2.setLayoutX(WIDTH - test2.getBoundsInLocal().getWidth());
		test3.setLayoutY((HEIGHT - test2.getFitHeight()) / 2 + 50);

		test1.setOnMouseClicked(e -> System.out.println("1"));
		test2.setOnMouseClicked(e -> System.out.println("2"));
		test3.setOnMouseClicked(e -> System.out.println("3"));

		test2.setOnMouseDragged(e -> pController1.handleMouseDragged(e));
		test3.setOnScroll(e -> pController2.handleMouseScrolled(e));

		imagePane.getChildren().addAll(test1, test2, test3);
		
		root.setCenter(imagePane);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
