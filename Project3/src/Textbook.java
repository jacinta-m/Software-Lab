import java.util.Date;

//Textbook class using the Item Superclass and adding in the author

public class Textbook extends Item {
	private String author;
	
	public Textbook(String id, String title, Date addedon, String author) {
		super(id, title, addedon);
		this.author = author;
	}
	
	public void set_author() {
		this.author = author;
	}

	public String get_author() {
		return author;
	}

	//implementing the Compare interface so Textbook items can be compared with other items in the database
	@Override public int compare(Item a, Item b) {
		 return a.get_id().compareTo(b.get_id());
	}
	
	@Override public String toString(){
		return String.format("%s %s",
		super.toString(), get_author());
		 }
}
