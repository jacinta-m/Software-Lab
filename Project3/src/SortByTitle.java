import java.util.Comparator;
//This class is used to sort Items by their Title  
public class SortByTitle implements Comparator<Item>{
	
	@Override public int compare(Item a, Item b) {
		 return a.get_title().compareTo(b.get_title());
	}

}
