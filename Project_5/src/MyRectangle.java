import java.awt.Color;
import java.awt.Graphics;

public class MyRectangle extends MyBoundedShape {
	
	//constructor empty rectangle
	public MyRectangle(int X1, int Y1, int X2, int Y2, Color colorShape) {
		super(X1, Y1, X2, Y2, colorShape);
	}
	
	//constructor color filled rectangle
	public MyRectangle(int X1, int Y1, int X2, int Y2, Color colorShape, boolean fill) {
		super(X1, Y1, X2, Y2, colorShape, fill);
	}
	
	
	//draw a rectangle 
	 @Override
	public void draw(Graphics g) {
		g.setColor(get_color());
		if(getFilled()) {
			g.fillRect(getUpperx(), getUppery(), getWidth(), getHeight());
		}
		else {
			g.drawRect(getUpperx(), getUppery(), getWidth(), getHeight());
		}
	}
}
