import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ScrollPaneConstants;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JPanel;



public class TextArea extends JFrame {
	
	private JTextArea TextBox;
	private JComboBox CBox;
	private static String[] fonts = {"Serif", "Sans-serif", "Monospaced"};
	private JLabel picture;
	private Icon [] pics = {new ImageIcon(getClass().getResource("/Image/a.png")),new ImageIcon(getClass().getResource("/Image/ss.png")),new ImageIcon(getClass().getResource("/Image/m.png"))};
	private JButton Up ;
	private JButton Down;
	private JCheckBox Bold;
	private final BorderLayout layout;
	private final JPanel buttons;
	private final JPanel style;
	private final JPanel cbox;
	private final JLabel label1;
	private final JLabel label2;
	private final JLabel label3;
	
	public TextArea () {
		super("Text Editor");
		layout = new BorderLayout(5, 5); // 5 pixel gaps
		setLayout(layout);
		
		//text area 
		TextBox = new JTextArea("Type Here",5,30);
		TextBox.setFont(new Font("Serif", Font.PLAIN, 18));
		Box box = Box.createHorizontalBox(); 
		JScrollPane scroll = new JScrollPane (TextBox);
		scroll.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
		box.add(scroll);
		
		//Combo Box to change font style
		CBox = new JComboBox(fonts);
		CBox.setFont(new Font("Arial", Font.PLAIN, 18));
		label1 = new JLabel(" Change Font Type");
		label1.setFont(new Font("Arial", Font.BOLD, 18));
		label1.setForeground (Color.BLUE);
		
		// Buttons to increase font size with pictures
		Icon a = new ImageIcon(getClass().getResource("/Image/up.png"));
		Up = new JButton("Font Larger", a);		
		Up.setFont(new Font("Arial", Font.PLAIN, 18));
		Icon b = new ImageIcon(getClass().getResource("/Image/d.png"));
		Down = new JButton("Font Smaller", b);
		Down.setFont(new Font("Arial", Font.PLAIN, 18));
		label2 = new JLabel(" Change Font Size");
		label2.setFont(new Font("Arial", Font.BOLD, 18));
		label2.setForeground (Color.BLUE);
		
		//Check Box to change to Bold
		Bold = new JCheckBox("bold");
		Bold.setFont(new Font("Arial", Font.PLAIN, 18));
		label3 = new JLabel(" Change Font Style");
		label3.setFont(new Font("Arial", Font.BOLD, 18));
		label3.setForeground (Color.BLUE);
		
		//JPanels to layout all the features 
		
		buttons = new JPanel();
		buttons.setLayout(new BorderLayout());
		buttons.add(Up, BorderLayout.NORTH);
		buttons.add(label2, BorderLayout.CENTER);
		buttons.add(Down,BorderLayout.SOUTH);
		
		style = new JPanel();
		style.add(label1);
		style.add(CBox);
		picture = new JLabel(pics[0]);
		style.add(picture);
		
		cbox = new JPanel();
		cbox.setLayout(new BorderLayout());
		cbox.add(label3, BorderLayout.WEST);
		cbox.add(Bold, BorderLayout.CENTER);
		
		 add(box, BorderLayout.CENTER); 
		 add(buttons, BorderLayout.EAST);
		 add(cbox, BorderLayout.SOUTH);
		 add(style, BorderLayout.NORTH);

		 //Item Listener to change the font type as each type is selected from the drop down box
		CBox.addItemListener(
				new ItemListener() {
					public void itemStateChanged(ItemEvent event) {
						if(event.getStateChange()==ItemEvent.SELECTED) {
							String fontName = (String) CBox.getSelectedItem();
							Font font = new Font(fontName, TextBox.getFont().getStyle() , TextBox.getFont().getSize());
							TextBox.setFont(font);
							picture.setIcon(pics[CBox.getSelectedIndex()]);
						}
					}
				});

		//Action Listener to increase font size when the button is pressed
		Up.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent event) {
						Font font = TextBox.getFont();
						float size = font.getSize() + 1.0f;
						TextBox.setFont( font.deriveFont(size) );
					}		
		});
		
		//Action Listener to decrease font size when the button is pressed
		Down.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent event) {
						Font font = TextBox.getFont();
						float size = font.getSize() - 1.0f; 
						
						if(size < 18.0) {
							size = 18;
						}
						TextBox.setFont( font.deriveFont(size) );			
					}
		});
		
		//Item Listener to change the font style to bold when the check box is selected 
		Bold.addItemListener(
				new ItemListener() {
					public void itemStateChanged(ItemEvent event) {
						if(Bold.isSelected()) {
							TextBox.setFont(new Font(TextBox.getFont().getName(), Font.BOLD, TextBox.getFont().getSize()));
						}
						else {
							TextBox.setFont(new Font(TextBox.getFont().getName(), Font.PLAIN, TextBox.getFont().getSize()));
						}
					}
				});
		
	}


}
