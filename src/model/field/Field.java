package model.field;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import model.IRenderable;

public class Field implements IRenderable {

	private int[][] field;
	private int row;
	private int col;

	// ------------------------------------------------
	public Field() {
		/*field = new int[][] {{1,1,1,20,21,22,1,1,1,1,1,1,1},
							{1,0,0,0,0,0,0,0,0,0,0,0,1},
							{1,0,0,0,0,0,0,0,0,0,0,0,1},
							//{1,0,0,0,0,0,0,0,0,0,0,0,1},
							{1,1,1,1,0,0,1,1,1,1,0,0,1},
							{1,0,0,0,0,0,0,0,0,0,0,0,6},
							{1,0,0,0,0,0,0,0,0,0,0,0,1},
							{4,0,0,0,0,0,0,0,0,0,0,0,1},
							{1,1,1,3,1,3,1,5,1,9,9,1,1}};*/
		
		field = new int[][] {{11,12,12,20,21,22,12,12,12,12,12,12,11},
							{11,0,0,0,0,0,0,0,0,0,0,0,11},
							{11,0,0,0,0,0,0,0,0,0,0,0,11},
							//{1,0,0,0,0,0,0,0,0,0,0,0,1},
							{11,12,12,12,0,0,12,12,12,12,0,0,11},
							{11,0,0,0,0,0,0,0,0,0,0,0,6},
							{11,0,0,0,0,0,0,0,0,0,0,0,11},
							{4,0,0,0,0,0,0,0,0,0,0,0,11},
							{11,11,11,3,11,3,11,5,11,9,9,11,11}};
							
		row = field.length;
		col = field[0].length;
	}
	//------------------modify in next time--------------------

	public int getZ() {
		return -9999999;
	}
	
	public int getRow() {
		return row;
	}
	
	public int getCol() {
		return col;
	}
	
	public int[][] getField() {
		return field;
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		//gc.setFill(Color.CYAN);
		//gc.fillRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
		/*gc.setFill(Color.LIGHTGRAY);
		int size = 70;
		for (int i = 0; i < col; i++) {
			for (int j = 0; j < row; j++) {
				gc.strokeRect(i*size, j*size, size, size);
			}
		}*/
		
		//String image_path = "file:res/1349 [Converted]1.jpg";
		String image_path = "file:res/bg.jpg";
		System.out.println(image_path);
		Image javafx_logo = new Image(image_path);
		gc.drawImage(javafx_logo, 10, 10); //x:10 y:10
		
	}

}
