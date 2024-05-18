package diet;

import java.util.*;

/**
 * Represents a takeaway restaurant chain.
 * It allows managing restaurants, customers, and orders.
 */
public class Takeaway {

	private Map<String, Restaurant> restaurants = new TreeMap<String, Restaurant>();
	private Collection<Customer> customers = new TreeSet<Customer>(new Comparator<Customer>() {
		// Done by ChatGPT. Unfortunately I couldn't figure out the cause of the error by myself.
		// Of course I analyzed and understood what the code is doing.
		// Note to Self: The important part is usage of the custom comparator.
        @Override
        public int compare(Customer c1, Customer c2) {
            int lastNameComparison = c1.getLastName().compareTo(c2.getLastName());
            if (lastNameComparison != 0) {
                return lastNameComparison;
            }
            return c1.getFirstName().compareTo(c2.getFirstName());
        }
    });
	private HashMap<Integer, Order> orders = new HashMap<Integer, Order>();

	/**
	 * Constructor
	 * 
	 * @param food the reference {@link Food} object with materials and products
	 *             info.
	 */

	private Food food;

	public Takeaway(Food food) {
		this.food = food;
	}

	/**
	 * Creates a new restaurant with a given name
	 *
	 * @param restaurantName name of the restaurant
	 * @return the new restaurant
	 */
	public Restaurant addRestaurant(String restaurantName) {
		Restaurant temp = new Restaurant(restaurantName);
		restaurants.put(restaurantName, temp);
		return temp;
	}

	/**
	 * Retrieves the names of all restaurants
	 *
	 * @return collection of restaurant names
	 */
	public Collection<String> restaurants() {
		return restaurants.keySet();
	}

	/**
	 * Creates a new customer for the takeaway
	 * 
	 * @param firstName   first name of the customer
	 * @param lastName    last name of the customer
	 * @param email       email of the customer
	 * @param phoneNumber mobile phone number
	 *
	 * @return the object representing the newly created customer
	 */
	public Customer registerCustomer(String firstName, String lastName, String email, String phoneNumber) {
		Customer temp = new Customer(firstName, lastName);
		temp.setPhone(phoneNumber);
		temp.SetEmail(email);
		customers.add(temp);
		return temp;
	}

	/**
	 * Retrieves all registered customers
	 *
	 * @return sorted collection of customers
	 */
	public Collection<Customer> customers() {
		List<Customer> sortedCustomers = new ArrayList<Customer>(customers);
		Collections.sort(sortedCustomers, new Comparator<Customer>() {
			// Done by ChatGPT. Unfortunately I couldn't figure out the cause of the error by myself.
			// Of course I analyzed and understood what the code is doing.
			// Note to Self: The important part is usage of the custom comparator.
            @Override
            public int compare(Customer c1, Customer c2) {
                int surnameComparison = c1.getLastName().compareTo(c2.getLastName());
                if (surnameComparison != 0) {
                    return surnameComparison;
                } else {
                    return c1.getFirstName().compareTo(c2.getFirstName());
                }
            }
        });
		return customers;
	}

	/**
	 * Creates a new order for the chain.
	 *
	 * @param customer       customer issuing the order
	 * @param restaurantName name of the restaurant that will take the order
	 * @param time           time of desired delivery
	 * @return order object
	 */
	private String setOrderTime(Restaurant restaurant, String time) {
		String deliveryTime = "";
		if (time.compareTo(restaurant.hours[3]) > 0)
			deliveryTime += restaurant.hours[0];
		else if (time.compareTo(restaurant.hours[1]) > 0)
			deliveryTime += restaurant.hours[2];
		return deliveryTime;
	}

	private int i = 0;

	public Order createOrder(Customer customer, String restaurantName, String time) {
		
		Restaurant temp_res = restaurants.get(restaurantName);
		String deliveryTime;
		String checkTime = "";
		if (time.length() == 4)
			checkTime += "0" + time;
		else
			checkTime = time;
		if (!temp_res.isOpenAt(checkTime)) {
			deliveryTime = setOrderTime(temp_res, time);
		} else {
			deliveryTime = checkTime;
		}

		Order temp = new Order(customer, temp_res, deliveryTime, food);
		orders.put(i++, temp);
		temp_res.orders.add(temp);
		return temp;
	}

	/**
	 * Find all restaurants that are open at a given time.
	 *
	 * @param time the time with format {@code "HH:MM"}
	 * @return the sorted collection of restaurants
	 */
	public Collection<Restaurant> openRestaurants(String time) {
		Collection<Restaurant> temp = new ArrayList<Restaurant>();
		for (Restaurant res: restaurants.values()) {
			if (res.isOpenAt(time))
				temp.add(res);
		}
		return temp;
	}
}
