package datastructures.arrays;

import datastructures.BasicOperation;
import nodes.KeyMode;
import nodes.SmartPhone;

public class UnsortedOptimizedArray<T> implements BasicOperation<T> {

	private int size;
	private int next;
	private T data[];

	@SuppressWarnings("unchecked")
	public UnsortedOptimizedArray(int size) {
		this.size = size;
		this.data = (T[]) new Object[size];
	}

	@SuppressWarnings("unchecked")
	public boolean insert(T newNode) {
		if (next == size) // the structure is full
			return false;

		data[next] = (T) ((KeyMode) newNode).deepCopy(); // store a deep copy of the client's node

		if (data[next] == null)
			return false; // insufficient system memory

		next++; // prepares for the next Insert

		return true; // the node was inserted
	}

	@SuppressWarnings("unchecked")
	@Override
	public T fetch(String targetKey) {

		T node;
		T temp;

		// access the node
		int i = 0;
		while (i < next && ((KeyMode) data[i]).compareTo(targetKey) != 0)
			i++;

		if (i == next)
			return null; // node not found

		node = (T) ((KeyMode) data[i]).deepCopy(); // deep copy the node's information into the client's node

		if (i != 0) { // move the node reference up one position
			temp = data[i - 1];
			data[i - 1] = data[i];
			data[i] = temp;
		}

		return node; // return a copy of the node

	}

	public boolean delete(String targetKey) {
		int i = 0;

		// access the node using a sequential search
		while (i < next && ((KeyMode) data[i]).compareTo(targetKey) != 0)
			i++;

		if (i == next)
			return false; // node not found

		data[i] = data[next - 1]; // move the last node into deleted node's position

		data[next - 1] = null;

		next--;

		return true;

	}

	public boolean update(String targetKey, T newNode) {
		if (!delete(targetKey)) // node not in the structure
			return false;

		if (!insert(newNode)) // insufficient memory
			return false;

		return true; // node found and update node
	}

	@Override
	public void display() {
		System.out.println(String.format("-------------------------------------------"));
		if (data.length > 0)
			System.out.println(String.format("| %-10s | %-15s | %-8s |", "Key", "Name", "Price"));
		System.out.println(String.format("-------------------------------------------"));
		for (int i = 0; i < data.length; i++) {
			System.out.println(data[i]);
			System.out.println(String.format("-------------------------------------------"));
		}
	}

	public static void main(String[] args) {
		UnsortedOptimizedArray<SmartPhone> ds = new UnsortedOptimizedArray<>(10);

		ds.insert(new SmartPhone("iPhone 5", "iPhone 5 16GB", 100F));
		ds.insert(new SmartPhone("iPhone 6", "iPhone 6 16GB", 120F));
		ds.insert(new SmartPhone("iPhone 7", "iPhone 7 16GB", 150F));
		ds.insert(new SmartPhone("iPhone X", "iPhone X 16GB", 200F));
		ds.insert(new SmartPhone("Note 4", "Note 4 16GB", 150F));
		ds.insert(new SmartPhone("Note 5", "Note 5 32GB", 180F));

		ds.display();

		ds.delete("iPhone X");

		System.out.println("After delete");

		ds.display();

		System.out.println("After update");
		ds.display();

		System.out.println(ds.fetch("Fiora"));
		System.out.println("After fetch");
		ds.display();
	}

}
