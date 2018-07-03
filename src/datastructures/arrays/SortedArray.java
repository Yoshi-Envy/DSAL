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

	@SuppressWarnings("unchecked")
	@Override
	public boolean insert(T newNode) {
		if (next == size)
			return false;
		data[next] = (T) ((KeyMode) newNode).deepCopy();
		next++;
		sortData();
		return true;
	}

	private void sortData() {
		for (int i = 0; i < next - 1; i++) {
			for (int j = i + 1; j < next; j++) {
				if (((KeyMode) data[i]).compareTo(((KeyMode) data[j]).getKey()) > 0) {
					T temp = data[i];
					data[i] = data[j];
					data[j] = temp;
				}
			}
		}
	}

	@Override
	public boolean update(String targetKey, T node) {
		if (!delete(targetKey))
			return false;
		if (!insert(node))
			return false;
		return true;
	}

	@Override
	public boolean delete(String targetKey) {
		int first = 0;
		int last = next - 1;
		int middle = (first + last) / 2;
		while (first <= last) {
			if (((KeyMode) data[middle]).compareTo(targetKey) > 0) {
				last = middle - 1;
			} else if (((KeyMode) data[middle]).compareTo(targetKey) < 0) {
				first = middle + 1;
			} else {
				for (int i = middle; i < next; i++) {
					data[i] = data[i + 1];
				}
				next--;
				data[next] = null;
				return true;
			}
			middle = (first + last) / 2;
		}
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
		System.out.println(ds.insert(new SmartPhone("Z", "iMac Pro", 5.2f)));
		System.out.println(ds.insert(new SmartPhone("Y", "iMac Pro", 5.2f)));
		System.out.println(ds.insert(new SmartPhone("J", "iMac Pro", 5.2f)));
		System.out.println(ds.insert(new SmartPhone("N", "iMac Pro", 5.2f)));

		ds.display();

		System.out.println(ds.delete("Z"));

		ds.display();

		System.out.println(ds.delete("C"));

		ds.display();

		System.out.println(ds.update("Y", new SmartPhone("Z", "iMacPro1", 1.5f)));

		ds.display();
		
		System.out.println(ds.insert(new SmartPhone("H", "iPhone 5s", 5.4f)));
		System.out.println(ds.insert(new SmartPhone("B", "iMac Pro", 5.2f)));
		System.out.println(ds.insert(new SmartPhone("C", "iMac Pro", 5.2f)));
		System.out.println(ds.insert(new SmartPhone("Z", "iMac Pro", 5.2f)));
		System.out.println(ds.insert(new SmartPhone("Y", "iMac Pro", 5.2f)));
		System.out.println(ds.insert(new SmartPhone("J", "iMac Pro", 5.2f)));
		System.out.println(ds.insert(new SmartPhone("N", "iMac Pro", 5.2f)));

	}

}
