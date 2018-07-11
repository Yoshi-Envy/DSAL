package datastructures.restricted.envy;

import java.util.Arrays;

public class BinarySearch {
	private int next;
	private int size;
	private int[] data;

	public BinarySearch(int size) {
		data = new int[size];
		this.size = size;
	}

	public void sort() {
		for (int i = 0; i < next - 1; i++) {
			for (int j = i; j < next; j++) {
				if (data[i] > data[j]) {
					int temp = data[i];
					data[i] = data[j];
					data[j] = temp;
				}
			}
		}
	}

	public boolean insert(int number) {
		if (next == size) {
			System.out.println("full size");
			return false;
		}
		data[next] = number;
		next++;
		sort();
		return true;
	}

	public boolean delete(int number) {
		int first = 0;
		int last = next - 1;
		int middle = (first + last) / 2;

		while (first < last) {
			if (number < data[middle]) {
				last = middle;
			} else if (number > data[middle]) {
				first = middle;
			} else {
				for (int i = middle; i < next - 1; i++) {
					data[i] = data[i + 1];

				}
				data[next - 1] = 0;
				next--;
				return true;
			}
			middle = (first + last) / 2;
		}
		return false;
	}

	public int search(int number) {
		int first = 0;
		int last = next - 1;
		int middle = (first + last) / 2;
		while (first < last) {
			if (number < data[middle]) {
				last = middle;
			} else if (number > data[middle]) {
				first = middle;
			} else {
				return number;
			}
		}
		return -1;
	}
	public boolean update(int number,int replace) {
		if(!delete(number)) {
			return false;
		}
		if(!insert(replace)) {
			return false;
		}
		return true;
	}
	public String toString() {
		return Arrays.toString(data);
	}
	
	public static void main(String[] args) {
		BinarySearch bs = new BinarySearch(5);
		bs.insert(1);
		bs.insert(4);
		bs.insert(2);
		bs.insert(9);
		bs.insert(7);
		System.out.println(bs.toString());
		
		bs.delete(4);
		System.out.println(bs.toString());
		bs.update(1, 3);
		System.out.println(bs.toString());
		
		//System.out.println(bs.search(5));
	}
}
