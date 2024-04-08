import Controller.ImageController;
import Controller.PerspectiveController;
import Controller.Serialize;
import Model.ImageModel;
import Model.ModelWrapper;
import Model.PerspectiveModel;
import View.PersepectiveImageView;
import View.ThumbnailImageView;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Bounds;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class MainWindow extends Application {
	public static final double HEIGHT = 600;
	public static final double WIDTH = 750;
	public static final double LIMIT = WIDTH / 2;

	private ImageView thumbnailImageView, perspectiveImageView1, perspectiveImageView2;
	private ImageModel iModel1, iModel2, iModel3;
	private ThumbnailImageView tImageView;
	private PerspectiveModel pModel1, pModel2;
	private PersepectiveImageView pImageView1, pImageView2;
	private ImageController iController;
	private PerspectiveController pController1, pController2;
	private MenuBar menuBar;
	private VBox root = new VBox();

	@Override
	public void start(Stage primaryStage) {
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

		pModel1 = new PerspectiveModel();
		pModel2 = new PerspectiveModel();

		iController = new ImageController(iModel1, iModel2, iModel3);
		pController1 = new PerspectiveController(pModel1, pImageView1);
		pController2 = new PerspectiveController(pModel2, pImageView2);

		iModel1.addObserver(tImageView);
		iModel2.addObserver(pImageView1);
		iModel3.addObserver(pImageView2);

		pModel1.addObserver(pImageView1);
		pModel2.addObserver(pImageView2);

		menuBar = new MenuBar();
		Menu fileMenu = new Menu("File");
		Menu openMenu = new Menu("Open");
		MenuItem openImageItem = new MenuItem("Open image");
		MenuItem openfileItem = new MenuItem("Open file");
		MenuItem saveItem = new MenuItem("Save");
		MenuItem exitItem = new MenuItem("Exit");
		openMenu.getItems().addAll(openImageItem, openfileItem);
		fileMenu.getItems().addAll(openMenu, saveItem, new SeparatorMenuItem(), exitItem);
		Menu optionMenu = new Menu("Options");
		Menu copyMenu = new Menu("Copy");
		Menu editMenu = new Menu("Edit");
		MenuItem pasteItem = new MenuItem("Paste");
		MenuItem allItem = new MenuItem("Copy all");
		MenuItem scaleItem = new MenuItem("Copy scale");
		MenuItem translationItem = new MenuItem("Copy translation");
		MenuItem undoItem = new MenuItem("Undo");
		MenuItem redoItem = new MenuItem("Redo");
		copyMenu.getItems().addAll(allItem, scaleItem, translationItem);
		optionMenu.getItems().addAll(copyMenu, pasteItem);
		editMenu.getItems().addAll(undoItem, redoItem);
		
		menuBar.getMenus().addAll(fileMenu, editMenu, optionMenu);
		menuBar.setUseSystemMenuBar(true);
		root.getChildren().add(menuBar);

		openImageItem.setOnAction(e -> openImage(""));
		openfileItem.setOnAction(e -> loadModels(""));
		saveItem.setOnAction(e -> saveModels());
		exitItem.setOnAction(e -> primaryStage.close());

		undoItem.setOnAction(e -> pController1.undo());
		undoItem.setOnAction(e -> pController2.undo());
		redoItem.setOnAction(e -> pController1.redo());
		redoItem.setOnAction(e -> pController2.redo());

		allItem.setOnAction(e -> copyModel());
		scaleItem.setOnAction(e - > copyScale());
		translationItem.setOnAction(e -> copyTranslation());

		Scene scene = new Scene(root, WIDTH, HEIGHT);

		primaryStage.setScene(scene);
		primaryStage.setTitle("Image viewer");
		primaryStage.setResizable(false);
		primaryStage.show();
	}

	public void saveModels() {
		pModel1 = pController1.getPerspectiveModel();
		pModel2 = pController2.getPerspectiveModel();
		ModelWrapper wrapper = new ModelWrapper(pModel1, pModel2);
		Serialize.serializeModels(wrapper, "models.ser");
	}

	public void loadModels(String path) {
		ModelWrapper wrapper = Serialize.deserializeModels("models.ser");
		pController1.loadModel(wrapper.getPerspectiveModel1());
		pController2.loadModel(wrapper.getPerspectiveModel2());
	}

	public void copyModel() {

	}

	public void copyScale() {

	}

	public void copyTranslation() {

	}

	public void openImage(String path) {
		iController.selectImage();
		Pane thumbnail = new Pane();
		Pane perspective1 = new Pane();
		Pane perspective2 = new Pane();

		perspective1.layoutBoundsProperty().addListener(new ChangeListener<Bounds>() {
			@Override public void changed(ObservableValue<? extends Bounds> observable, Bounds oldBounds, Bounds bounds) {
				perspective1.setClip(new Rectangle(bounds.getMinX(), bounds.getMinY(), bounds.getWidth(), bounds.getHeight()));
			}
		});

		perspective2.layoutBoundsProperty().addListener(new ChangeListener<Bounds>() {
			@Override public void changed(ObservableValue<? extends Bounds> observable, Bounds oldBounds, Bounds bounds) {
				perspective2.setClip(new Rectangle(bounds.getMinX(), bounds.getMinY(), bounds.getWidth(), bounds.getHeight()));
			}
		});
		
		thumbnailImageView.setFitHeight(150);
		thumbnailImageView.setFitWidth(200);
		thumbnailImageView.setPreserveRatio(true);

		perspectiveImageView1.setFitHeight(HEIGHT);
		perspectiveImageView1.setFitWidth(WIDTH / 2);
		perspectiveImageView1.setPreserveRatio(true);

		perspectiveImageView2.setFitHeight(HEIGHT);
		perspectiveImageView2.setFitWidth(WIDTH / 2);
		perspectiveImageView2.setPreserveRatio(true);

		perspectiveImageView1.setOnMouseEntered(e -> pController1.handleMouseEntered());
		perspectiveImageView2.setOnMouseEntered(e -> pController2.handleMouseEntered());

		perspectiveImageView1.setOnMousePressed(e -> pController1.handleMousePressed(e));
		perspectiveImageView2.setOnMousePressed(e -> pController2.handleMousePressed(e));

		perspectiveImageView1.setOnMouseReleased(e -> pController1.handleMouseReleased(e));
		perspectiveImageView2.setOnMouseReleased(e -> pController2.handleMouseReleased(e));

		perspectiveImageView1.setOnMouseDragged(e -> pController1.handleMouseDragged(e)); // delete ca a la fin
		perspectiveImageView2.setOnMouseDragged(e -> pController2.handleMouseDragged(e)); // delete ca a la fin

		perspectiveImageView1.setOnScroll(e -> pController1.handleMouseScrolled(e));
		perspectiveImageView2.setOnScroll(e -> pController2.handleMouseScrolled(e));
		
		thumbnail.getChildren().add(thumbnailImageView);
		perspective1.getChildren().add(perspectiveImageView1);
		perspective2.getChildren().add(perspectiveImageView2);

		HBox thumbnailBox = new HBox();
		thumbnailBox.getChildren().add(thumbnail);
		thumbnailBox.setAlignment(Pos.CENTER);

		HBox persectiveBox = new HBox(20);
		persectiveBox.getChildren().addAll(perspective1, perspective2);
		persectiveBox.setAlignment(Pos.CENTER);
		persectiveBox.setLayoutY(HEIGHT / 2);
		root.getChildren().addAll(persectiveBox, thumbnailBox);

		VBox.setVgrow(persectiveBox, Priority.ALWAYS);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
