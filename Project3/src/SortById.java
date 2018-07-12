import java.util.Comparator;

//This class is used to sort Items by id attribute  
public class SortById implements Comparator<Item>{
	// compare method to sort by id	
	@Override public int compare(Item a, Item b) {
		 return a.get_id().compareTo(b.get_id());
	}
}
