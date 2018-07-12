import java.util.Comparator;

//This class is used to sort Items by Date they are added on 

public class SortByAdd implements Comparator<Item>{
	// compare method to sort by date addedon
	@Override public int compare(Item a, Item b) {
		 return a.get_addedon().compareTo(b.get_addedon());
	}
}
