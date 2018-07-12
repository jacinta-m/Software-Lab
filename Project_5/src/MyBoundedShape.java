import java.awt.Color;
import java.awt.Graphics;

public abstract class MyBoundedShape extends MyShape {

	private boolean filled;
	
	public MyBoundedShape(int X1, int Y1, int X2, int Y2, Color colorShape){
		super(X1, Y1, X2, Y2, colorShape);
		filled = false;
	}
	
	public MyBoundedShape(int X1, int Y1, int X2, int Y2, Color colorShape, boolean fill){
		super(X1, Y1, X2, Y2, colorShape);
		this.filled = fill;
	}
	
	//set fill
		public void set_filled(boolean fill ) {
			this.filled = fill;
		}
		
		//get upper_x
		public int getUpperx() {
			return Math.min(get_x1(), get_x2());
		}
		
		//get upper y
		public int getUppery() {
			return Math.min(get_y1(), get_y2());
		}
		
		// get height
		public int getHeight() {
			return Math.abs(get_y1()-get_y2());
		}
		
		
		//get width
		public int getWidth() {
			return 	Math.abs(get_x1()-get_x2());	
		}
		
		//get whether shape is filled
		public boolean getFilled() {
			return filled;		
		}
		

		// abstract draw method
		public abstract void draw(Graphics g);
		
}

