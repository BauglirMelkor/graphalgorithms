package depthfirstsearch;

public class App {

	public static void main(String[] args) {
		DFS dfs = new DFS();

		Vertex vertex1 = new Vertex("1");
		Vertex vertex2 = new Vertex("2");
		Vertex vertex3 = new Vertex("3");
		Vertex vertex4 = new Vertex("4");
		Vertex vertex5 = new Vertex("5");

		vertex1.addNeighbourList(vertex2);
		vertex1.addNeighbourList(vertex3);
		vertex3.addNeighbourList(vertex4);
		vertex4.addNeighbourList(vertex5);

		dfs.dfs(vertex1);
	}

}
