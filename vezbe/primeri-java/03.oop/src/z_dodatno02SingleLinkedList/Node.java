package z_dodatno02SingleLinkedList;

public class Node {
	private Node next;
	private int data;
	
	public Node(int n) {
		data = n;
		next = null;
	}
	
	public int getData() {
		return data;
	}
	
	public boolean hasNext() {
		if (next == null)
			return false;
		else
			return true;
	}
	
	public Node getNext() {
		return next;
	}
	
	public void setNext(Node n) {
		next = n;
	}
	
	public String toString() {
		return "" + data;
	}
}
