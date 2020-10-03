package z_dodatno02SingleLinkedList;

public class LinkedList {
	private Node root;
	private int size;
	
	public LinkedList() {
		root = null;
		size = 0;
	}
	
	public void insert(int n) {
		Node tmp = new Node(n);
		tmp.setNext(root);
		root = tmp;
		size++;
	}
	
	public int get(int i) {
		if (i < 0 || i >= size) {
			System.out.println("Lose indeksiranje!");
			return 0;
		} 

		Node iter = root;
		while (i > 0) {
			i--;
			iter = iter.getNext();
		}
		return iter.getData();
	}
	
	public Node getHead() {
		return root;
	}
	
	public int getSize() {
		return size;
	}
}
