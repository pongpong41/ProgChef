package model.food;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Plate implements IRenderableFood {

	private Food foodOnPlate;
	
	public Plate() {
		foodOnPlate = new Food(false,false,false);
	}
	
	public boolean canSettleOnPlate(IRenderableFood food) {
		if (!(food instanceof Ingredient)) return false;
		Ingredient ingredient = (Ingredient) food;
		if (ingredient.getState() != Ingredient.COOKED) return false;
		if 		(ingredient instanceof Meat 		&& foodOnPlate.getIngredient(Food.MEAT) == false) 		return true;
		else if (ingredient instanceof Vegetable	&& foodOnPlate.getIngredient(Food.VEGETABLE) == false) 	return true;
		else if (ingredient instanceof Bread 		&& foodOnPlate.getIngredient(Food.BREAD) == false) 		return true;
		return false;
	}
	
	public IRenderableFood settleMeatOnPlate() {
		foodOnPlate.setIngredient(Food.MEAT,true);
		System.out.println("Meat already on plate");
		return this;
	}
	
	public IRenderableFood settleVegtableOnPlate() {
		foodOnPlate.setIngredient(Food.VEGETABLE, true);
		System.out.println("Vegetable already on plate");
		return this;
	}
	
	public IRenderableFood settleBreadOnPlate() {
		foodOnPlate.setIngredient(Food.BREAD, true);
		System.out.println("Bread already on plate");
		return this;
	}
	
	
	public boolean plateHaveFood() {
		return !foodOnPlate.IsfoodEmpty();
	}
	
	public Food getFoodOnPlate() {
		return foodOnPlate;
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
		double yOfIngredient = y-27;
		
		if (foodOnPlate.getIngredient(Food.VEGETABLE) == true) {
			gc.setFill(Color.GREENYELLOW);
			gc.fillRect(x-20, yOfIngredient, 30, 20);
			gc.strokeRect(x-20, yOfIngredient, 6, 20);
			gc.strokeRect(x-14, yOfIngredient, 6, 20);
			gc.strokeRect(x-8, yOfIngredient, 6, 20);
			gc.strokeRect(x-2, yOfIngredient, 6, 20);
			gc.strokeRect(x+4, yOfIngredient, 6, 20);
			yOfIngredient -= 3;
		}
		if (foodOnPlate.getIngredient(Food.MEAT) == true) {
			gc.setFill(Color.CHOCOLATE);
			gc.fillRect(x-20, yOfIngredient, 30, 20);
			gc.strokeRect(x-20, yOfIngredient, 6, 20);
			gc.strokeRect(x-14, yOfIngredient, 6, 20);
			gc.strokeRect(x-8, yOfIngredient, 6, 20);
			gc.strokeRect(x-2, yOfIngredient, 6, 20);
			gc.strokeRect(x+4, yOfIngredient, 6, 20);
			yOfIngredient -= 3;
		}
		if (foodOnPlate.getIngredient(Food.BREAD) == true) {
			gc.setFill(Color.BURLYWOOD); 
			gc.fillRect(x-20, yOfIngredient, 30, 20);
			yOfIngredient -= 3;
		}
	}

}
