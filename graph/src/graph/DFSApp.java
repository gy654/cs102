package graph;

import java.util.ArrayList;

public class DFSApp {
	public static void main(String[] args) {
		Graph theGraph = new Graph();
		theGraph.addVertex('A'); // 0 (start for dfs)
		theGraph.addVertex('B'); // 1
		theGraph.addVertex('C'); // 2
		theGraph.addVertex('D'); // 3
		theGraph.addVertex('E'); // 4
		theGraph.addVertex('F');
		theGraph.addVertex('G');

		theGraph.addEdge(0, 1); // AB
		theGraph.addEdge(1, 2); // BC
		theGraph.addEdge(0, 3); // AD
		theGraph.addEdge(3, 4); // DE
		theGraph.addEdge(5, 6); 

		theGraph.isPath(0,6);
		System.out.println(theGraph.isConnected());
		theGraph.allArticulation();
		//theGraph.DisplaySubGraphs();

		System.out.print("\nVisits: ");
		//theGraph.dfs(0); // depth-first search
		//System.out.println();
		//theGraph.dfs(5);
		//System.out.println();
		System.out.print(theGraph.AnalyzeV(1));
		
	} // end main()
} // end class DFSApp