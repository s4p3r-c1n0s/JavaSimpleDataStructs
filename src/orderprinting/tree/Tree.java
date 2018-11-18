package orderprinting.tree;

public class Tree {

	private Node root;

	public Node getRoot() {
		return root;
	}

	public Node searchNode(Integer value) {
		return searchNode(null, value);	
	}

	public Node searchNode(Node node, Integer value) {
		if(node == null) 
			node = root;
		if(node.getValue() == value)
			return node;
		else if(node.getValue() > value) {
			if (node.getLeft() == null)
				return node;
			else
				return searchNode(node.getLeft(), value);

		}
		else {//if(node.getValue() < value)
			if (node.getRight() == null)
				return node;
			else
				return searchNode(node.getRight(), value);
		}
	}

	public boolean addNode(Integer childValue) {
		if(childValue == null)
			return false;
		
		if (root == null) {
			root = new Node(childValue, null, null);
			return true;
		}

		Node foundNode = searchNode(null, childValue);
		if(foundNode == null || foundNode.getValue() == childValue) 
			return false;
	
		if(foundNode.getValue() > childValue){
			foundNode.setLeft(new Node(childValue, null, null));
		} else {
			foundNode.setRight(new Node(childValue, null, null));
		}
		return true;
	}
}
