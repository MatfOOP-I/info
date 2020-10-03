package z_dodatno02SingleLinkedList;

public class Main {
	
	static void example1(LinkedList list) {
		Node iter = list.getHead();
		while (iter != null) {
			System.out.print(iter + " ");
			iter = iter.getNext();
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		
		list.insert(10);
		list.insert(20);
		list.insert(30);
		list.insert(40);
		list.insert(50);
		
		example1(list);
		example2(list);
		
		System.out.println("list[0] = " + list.get(0));
		System.out.println("list[4] = " + list.get(4));
		
		// list.get(-4);
		// list.get(8);
	}

	// Prikazuje koriscenje Iteratora (radicemo uskoro na vezbama)
	static void example2(LinkedList list) {
		ListIterator iterator = new ListIterator(list);
		while (iterator.hasNext()) {
			int data = iterator.next();
			System.out.print(data + " ");
		}
		System.out.println();
	}
}
