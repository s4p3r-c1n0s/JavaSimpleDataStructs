package orderprinting.linkedlist;

public class Queue<V extends Comparable<? super V>>{
	private final List<V> list;

	public Queue() {
		list = new List<V>();
	}

	public void offer(V element){
		list.addNode(element);
	}

	public V poll() {
		Node<V> deletedNode = list.deleteNodefromStart();
		return deletedNode == null ? null : deletedNode.getValue();
	}

	public V peek() {
		Node<V> topNode = list.getTop();
		return topNode == null ? null : topNode.getValue();
	}

	public static void main(String args[]) {
		Queue<Integer> q = new Queue<Integer>();
		q.offer(1);
		q.offer(2);
		q.offer(3);
		q.offer(4);
		System.out.println(""+ q.poll());
		System.out.println(""+ q.peek());
	}

}
