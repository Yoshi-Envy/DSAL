package datastructures.arrays;

import datastructures.BasicOperation;
import nodes.KeyMode;
import nodes.SmartPhone;

public class SortedArray<T> implements BasicOperation<T> {

	private int next;
	private int size;
	private T[] data;

	@SuppressWarnings("unchecked")
	public SortedArray(int size) {
		data = (T[]) new Object[size];
		this.size = size;
	}

	@Override
	public boolean insert(T newNode) {
		return false;
	}

	@Override
	public boolean update(String targetKey, T node) {
		return false;
	}

	@Override
	public boolean delete(String targetKey) {
		return false;
	}

	@Override
	public T fetch(String targetKey) { 
		int first = 0;
		int last = next - 1;
		int middle = (first + last) / 2;
		while (first <= last) {
			if (((KeyMode) data[middle]).compareTo(targetKey) > 0) {
				last = middle - 1;
			} else if (((KeyMode) data[middle]).compareTo(targetKey) < 0) {
				first = middle + 1;
			} else {
				return data[middle];
			}
			middle = (first + last) / 2;
		}
		return null;
	}

	public void display() {
		for (int i = 0; i < data.length; i++) {
			System.out.println(data[i]);
		}
	}

	public static void main(String[] args) {
		SortedArray<SmartPhone> ds = new SortedArray<>(10);
		System.out.println(ds.insert(new SmartPhone("H", "iPhone 5s", 5.4f)));
		System.out.println(ds.insert(new SmartPhone("B", "iMac Pro", 5.2f)));
		System.out.println(ds.insert(new SmartPhone("C", "iMac Pro", 5.2f)));
		System.out.println(ds.insert(new SmartPhone("A", "iMac Pro", 5.2f)));
		System.out.println(ds.insert(new SmartPhone("A", "iMac Pro", 5.2f)));
		System.out.println(ds.insert(new SmartPhone("A", "iMac Pro", 5.2f)));
		//System.out.println(ds.insert(new SmartPhone("C", "iMac Pro", 5.2f)));
		ds.display();

		// System.out.println(ds.fetch("H"));
	}

}
