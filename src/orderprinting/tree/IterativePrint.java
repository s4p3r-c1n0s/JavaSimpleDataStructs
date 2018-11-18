package orderprinting.tree;

import orderprinting.linkedlist.Queue;
import orderprinting.linkedlist.Stack;

public class IterativePrint extends TreePrint {

	private final Queue<Node> q;
	private final Stack<Node> s;

	public IterativePrint(){
		q = new Queue<Node>();	
		s = new Stack<Node>();
	}


	public static void main(String args[]) {
		IterativePrint ip = new IterativePrint();
		ip.printAll();
	}

	@Override
	public void preOrder(Node root){
		do {
			if(root == null)
				root = s.pop();
			else {
				System.out.print(" <"+root.getValue()+">");
				if(root.getRight() != null)
					s.push(root.getRight());
				root = root.getLeft();
			}
		} while(root !=null || s.peek() != null);
	}
	@Override
	public void postOrder(Node root){
		do {
			if(root == null) {
				root = s.pop();
				
				if(root == null)
					continue;

				if(root.getRight() != null && root.getRight() == s.peek()){
					s.pop();
					s.push(root);
					root = root.getRight();
				} 
				else {
					System.out.print(" <"+root.getValue()+">");
					root = null;
				}
			} 
			else {
				if(root.getRight() != null)
					s.push(root.getRight());
				s.push(root);

				root = root.getLeft();
			}
			
		} while(s.peek() != null);
	}
	@Override
	public void inOrder(Node root){
		do {
			if(root == null) {
				root = s.pop();
				
				if(root == null)
					continue;

				if(root.getRight() != null && root.getRight() == s.peek()){
					s.pop();
					System.out.print(" <"+root.getValue()+">");
					root = root.getRight();
				} 
				else {
					System.out.print(" <"+root.getValue()+">");
					root = null;
				}
			} 
			else {
				if(root.getRight() != null)
					s.push(root.getRight());
				s.push(root);

				root = root.getLeft();
			}
			
		} while(!(root == null && s.peek() == null));
	}
}
