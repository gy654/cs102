package graph;

import java.util.ArrayList;

public class Graph{
	private final int MAX_VERTS = 20;
	private Vertex vertexList[]; // list of vertices
	private int adjMat[][]; // adjacency matrix
	private int nVerts; // current number of vertices
	private StackX theStack;
	private ArrayList<Integer> visited = new ArrayList<Integer>();
	


//------------------------------------------------------------
	public Graph(){ // constructor
		vertexList = new Vertex[MAX_VERTS];
		// adjacency matrix
		adjMat = new int[MAX_VERTS][MAX_VERTS];
		nVerts = 0;
		for (int y = 0; y < MAX_VERTS; y++) // set adjacency
			for (int x = 0; x < MAX_VERTS; x++) // matrix to 0
				adjMat[x][y] = 0;
		theStack = new StackX();
	} // end constructor
//------------------------------------------------------------

	public void addVertex(char lab) {
		vertexList[nVerts++] = new Vertex(lab);
	}

//------------------------------------------------------------
	public void addEdge(int start, int end) {
		adjMat[start][end] = 1;
		adjMat[end][start] = 1;
	}

//------------------------------------------------------------
	public void displayVertex(int v) {
		System.out.print(vertexList[v].label);
	}

//------------------------------------------------------------
	public void DisplaySubGraphs(){
		dfs(0);
		while(visited.size()!=nVerts){
			int unvisited = findUnvisited();
			System.out.println();
			dfs(unvisited);
		}
	}
	
	public int findUnvisited() {
		for (int i = 0; i < nVerts; i++) {
			if (! visited.contains(i)) {
				return i;
			}
		}
		return -1;
	}
//--------------------------------------------------
	public void dfs(int start){ // depth-first search

		vertexList[start].wasVisited = true; // mark it
		vertexList[start].friends_club_number = start;
		displayVertex(start); // display it
		visited.add(start);
		theStack.push(start); // push it

		while (!theStack.isEmpty()) // until stack empty,
		{
			// get an unvisited vertex adjacent to stack top
			int v = getAdjUnvisitedVertex(theStack.peek());
			if (v == -1) // if no such vertex,
				theStack.pop();
			else // if it exists,
			{
				vertexList[v].wasVisited = true;
				vertexList[v].friends_club_number = start;
				// mark it
				displayVertex(v); // display it
				visited.add(v);
				theStack.push(v); // push it
			}
		} // end while

		// stack is empty, so we're done
		for (int j = 0; j < nVerts; j++) // reset flags
			vertexList[j].wasVisited = false;
		
		
		/*for (int i =0;i < visited.size(); i++) {
			System.out.print(visited.get(i));
		}*/
	} // end dfs

	public int DFS(int start){ // depth-first search

		int count = 1;
		vertexList[start].wasVisited = true; // mark it
		vertexList[start].friends_club_number = start;
		//displayVertex(start); // display it
		visited.add(start);
		theStack.push(start); // push it

		while (!theStack.isEmpty()) // until stack empty,
		{
			// get an unvisited vertex adjacent to stack top
			int v = getAdjUnvisitedVertex(theStack.peek());
			if (v == -1) // if no such vertex,
				theStack.pop();
			else // if it exists,
			{
				vertexList[v].wasVisited = true;
				vertexList[v].friends_club_number = start;
				count++;
				// mark it
				//displayVertex(v); // display it
				visited.add(v);
				theStack.push(v); // push it
			}
		} // end while

		// stack is empty, so we're done
		for (int j = 0; j < nVerts; j++) // reset flags
			vertexList[j].wasVisited = false;
		return count;
	} // end dfs

//------------------------------------------------------------
// returns an unvisited vertex adj to v
	
	public boolean isConnected() {
		int counts = DFS(0);
		if (counts == nVerts) {
			return true;
		}else {
			return false;
		}
	}

	public int getAdjUnvisitedVertex(int v) {
		for (int j = 0; j < nVerts; j++)
			if (adjMat[v][j] == 1 && vertexList[j].wasVisited == false)
				return j;
		return -1;
	} // end getAdjUnvisitedVertex()
//------------------------------------------------------------
	// returns an unvisited vertex adj to v
	public int AnalyzeV(int v) {
		vertexList[v].wasVisited = true;
		int count = DFS(1);
		if (count< nVerts-1) {
			vertexList[v].isArticulation = true;
			return 1;
		}else {
			return 0;
		}
		
	}
//-------------------------------------------------------------
	public void allArticulation() {
		for (int i = 0; i < nVerts; i++) {
			if(AnalyzeV(i)==1) {
				System.out.print(vertexList[i].getLabel());
			}
		}
	}
//--------------------------------------------------------------
	public void isPath(int a , int b) {
		boolean found = false;
		theStack.push(a);
		do {
			int c = theStack.pop();
			if(c == b) {
				found = true;
			}else {
				for (int j = 0; j < nVerts; j++) {
					if (adjMat[c][j]==1 && !vertexList[j].wasVisited  ) {
						theStack.push(j);
						vertexList[j].wasVisited = true;
					}
				}
			}

		}while (! theStack.isEmpty() && ! found);
		if(! found) {
			System.out.println("Path does not exist");
		}else {
			System.out.println("Path exists");
		}
	}
} // end class Graph