package nodes;

public class Person implements KeyMode {

	private String key;
	private String name;
	private int age;
	private float weight;

	public Person() {
		super();
	}

	public Person(String key, String name, int age, float weight) {
		super();
		this.key = key;
		this.name = name;
		this.age = age;
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	@Override
	public Object deepCopy() {
		return new Person(key, name, age, weight);
	}

	@Override
	public int compareTo(Object targetKey) {
		return key.compareToIgnoreCase((String) targetKey);
	}

	@Override
	public String toString() {
		return String.format("| %-5s | %-10s | %-5d | %-8.2f |", key, name, age, weight);
	}

	@Override
	public String getKey() {
		return key;
	}

	@Override
	public void setKey(Object key) {
		this.key = (String) key;
	}

}
