import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class DrawPanel extends JPanel {
	
	private int shapeCount;
	private ArrayList shapesList = new ArrayList(); 
	private MyShape currentShape;
	private int shapeType;
	private Color currentColor;
	boolean filledShape;
	private JLabel statusLabel;
	
	//constructor
	public DrawPanel(JLabel statusLabel) {
		
		shapeCount = 0;
		shapeType = 0;
		currentColor= Color.BLACK;
		filledShape= false;
		this.statusLabel = statusLabel;
		addMouseListener(
				new MouseAdapter() {
					public void mousePressed(MouseEvent event) {
						if (shapeType ==0 ) {
							currentShape = new MyLine(event.getX(), event.getY(), event.getX(), event.getY(), currentColor);
						}
						else if (shapeType == 1 && filledShape==false ) {
							currentShape = new MyRectangle(event.getX(), event.getY(), event.getX(), event.getY(), currentColor);
						}
						else if (shapeType == 1 && filledShape==true) {
							currentShape = new MyRectangle(event.getX(), event.getY(), event.getX(), event.getY(), currentColor, filledShape);
						}
						else if (shapeType ==2 && filledShape == false) {
							currentShape = new MyOval(event.getX(), event.getY(), event.getX(), event.getY(), currentColor);
						}
						else if (shapeType ==2 && filledShape == true) {
							currentShape = new MyOval(event.getX(), event.getY(), event.getX(), event.getY(), currentColor, filledShape);
						}
						shapeCount++;
						shapesList.add(shapeCount-1,currentShape);
						
					}
				});
		
		addMouseMotionListener(
				new MouseMotionAdapter() {
					public void mouseDragged(MouseEvent event) {
						currentShape.set_x2(event.getX());
						currentShape.set_y2(event.getY());
						statusLabel.setText(String.format("Mouse Coordinates X: %d Y: %d",event.getX(),event.getY()));
						repaint();
					}
				});
		
		addMouseMotionListener(
				new MouseMotionAdapter() {
					public void mouseMoved(MouseEvent event) {
						statusLabel.setText(String.format("Mouse Coordinates X: %d Y: %d",event.getX(),event.getY()));
					}
				});
	}
	
	//change current shape type 
	public void setCurrentShape( int shapeNo) {
		shapeType = shapeNo;
	}
	
	//change current color
	public void setCurrentColor(Color colorShape) {
		currentColor = colorShape;
	}
	
	//change whether filled
	public void setCurrentFill(boolean f) {
		filledShape = f;
	}
	
	//remove the last shape from Array of shapes
	public void undoLastShape() {
		if( shapeCount <=0) {
			shapeCount =0;
		}
		else{
			--shapeCount;
		}
		repaint();
	}
	
	//re-add the last shape from Array of shapes
	public void redoLastShape() {
		if(shapeCount==shapesList.size()) {
			shapeCount=shapesList.size();
		}
		else{
			++shapeCount;
		}
		repaint();
	}
	
	//clear all shapes from Array of shapes
	public void clearShapes() {
		shapeCount=0;
		repaint();
	}
	
	//paint the shapes
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		MyShape nextShape;
		for(int i=0; i< shapeCount; ++i) {
		nextShape = (MyShape) shapesList.get(i);
		nextShape.draw(g);
		}
	}
	
	//write/serialize drawing to file
	public void saveDrawing() {
		
	    try {
	    	Path path = getFilePath();		
	        ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(path));
	        ArrayList tempList = new ArrayList();
	        for(int i=0; i< shapeCount; ++i) {
	        	tempList.add(shapesList.get(i)) ;
	        }
	        out.writeObject(tempList);
	        out.close(); // Also flushes output
	      } 
	      catch(Exception e) {
	        e.printStackTrace();
	      }
	}
	
	//deserialize drawing to file
	public void importDrawing() {
		   try {
			   Path ipath = getFilePath();
			   ObjectInputStream in = new ObjectInputStream(Files.newInputStream(ipath));
			   shapesList =  (ArrayList) in.readObject();
			   shapeCount = shapesList.size();
			   repaint();
			    }
			    catch(Exception e) {
			      e.printStackTrace();
			    }
	}
	
	public Path getFilePath() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(
		JFileChooser.FILES_AND_DIRECTORIES);
		int result = fileChooser.showOpenDialog(this);
		if (result == JFileChooser.CANCEL_OPTION)
			System.exit(1);
		return fileChooser.getSelectedFile().toPath();
	}
	
}
