import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JOptionPane;

//This class runs the main "Book Store System"

public class BookStoreTest {
	public static void main(String[] args) throws IOException {
		Database library = new Database();
		Calendar cal = Calendar.getInstance();
		int dialogButton = JOptionPane.YES_NO_OPTION;
		JOptionPane.showMessageDialog(null, "Welcome to the Database Program");
		boolean programrun = true; 
		while (programrun) {
			 //Basic GUI showing a menu of options for the user 
			 String msg = String.format( "Please enter 1 to enter in items:%nPlease enter 2 to sort items:%nPlease enter 3 to copy database to file%nPlease enter 4 to Exit Program:");
			 String MenuOption = JOptionPane.showInputDialog(null, msg, "Option Menu",JOptionPane.INFORMATION_MESSAGE );
			 int menuOp = Integer.parseInt(MenuOption);
			 boolean menuCheck = false;
			 do {
					if(menuOp <5) {
						menuCheck = true;
					};
					if(!menuCheck) {
						JOptionPane.showMessageDialog(null,"Please enter a correct number (1-4)", "Error",JOptionPane.ERROR_MESSAGE );
						MenuOption = JOptionPane.showInputDialog(null, msg, "Option Menu",JOptionPane.INFORMATION_MESSAGE );
						menuOp = Integer.parseInt(MenuOption);
					}
				}while(!menuCheck);
			 // Each case is a menu option, different functions that can be done on the "Book Store System" 
			 switch(menuOp) {
			 case 1: 	//Entering items into the Library 
				 		boolean moreitems = true;
			 			while(moreitems) {
			 					int dialogTextbButton = JOptionPane.YES_NO_OPTION;
			 					int dialogTextbResult = JOptionPane.showConfirmDialog(null, "Would you like to enter an Textbook item into the Library ", "Library Entry", dialogButton);
			 					if(dialogTextbResult == 0) {
			 						//Enter Textbook
			 						String id = JOptionPane.showInputDialog("Please enter the I.D:");
			 						String title = JOptionPane.showInputDialog("Please enter the book Title:");
			 						Date date = (Date) cal.getTime();
			 						String author = JOptionPane.showInputDialog("Please enter the author of the book:");
			 						library.addItem(new Textbook(id, title, date, author));
			 						JOptionPane.showMessageDialog(null, "Your Textbook has been added to the libray", "Library Entry", JOptionPane.INFORMATION_MESSAGE);
			 					}
			 					int dialogVidButton = JOptionPane.YES_NO_OPTION;
			 					int dialogVidResult = JOptionPane.showConfirmDialog(null, "Would you like to enter an Video item into the Library ", "Library Entry", dialogButton);
			 					Date date = (Date) cal.getTime();
			 					if(dialogVidResult == 0) {
			 						//Enter Video
			 						String id = JOptionPane.showInputDialog("Please enter the I.D:");
			 						String title = JOptionPane.showInputDialog("Please enter the video Title:");
			 						date = (Date) cal.getTime();
			 						String Runningtime  = JOptionPane.showInputDialog("Please enter the running time:");
			 						int rTime = Integer.parseInt(Runningtime);
			 						String director = JOptionPane.showInputDialog("Please enter the name of the director:");
			 						library.addItem(new Video(id, title, date, rTime, director));
			 						JOptionPane.showMessageDialog(null, "Your Video has been added to the libray", "Library Entry", JOptionPane.INFORMATION_MESSAGE);

			 					}
			 					int dialogCDButton = JOptionPane.YES_NO_OPTION;
			 					int dialogCDResult = JOptionPane.showConfirmDialog(null, "Would you like to enter an CD item into the Library ", "Library Entry", dialogButton);
								if(dialogCDResult == 0) {
			 						//Enter CD
			 						String id = JOptionPane.showInputDialog("Please enter the I.D:");
			 						String title = JOptionPane.showInputDialog("Please enter the CD Title:");
			 						date = (Date) cal.getTime();
			 						String Runningtime  = JOptionPane.showInputDialog("Please enter the running time of the CD:");
			 						int rTime = Integer.parseInt(Runningtime);
			 						String artist = JOptionPane.showInputDialog("Please enter the name of the artist:");
			 						library.addItem(new CD(id, title, date, rTime, artist));
			 						JOptionPane.showMessageDialog(null, "Your CD has been added to the libray", "Library Entry", JOptionPane.INFORMATION_MESSAGE);
			 					}
								int dialogAButton = JOptionPane.YES_NO_OPTION;
			 					int dialogAResult = JOptionPane.showConfirmDialog(null, "Would you like to enter an Audio item into the Library ", "Library Entry", dialogButton);
								if(dialogAResult == 0) {
								//Enter Audio
		 								String id = JOptionPane.showInputDialog("Please enter the I.D:");
		 								String title = JOptionPane.showInputDialog("Please enter the Audio Title:");
		 								date = (Date) cal.getTime();
		 								String Runningtime  = JOptionPane.showInputDialog("Please enter the running time of the Audio:");
		 								int rTime = Integer.parseInt(Runningtime);
		 								String director = JOptionPane.showInputDialog("Please enter the name of the director:");
		 								library.addItem(new Video(id, title, date, rTime, director));
		 								JOptionPane.showMessageDialog(null, "Your CD has been added to the libray", "Library Entry", JOptionPane.INFORMATION_MESSAGE);
								}
		 						int dialogContButton = JOptionPane.YES_NO_OPTION;
		 						int dialogContResult = JOptionPane.showConfirmDialog(null, "Would you like to enter another item into the Library ", "Library Entry", dialogButton);
		 						if(dialogContResult == 1) {
		 							moreitems = false;
		 						}			
	 						}
			 			//Printing out the database 
			 			JOptionPane.showMessageDialog(null,"Database before Sorting", "Information",JOptionPane.INFORMATION_MESSAGE );
			 			System.out.println("----- DATABASE BEFORE SORTING: -----");	  
			 			library.list();
			 			break;
			 
			 case 2:	// Sorting the Library
				 		if(library.size()==0) {
				 		JOptionPane.showMessageDialog(null,"The library database is empty and cannot sort until an item is entered", "Error",JOptionPane.ERROR_MESSAGE );
				 		}
				 		JOptionPane.showMessageDialog(null,"Database before Sorting", "Information",JOptionPane.INFORMATION_MESSAGE );
						System.out.println("----- DATABASE BEFORE SORTING: -----");	  
						library.list();
						
						//Sorting the Library by default
						ComparatorChain chain = new ComparatorChain (); 
						  
						 Collections.sort(library.datab, new Comparator<Item>(){
							 public int compare(Item a, Item b) {
					            return a.get_id().compareTo(b.get_id());
							 }
						 });
						 JOptionPane.showMessageDialog(null,"Database after Sorting by I.D", "Information",JOptionPane.INFORMATION_MESSAGE );
						 System.out.println("----- DATABASE AFTER SORTING BY ID (default): -----"); 
						 library.list();
						 
						 //Sorting the Library by selected fields
						 int dialogSortCButton = JOptionPane.YES_NO_OPTION;
						 int dialogSortCResult = JOptionPane.showConfirmDialog(null, "Would you like to sort the items by other fields?  ", "Library", dialogButton);
				       
						 if(dialogSortCResult ==0) {
							boolean check = false;
							do {
								String SortChoice  = JOptionPane.showInputDialog("Please enter 1 to sort by Title, 2 to sort by date added or 3 to sort by I.d:");
								int SortC = Integer.parseInt(SortChoice);
								if (SortC > 3) {
									JOptionPane.showMessageDialog(null,"Please enter a correct number", "Error",JOptionPane.ERROR_MESSAGE );
								}
								else if (SortC==1) {
									check = true;
									int dialogSortC1Button = JOptionPane.YES_NO_OPTION;
									int dialogSortC1Result = JOptionPane.showConfirmDialog(null, "Would you like to sort the items then by date added? No will sort then by i.d  ", "Library", dialogButton);			
									
									if(dialogSortC1Result == 0) {
										Collections.sort(library.datab, new ComparatorChain(
								                new SortByTitle(),
								                new SortByAdd(),
								                new SortById()
								                )
										);
									    System.out.println("----- DATABASE AFTER SORTING BY OTHER FIELDS: -----");
									    System.out.println("------------ (title, addedOn, i.d) -----------");
										library.list();
									}
									else {
										Collections.sort(library.datab, new ComparatorChain(
								                new SortByTitle(),
								                new SortById(),
								                new SortByAdd()
								                )
										);
										System.out.println("----- DATABASE AFTER SORTING BY OTHER FIELDS: -----");
									    System.out.println("------------ (title, i.d, addedon) -----------");
										library.list();
									}
								}
								
								else if (SortC==2) {
									check = true;
									int dialogSortC1Button = JOptionPane.YES_NO_OPTION;
									int dialogSortC1Result = JOptionPane.showConfirmDialog(null, "Would you like to sort the items then by id? No will sort then by title ", "Library", dialogButton);			
									
									if(dialogSortC1Result == 0) {
										Collections.sort(library.datab, new ComparatorChain(
												new SortByAdd(),
								                new SortById(),
								                new SortByTitle()
								                )
										);
									    System.out.println("----- DATABASE AFTER SORTING BY OTHER FIELDS: -----");
									    System.out.println("------------ (addedOn, i.d, title) -----------");
										library.list();
									}
									else {
										Collections.sort(library.datab, new ComparatorChain(
								                new SortByAdd(),
												new SortByTitle(),
								                new SortById() 
								                )
										);
										System.out.println("----- DATABASE AFTER SORTING BY OTHER FIELDS: -----");
									    System.out.println("------------ (title, i.d, addedon) -----------");
										library.list();
									}
								}
								
								else if (SortC==3) {
									check = true;
									int dialogSortC1Button = JOptionPane.YES_NO_OPTION;
									int dialogSortC1Result = JOptionPane.showConfirmDialog(null, "Would you like to sort the items then by date added? No will sort then by title", "Library", dialogButton);			
									
									if(dialogSortC1Result == 0) {
										Collections.sort(library.datab, new ComparatorChain(
												new SortById(),
												new SortByAdd(),
								                new SortByTitle()
								                )
										);
									    System.out.println("----- DATABASE AFTER SORTING BY OTHER FIELDS: -----");
									    System.out.println("------------ (i.d, added on, title) -----------");
										library.list();
									}
									else {
										Collections.sort(library.datab, new ComparatorChain(
								                new SortById(),
												new SortByTitle(),
								                new SortByAdd() 
								                )
										);
										System.out.println("----- DATABASE AFTER SORTING BY OTHER FIELDS: -----");
									    System.out.println("------------ (i.d, title, addedon) -----------");
										library.list();
									}
								}
							}while(!check);
						 }
						 break;
			 case 3:	// Printing the "Book Store System" to a text file
				 		library.DatabaseToFile();
				 		
				 		
			 case 4:	//Exiting the Program
				 	programrun = false;
				 	break;
			 }
		 }
	}
}


