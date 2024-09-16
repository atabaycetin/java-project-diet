package diet;

public class Customer {

	private String name, email, surname, phone;

	Customer(String name, String surname) {
		this.name = name; this.surname = surname;
	}

	public String getLastName() {
		return surname;
	}

	public String getFirstName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void SetEmail(String email) {
		this.email = email;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		StringBuffer returnString = new StringBuffer();
		returnString.append(getFirstName()).append(" " + getLastName());
		return returnString.toString();
	}
}