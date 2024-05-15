package diet;

import diet.Order.OrderStatus;
import java.util.Collection;
import java.util.TreeSet;
import java.util.ArrayList;

/**
 * Represents a restaurant class with given opening times and a set of menus.
 */
public class Restaurant {
	
	/**
	 * retrieves the name of the restaurant.
	 *
	 * @return name of the restaurant
	 */

	private String name;
	TreeSet<Order> orders = new TreeSet<Order>(new myComparator());

	Restaurant (String name) { 
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	/**
	 * Define opening times.
	 * Accepts an array of strings (even number of elements) in the format {@code "HH:MM"},
	 * so that the closing hours follow the opening hours
	 * (e.g., for a restaurant opened from 8:15 until 14:00 and from 19:00 until 00:00,
	 * arguments would be {@code "08:15", "14:00", "19:00", "00:00"}).
	 *
	 * @param hm sequence of opening and closing times
	 */
	public String[] hours;
	public void setHours(String ... hm) {
		hours = new String[hm.length];
		hours = hm;
	}

	/**
	 * Checks whether the restaurant is open at the given time.
	 *
	 * @param time time to check
	 * @return {@code true} is the restaurant is open at that time
	 */
	public boolean isOpenAt(String time){
		if (time.compareTo(hours[0]) > 0) {
			if (time.compareTo(hours[1]) < 0)
				return true;
			else
				if (time.compareTo(hours[2]) > 0) {
					if (time.compareTo(hours[3]) < 0) {
						return true;
					}
				}
		}
		return false;
	}

	/**
	 * Adds a menu to the list of menus offered by the restaurant
	 *
	 * @param menu	the menu
	 */

	private Collection<Menu> menus = new ArrayList<Menu>();

	public void addMenu(Menu menu) {
		menus.add(menu);
	}

	/**
	 * Gets the restaurant menu with the given name
	 *
	 * @param name	name of the required menu
	 * @return menu with the given name
	 */
	public Menu getMenu(String name) {
		for (Menu m : menus)
			if (m.getName().equals(name))
				return m;
		return null;
	}

	/**
	 * Retrieve all order with a given status with all the relative details in text format.
	 *
	 * @param status the status to be matched
	 * @return textual representation of orders
	 */
	public String ordersWithStatus(OrderStatus status) {
		StringBuffer returnS = new StringBuffer();
		for (Order o: orders) {
			if (o.os == status) {
				returnS.append(String.format("%s, %s %s : (%s):\n", 
					o.restaurant.getName(), o.customer.getFirstName(), o.customer.getLastName(), o.time));
				for (String key : o.menuList.keySet()) {
					returnS.append(String.format("\t%s->%d\n", key, o.menuList.get(key)));
				}
			}
		}
		/*YOU NEED TO ORDER THE OUTPUT BY THE NAME OF THE CUSTOMERS */


		return returnS.toString();
	}
}
