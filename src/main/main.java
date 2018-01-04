package main;
import game.GameMain;
import game.logic.GameLogic;
import game.ui.GameScreen;
import input.InputUtility;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.RenderableHolder;
import window.SceneManager;

public class main extends Application {
	public static final double width_screen = 910;
	public static final double height_screen = 560;
	
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		//public static final int width = 900; create class to control canvas
		//public static final int height = 600;
		/*StackPane root = new StackPane();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Prog Meth");

		GameLogic logic = new GameLogic();
		GameScreen gameScreen = new GameScreen(width_screen, height_screen);
		root.getChildren().add(gameScreen);
		gameScreen.requestFocus();
		
		stage.show();
		
		AnimationTimer animation = new AnimationTimer() {
			public void handle(long now) {
				gameScreen.updateAnimation();
				logic.logicUpdate();
				RenderableHolder.getInstance().update();
				//InputUtility.updateInputState();
			}
		};
		animation.start();*/
		
		try {
			SceneManager.initialize(primaryStage);
			primaryStage.setTitle("Prog Meth");
			primaryStage.centerOnScreen();
			GameMain.newGame();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}