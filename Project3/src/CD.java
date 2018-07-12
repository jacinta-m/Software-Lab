import java.util.Date;
//CD class using the Item and Multimedia Superclass and adding in the artist
public class CD extends MultiMediaItem{
	private String artist;
	
	public CD(String id, String title, Date addedon, int PlayingTime, String artist) {
		super(id, title, addedon, PlayingTime);
		this.artist = artist;
	}
	
	public void set_artist(String artist) {
		this.artist = artist;
	}
	
	public String get_artist() {
		return artist;
	}
	//implementing the Compare interface so CD items can be compared with other items in the database		
	@Override public int compare(Item a, Item b) {
		 return a.get_id().compareTo(b.get_id());
	}
	
	@Override public String toString(){
		return String.format("%s %s",
		super.toString(), get_artist());
		 }
}
