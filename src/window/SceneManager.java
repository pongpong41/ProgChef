package window;

import game.ui.GameScreen;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class SceneManager {

	private static Stage primaryStage;
	public static final double width_screen = 910;
	public static final double height_screen = 560;

	public static void initialize(Stage stage) {
		primaryStage = stage;
		primaryStage.show();
	}
	
	public static void gotoSceneOf(Canvas canvas) {
		//TODO Fill Code
		Pane root = new Pane(canvas);
		primaryStage.setScene(new Scene(root));
		canvas.requestFocus();
	}
}
