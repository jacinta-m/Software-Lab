import java.util.Date;

public class Audio extends MultiMediaItem{
	private String director;
	
	public Audio(String id, String title, Date addedon, int PlayingTime, String director) {
		super(id, title, addedon, PlayingTime);
		this.director = director;
	}
	
	public void set_director(String director) {
		this.director = director;
	}
	
	public String get_director() {
		return director;
	}
		
	@Override public int compare(Item a, Item b) {
		 return a.get_id().compareTo(b.get_id());
	}
	
	@Override public String toString(){
		return String.format("%s %s",
		super.toString(), get_director());
		 }
}
