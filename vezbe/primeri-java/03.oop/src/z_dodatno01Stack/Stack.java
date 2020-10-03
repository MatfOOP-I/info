package z_dodatno01Stack;

public class Stack {
	private int[] elements;
	private int headPtr;
	
	public Stack() {
		elements = new int[3];
		headPtr = 0;
	}
	
	private void checkCapacity() {
		if (headPtr == elements.length-1) {
			// Debugging purposes
			// System.out.println("Reallocating array from size " + elements.length + " to " + 2*elements.length + "...");

			// Copies elements of given array into a new one, the rest of specified lenght is filled
			// with neutral values for array type (in our case, 0 for int)
			elements = java.util.Arrays.copyOf(elements, 2 * elements.length);
		}
	}
	
	public void push(int val) {
		checkCapacity();
		elements[headPtr++] = val;
	}
	
	public int top() {
		return elements[headPtr];
	}
	
	public int size() {
		return headPtr;
	}
	
	public int capacity() {
		return elements.length;
	}
	
	public void showContent() {
		System.out.println("size: " + headPtr + " capacity: " + elements.length);
		for (int i = 0; i < headPtr; i++)
			System.out.print(elements[i] + " ");
		System.out.println();
	}
	
	public int pop() {
		if (headPtr > 0) {
			headPtr--;
			return elements[headPtr+1];
		} else {
			System.out.println("Stack underflow...");
			return 0;
		}
	}
}
