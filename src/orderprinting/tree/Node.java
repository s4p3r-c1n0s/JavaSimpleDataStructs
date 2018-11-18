package orderprinting.tree;

public class Node implements Comparable<Node> {
	private Node left;
	private Node right;
	private final Integer value;

	public Integer getValue(){
		return value;
	}

	public Node getLeft() {
		return left;
	}

	public Node getRight(){
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public void setLeft(Node left) {
		this.left = left;
	}


	public Node(int value, Node left, Node right) {
		this.value = value;
		this.left = left;
		this.right = right;
	}

	@Override
	public int compareTo(Node n){
		return Integer.compare(this.value, n.getValue());
	}


}

