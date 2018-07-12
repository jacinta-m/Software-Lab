import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

public abstract class MyShape extends Object implements Serializable {
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	private Color color;
	
	//constructor 
	
	public MyShape( int X1, int Y1, int X2, int Y2, Color colorShape) {
		set_x1(X1);
		set_y1(Y1);
		set_x2(X2);
		set_y2(Y2);
		set_color(colorShape);
	}
	
	//set x1
	public void set_x1( int x) {
		x1 = x;
	}
	
	//set y1
	public void set_y1(int y) {
		y1 = y;
	}
	
	// set x2
	public void set_x2( int x) {
		x2 = x;
	}
	
	//set y2
	public void set_y2(int y) {
		y2 = y;
	}
	
	//set color
	public void set_color(Color c) {
		color =c;
	}
	
	//get x1
	public int get_x1() {
		return x1;		
	}
	
	//get y1
	public int get_y1() {
		return y1;		
	}
	
	//get x2
	public int get_x2() {
		return x2;		
	}
	
	//get y1
	public int get_y2() {
		return y2;		
	}	
	
	public Color get_color() {
		return color;
	}
	
	// abstract draw method
	public abstract void draw(Graphics g);
	
}
