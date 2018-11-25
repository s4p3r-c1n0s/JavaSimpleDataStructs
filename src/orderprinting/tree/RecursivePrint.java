package orderprinting.tree;

public class RecursivePrint extends TreePrint {


	public static void main(String args[]) {
		RecursivePrint rp = new RecursivePrint();
		rp.printAll();
	}

	@Override
	public void preOrder(Node n){
		if(n == null)
			return;
		Node r = n.getRight();
		Node l = n.getLeft();
		System.out.print(""+n.getValue()+" > ");
		preOrder(l);
		preOrder(r);
	}

	@Override
	public void inOrder(Node n){
		if(n == null)
			return;
		Node r = n.getRight();
		Node l = n.getLeft();
		inOrder(l);
		System.out.print(""+n.getValue()+" > ");
		inOrder(r);
	}

	@Override
	public void postOrder(Node n){
		if(n == null)
			return;
		Node r = n.getRight();
		Node l = n.getLeft();
		postOrder(l);
		postOrder(r);
		System.out.print(""+n.getValue()+" > ");
	}


	@Override
	public void levelOrder(Node n){
		if(n == null)
			return;
		int count = 1;
		while(dfsOrder(n, 1, count++));
		//dfsOrder(n, 1, 4);;
	}

	
	private boolean dfsOrder(Node n, int deep, final int maxDepth) {
		if(n == null)
			return false;
		
		if(deep++ == maxDepth) {
			System.out.print(""+n.getValue()+" > ");
			return true;
		} else {
			boolean b = dfsOrder(n.getLeft(), deep, maxDepth);
			boolean a = dfsOrder(n.getRight(), deep, maxDepth);
			return a || b;
		}
	}
}
