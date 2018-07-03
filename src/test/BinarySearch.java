package test;

import java.util.Arrays;

public class BinarySearch {

	private int size;
	private int[] data;
	private int next;

	public BinarySearch(int size) {
		data = new int[size];
		this.size = size;
	}

	public boolean insert(int num) {
		if (next == size) {
			System.out.println("Full size!");
			return false;
		}
		data[next] = num;
		next++;
		sort();
		return true;
	}

	private void sort() {
		for (int i = 0; i < next - 1; i++) {
			for (int j = i + 1; j < next; j++) {
				if (data[i] > data[j]) {
					int temp = data[i];
					data[i] = data[j];
					data[j] = temp;
				}
			}
		}
	}

	public boolean update(int search, int replace) {
//		int first = 0;
//		int last = next - 1;
//		int middle = (first + last) / 2;
//		while (first <= last) {
//			if (search < data[middle]) {
//				last = middle - 1;
//			} else if (search > data[middle]) {
//				first = middle + 1;
//			} else {
//				data[middle] = replace;
//				sort();
//			}
//			middle = (first + last) / 2;
//		}
		if(!delete(search)) return false;
		if(!insert(replace)) return false;
		return true;
	}

	public int search(int num) { // 4
		int first = 0;
		int last = next - 1;
		int middle = (first + last) / 2;
		while (first <= last) {
			if (num < data[middle]) {
				last = middle - 1;
			} else if (num > data[middle]) {
				first = middle + 1;
			} else {
				return num;
			}
			middle = (first + last) / 2;
		}
		return -1;
	}

	public boolean delete(int num) {
		int first = 0;
		int last = next - 1;
		int middle = (first + last) / 2;

		while (first <= last) {
			if (num < data[middle]) {
				last = middle - 1;
			} else if (num > data[middle]) {
				first = middle + 1;
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

	public String toString() {
		return Arrays.toString(data);
	}

	public static void main(String[] args) {

		BinarySearch ds = new BinarySearch(20);
		ds.insert(3);
		System.out.println(ds.toString());
		ds.insert(1);
		System.out.println(ds.toString());
		ds.insert(7);
		System.out.println(ds.toString());
		ds.insert(4);
		System.out.println(ds.toString());
		ds.insert(9);
		System.out.println(ds.toString());
		ds.insert(5);
		System.out.println(ds.toString());

		ds.update(4 , 10);
		System.out.println(ds.toString());

	}

}
