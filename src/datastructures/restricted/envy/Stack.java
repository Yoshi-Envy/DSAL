package datastructures.restricted.envy;

import java.util.Arrays;

public class Stack {

	private int size;
	private int top;
	Listing[] data;

	public Stack(int size) {
		top = -1;
		this.size = size;
		data = new Listing[size];
	}

	public boolean push(Listing method) {
		if (top == size - 1) {
			return false;
		} else {
			top++;
			data[top] = method.deepCopy();
			return true;
		}
	}

	public Listing pop() {

		int topLocation;
		if (top ==- 1) {
			return null;
		} else {
			topLocation = top;
			top--;
			return data[topLocation];
		}
	}

	public void showAll() {
		System.out.println("Top: " + top);
		System.out.println("Size: " + size);
		System.out.println(Arrays.toString(data));
	}

	public static void main(String[] args) {
		Stack stack = new Stack(5);
		stack.push(new Listing("Long", "HN", "3"));
		stack.push(new Listing("Lam", "QN", "1"));
		stack.push(new Listing("Hai", "HN", "4"));
		stack.push(new Listing("Manh", "BN", "8"));
		stack.push(new Listing("Tien", "HN", "6"));
		stack.showAll();
		
		System.out.println(stack.pop().toString());
		System.out.println(stack.pop().toString());
		System.out.println(stack.pop().toString());
	}
}
