package model.food;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Bread extends Ingredient {
	
	public Bread() {
		state = COOKED;
	}

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void draw(GraphicsContext gc, double x, double y) {
		// TODO Auto-generated method stub
		gc.setFill(Color.BURLYWOOD); 
		gc.fillRect(x-20, y-33, 30, 20);
	}

}
