package model.counter;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import model.food.Bread;
import model.food.IRenderableFood;
import model.food.Ingredient;
import model.food.Meat;
import model.food.Plate;
import model.food.Vegetable;
import model.player.Player;

public class Shelf extends Counter {
	private int image;
	String image_path1 = "file:res/shelf3.jpg";
	Image image1 = new Image(image_path1);
	Image image2 = new Image("file:res/shelf2.jpg");
	
	public Shelf(double x, double y, int w, int h, IRenderableFood food, int i) {
		super(x, y, w, h);
		foodOnCounter = food;
		image = i;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean canSettle(IRenderableFood foodOnPlayer) {
		if (foodOnCounter == null) return true;
		else if (foodOnCounter instanceof Plate) {
			Plate plate = (Plate) foodOnCounter;
			if (plate.canSettleOnPlate(foodOnPlayer)) return true;
		} else if (foodOnPlayer instanceof Plate) {
			Plate plate = (Plate) foodOnPlayer;
			if (plate.canSettleOnPlate(foodOnCounter)) return true;
		}
		return false;
	}
	
	@Override
	public IRenderableFood setFoodOnCounter(IRenderableFood foodOnPlayer) {
		/*if (foodOnCounter == null) {
			foodOnCounter = foodOnPlayer;
		} else if (foodOnCounter instanceof Plate) {
			Plate plate = (Plate) foodOnCounter;
			if (foodOnPlayer instanceof Meat) 				plate.settleMeatOnPlate();
			else if (foodOnPlayer instanceof Vegetable) 	plate.settleVegtableOnPlate();
		} else if (foodOnPlayer instanceof Plate) {
			Plate plate = (Plate) foodOnPlayer;
			if (foodOnCounter instanceof Meat) 				foodOnCounter = plate.settleMeatOnPlate();
			else if (foodOnCounter instanceof Vegetable) 	foodOnCounter = plate.settleVegtableOnPlate();
		}*/
		
		if (foodOnCounter == null) {
			foodOnCounter = foodOnPlayer;
		} else {
			if (foodOnPlayer instanceof Plate) {
				IRenderableFood temp = foodOnCounter;
				foodOnCounter = foodOnPlayer;
				foodOnPlayer = temp;
			}
			if (foodOnCounter instanceof Plate) {
				Plate plate = (Plate) foodOnCounter;
				if (foodOnPlayer instanceof Meat) 				plate.settleMeatOnPlate();
				else if (foodOnPlayer instanceof Vegetable) 	plate.settleVegtableOnPlate();
				else if (foodOnPlayer instanceof Bread) 		plate.settleBreadOnPlate();
			}
		}
		return null;
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		/*gc.setFill(Color.LIGHTGRAY);
		gc.fillRect(x-width/2, y-height, width, height);*/
		
		if (image == 1) 
		/*String image_path = "file:res/shelf1.jpg";
		System.out.println(image_path);
		Image javafx_logo = new Image(image_path);*/
		gc.drawImage(image2, x-width/2, y-height, 70, 70);
		else if (image == 2) gc.drawImage(image1, x-width/2, y-height, 70, 80);
		
		if (foodOnCounter != null) {
			foodOnCounter.draw(gc, x, y);
		}
	}
}
