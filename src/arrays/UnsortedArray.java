package arrays;

import java.util.Arrays;

public class UnsortedArray {
	private int next;
	private int size;
	private Node[] data;

	public UnsortedArray() {
		next = 0;
		size = 10;
		data = new Node[size];
	}

	public boolean insert(Node newNode) throws Exception {
		System.out.println("Inserting...");
		if (next >= size)
			throw new Exception("Vượt quá kích thước của mảng!");
		data[next] = newNode.deepCopy();

		if (data[next] == null)
			throw new Exception("Bộ nhớ hệ thống không đủ!");

		next = next + 1;
		return true;
	}

	/*public boolean delete(String targetKey) {
		for (int i = 0; i < data.length; i++) {
			if (targetKey == data[i].getName()) {
				data[i] = null;
				return true;
			}
		}
		return false;
	}*/

	public boolean delete(String targetKey) {
		int i = 0;
		while (targetKey != data[i].getName()) { 
			i++;
		}
		if (i == next)
			return false;
		for (int j = i; j < next - 1; j++) {
			data[j] = data[j + 1]; // move
		}
		next = next - 1;
		data[next] = null;
		return true;
	}

	// public Node fetch(String keyField) {
	// long lastTime = System.nanoTime();
	// Node node = null;
	// int count = 0;
	// for (int i = 0; i < data.length; i++) {
	// if (keyField.equals(data[i].getName())) {
	// node = data[i];
	// count++;
	// break;
	// }
	// }
	// long currentTime = System.nanoTime();
	// long totalTime = currentTime - lastTime;
	// if (count > 0) {
	// System.out.println("total time: " + totalTime);
	// return node;
	// }
	// return null;
	// }

	public Node fetch(String targetKey) {
		long lastTime = System.nanoTime();
		Node node;
		Node temp;

		int i = 0;
		while (i < next && (data[i].compareTo(targetKey) != 0)) {
			i++;
		}
		if (i == next)
			return null;

		node = data[i].deepCopy();

		if (i != 0) {
			temp = data[i - 1];
			data[i - 1] = data[i];
			data[i] = temp;
		}

		long currentTime = System.nanoTime();
		long totalTime = currentTime - lastTime;
		System.out.println("total time: " + totalTime);
		return node;

	}

	public void print() {
		System.out.println("---------------------");
		System.out.println("Size: " + size);
		System.out.println("Next: " + next);
		System.out.println("Array: " + Arrays.toString(data));
		System.out.println("----------------------");
	}

}
