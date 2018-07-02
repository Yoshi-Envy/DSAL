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
		if(next == size) 
			return false;
		
		if (next == 0) {
			data[next] = (T) ((KeyMode) newNode).deepCopy();
			next++;
			return true;
		}

		if (next == 1) {
			if (((KeyMode) newNode).compareTo(((KeyMode) data[0]).getKey()) > 0) {
				data[next] = (T) ((KeyMode) newNode).deepCopy();
			} else {
				data[next] = (T) ((KeyMode) data[0]).deepCopy();
				data[0] = (T) ((KeyMode) newNode).deepCopy();
			}
			next++;
			return true;
		}

		int first = 0;
		int last = next - 1;

		while (first <= last) {
			int i = (first + last) / 2;
			if (((KeyMode) newNode).compareTo(((KeyMode) data[i]).getKey()) < 0) {
				for (int j = next; j > 0; j--) {
					data[j] = data[j - 1];
				}
				data[i] = newNode;
				next++;
				last = i - 1;
			} else if (((KeyMode) newNode).compareTo(((KeyMode) data[i]).getKey()) > 0) {
				//for(int j=i;)
				System.out.println(((KeyMode) newNode).getKey());
				first = i + 1;
			} else {
				return true;
			}
		}

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
		int i = (first + last) / 2;
		while (first <= last) {
			if (((KeyMode) data[i]).compareTo(targetKey) > 0) {
				last = i - 1;
			} else if (((KeyMode) data[i]).compareTo(targetKey) < 0) {
				first = i + 1;
			} else {
				return data[i];
			}
			i = (first + last) / 2;
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
