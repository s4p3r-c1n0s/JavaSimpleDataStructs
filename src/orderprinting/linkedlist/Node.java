package orderprinting.linkedlist;

public class Node<V extends Comparable<? super V>> {
	private final V value;
	private Node<V> next;

	public Node<V> getNext(){
		return next;
	}

	public void setNext(Node<V> next){
		this.next = next;
	}

	public Node(V value, Node<V> next) {
		this.value = value;
		setNext(next);
	}

	public Node(V value){
		this(value, null);
	}

	public V getValue() {
		return value;
	}

	public String toString() {
		return value.toString();
	}

	public static void main(String args[]){
		Node<Integer> n = new Node<Integer>(new Integer(10));
		Node<Integer> next = new Node<Integer>(new Integer(20));
		n.setNext(next);
		System.out.println(n.getValue()+" "+n.getNext().getValue());
	}
}

