package depthfirstsearch;

import java.util.List;
import java.util.Stack;

public class DFS {

	private Stack<Vertex> stack;

	public DFS() {
		stack = new Stack<>();
	}

	public void dfs(Vertex vertex) {
		vertex.setVisited(true);
		dfsRecursive(vertex);
	}

	private void dfsRecursive(Vertex vertex) {
		System.out.println(vertex + " ");
		for (Vertex v : vertex.getNeighbourList()) {
			if (!v.isVisited()) {
				v.setVisited(true);
				dfsRecursive(v);
			}
		}
	}

	private void dfsWithStack(Vertex rootVertex) {
		this.stack.add(rootVertex);
		while (!stack.isEmpty()) {
			Vertex actualVertex = stack.pop();
			System.out.println(actualVertex + " ");

			for (Vertex v : actualVertex.getNeighbourList()) {
				if (!v.isVisited()) {
					v.setVisited(true);
					stack.push(v);
				}
			}

		}

	}
}