import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileWriter;


//Database class is representative of the "Book Store System": it holds all the Items
public class Database  {
	 List<Item> datab = new ArrayList<Item>();
	 
	 //Database constructor 
	 public Database() {
		 List<Item> datab = new ArrayList<Item>();
	 }

	 //adding Items to the database 
	 public void addItem(Item c) {
		datab.add(c); 
	 }
	 // printing out the database
	 public void list() {
				  System.out.println(datab.toString());
	}
	 //returning the size of the database
	 public int size() {
		 return datab.size();
	 }
	//writing the database to an output file
	 public void DatabaseToFile() throws IOException {

		 FileWriter writer = new FileWriter("output.txt"); 
		 for(int i=0; i< datab.size(); ++i) {
			 String str = datab.get(i).toString();
			 writer.write(str);
		 }
		 writer.close();
	 
	 }	

	
}
