package game.ui;

import com.sun.javafx.tk.FontLoader;
import com.sun.javafx.tk.Toolkit;

import input.InputUtility;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import model.GameModel;
import model.IRenderable;
import window.SceneManager;

public class GameScreen extends Canvas{
	
	private static final int FPS = 60;
	private static final long LOOP_TIME = 1000000000 / FPS;

	private static final Font TEXT_FONT = new Font("Monospace", 80);
	private static final Font SCORE_TIME_FONT = new Font("Monospace", 30);
	
	private GraphicsContext gc = this.getGraphicsContext2D();
	private GameModel model;
	private Thread gameAnimation;
	private boolean isAnimationRunning;
	
	public GameScreen(GameModel model) {
		this.setWidth(SceneManager.width_screen);
		this.setHeight(SceneManager.height_screen);
		this.model = model;
		isAnimationRunning = false;
		//this.setVisible(true);
		addListerner();
	}
	
	public void startAnimation() {
		gameAnimation = new Thread(this::animationLoop, "Game Animation Thread");
		isAnimationRunning = true;
		gameAnimation.start();
	}
	
	public void stopAnimation() {
		isAnimationRunning = false;
	}

	private void animationLoop() {
		long lastLoopStartTime = System.nanoTime();
		while (isAnimationRunning) {
			long now = System.nanoTime();
			if (now - lastLoopStartTime >= LOOP_TIME) {
				lastLoopStartTime += LOOP_TIME;

				updateAnimation(now);
				
				System.out.println("AnimationLoop");
				//Thread.yield();
			}

			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void addListerner() {
		this.setOnKeyPressed((KeyEvent event)-> {
			InputUtility.setKeyPressed(event.getCode(), true);
		});
		this.setOnKeyReleased((KeyEvent event)-> {
			InputUtility.setKeyPressed(event.getCode(), false);
		});
	}
	
	public void updateAnimation(long now) {
		
		for (IRenderable entity : model.getEntities()) {
			entity.draw(gc);
		
		/*FontLoader fontLoader = Toolkit.getToolkit().getFontLoader();
		gc.setFill(Color.BLACK);
		gc.setFont(SCORE_TIME_FONT);
		gc.fillText("Time: " + model.getTimeSecond(),
				getWidth() - fontLoader.computeStringWidth("Time: " + model.getTimeSecond(), SCORE_TIME_FONT) - 10,
				fontLoader.getFontMetrics(SCORE_TIME_FONT).getLineHeight() + 10);
		gc.fillText("Score: " + model.getScore(), 10, fontLoader.getFontMetrics(SCORE_TIME_FONT).getLineHeight() + 10);*/
		
		}
	}
	
}
