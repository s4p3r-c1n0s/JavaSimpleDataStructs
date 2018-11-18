package orderprinting.linkedlist;

public class ListCreator{

	private final List<Integer> list;

	public ListCreator(){
		list = new List<Integer>();
		buildList();
	}

	private void buildList(){
		list.addNode(1);
		list.addNode(2);
		list.addNode(3);
		list.addNode(4);
		list.addNode(5);
		list.addNode(6);
	}

	public List<Integer> getList() {
		return list;
	}
	public static void main(String[] args){
		List<Integer> l = (new ListCreator()).getList();
		System.out.println(l.size() +" "+l.getTop().getValue()+" "+l.getBottom().getValue() );
	}
}
