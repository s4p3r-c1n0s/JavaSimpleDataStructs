package orderprinting.linkedlist;

public class Stack<V extends Comparable<? super V>> {

	private final List<V> list;

	public Stack(){
		list = new List<V>();
	}

	public void push(V newNode){
		list.addNode(newNode);
	}
	
	public V pop() {
		Node<V> deletedNode = list.deleteNodefromEnd();
		return deletedNode == null ? null : deletedNode.getValue();
	}

	public V peek() {
		Node<V> topNode = list.getBottom();
		return topNode == null ? null : topNode.getValue();
	}

	public int size() {
		return list.size();
	}

	public static void main(String args[]) {
		Stack<Integer> s = new Stack<Integer>();
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		System.out.println(""+ s.pop());
		System.out.println(""+ s.pop());
	}
}
