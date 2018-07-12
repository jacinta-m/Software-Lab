import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DrawFrame extends JFrame{
	//JPanel for the shape and color controls
	private JPanel bcontrol;
	private JPanel topcontrol;
	private JPanel controls;
	private JLabel stausLabel;
	private JButton undoButton;
	private JButton redoButton;
	private JButton clearButton;
	private JButton saveButton;
	private JButton loadButton;
	private JComboBox colorBox;
	private String[] colorTypes = {"Black", "Blue","City College Lavender","Cyan","Green","Grey", "Magneta", "Orange","Pink","Purple" ,"Red","White","Yellow"};
	private Color [] colorArray = {Color.BLACK , Color.BLUE , new Color(230, 230,250), Color.CYAN , Color.GREEN, Color.GRAY , Color.MAGENTA , Color.ORANGE , 
									Color.PINK , new Color(100, 22,178),Color.RED , Color.WHITE , Color.YELLOW};
	private JComboBox shapesBox;
	private String[] shapeTypes = {"Line", "Rectangle", "Oval"};
	private JCheckBox fillBox;
	private JLabel label1;
	private DrawPanel painter;
	private JPanel buttons;
	private JPanel sbuttons;
	
	public DrawFrame() {
		createUserInterface();
	}
	
	public void createUserInterface() {
		//pane for attaching GUI components
		Container contentPane = getContentPane();
		
		contentPane.setLayout(new BorderLayout());
		
		//set up controls
		controls = new JPanel();
		controls.setLayout( new BorderLayout());
		topcontrol = new JPanel();
		topcontrol.setLayout( new BorderLayout());
		bcontrol = new JPanel();
		controls.add(topcontrol, BorderLayout.NORTH);
		controls.add(bcontrol, BorderLayout.SOUTH);
		contentPane.add(controls, BorderLayout.NORTH);
		
		//set up painter
		JLabel statusLabel = new JLabel( "" );
		painter = new DrawPanel(statusLabel);
		painter.setBounds(0, 40, 500, 400);
		painter.setBackground(Color.WHITE);
		contentPane.add(painter, BorderLayout.CENTER);
		contentPane.add(statusLabel, BorderLayout.SOUTH);
		
		//set up undo and clear buttons
		undoButton = new JButton("Undo");
		undoButton.setForeground (Color.BLUE);
		clearButton = new JButton("Clear");
		clearButton.setForeground (Color.BLUE);
		redoButton = new JButton("Redo");
		redoButton.setForeground (Color.BLUE);
		buttons = new JPanel();
		buttons.setLayout( new GridLayout( 1, 5 ));
		buttons.add(undoButton);
		buttons.add(clearButton);
		buttons.add(redoButton);
		topcontrol.add(buttons, BorderLayout.EAST);
		undoButton.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent event) {
						 painter.undoLastShape();
						}
				});	
		clearButton.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent event) {
						 painter.clearShapes();
						}
				});
		redoButton.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent event) {
						 painter.redoLastShape();
						}
				});
		
		//set up Shape Combo Box
		shapesBox = new JComboBox( shapeTypes);
		bcontrol.add(shapesBox);
		shapesBox.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent event) {
						painter.setCurrentShape(shapesBox.getSelectedIndex());
					}
				});
		
		//set up Color Combo Box
		colorBox = new JComboBox( colorTypes);
		bcontrol.add(colorBox);
		colorBox.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent event) {
						int colorchoice = colorBox.getSelectedIndex();
						painter.setCurrentColor(colorArray[colorchoice]);
					}
				});
		
		//set up Check Box to fill the shape
		fillBox = new JCheckBox("Fill in with Color");

		bcontrol.add(fillBox);
		fillBox.addItemListener(
				new ItemListener() {
					public void itemStateChanged(ItemEvent event) {
						if(fillBox.isSelected()) {
							boolean f = true;
							painter.setCurrentFill(f);
						}
						else {
							painter.setCurrentFill(false);
						}
					}
				});

		//set up save and load buttons
		saveButton = new JButton("Save");
		saveButton.setFont(new Font("Arial", Font.BOLD, 14));
		loadButton = new JButton("Load");
		loadButton.setFont(new Font("Arial", Font.BOLD, 14));
		sbuttons = new JPanel();
		sbuttons.add(saveButton);
		sbuttons.add(loadButton);
		topcontrol.add(sbuttons, BorderLayout.WEST);
		saveButton.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					painter.saveDrawing();		 
				}
			});
		loadButton.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent event) {
						painter.importDrawing();		 
					}
				});
				
				
		//set properties of applications window
		setTitle( "Drawing Application");
		setSize(508, 407);
		setVisible( true);
	}
	
	public static void main(String args[]) {
		DrawFrame app = new DrawFrame();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
