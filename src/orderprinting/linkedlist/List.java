package orderprinting.linkedlist;

public class List<V extends Comparable<? super V>> {

	public List() {
		top = null;
		bottom = top;
	}
	
	private Node<V> top;

	private Node<V> bottom;
	
	public Node<V> getTop(){
		return top;
	}

	public Node<V> getBottom(){
		return bottom;
	}

	public int size(){
		if(top == bottom && top == null) 
			return 0;

		int count = 1;
		Node<V> currentNode = top;
		while (currentNode != bottom) {
			count++;
			currentNode = currentNode.getNext();
		}
		return count;
	}

	public boolean isEmpty(){
		return size() == 0;
	}

	public List<V>  addNode(V newElement){
		Node<V> newNode = new Node<V>(newElement);
		if(isEmpty()){
			top = newNode;
			bottom = top;
		} else {
			bottom.setNext(newNode);
			bottom = newNode;
		}
		return this;
	}

	public Node<V> deleteNodefromEnd(){
		int size = size();
		if(size == 0) 
			return null;
		
		Node<V> lastNode = bottom;
		if(size == 1){
			top = null;
			bottom = top;
		}
		else {
			Node<V> currentNode = top;
			while(bottom != currentNode.getNext()){
				currentNode = currentNode.getNext();
			}
			bottom = currentNode;
		}
		return lastNode;
	}

	public Node<V> deleteNodefromStart(){
		int size = size();
		if(size == 0)
			return null;
		
		Node<V> firstElement = top;
		if(size == 1) {
			top = null;
			bottom = top;
		}
		else
			top = top.getNext();
		return firstElement;
	}

	public V find(V value){
		Node<V> foundNode = findNode(value);
		return foundNode != null ? foundNode.getValue() : null;
	}


	private Node<V> findNode(V value){
		if(isEmpty())
			return null;

		Node<V> currentNode = top;
		while(value.compareTo(currentNode.getValue()) != 0){
			if(currentNode == bottom){
				return null;
			}
			currentNode = currentNode.getNext();
		}
		return currentNode;
	}

	public V getAtIndex(int i){
		if(i >= size() || i < 0)
			return null;
		Node<V> indexNode = top;
		while(i != 0) {
			indexNode = indexNode.getNext();
			i--;
		}
		return indexNode.getValue();

	}

	public Node<V> deleteNode(V value) {
		Node<V> foundNode = findNode(value);
		if(foundNode == null)
			return null;
		
		if(top == bottom){
			top = null;
			bottom = top;
		} else if(foundNode == top){
			top = top.getNext();
		} else {
			Node<V> currentNode = top; // currentNode to hold node previous to foundNode
			while(foundNode != currentNode.getNext()){
				currentNode = currentNode.getNext();
			}
			if(foundNode == bottom)
				bottom = currentNode;	
			else 
				currentNode.setNext(foundNode.getNext());		
		}
		return foundNode;
	}

	public static void main(String args[]){
		List<Integer> list = new List<Integer>();
		System.out.println(list.addNode(1));
		System.out.println(list.deleteNode(1));
		System.out.println(list.addNode(2));
		System.out.println(list.addNode(3));
		System.out.println(list.deleteNode(2));
		System.out.println(list.addNode(4));
		System.out.println(list.deleteNode(4));
		System.out.println(list.addNode(5));
		System.out.println(list.addNode(6));
		System.out.println(list.deleteNode(5));
		System.out.println(list.addNode(7));
		System.out.println(list.deleteNodefromStart());
		System.out.println(list.deleteNodefromEnd());
		if (list.getTop() != null)
			System.out.println("top: " +list.getTop().getValue());
		if (list.getBottom() != null)
			System.out.println("bottom: "+list.getBottom().getValue() );
		System.out.println("size: " +list.size());
	}
}
