package diet;

import java.util.Comparator;

public class myComparator implements Comparator<Order>{
	@Override
    public int compare(Order o1, Order o2) {
        if (o1.restaurant.getName().compareTo(o2.restaurant.getName()) == 0) {
            if (o1.customer.getFirstName().compareTo(o2.customer.getFirstName()) == 0)
                return o1.time.compareTo(o2.time);
            else
                return o1.customer.getFirstName().compareTo(o2.customer.getFirstName());
        } else {
            return o1.restaurant.getName().compareTo(o2.restaurant.getName());
        }
    }
}
