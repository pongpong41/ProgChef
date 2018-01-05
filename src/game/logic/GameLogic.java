package game.logic;

import java.util.ArrayList;
import java.util.List;

import game.GameMain;
import javafx.scene.input.KeyCode;
import model.field.Field;
import model.food.Plate;
import model.player.Player;
import model.Entity;
import model.GameModel;
import model.counter.*;

public class GameLogic {
	private static final int FPS = 60;
	private static final long LOOP_TIME = 1000000000 / FPS;

	private GameModel model;
	private boolean isGameRunning; 
	
	private List<Entity> gameObjectContainer;
	public List<Counter> counterInGame;
	private Player player1;
	//private Player player2;
	
	public GameLogic(GameModel model) {
		this.gameObjectContainer = new ArrayList<Entity>();
		this.counterInGame = new ArrayList<>();
		
		this.model = model;
		isGameRunning = false;
		
		Field field = new Field();
		model.getRenderableHolder().add(field);
		player1 = new Player(600,420,this,KeyCode.RIGHT,KeyCode.LEFT,KeyCode.UP,KeyCode.DOWN,KeyCode.A,KeyCode.S);
		addNewObject(player1);
		//player2 = new Player(400,420,this,KeyCode.D,KeyCode.A,KeyCode.W,KeyCode.S,KeyCode.E,KeyCode.R);
		//addNewObject(player2);
		addCounter(field);
	}
	
	protected void addNewObject(Entity entity) {
		gameObjectContainer.add(entity);
		model.getRenderableHolder().add(entity);
		if (entity!=null && entity instanceof Counter) 	counterInGame.add((Counter) entity);
	}
	
	private void addCounter(Field field) {
		int size = 70;
		for (int i = 0; i < field.getRow(); i++) {
			for (int j = 0; j < field.getCol(); j++) {
				if (field.getField()[i][j] == 1) addNewObject(new Shelf(j*size+size/2, (i+1)*size, 70,70,null));
				else if (field.getField()[i][j] == 20) addNewObject(new Chest(j*size+size/2, (i+1)*size, 70,70,0));
				else if (field.getField()[i][j] == 21) addNewObject(new Chest(j*size+size/2, (i+1)*size, 70,70,1));
				else if (field.getField()[i][j] == 22) addNewObject(new Chest(j*size+size/2, (i+1)*size, 70,70,2));
				else if (field.getField()[i][j] == 3) addNewObject(new Chopper(j*size+size/2, (i+1)*size, 70,70));
				else if (field.getField()[i][j] == 4) addNewObject(new Cashier(j*size+size/2, (i+1)*size, 70,70,model));
				else if (field.getField()[i][j] == 5) addNewObject(new Stove(j*size+size/2, (i+1)*size, 70,70));
				else if (field.getField()[i][j] == 6) addNewObject(new Garbage(j*size+size/2, (i+1)*size, 70,70));
				else if (field.getField()[i][j] == 9) addNewObject(new Shelf(j*size+size/2, (i+1)*size, 70,70,new Plate()));
			}
		}
	}
	
	public void startGame() {
		this.isGameRunning = true;
		new Thread(gameLoop, "Game Loop Thread").start();
	}

	public void stopGame() {
		this.isGameRunning = false;
	}

	Runnable gameLoop = new Runnable() {
		@Override
		public void run() {
			long lastLoopStartTime = System.nanoTime();
			while (isGameRunning) {
				long elapsedTime = System.nanoTime() - lastLoopStartTime;
				if (elapsedTime >= LOOP_TIME) {
					lastLoopStartTime += LOOP_TIME;

					logicUpdate(elapsedTime);
					//System.out.println("Game Loop Thred");
					Thread.yield();
				}

				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
	};
	
	public void logicUpdate(long elapsedTime) {
		//player2.update();
		player1.update();
		//player2.update();
		model.decreaseRemainingTime(elapsedTime);
		if (model.getTimeNanosecond() <= 0) {
			System.out.println("Game Over!");
			GameMain.stopGame();
		}
	}
	
}
