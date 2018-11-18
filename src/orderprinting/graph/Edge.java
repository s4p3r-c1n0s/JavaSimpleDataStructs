package orderprinting.graph;

public class Edge implements Comparable<Edge> {
	private final int weight;
	private final Vertex vertex;

	public Edge(int weight, Vertex vertex) {
		this.weight = weight;
		this.vertex = vertex;
	}

	@Override
	public String toString(){
		return  vertex.getValue().toString() + "(" + weight + ")->";
	}
	
	public Edge(Integer weight, Vertex vertex) {
		this(weight == null ? NO_WEIGHT : weight.intValue(), vertex);
	}
	public Edge(Vertex vertex) {
		this(NO_WEIGHT, vertex);
	}

	public int getWeight(){
		return weight;
	}

	public Vertex getVertex(){
		return vertex;
	}

	private static final int NO_WEIGHT = 1;

	@Override
	public int compareTo(Edge e){
		int value =  this.vertex.compareTo(e.getVertex()) | Integer.compare(this.weight, e.getWeight());
		return value;	
	}

}
