package model;

import java.util.List;

public class GameModel {
	private RenderableHolder renderableHolder;
	
	private static final long START_NANO_TIME = 120000000000L;
	
	int score;
	long remainingNanoTime;
	
	public GameModel() {
		renderableHolder = new RenderableHolder();
		score = 0;
		remainingNanoTime = START_NANO_TIME;
	}
	
	public RenderableHolder getRenderableHolder() {
		return renderableHolder;
	}
	
	public List<IRenderable> getEntities() {
		return renderableHolder.entities;
	}
	
	public void decreaseRemainingTime(long decreasedNanoTime) {
		remainingNanoTime -= decreasedNanoTime;
	}
	
	public int getScore() {
		return score;
	}
	
	public long getTimeNanosecond() {
		return remainingNanoTime;
	}
	
	public int getTimeSecond() {
		return (int) (remainingNanoTime / 1000000000);
	}
}
