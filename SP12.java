package kxy170003;

import java.util.Scanner;
import rbk.BFSOO;
import rbk.Graph;
import rbk.Graph.Vertex;

public class SP12 {

	/**
	 * To find the diameter of a Tree (undirected acyclic graph) .
	 * 
	 * @param g
	 * @return max distance
	 */
	int diameter(Graph g) {
		BFSOO bfs = BFSOO.breadthFirstSearch(g, 1);		// bfs on graph with 1 as source													
		int maxmimumDistance = 0;		//keeps track of max distance of a vertex from source 
		Vertex maxVertex = null;		
		for (Vertex v : g) {
			if (bfs.getDistance(v) > maxmimumDistance) {
				maxmimumDistance = bfs.getDistance(v);
				maxVertex = v;
			}
		}
		bfs = BFSOO.breadthFirstSearch(g, maxVertex);// running bfs with max vertex						
		maxmimumDistance = 0;
		for (Vertex v : g) {
			if (bfs.getDistance(v) > maxmimumDistance) {
				maxmimumDistance = bfs.getDistance(v);
				maxVertex = v;
			}
		}
		return maxmimumDistance;
	}

	public static void main(String[] args) throws Exception {
		String string = "9 8  1 2 2   2 3 3   1 4 5   4 5 6  5 6 9  1 7 6  7 8 2  8 9 0  ";
		Scanner in;
		in = new Scanner(string);
		Graph g = Graph.readGraph(in);
		SP12 sp12 = new SP12();
		System.out.println("Given Tree's Diameter"+" : " +sp12.diameter(g));
	}
}