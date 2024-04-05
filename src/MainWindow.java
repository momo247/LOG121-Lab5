import Controller.ImageController;
import Controller.OperationManager;
import Controller.PerspectiveController;
import Model.ImageModel;
import View.PersepectiveImageView;
import View.ThumbnailImageView;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class MainWindow extends Application {
	public static final double HEIGHT = 600;
	public static final double WIDTH = 750;
	public static final double LIMIT = WIDTH / 2;

	private ImageView thumbnailImageView, perspectiveImageView1, perspectiveImageView2;
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
		pImageView1.getImageView().toBack();
		pImageView2.getImageView().toBack();

		thumbnailImageView = tImageView.getImageView();
		perspectiveImageView1 = pImageView1.getImageView();
		perspectiveImageView2 = pImageView2.getImageView();

		iController = new ImageController(iModel1, iModel2, iModel3, tImageView);
		pController1 = new PerspectiveController(operationManager, perspectiveImageView1);
		pController2 = new PerspectiveController(operationManager, perspectiveImageView2);
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
		menuBar.setUseSystemMenuBar(true);
		root.setTop(menuBar);

		Line center = new Line(WIDTH / 2, 0, WIDTH / 2, HEIGHT - 200);
		root.setCenter(center);

		openItem.setOnAction(e -> openImage(""));
		saveItem.setOnAction(e -> saveModels());
		exitItem.setOnAction(e -> primaryStage.close());

		Scene scene = new Scene(root, WIDTH, HEIGHT);

		primaryStage.setScene(scene);
		primaryStage.setTitle("Image viewer");
		primaryStage.setResizable(false);
		primaryStage.show();
	}

	public void saveModels() {
		System.out.println("Saving");
	}

	public void loadModels(String path) {
		System.out.println("Loading");
	}

	public void openImage(String path) {
		iController.selectImage();
		Pane thumbnail = new Pane();
		Pane perspective1 = new Pane();
		Pane perspective2 = new Pane();
		
		thumbnailImageView.setFitHeight(150);
		thumbnailImageView.setFitWidth(200);
		thumbnailImageView.setPreserveRatio(true);

		perspectiveImageView1.setFitHeight(350);
		perspectiveImageView1.setFitWidth(350);
		perspectiveImageView1.setPreserveRatio(true);

		perspectiveImageView2.setFitHeight(350);
		perspectiveImageView2.setFitWidth(350);
		perspectiveImageView2.setPreserveRatio(true);

		thumbnail.setLayoutX((WIDTH - thumbnailImageView.getBoundsInLocal().getWidth()) / 2);
		perspective1.setLayoutY((HEIGHT - perspectiveImageView1.getFitHeight()) / 2 + 50);
		perspective1.setPickOnBounds(false);
		perspective2.setLayoutY((HEIGHT - perspectiveImageView2.getFitHeight()) / 2 + 50);
		perspective2.setLayoutX(WIDTH - perspectiveImageView2.getBoundsInLocal().getWidth());

		perspectiveImageView1.setOnMousePressed(e -> pController1.handleMousePressed(e));
		perspectiveImageView2.setOnMousePressed(e -> pController2.handleMousePressed(e));

		perspectiveImageView1.setOnMouseDragged(e -> pController1.handleMouseDragged(e));
		perspectiveImageView2.setOnMouseDragged(e -> pController2.handleMouseDragged(e));

		perspectiveImageView1.setOnScroll(e -> pController1.handleMouseScrolled(e));
		perspectiveImageView2.setOnScroll(e -> pController2.handleMouseScrolled(e));

		thumbnail.getChildren().add(thumbnailImageView);
		perspective1.getChildren().add(perspectiveImageView2);
		perspective2.getChildren().add(perspectiveImageView1);
		
		HBox hBox2 = new HBox();
		hBox2.getChildren().add(thumbnail);
		hBox2.setAlignment(Pos.CENTER);
		hBox2.setBackground(new Background(new BackgroundFill(root.getBackground().getFills().get(0).getFill(), null, null)));
		
		root.setLeft(perspective1);
		root.getLeft().toBack();
		root.setRight(perspective2);
		root.getRight().toBack();
		root.setBottom(hBox2);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
