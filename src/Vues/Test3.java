package Vues;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Test3 extends StackPane {

	public Test3() {
		Rectangle rectangle = new Rectangle(200, 200, Color.LIMEGREEN);
		this.getChildren().add(rectangle);
	}

}