import Controller.ImageController;
import Controller.PerspectiveController;
import Model.ImageModel;
import Model.PerspectiveModel;
import View.PersepectiveImageView;
import View.ThumbnailImageView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainWindow extends Application {

	private ImageModel iModel;
	private PerspectiveModel pModel1, pModel2;
	private ThumbnailImageView tImageView;
	private PersepectiveImageView pImageView1, pImageView2;
	private ImageController iController;
	private PerspectiveController pController1, pController2;

	@Override
	public void start(Stage primaryStage) {

		BorderPane root = new BorderPane();
		
		//root.setCenter();

		Scene scene = new Scene(root, 750, 600);

		primaryStage.setScene(scene);
		primaryStage.setTitle("Test");
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
