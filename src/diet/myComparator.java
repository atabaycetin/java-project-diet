package diet;

import java.util.Comparator;

public class myComparator implements Comparator<Order>{
	@Override
    public int compare(Order o1, Order o2) {
        return o1.customer.getFirstName().compareTo(o2.customer.getFirstName());
    }
}
