package astartsearch;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class AStarAlgorithm {

	private Node[][] searchSpace;
	private Node startNode;
	private Node endNode;
	private List<Node> closedSet;
	private Queue<Node> openSet;

	public AStarAlgorithm() {
		this.searchSpace = new Node[Constants.NUM_ROWS][Constants.NUM_COLS];
		this.openSet = new PriorityQueue<>(new NodeComparator());
		this.closedSet = new ArrayList<>();
		initializeSearchSpace();
	}

	private void initializeSearchSpace() {
		for (int i = 0; i < Constants.NUM_ROWS; i++) {
			for (int j = 0; j < Constants.NUM_COLS; j++) {
				Node node = new Node(i, j);
				this.searchSpace[i][j] = node;
			}
		}

		this.searchSpace[1][7].setBlock(true);
		this.searchSpace[2][3].setBlock(true);
		this.searchSpace[2][4].setBlock(true);
		this.searchSpace[2][5].setBlock(true);
		this.searchSpace[2][6].setBlock(true);
		this.searchSpace[2][7].setBlock(true);

		this.startNode = this.searchSpace[3][3];
		this.endNode = this.searchSpace[1][6];

	}

	public void search() {
		startNode.setH(manhattanHeuristic(startNode, endNode));
		openSet.add(startNode);
		while (!openSet.isEmpty()) {
			Node currentNode = openSet.poll();
			System.out.println(currentNode + " Predecessor is: " + currentNode.getPredecessor());
			if (currentNode.equals(endNode))
				return;

			openSet.remove(currentNode);
			closedSet.add(currentNode);

			for (Node neighbor : getAllNeigbor(currentNode)) {
				if (closedSet.contains(neighbor))
					continue;

				if (!openSet.contains(neighbor))
					openSet.add(neighbor);

				neighbor.setPredecessor(currentNode);

			}

		}
	}

	private List<Node> getAllNeigbor(Node currentNode) {

		List<Node> neighbors = new ArrayList<>();
		int row = currentNode.getRowIndex();
		int col = currentNode.getColIndex();

		if (row - 1 > 0 && !this.searchSpace[row - 1][col].isBlock()) {
			searchSpace[row - 1][col].setG(currentNode.getG() + Constants.HORIZONTAL_VERTICAL_COST);
			searchSpace[row - 1][col].setH(manhattanHeuristic(searchSpace[row - 1][col], endNode));
			neighbors.add(searchSpace[row - 1][col]);
		}

		if (row + 1 < Constants.NUM_ROWS && !this.searchSpace[row + 1][col].isBlock()) {
			searchSpace[row + 1][col].setG(currentNode.getG() + Constants.HORIZONTAL_VERTICAL_COST);
			searchSpace[row + 1][col].setH(manhattanHeuristic(searchSpace[row + 1][col], endNode));
			neighbors.add(searchSpace[row + 1][col]);
		}

		if (col - 1 > 0 && !this.searchSpace[row][col - 1].isBlock()) {
			searchSpace[row][col - 1].setG(currentNode.getG() + Constants.HORIZONTAL_VERTICAL_COST);
			searchSpace[row][col - 1].setH(manhattanHeuristic(searchSpace[row][col - 1], endNode));
			neighbors.add(searchSpace[row][col - 1]);
		}

		if (col + 1 < Constants.NUM_COLS && !this.searchSpace[row][col + 1].isBlock()) {
			searchSpace[row][col + 1].setG(currentNode.getG() + Constants.HORIZONTAL_VERTICAL_COST);
			searchSpace[row][col + 1].setH(manhattanHeuristic(searchSpace[row][col + 1], endNode));
			neighbors.add(searchSpace[row][col + 1]);
		}

		return neighbors;
	}

	private int manhattanHeuristic(Node startNode, Node endNode) {
		return (Math.abs(startNode.getRowIndex() - endNode.getRowIndex())
				+ Math.abs(startNode.getColIndex() - endNode.getColIndex())) * 10;
	}

}
