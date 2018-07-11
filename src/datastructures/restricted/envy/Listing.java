package datastructures.restricted.envy;

public class Listing {

	private String name;
	private String address;
	private String number;

	public Listing(String name, String address, String number) {
		super();
		this.name = name;
		this.address = address;
		this.number = number;
	}

	public Listing deepCopy() {
		Listing clone = new Listing(name, address, number);
		return clone;
	}

	public int compareTo(String targetKey) {
		return name.compareToIgnoreCase(targetKey);
	}

	@Override
	public String toString() {
		return ("Name is: " + name +" Address is: " + address +" Number is: " + number+"\n");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	
}
