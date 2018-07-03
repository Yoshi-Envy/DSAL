package datastructures.restricted;

import nodes.KeyMode;
import nodes.Person;

public class Stack<T> {

	private int top;
	private int size;
	private T[] data;

	@SuppressWarnings("unchecked")
	public Stack() {
		top = -1;
		size = 100;
		data = (T[]) new Object[size];
	}

	@SuppressWarnings("unchecked")
	public Stack(int size) {
		top = -1;
		this.size = size;
		data = (T[]) new Object[size];
	}

	@SuppressWarnings("unchecked")
	public boolean push(T t) {
		if (top == size)
			return false; // overflow error
		top++;
		data[top] = (T) ((KeyMode) t).deepCopy();
		return true;
	}

	@SuppressWarnings("unchecked")
	public T pop() {
		int topLocation;
		if (top == -1)
			return null; // underflow error
		topLocation = top;
		top--;
		return (T) ((KeyMode) data[topLocation]).deepCopy();
	}

	public void showAll() {
		for (int i = data.length - 1; i >= 0; i--) {
			System.out.println(data[i].toString());
		}
	}

	public static void main(String[] args) {
		Stack<Person> stack = new Stack<>(5);

		System.out.println(stack.pop());

		System.out.println("PUSHING...");
		System.out.println(stack.push(new Person("1", "Fizz", 24, 4.5f)));
		System.out.println(stack.push(new Person("4", "Darius", 33, 80.5f)));
		System.out.println(stack.push(new Person("2", "Vayne", 20, 44.5f)));
		System.out.println(stack.push(new Person("3", "Jinx", 25, 43.5f)));

		System.out.println("POPPING...");
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}

}
