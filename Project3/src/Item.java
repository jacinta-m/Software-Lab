import java.util.Date;
import java.util.Comparator;
//Abstract class for all Items in the Book Store System 

public abstract class Item implements Comparable, Comparator<Item> {
	private String id;
	private String title; 
	private Date addedon; 
	
	public Item(String id, String title, Date addedon) {
		this.id = id;
		this.title = title;
		this.addedon = addedon;
	}
	
	public String get_id() {
		return id;
	}
	
	public String get_title() {
		return title;
	}
	
	public Date get_addedon() {
		return addedon;
	}

	@Override public String toString(){
	return String.format("%s %s %s",
	get_id(), get_title(), get_addedon().toString());
	 }	
}
