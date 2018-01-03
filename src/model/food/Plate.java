package model.food;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Plate implements IRenderableFood {
	public static final int meat = 0;

	private Boolean[] IngredientOnPlate;
	
	public Plate() {
		IngredientOnPlate = new Boolean[1];
		IngredientOnPlate[meat] = false;
	}
	
	public boolean canSettleOnPlate(IRenderableFood food) {
		if (!(food instanceof Ingredient)) return false;
		Ingredient ingredient = (Ingredient) food;
		if (ingredient.getState() != Ingredient.cooked) return false;
		if (ingredient instanceof Meat && IngredientOnPlate[meat] == false) return true;
		return false;
	}
	
	public IRenderableFood settleMeatOnPlate() {
		IngredientOnPlate[meat] = true;
		return this;
	}
	
	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void draw(GraphicsContext gc, double x, double y) {
		// TODO Auto-generated method stub
		gc.setFill(Color.WHITE);
		gc.fillRect(x-24, y-34, 38, 28);
		
		if (IngredientOnPlate[meat] == true) {
			gc.setFill(Color.CHOCOLATE);
			gc.fillRect(x-20, y-30, 30, 20);
			gc.strokeRect(x-20, y-30, 6, 20);
			gc.strokeRect(x-14, y-30, 6, 20);
			gc.strokeRect(x-8, y-30, 6, 20);
			gc.strokeRect(x-2, y-30, 6, 20);
			gc.strokeRect(x+4, y-30, 6, 20);
		}
	}

}
