package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Demo extends Application{

		@Override
		public void start(Stage primaryStage) {
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("PanneauTest.fxml"));
				Pane root = loader.load();
				Scene scene = new Scene(root);
				primaryStage.setScene(scene);
				primaryStage.setTitle("");
				primaryStage.setResizable(false);
				primaryStage.show();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public static void main(String[] args) {
			launch(args);
		}
}
