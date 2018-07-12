import java.awt.Color;
import java.awt.Graphics;

public class MyLine extends MyShape {

	//constructor
	public MyLine(int X1, int Y1, int X2, int Y2, Color colorShape) {
		super(X1, Y1, X2, Y2, colorShape);
	}
	
	public void draw(Graphics g) {
		g.setColor(get_color());
		g.drawLine(get_x1(), get_y1(), get_x2(), get_y2());
	}
}
