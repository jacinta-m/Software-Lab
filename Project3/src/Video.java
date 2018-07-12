import java.util.Date;
//CD class using the Item and Multimedia Superclass and adding in the artist
public class Video extends MultiMediaItem{
	private String director;
	
	public Video(String id, String title, Date addedon, int PlayingTime, String director) {
		super(id, title, addedon, PlayingTime);
		this.director = director;
	}
	
	public void set_director(String director) {
		this.director = director;
	}
	
	public String get_director() {
		return director;
	}
	//implementing the Compare interface so video items can be compared with other items in the database		
	@Override public int compare(Item a, Item b) {
		 return a.get_id().compareTo(b.get_id());
	}
	
	@Override public String toString(){
		return String.format("%s %s",
		super.toString(), get_director());
		 }

}
