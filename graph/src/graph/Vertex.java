package graph;

public class Vertex{
	public char label;        // label (e.g. 'A')
	public boolean wasVisited;
	public int friends_club_number;
	public boolean isArticulation;

//------------------------------------------------------------
	public Vertex(char lab) {   // constructor
		label = lab;
		wasVisited = false;
		friends_club_number= -1; //they belong yet.
		isArticulation = false;
	
   }
	
	public char getLabel() {
		return this.label;
	}
//------------------------------------------------------------
}  // end class Vertex