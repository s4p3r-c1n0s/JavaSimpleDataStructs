package orderprinting.graph;

import orderprinting.linkedlist.List;

public class Vertex<V extends Comparable<? super V>> implements Comparable<Vertex<V>> {
	private final V value;
	private final List<Edge> edges;

	public Vertex(V value) {
		this.value = value;
		edges = new List<Edge>();
	}

	public V getValue(){
		return value;
	}

	public List<Edge> getEdges(){
		return edges;
	}

	@Override 
	public int compareTo(Vertex<V> vertex){
		return value.compareTo(vertex.getValue());
	}

	public Vertex<V> addEdge(Edge e) {
		edges.addNode(e);
		return this;
	}

	public Vertex<V> addEdge(Integer weight, Vertex<V> vertex) {
		 return addEdge(new Edge(weight, vertex));
	}

	public Vertex<V> addEdge(Vertex<V> vertex) {
		return addEdge(new Edge(vertex));
	}

	public Vertex<V> addEdge(V value) {
		return addEdge(new Vertex(value));
	}

	public boolean findEdge(Edge e){
		Edge edge = edges.find(e);
		return edge != null;
	}

	public boolean findEdge(Vertex<V> v){
		return findEdge(new Edge(v));
	}

	public boolean findEdge(Integer weight, Vertex<V> v){
		return findEdge(new Edge(weight, v));
	}
	public boolean findEdge(V value){
		return findEdge(new Vertex(value));
	}

	public static void main(String args[]){
		Vertex<Integer> v = new Vertex<Integer>(1);
		v.addEdge(2).addEdge(3).addEdge(4);
		System.out.println("findEdge : " + v.findEdge(3));
		System.out.println("findEdge " + v.findEdge(5));
		System.out.println(v.toString());
	}

	@Override
	public String toString() {
		String str = "V:"+value.toString()+" :: ";
		for(int i = 0; i<edges.size(); i++)
			str += edges.getAtIndex(i).toString();
		return str;
	}


}

