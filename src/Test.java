import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Test extends Application {
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	@Override
	public void start(Stage stage) {
		StackPane root = new StackPane();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("click");
		
		Canvas canvas = new Canvas(420,200);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		root.getChildren().add(canvas);
		
		redraw("",gc);
		stage.show();
		
		scene.setOnKeyPressed((KeyEvent e) -> {
			String new_code = e.getCode().toString();
			redraw(new_code, gc);
		});
	}
	
	public void redraw(String code, GraphicsContext gc) {
		gc.setFill(Color.BLACK);
		gc.setFont(Font.font(40));
		gc.clearRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
		gc.fillText("TEST SetOnKeyPressed", 10, 50);
		gc.fillText(code, 200, 100);
		
	}
}