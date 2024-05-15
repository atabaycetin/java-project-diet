package diet;

import java.util.TreeMap;
import java.util.Map;

/**
 * Represents and order issued by an {@link Customer} for a {@link Restaurant}.
 *
 * When an order is printed to a string is should look like:
 * <pre>
 *  RESTAURANT_NAME, USER_FIRST_NAME USER_LAST_NAME : DELIVERY(HH:MM):
 *  	MENU_NAME_1->MENU_QUANTITY_1
 *  	...
 *  	MENU_NAME_k->MENU_QUANTITY_k
 * </pre>
 */
public class Order {

	Customer customer;
	Restaurant restaurant;
	String time;
	Food food;
	OrderStatus os;
	PaymentMethod pm;
	
	Map<String, Integer> menuList = new TreeMap<String, Integer>();

	Order (Customer customer, Restaurant restaurant, String time, Food food) {
		this.customer = customer; this.restaurant = restaurant; this.time = time; this.food = food;
		this.pm = PaymentMethod.CASH;
		this.os = OrderStatus.ORDERED;
	}

	/**
	 * Possible order statuses
	 */
	public enum OrderStatus {
		ORDERED, READY, DELIVERED
	}

	/**
	 * Accepted payment methods
	 */
	public enum PaymentMethod {
		PAID, CASH, CARD
	}

	/**
	 * Set payment method
	 * @param pm the payment method
	 */
	public void setPaymentMethod(PaymentMethod pm) {
		this.pm = pm;
	}

	/**
	 * Retrieves current payment method
	 * @return the current method
	 */
	public PaymentMethod getPaymentMethod() {
		return pm;
	}

	/**
	 * Set the new status for the order
	 * @param os new status
	 */

	public void setStatus(OrderStatus os) {
		this.os = os;
	}

	/**
	 * Retrieves the current status of the order
	 *
	 * @return current status
	 */
	public OrderStatus getStatus() {
		return os;
	}

	/**
	 * Add a new menu to the order with a given quantity
	 *
	 * @param menu	menu to be added
	 * @param quantity quantity
	 * @return the order itself (allows method chaining)
	 */

	public Order addMenus(String menu, int quantity) {
		menuList.put(menu, quantity);
		return this;
	}
	/*	
	```
	"RESTAURANT_NAME, USER_FIRST_NAME USER_LAST_NAME : (DELIVERY_HH:MM):
		MENU_NAME_1->MENU_QUANTITY_1
		...
		MENU_NAME_k->MENU_QUANTITY_k
	"
	``` 
	*/
	@Override
	public String toString () {
		StringBuffer returnString = new StringBuffer();
		returnString.append(String.format("%s, %s %s : (%s):\n", 
			restaurant.getName(), customer.getFirstName(), customer.getLastName(), time));
		for (String key : menuList.keySet()) {
			returnString.append(String.format("\t%s->%d\n", key, menuList.get(key)));
		}
		return returnString.toString();
	}
	
}
