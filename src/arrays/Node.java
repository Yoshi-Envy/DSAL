package arrays;

public class Node {
	
	private String name; // key field
	private String address; // Long edited
	
	public Node() {
	}
	
	public Node(String name, String address) {
		this.name = name;
		this.address = address;
	}

	public Node deepCopy() {
		Node clone = new Node(name, address);
		return clone;
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
	
	public int compareTo(String targetKey) {
		return name.compareTo(targetKey);
	}

	@Override
	public String toString() {
		return String.format(" |Key=%s, Addr=%s| ", name, address);
	}
	
	
}
