package Vues;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Test1 extends StackPane {

	public Test1() {
		Rectangle rectangle = new Rectangle(200, 200, Color.LIGHTBLUE);
		this.getChildren().add(rectangle);
	}

}