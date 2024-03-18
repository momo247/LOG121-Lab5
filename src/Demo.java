import Views.NavBar;
import Views.Test1;
import Views.Test2;
import Views.Test3;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Demo extends Application {

	@Override
	public void start(Stage primaryStage) {
		Test1 test = new Test1();
		Test2 test2 = new Test2();
		Test3 test3 = new Test3();

		NavBar navBar = new NavBar();

		BorderPane root = new BorderPane();
		root.setTop(navBar);
		root.setLeft(test);
		root.setRight(test2);
		root.setBottom(test3);

		Scene scene = new Scene(root);

		primaryStage.setScene(scene);
		primaryStage.setTitle("Testing");
		primaryStage.setResizable(false);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
