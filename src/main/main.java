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