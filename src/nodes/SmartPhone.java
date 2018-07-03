package nodes;

public class SmartPhone implements KeyMode {

	private String key;
	private String name;
	private float price;

	public SmartPhone() {
		super();
	}

	public SmartPhone(String key, String name, float price) {
		super();
		this.key = key;
		this.name = name;
		this.price = price;
	}

	@Override
	public void setKey(Object key) {
		this.key = (String) key;
	}

	@Override
	public String getKey() {
		return key;
	}

	@Override
	public Object deepCopy() {
		return new SmartPhone(key, name, price);
	}

	@Override
	public int compareTo(Object targetKey) {
		return key.compareToIgnoreCase((String) targetKey);
	}

	@Override
	public String toString() {
		return "SmartPhone [key=" + key + ", name=" + name + ", price=" + price + "]";
	}
	
}
