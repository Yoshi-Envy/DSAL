package nodes;

public class Bike implements Vehicle {

	private String code;
	private String name;

	public Bike() {
		super();
	}

	public Bike(String code, String name) {
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
	public void setKey(Object key) {
		this.code = (String) key;
	}

	@Override
	public Object getKey() {
		return code;
	}

	@Override
	public Object deepCopy() {
		return new Bike(code, name);
	}

	@Override
	public int compareTo(Object targetKey) {
		return code.compareToIgnoreCase((String) targetKey);
	}

	@Override
	public String toString() {
		return "code " + code + " \nname " + name;
	}

}
