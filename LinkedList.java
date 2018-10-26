class Node {
	Object data;
	Node next = null;

	public Node(Object val) {
		this.data = val;
	}
}

public class LinkedList implements List {
	Node head;

	public Node getLastNode() {
		Node current = head;
		while (current.next != null) {
			current = current.next;
		}
		return current;
	}

	@Override
	public void add(Object obj) throws Exception {
		if (head == null) {
			head = new Node(obj);
			return;
		}
		Node lastNode = getLastNode();
		lastNode.next = new Node(obj);
	}

	@Override
	public void add(int pos, Object obj) throws Exception {
		if (head == null) {
			head = new Node(obj);
			return;
		}
		int i = 0;
		Node current = head;
		while (i < pos - 1) {
			i++;
			current = current.next;
		}
		Node n = new Node(obj);
		if (current.next != null) {
			n.next = current.next;
		}
		current.next = n;

	}

	@Override
	public Object get(int pos) throws Exception {
		int i = 0;
		Node current = head;
		while (i < pos) {
			i++;
			current = current.next;
		}
		return current.data;
	}

	@Override
	public Object remove(int pos) throws Exception {
		int i = 0;
		Node current = head;
		Node prev = head;
		while (i < pos) {
			prev = current;
			current = current.next;
			i++;
		}
		Object removed = current.data;
		if (pos==0&&head.next!=null) {
			head=head.next;
		} else if(pos==0) {
			head=null;
		}
		if (current.next != null) {
			prev.next = current.next;
		}
		return removed;
	}

	@Override
	public int size() {
		int i = 0;
		Node current = head;
		while (current != null) {
			current = current.next;
			i++;
		}
		return i;
	}

}
