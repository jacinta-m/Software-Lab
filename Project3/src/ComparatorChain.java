import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class ComparatorChain implements Comparator<Item> {
			 
	    private List<Comparator<Item>> listComparators;
	 
	    @SafeVarargs
	    public ComparatorChain(Comparator<Item>... comparators) {
	        this.listComparators = Arrays.asList(comparators);
	    }
	 
	    @Override
	    public int compare(Item a, Item b) {
	        for (Comparator<Item> comparator : listComparators) {
	            int result = comparator.compare(a, b);
	            if (result != 0) {
	                return result;
	            }
	        }
	        return 0;
	    }
	   
	    
}
