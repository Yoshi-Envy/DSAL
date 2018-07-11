package datastructures.restricted.envy;

import java.util.Arrays;

public class UnsortedArray {

	private int next;
	private int size;
	private Node[] data;

	public UnsortedArray() {
		next = 0;
		size = 5;
		data = new Node[size];
	}
	public static void main(String[] args) {
		UnsortedArray ua = new UnsortedArray();
		ua.insert(new Node("long", "1"));
		ua.insert(new Node("Manh", "2"));
		ua.insert(new Node("Tam", "3"));
		ua.print();
//		ua.delete("manh");
//		ua.print();
		ua.fetch("tam");
		ua.print();
		ua.update("long", new Node("Kim Long", "4"));
		ua.print();
	}
	public void print() {
		System.out.println("----------");
		System.out.println("size: "+size);
		System.out.println("next: "+next);
		System.out.println("Array:\n "+Arrays.toString(data));
	}
	public boolean insert(Node newNode){
		System.out.println("Inserting....");
		if(next >= size) {
			System.out.println("Vuot qua kich co mang");
			return false;
		}
		data[next] = newNode.deppCopy();
		
		if(data[next]==null) {
			System.out.println("Day bo nho");
			return false;
		}
		next++;
		return true;
	}
	public boolean delete(String targetKey) {
		int i=0;
		while(!targetKey.equalsIgnoreCase(data[i].getKeyField())) {
			i++;
		}
		if(i==next) {
			return false;
		}
		for(int j =i;j<next-1;j++) {
			data[j]=data[i+1];
		}
		next--;
		data[next]=null;
		return true;
	}
	public Node fetch(String targetKey) {
		Node node;
		Node temp;
		int i=0;
		while(!targetKey.equalsIgnoreCase(data[i].getKeyField())) {
			i++;
		}
		if(i==next) {
			return null;
		}
		node = data[i].deppCopy();
		
		if(i!=0) {
			temp = data[i-1];
			data[i-1]= data[i];
			data[i]=temp;
		}
		return node;
	}
	public boolean update(String targetKey,Node newNode) {
		if(delete(targetKey)==false) {
			return false;
		}else if(insert(newNode)==false) {
			return false;
		}else {
			return true;
		}
	}
}
