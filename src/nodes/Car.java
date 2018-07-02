package nodes;

public class Car implements Vehicle {

	private String code;
	private String name;

	public Car() {
	}

	public Car(String code, String name) {
		super();
		this.code = code;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return String.format("Code: %s\nName: %s", code, name);
	}

	@Override
	public Object deepCopy() {
		return new Car(code, name);
	}

	@Override
	public int compareTo(Object targetKey) {
		return code.compareToIgnoreCase((String) targetKey);
	}

	@Override
	public void setKey(Object key) {
		this.code = (String) key;
	}

	@Override
	public Object getKey() {
		return code;
	}

}
