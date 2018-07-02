package datastructures.arrays;

import datastructures.BasicOperation;
import nodes.KeyMode;
import nodes.Person;

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
		UnsortedArray<Person> ds = new UnsortedArray<>(10);

		ds.insert(new Person("1", "Fizz", 23, 33.0F));
		ds.insert(new Person("2", "Jax", 28, 70.0F));
		ds.insert(new Person("3", "Alistar", 15, 90.0F));
		ds.insert(new Person("4", "Vladimir", 49, 65.0F));
		ds.insert(new Person("5", "Darius", 35, 73.0F));
		ds.insert(new Person("6", "Garen", 33, 70.0F));
		ds.insert(new Person("7", "Mundo", 36, 80.5F));
		ds.insert(new Person("8", "Corkie", 50, 50.0F));
		ds.insert(new Person("9", "Kalista", 18, 45.0F));
		ds.insert(new Person("10", "Teemo", 21, 15.2F));

		ds.display();

		System.out.println(ds.delete("11"));

		ds.display();

	}

}
