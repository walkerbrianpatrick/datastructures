package org.walker.datastructures;

import org.junit.Test;

public class TestGraph {

	@Test
	public void createGraph() {
		Graph graph = new Graph(10);

		graph.addVertex(new Vertex('a'));
		graph.addVertex(new Vertex('b'));
		graph.addVertex(new Vertex('c'));
		graph.addVertex(new Vertex('d'));

		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);

		assert (graph.edgeExists(0, 1));
		assert (graph.edgeExists(1, 2));
		assert (graph.edgeExists(2, 3));
	}

	@Test
	public void labelConnection() {
		Graph graph = new Graph(10);

		graph.addVertex(new Vertex('a'));
		graph.addVertex(new Vertex('b'));
		graph.addVertex(new Vertex('c'));
		graph.addVertex(new Vertex('d'));

		graph.addEdge('a', 'b');
		graph.addEdge('b', 'c');
		graph.addEdge('c', 'd');
		try {
			assert (graph.edgeExists('a', 'b'));
			assert (graph.edgeExists('b', 'c'));
			assert (graph.edgeExists('c', 'd'));
		} catch (AssertionError e) {
			graph.printVertices();
			graph.printAdjMatrix();
		}
	}

	@Test
	public void depthFirstVisit() {
		Graph graph = new Graph(10);

		graph.addVertex(new Vertex('a'));
		graph.addVertex(new Vertex('b'));
		graph.addVertex(new Vertex('c'));
		graph.addVertex(new Vertex('d'));
		graph.addVertex(new Vertex('e'));
		graph.addVertex(new Vertex('f'));

		graph.addEdge('a', 'b');
		graph.addEdge('b', 'c');
		graph.addEdge('c', 'd');
		graph.addEdge('a', 'e');
		graph.addEdge('e', 'f');
		graph.addEdge('f', 'd');
		

		System.out.println("Depth First:");
		graph.depthFirstVisit(0, a -> {
			System.out.print(a.getLabel());
		});
		System.out.println();
		
	}

	@Test
	public void breadthFirstVisit() {
		Graph graph = new Graph(10);

		graph.addVertex(new Vertex('a'));
		graph.addVertex(new Vertex('b'));
		graph.addVertex(new Vertex('c'));
		graph.addVertex(new Vertex('d'));
		graph.addVertex(new Vertex('e'));
		graph.addVertex(new Vertex('f'));

		graph.addEdge('a', 'b');
		graph.addEdge('b', 'c');
		graph.addEdge('c', 'd');
		graph.addEdge('a', 'e');
		graph.addEdge('e', 'f');
		graph.addEdge('f', 'd');
		
		System.out.println("Breadth first:");
		graph.breadthFirstVisit(0, a -> {
			System.out.print(a.getLabel());
		});
		System.out.println();
	}
	
}
