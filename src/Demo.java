import Vues.BarNavig;
import Vues.Test1;
import Vues.Test2;
import Vues.Test3;
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

		BarNavig navBar = new BarNavig();

		BorderPane root = new BorderPane();
		root.setTop(navBar);
		root.setLeft(test);
		root.setRight(test2);
		root.setBottom(test3);

		Scene scene = new Scene(root);

		primaryStage.setScene(scene);
		primaryStage.setTitle("Test");
		primaryStage.setResizable(false);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
