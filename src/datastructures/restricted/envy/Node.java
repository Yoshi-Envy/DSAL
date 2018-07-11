package datastructures.restricted.envy;

public class Node {
	private String keyField;
	private String address;
	public Node() {
		// TODO Auto-generated constructor stub
	}
	public Node(String keyField, String address) {
		super();
		this.keyField = keyField;
		this.address = address;
	}
	
	public Node deppCopy() {
		Node clone = new Node(keyField, address);
		return clone;
	}
	public String getKeyField() {
		return keyField;
	}
	public void setKeyField(String keyField) {
		this.keyField = keyField;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	@Override
	public String toString() {
		return ("Key field is: "+ keyField +"\nAddress is: "+ address);
	}
	
	public int compareTo(String targetKey) {
		return keyField.compareTo(targetKey);
	}
}
