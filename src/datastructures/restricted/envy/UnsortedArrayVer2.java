package datastructures.restricted.envy;

import java.util.Arrays;

public class UnsortedArrayVer2 {

	private int next;
	private int size;
	private Listing[] data;

	public UnsortedArrayVer2() {
		next = 0;
		size = 5;
		data = new Listing[size];
	}

	public boolean insert(Listing method) {
		if(next ==size) { // the structure is full
			return false;
		}
		data[next] = method.deepCopy(); // store a deepcopy of the client's node
		
		if(data[next] ==null) { // insufficient system memory
			return false;
		}
		next++;
		return true;
	}
	
	public Listing fetch(String targetKey) {
		Listing node;
		Listing temp;
		//access the node using the sequential search
		int i=0;
		while(i<next && !(data[i].compareTo(targetKey)==0)) {
			i++;
		}
		
		if(i==next) { //node not found
			return null;
		}
		
		//deepcopy the node's imformation into the client's node
		node = data[i].deepCopy();
		//move the node up ont position in the array, unless it is the first node
		if(i!=0) {// bubble up accessed node
			temp = data[i-1];
			data[i-1]=data[i];
			data[i]=temp;
		}
		return node;
	}
	
	public boolean delete(String targetKey) {
		int i=0;
		while(i<next && !(data[i].compareTo(targetKey)==0)) {
			i++;
		}
		
		if(i==next) {
			return false;
		}
		
		data[i] = data[next -1];
		data[next -1]=null;
		next--;
		return true; // node found and delete
	}
	public boolean update(String targetKey,Listing method) {
		if(delete(targetKey) ==false) {
			return false;
		}else if(insert(method)==false) {
			return false;
		}else {
			return true;
		}
	}
	
	public void print() {
		System.out.println("----------");
		System.out.println("size: "+size);
		System.out.println("next: "+next);
		System.out.println("Array:\n "+Arrays.toString(data));
	}
	
	public static void main(String[] args) {
		UnsortedArrayVer2 ua2 = new UnsortedArrayVer2();
		ua2.insert(new Listing("Long", "HN", "1"));
		ua2.insert(new Listing("Hai", "HN", "2"));
		ua2.insert(new Listing("Manh", "HN", "3"));
		ua2.print();
		
//		ua2.fetch("Manh");
//		ua2.print();
		ua2.delete("hai");
		ua2.print();
		ua2.update("manh", new Listing("Lam","QN" , "9"));
		ua2.print();
	}
}
