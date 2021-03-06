package org.walker.datastructures;

import java.util.Arrays;
import java.util.function.Consumer;

import org.walker.datastructures.stacksandqueues.Queue;
/**
 * Undirected graph class that allows circular connections
 * Labels are of type char, and are assumed to be unique
 * @author walker
 *
 */
public class Graph {

	private Vertex[] vertices;
	private boolean[][] adjMatrix;
	private int numVertices;

	public Graph(int maxGraphSize) {
		vertices = new Vertex[maxGraphSize];
		adjMatrix = new boolean[maxGraphSize][maxGraphSize];
		numVertices = 0;
	}

	public int addVertex(Vertex vertex) {
		vertices[numVertices] = vertex;
		return numVertices++;
	}

	/**
	 * Add edge by index of two vertices
	 * 
	 * @param vert1
	 * @param vert2
	 */
	public void addEdge(int vert1, int vert2) {
		adjMatrix[vert1][vert2] = true;
		adjMatrix[vert2][vert1] = true;
	}

	/**
	 * Add an edge by label instead of index
	 * 
	 * @param vertLabel1
	 * @param vertLabel2
	 */
	public void addEdge(char vertLabel1, char vertLabel2) {
		IntPair indices = getPairVertexIndex(vertLabel1, vertLabel2);

		if (indices.left != -1 && indices.right != -1) {
			addEdge(indices.left, indices.right);
		}
	}

	public Vertex getVertex(int vertIndex) {
		return vertices[vertIndex];
	}

	/**
	 * Return if an edge exists between two indexed vertices
	 * 
	 * @param vert1
	 * @param vert2
	 * @return
	 */
	public boolean edgeExists(int vert1, int vert2) {
		return adjMatrix[vert1][vert2];
	}

	public boolean edgeExists(char label1, char label2) {
		boolean result = false;
		IntPair indices = getPairVertexIndex(label1, label2);
		if (indices.left != -1 && indices.right != -1) {
			return adjMatrix[indices.left][indices.right];
		}
		return result;
	}

	/**
	 * get the index of the vertex which has a given label
	 * 
	 * @param label
	 * @return
	 */
	public int getVertexIndex(char label) {
		int result = -1;
		for (int i = 0; i < numVertices; i++) {
			if (label == vertices[i].getLabel()) {
				result = i;
			}
			if (result!= -1) {
				break;
			}
		}
		return result;
	}

	/**
	 * Get a pair of indices for labels in the vertex array. This is more efficient
	 * than finding indices for two label independently, because it only iterates
	 * over the array once, and has short circuiting once both labels are found
	 * 
	 * @param label1
	 * @param label2
	 * @return
	 */
	public IntPair getPairVertexIndex(char label1, char label2) {
		IntPair result = new IntPair();
		result.left = -1;
		result.right = -1;
		for (int i = 0; i < numVertices; i++) {
			if (label1 == vertices[i].getLabel()) {

				result.left = i;
			}
			if (label2 == vertices[i].getLabel()) {
				result.right = i;
			}
			// short circuit completion
			if ((result.left != -1) && (result.right != -1)) {
				break;
			}
		}
		return result;
	}

	/**
	 * Use the depth first pattern to visit all vertices connected to 
	 * a given vertex
	 * @param vert
	 * @param visitor
	 */
	public void depthFirstVisit(int vert, Consumer<Vertex> visitor) {
		dfsVisitArray(vert, visitor);
		setAllVisitedToFalse();
	}
	/**
	 * Alias for depthFirstVisit(int, visitor) 
	 * Which allows for reference to vertices by label 
	 * instead of index. There is a lookup cost O(N) associated
	 * with using this method
	 * @param label
	 * @param visitor
	 */
	public void depthFirstVisit(char label, Consumer<Vertex> visitor) {
		depthFirstVisit(getVertexIndex(label), visitor);
	}
	
	private void dfsVisitArray(int vert, Consumer<Vertex> visitor) {
		// do whatever you were going to do at this vertex
		visitor.accept(vertices[vert]);
		vertices[vert].setVisited(true);
		int nextVertex;
		while ((nextVertex = findUnvistedNeighbor(vert)) != -1) {
			dfsVisitArray(nextVertex, visitor);
		}		
	}
	
	private int findUnvistedNeighbor(int vertIndex) {
		for (int i = 0; i < numVertices; i++) {
			// if a neighbor is connected, and unvisted return its index
			if ((adjMatrix[vertIndex][i] == true) && (vertices[i].isVisited() == false)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Using a breadth first pattern, visit all nodes of the graph
	 * @param vert
	 * @param visitor
	 */
	public void breadthFirstVisit(int vert, Consumer<Vertex> visitor) {
		Queue<Integer> vertQueue = new Queue<>(numVertices);
		vertQueue.insert(vert);
		vertices[vert].setVisited(true);
		bfsVisitQueue(vertQueue, visitor);
		setAllVisitedToFalse();
	}
	
	/**
	 * Allowing for reference to the vertices by label instead of index
	 * @param label
	 * @param visitor
	 */
	public void breadthFirstVisit(char label, Consumer<Vertex> visitor) {
		breadthFirstVisit(getVertexIndex(label),visitor);
	}

	private void bfsVisitQueue(Queue<Integer> vertQueue, Consumer<Vertex> visitor) {
		if (!vertQueue.isEmpty()) {
			int currentIndex = vertQueue.remove();
			visitor.accept(vertices[currentIndex]);
			addUnvisitedNeighborsToQueue(currentIndex, vertQueue);
			bfsVisitQueue(vertQueue, visitor);
		}
		
	}

	private void addUnvisitedNeighborsToQueue(int vertIndex, Queue<Integer> vertQueue) {
		for (int i = 0; i < numVertices; i++) {
			if ((adjMatrix[vertIndex][i] == true) && (vertices[i].isVisited() == false)) {
				// set visited to true once they enter the queue to prevent
				// multiple visits to a single node, and to prevent
				// the N^2 queue size needed to track a fully connected graph
				vertices[i].setVisited(true);
				vertQueue.insert(i);
			}
		}
	}
	
	private void setAllVisitedToFalse() {
		for(int i = 0; i<numVertices; i++) {
			vertices[i].setVisited(false);
		}
	}

	@Override
	public String toString() {
		return "Graph [vertices=" + Arrays.toString(vertices) + ", numVertices=" + numVertices + "]";
	}

	public void printVertices() {
		for (int i = 0; i < numVertices; i++) {
			System.out.print(vertices[i].getLabel());
		}
		System.out.print("\n");
	}

	public void printAdjMatrix() {
		for (int i = 0; i < adjMatrix.length; i++) {
			for (int j = 0; j < adjMatrix[i].length; j++) {
				System.out.print(adjMatrix[i][j] ? "1" : "0");
			}
			System.out.print("\n");
		}
		System.out.print("\n");
	}
}
