import java.util.Comparator;
import java.util.Date;

//Abstract Class for the Multimedia items in the Book Store System
//adding in running time 
public abstract class MultiMediaItem extends Item  {
	private int PlayingTime;
	
	public MultiMediaItem(String id, String title, Date addedon, int PlayingTime){
		super(id, title, addedon);
		this.PlayingTime = PlayingTime; 
	}
	
	public int getPlayingTime() {
		return PlayingTime;
	}
	
	@Override public String toString(){
		return String.format("%s %d",
		super.toString(),getPlayingTime());
		 }
}
