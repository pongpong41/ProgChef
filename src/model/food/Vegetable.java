package model.food;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Vegetable extends Ingredient implements Chopable{
	private int timeToChopped;
	
	public Vegetable() {
		state = CAN_CHOP;
		timeToChopped = 0; 
	}
	
	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void draw(GraphicsContext gc, double x, double y) {
		gc.setFill(Color.GREENYELLOW);
		if (state == CAN_CHOP) {
			gc.fillRect(x-20, y-30, 30, 20);
			if (timeToChopped >= 1) {
				gc.setFill(Color.LIGHTGRAY);
				gc.fillRect(x-20, y-40, 30, 5);
				gc.setFill(Color.GREEN);
				gc.fillRect(x-20, y-40, (double) (timeToChopped/7*3), 5);
			}
		} else if (state == COOKED) { 
			gc.fillRect(x-20, y-30, 30, 20);
			gc.strokeRect(x-20, y-30, 6, 20);
			gc.strokeRect(x-14, y-30, 6, 20);
			gc.strokeRect(x-8, y-30, 6, 20);
			gc.strokeRect(x-2, y-30, 6, 20);
			gc.strokeRect(x+4, y-30, 6, 20);
		}
	}

	@Override
	public void addTimeToChopped() {
		timeToChopped++;
	}

	@Override
	public void setStateWhenCompleteChop() {
		state = COOKED;
	}

	@Override
	public int getTimeToChopped() {
		// TODO Auto-generated method stub
		return timeToChopped;
	}

}
