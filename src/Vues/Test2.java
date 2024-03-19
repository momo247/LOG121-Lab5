package Views;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Test2 extends StackPane {

	public Test2() {
		Rectangle rectangle = new Rectangle(200, 200, Color.CRIMSON);
		this.getChildren().add(rectangle);
	}

}