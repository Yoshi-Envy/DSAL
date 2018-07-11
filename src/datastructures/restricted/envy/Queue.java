package datastructures.restricted.envy;

import java.util.Arrays;

public class Queue {

	private int size;
	private int numOfNodes;
	private int front;
	private int near;
	private Listing[] data;

	public Queue(int size) {
		front = 0;
		near = 0;
		numOfNodes = 0;
		this.size = size;
		data = new Listing[size];
	}

	public boolean Enqueue(Listing method) {
		if (numOfNodes == size) {
			return false;
		} else {
			numOfNodes++;
			data[near] = method.deepCopy();
			near = (near + 1) % size;
			return true;
		}

	}

	public Listing Dequeue() {
		int frontLocation;
		if (numOfNodes == 0) {
			return null;
		} else {
			frontLocation = front;
			front = (front + 1) % size;
			numOfNodes--;
			return data[frontLocation];
		}
	}

//	public void showAll() {
//		int i = front;
//		for (int c = 1; c <= numOfNodes; c++) {
//			System.out.println(data[i].toString());
//			i = (i + 1) % size;
//		}
//	}
	public void showAll() {
		System.out.println("front: " + front);
		System.out.println("near: "+near);
		System.out.println("num: "+numOfNodes);
		System.out.println("Size: " + size);
		System.out.println(Arrays.toString(data));
	}
	
	public static void main(String[] args) {
		Queue queue = new Queue(5);
		queue.Enqueue(new Listing("Long", "HN", "1"));
		queue.Enqueue(new Listing("Lam", "QN", "2"));
		queue.Enqueue(new Listing("Manh", "BN", "3"));
		queue.showAll();
		System.out.println(queue.Dequeue());
		System.out.println(queue.Dequeue());
		System.out.println(queue.Dequeue());
	}
}
