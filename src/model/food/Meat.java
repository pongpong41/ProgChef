package model.food;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Meat extends Ingredient implements Chopable, Ripenable {
	private int timeToChopped;
	private double timeToRipened;
	
	public Meat() {
		state = CAN_CHOP;
		timeToChopped = 0;
		timeToRipened = 0;
	}

	public int getZ() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void draw(GraphicsContext gc, double x, double y) {
		// TODO Auto-generated method stub
		gc.setFill(Color.BROWN);
		if (state == CAN_CHOP) {
			gc.fillRect(x-20, y-30, 30, 20);
			if (timeToChopped >= 1) {
				gc.setFill(Color.LIGHTGRAY);
				gc.fillRect(x-20, y-40, 30, 5);
				gc.setFill(Color.GREEN);
				gc.fillRect(x-20, y-40, (double) (timeToChopped/7*3), 5);
			}
		} else if (state == CAN_RIPEN) {
			gc.fillRect(x-20, y-30, 30, 20);
			gc.strokeRect(x-20, y-30, 6, 20);
			gc.strokeRect(x-14, y-30, 6, 20);
			gc.strokeRect(x-8, y-30, 6, 20);
			gc.strokeRect(x-2, y-30, 6, 20);
			gc.strokeRect(x+4, y-30, 6, 20);
			if (timeToRipened >= 1) {
				gc.setFill(Color.LIGHTGRAY);
				gc.fillRect(x-20, y-40, 30, 5);
				gc.setFill(Color.RED);
				gc.fillRect(x-20, y-40, (double) (timeToRipened/72*3), 5);
			}
		} else if (state == COOKED) { 
			gc.setFill(Color.CHOCOLATE);
			gc.fillRect(x-20, y-30, 30, 20);
			gc.strokeRect(x-20, y-30, 6, 20);
			gc.strokeRect(x-14, y-30, 6, 20);
			gc.strokeRect(x-8, y-30, 6, 20);
			gc.strokeRect(x-2, y-30, 6, 20);
			gc.strokeRect(x+4, y-30, 6, 20);
		}
	}
	
	public void setStateWhenCompleteChop() {
		this.state = CAN_RIPEN;
		//this.state = cooked;
	}
	
	public void setStateWhenCompleteRipen() {
		this.state = COOKED;
	}
	
	@Override
	public int getTimeToChopped() {
		return timeToChopped;
	}

	@Override
	public void addTimeToChopped() {
		// TODO Auto-generated method stub
		timeToChopped++;
	}

	@Override
	public void addTimeToRipened() {
		// TODO Auto-generated method stub
		timeToRipened++;
	}

	@Override
	public double getTimeToRippened() {
		return timeToRipened;
	}

}
