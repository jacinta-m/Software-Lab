import java.awt.Color;
import java.awt.Graphics;

public class MyOval extends MyBoundedShape{

	//constructor empty Oval
	public MyOval(int X1, int Y1, int X2, int Y2, Color colorShape) {
		super(X1, Y1, X2, Y2, colorShape);
	}
	
	//constructor color filled Oval
	public MyOval(int X1, int Y1, int X2, int Y2, Color colorShape, boolean fill) {
		super(X1, Y1, X2, Y2, colorShape, fill);
	}
	
	//draw a oval 
	public void draw(Graphics g) {
		g.setColor(get_color());
		if(getFilled()) {
		g.fillOval(getUpperx(), getUppery(), getWidth(), getHeight());	
		}
		else {
		g.drawOval(getUpperx(), getUppery(), getWidth(), getHeight());
		}
	}
}
