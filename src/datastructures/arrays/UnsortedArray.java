package datastructures.arrays;

import datastructures.BasicOperation;
import nodes.KeyMode;
import nodes.SmartPhone;

public class UnsortedArray<T> implements BasicOperation<T> {

	private int next;
	private int size;
	private T[] data;

	@SuppressWarnings("unchecked")
	public UnsortedArray(int size) {
		next = 0;
		data = (T[]) new Object[size];
		this.size = size;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean insert(T newNode) {
		if (next == size) {
			System.out.println("The structure is full!");
			return false;
		}
		data[next] = (T) ((KeyMode) newNode).deepCopy();
		if (data[next] == null) {
			System.out.println("Insufficient system memory!");
			return false;
		}
		next++;
		return true;
	}

	public boolean delete(String targetKey) {
		int i = 0;
		while (i < next && ((KeyMode) data[i]).compareTo(targetKey) != 0) { //
			i++;
		}
		if (i == next) {
			return false;
		}
		for (int j = i; j < next - 1; j++) {
			data[j] = data[j + 1];
		}
		next = next - 1;
		data[next] = null;
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean update(String targetKey, T node) {
		int i = 0;
		while (i < next && ((KeyMode) data[i]).compareTo(targetKey) != 0) {
			i++;
		}
		if (i == next) {
			return false;
		}
		data[i] = (T) ((KeyMode) node).deepCopy();
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T fetch(String targetKey) {
		int i = 0;
		while (i < next && ((KeyMode) data[i]).compareTo(targetKey) != 0) {
			i++;
		}
		if (i >= next) {
			return null;
		}
		return (T) ((KeyMode) data[i]).deepCopy();
	}

	@Override
	public void display() {
		String title = String.format("| %-5s | %-10s | %-5s | %-8s |", "Key", "Name", "Age", "Weight");
		System.out.println("-----------------------------------------");
		System.out.println(title);
		System.out.println("-----------------------------------------");
		for (int i = 0; i < data.length; i++) {
			System.out.println(data[i]);
			System.out.println("-----------------------------------------");
		}
	}

	public static void main(String[] args) {
		UnsortedArray<SmartPhone> ds = new UnsortedArray<>(10);

		ds.insert(new SmartPhone("1", "Fizz",  33.0F));
		ds.insert(new SmartPhone("2", "Jax",  70.0F));
		ds.insert(new SmartPhone("3", "Alistar", 90.0F));
		ds.insert(new SmartPhone("4", "Vladimir",  65.0F));
		ds.insert(new SmartPhone("5", "Darius",  73.0F));
		ds.insert(new SmartPhone("6", "Garen",  70.0F));
		ds.insert(new SmartPhone("7", "Mundo",  80.5F));
		ds.insert(new SmartPhone("8", "Corkie", 50.0F));
		ds.insert(new SmartPhone("9", "Kalista",  45.0F));
		ds.insert(new SmartPhone("10", "Teemo",  15.2F));

		ds.display();

		// System.out.println(ds.delete("11"));

		ds.display();

	}

}
