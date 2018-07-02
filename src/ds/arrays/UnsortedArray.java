package ds.arrays;

import ds.BasicOperation;
import nodes.Bike;
import nodes.Vehicle;

public class UnsortedArray<T> implements BasicOperation<T> {

	private int next; // 0
	private int size; // 0
	private T[] data;

	@SuppressWarnings("unchecked")
	public UnsortedArray(int size) {
		data = (T[]) new Object[size];
		this.size = size;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean insert(T node) {
		if (next == size) {
			System.out.println("Vượt quá phạm vi của cấu trúc dữ liệu!");
			return false;
		}
		data[next] = (T) ((Vehicle) node).deepCopy();

		if (data[next] == null) {
			System.out.println("Bộ nhớ không đủ để tạo mới đối tượng!");
			return false;
		}
		next++;
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean update(String targetKey, T node) {
		int i = 0;
		while (i < next && ((Vehicle) data[i]).compareTo(targetKey) != 0) {
			i++; // khong tim thay thi i tang len 1 don vi
		}
		if (i == next) {
			System.out.println("Not found");
			return false;
		}
		data[i] = (T) ((Vehicle) node).deepCopy();
		return true;
	}

	@Override
	public boolean delete(String targetKey) {
		// Sequential search
		int i = 0;
		while (i < next && ((Vehicle) data[i]).compareTo(targetKey) != 0) {
			i++; // khong tim thay thi i tang len 1 don vi
		}

		if (i == next) {
			System.out.println("Not found");
			return false;
		}

		// di chuyen vi tri duoi i len 1 don vi
		for (int j = i; j < next; j++) {
			data[j] = data[j + 1];
		}
		next--;
		data[next] = null;
		// garbage collection
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T fetch(String targetKey) {
		int i = 0;

		while (i < next && ((Vehicle) data[i]).compareTo(targetKey) != 0) {
			i++;
		}

		if (i == next) {
			System.out.println("Not found");
			return null;
		}

		return (T) ((Vehicle) data[i]).deepCopy();
	}

	public static void main(String[] args) {
		UnsortedArray<Bike> ds = new UnsortedArray<>(10);
		ds.insert(new Bike("1", "ferrari"));
		ds.insert(new Bike("2", "huyndai"));
		ds.insert(new Bike("3", "lamboghini"));
		ds.insert(new Bike("4", "porsche"));
		ds.insert(new Bike("5", "ford"));

		ds.display();

	}

	@Override
	public void display() {
		for (int i = 0; i < data.length; i++) {
			System.out.println(data[i]);
			System.out.println("----------------");
		}
	}

}
