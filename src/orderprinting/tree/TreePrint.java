package orderprinting.tree;

public abstract class TreePrint implements Print{
	
	public static final Tree tree = (new TreeBuilder()).getTree();
	
	public void printAll(){

		if(tree == null) {
			System.out.println("TREE IS NULL");
			return;
		}

		preOrder(tree.getRoot());
		System.out.println(" :Pre-Order");
		postOrder(tree.getRoot());
		System.out.println(" :Post-Order");
		inOrder(tree.getRoot());
		System.out.println(" :In-Order");
	}
}
