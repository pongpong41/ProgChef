package game;

import game.logic.GameLogic;
import game.ui.GameScreen;
import model.GameModel;
import window.SceneManager;

public class GameMain {
	
	private static GameModel model;
	private static GameScreen canvas;
	private static GameLogic logic;

	public static void newGame() {
		// TODO fill code
		model = new GameModel();
		canvas = new GameScreen(model);
		logic = new GameLogic(model);
		SceneManager.gotoSceneOf(canvas);
		logic.startGame();
		canvas.startAnimation();
	}
	
	public static void stopGame() {
		// TODO fill code
		logic.stopGame();
		canvas.stopAnimation();
	}
}
