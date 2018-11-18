package orderprinting.graph;

import orderprinting.linkedlist.List;

public class AdjList<V extends Comparable<? super V>> {

	private final List<Vertex<V>> graph;
	private final boolean isDirected;

	public AdjList(boolean isDirected) {
		graph = new List<Vertex<V>>();
		this.isDirected = isDirected;
	}

	public AdjList addVertex(Vertex vertex){
		graph.addNode(vertex);
		return this;
	}

	public AdjList addVertex(V value){
		return addVertex(new Vertex(value));
	}

	public boolean connect(V value1, V value2){
		return connect(new Vertex(value1), new Vertex(value2), null);
	}

	public boolean connect(V value1, V value2, Integer weight){
		return connect(new Vertex(value1), new Vertex(value2), weight);
	}

	public boolean connect(Vertex<V> v1, Vertex<V> v2, Integer weight){
		if(v1.compareTo(v2) == 0)
			return false;
		Vertex<V> found1 =  graph.find(v1);
		Vertex<V> found2 =  graph.find(v2);
		if(found1 == null || found2 == null)
			return false;
		return connectVertices(found1, found2, weight);
	}

	public boolean connectVertices(Vertex<V> found1, Vertex<V> found2, Integer weight){

		// we make one way connection for both directed and undirected
		boolean oneWayConnected = addOneWayEdge(found1, found2, weight);
		boolean reverseWayConnected = false;
		if(!isDirected){
			// we make a reverse connection only when graph is undirected 
			reverseWayConnected = addOneWayEdge(found2, found1, weight);
		}
		// isDirected XOR reverseWayConnected will return true when : 
		// 1. undirected graph is now reverse connected
		// 2. directed graph did not get reverse connected
		// NOTE : XNOR was done to make AND operation give correct result
		return (reverseWayConnected == !isDirected) && oneWayConnected;
	}

	private boolean addOneWayEdge(Vertex<V> v1, Vertex<V> v2, Integer weight){
		if(!v1.findEdge(weight, v2)) {
			if(weight == null)
				v1.addEdge(v2);
			else 
				v1.addEdge(weight, v2);
			return true;
			}
		return false;
		}
	public static void main(String args[]){
		AdjList<Integer> al = new AdjList<Integer>(false);
		System.out.print(al);
		al.addVertex(1).addVertex(2).addVertex(3).addVertex(4).addVertex(5);
		System.out.println("CONNECTED?:"+al.connect(1,3) + "\n" + al);
		System.out.println("CONNECTED?:"+al.connect(5,3) + "\n" + al);
		System.out.println("CONNECTED?:"+al.connect(2,4) + "\n" + al);
		System.out.println("CONNECTED?:"+al.connect(1,3) + "\n" + al);
		System.out.println("CONNECTED?:"+al.connect(4,3) + "\n" + al);
		System.out.println("CONNECTED?:"+al.connect(4,1) + "\n" + al);
		System.out.println("CONNECTED?:"+al.connect(2,3) + "\n" + al);
	
	}


	@Override
	public String toString() {
		String str = "";
		for(int i=0 ; i<graph.size(); i++)
			str+=graph.getAtIndex(i)+"\n";
		return str;
	}
}
