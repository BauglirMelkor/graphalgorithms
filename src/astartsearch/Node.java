package astartsearch;

public class Node {

	private int g;
	private int h;
	private int rowIndex;
	private int colIndex;
	private Node predecessor;
	private boolean isBlock;

	public Node(int rowIndex, int colIndex) {
		this.rowIndex = rowIndex;
		this.colIndex = colIndex;
	}

	@Override
	public boolean equals(Object node2) {
		Node otherNode = (Node) node2;
		return this.rowIndex == otherNode.getRowIndex() && this.colIndex == otherNode.getColIndex();
	}

	public int getF() {
		return this.getG() + this.getH();
	}

	@Override
	public String toString() {
		return "Node (" + this.rowIndex + ";" + this.getColIndex() + ")" + "h:" + this.h + "- g:" + this.g + " - f"
				+ this.getF();
	}

	public int getG() {
		return g;
	}

	public void setG(int g) {
		this.g = g;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public int getRowIndex() {
		return rowIndex;
	}

	public void setRowIndex(int rowIndex) {
		this.rowIndex = rowIndex;
	}

	public int getColIndex() {
		return colIndex;
	}

	public void setColIndex(int colIndex) {
		this.colIndex = colIndex;
	}

	public Node getPredecessor() {
		return predecessor;
	}

	public void setPredecessor(Node predecessor) {
		this.predecessor = predecessor;
	}

	public boolean isBlock() {
		return isBlock;
	}

	public void setBlock(boolean isBlock) {
		this.isBlock = isBlock;
	}

}
