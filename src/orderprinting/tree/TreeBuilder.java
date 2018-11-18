package orderprinting.tree;

public class TreeBuilder{

	private final Tree tree;
	
	public TreeBuilder() {
		tree = new Tree();
		buildTree();
	}

	public Tree getTree(){
		return tree;
	}

private void buildTree() {
		tree.addNode(4);
		tree.addNode(7);
		tree.addNode(1);
		tree.addNode(0);
		tree.addNode(3);
		tree.addNode(2);
		tree.addNode(8);
		tree.addNode(5);
		tree.addNode(6);
	}

	public void printRoot() {
		
		Node rootNode = tree.getRoot();
		System.out.println("ROOT " + rootNode.getValue());
		if (rootNode.getLeft() != null){
			Node LeftNode = rootNode.getLeft();
			System.out.println("LEFT " + LeftNode.getValue());
		}
		if (rootNode.getRight() != null){
			Node RightNode = rootNode.getRight();
			System.out.println("RGHT " + RightNode.getValue());
		}
		//printNode(rootNode.getLeft().getValue());
		//printNode(rootNode.getRight().getValue());
	}

	public void printNode(int value) {
		Node foundNode = tree.searchNode(value);
		System.out.println("PRNT " + foundNode.getValue());
		
		if (foundNode.getLeft() != null){
			Node LeftNode = foundNode.getLeft();
			System.out.println("LEFT " + LeftNode.getValue());
		}
		if (foundNode.getRight() != null){
			Node RightNode = foundNode.getRight();
			System.out.println("RGHT " + RightNode.getValue());
		}
	}
}

