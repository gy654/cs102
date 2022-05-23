package tree;

import java.util.ArrayList;

public class Tree {

	private Node root;
	

//-------------------------------------------------------------
	public Tree() {
		root = null;
	}
	
	public Node getRoot() {
		return this.root;
	}


//-------------------------------------------------------------
	public Node find(int key) {
		Node current = root;
		while (current.iData != key) {
			if (key < current.iData)
				current = current.leftChild;
			else
				current = current.rightChild;
			if (current == null)
				return null;
		}
		return current;
	}

//-------------------------------------------------------------
	public void insert(int id, double dd) {
		Node newNode = new Node();
		newNode.iData = id; 
		newNode.dData = dd;
		if (root == null) 
			root = newNode;
		else {
			Node current = root; 
			Node parent;
			while (true){
				parent = current;
				if (id < current.iData){
					current = current.leftChild;
					if (current == null){ 
						parent.leftChild = newNode;
						return;
					}
				} 
				else{
					current = current.rightChild;
					if (current == null){ 
						parent.rightChild = newNode;
						return;
					}
				} 
			}
		} 
	} 
//-------------------------------------------------------------

	public void traverse(int traverseType) {
		switch (traverseType) {
		case 1:
			System.out.print("\nPreorder traversal: ");
			preOrder(root);
			break;
		case 2:
			System.out.print("\nInorder traversal:  ");
			inOrder(root);
			break;
		case 3:
			System.out.print("\nPostorder traversal: ");
			postOrder(root);
			break;
		}
		System.out.println();
	}

//-------------------------------------------------------------
	public void preOrder(Node localRoot) {
		if (localRoot != null) {
			System.out.print(localRoot.iData + " ");
			preOrder(localRoot.leftChild);
			preOrder(localRoot.rightChild);
		}
	}

//-------------------------------------------------------------
	public void inOrder(Node localRoot) {
		if (localRoot != null) {
			inOrder(localRoot.leftChild);
			System.out.print(localRoot.iData + " ");
			inOrder(localRoot.rightChild);
		}
	}

//-------------------------------------------------------------
	public void postOrder(Node localRoot) {
		if (localRoot != null) {
			postOrder(localRoot.leftChild);
			postOrder(localRoot.rightChild);
			System.out.print(localRoot.iData + " ");
		}
	}

//-------------------------------------------------------------
	//this method will take a tree as an input and will PRINT to the screen if the tree is a BST or NOT.

	
	public boolean isBST(Node localRoot,int i, ArrayList<Integer> inOrderArray){
		

		if (localRoot != null){
			isBST(localRoot.leftChild, i, inOrderArray);
			inOrderArray.add(localRoot.iData);
			
			if( i!=0 && inOrderArray.get(i) < inOrderArray.get(i-1)){
				System.out.println("The tree is not a BST");
				return false;
			}
			i++;
			isBST(localRoot.rightChild, i, inOrderArray);
			
		}
		return true;
	}
//-------------------------------------------------------------
	
	

//delete node with given key (iData) (if there are multiple nodes match key with iData you have to delete all of them.

	public boolean delete(int key) {
		Node current = root;
		Node parent = root;
		Boolean isLeftChild = true;
		while (current.iData != key) {
			parent = current;
			if (key < current.iData) {
				current = current.leftChild;
				isLeftChild = true;
			} else {
				current = current.rightChild;
				isLeftChild = false;
			}
			if (current == null) {
				return false;
			}
		}
		if (current.leftChild == null && current.rightChild == null) {
			if (current == root) {
				root = null;
			} else if (isLeftChild) {
				parent.leftChild = null;
			} else {
				parent.rightChild = null;
			}
		} else if (current.leftChild == null) {
			if (current == root) {
				root = current.rightChild;
			} else if (isLeftChild) {
				parent.leftChild = current.rightChild;
			} else {
				parent.rightChild = current.rightChild;
			}

		} else if (current.rightChild == null) {
			if (current == root) {
				root = current.rightChild;
			} else if (isLeftChild) {
				parent.leftChild = current.leftChild;
			} else {
				parent.rightChild = current.leftChild;
			}

		} else {
			Node successor = getSuccessor(current);
			if (current == root) {
				root = successor;
			} else if (isLeftChild) {
				parent.leftChild = successor;
			} else {
				parent.rightChild = successor;
			}
			successor.leftChild = current.leftChild;
		}
		return true;

	} 

//-------------------------------------------------------------
	private Node getSuccessor(Node delNode) {
		Node successorParent = delNode;
		Node successor = delNode;
		Node current = delNode.rightChild;
		while (current != null) {
			successorParent = successor;
			successor = current;
			current = current.leftChild;
		}

		if (successor != delNode.rightChild) {
			successorParent.leftChild = successor.rightChild;
			successor.rightChild = delNode.rightChild;
		}
		return successor;
	}
//   -----------------------------------------------------------
	public void displayTreeLevels() {
		int total = totalLevel(root);
		for (int j = 1; j < total+1; j++) {
			System.out.println("\nLevel" + j + ": ");
			printLevel(root, j);
		}
	}

	public int totalLevel(Node LocalRoot) {
		if (LocalRoot == null) {
			return 0;
		} else if (LocalRoot.leftChild == null && LocalRoot.rightChild == null){
			return 1;
		}
		int l1 = totalLevel(LocalRoot.leftChild);
		int l2 = totalLevel(LocalRoot.rightChild);
		if (l1 < l2) {
			return l2 + 1;
		} else {
			return l1 + 1;
		}
	}

	

	public void printLevel(Node root, int level) {
		if (root == null) {
			return;
		}
		if (level == 1) {
			root.displayNode();
		} else if (level > 1) {
			printLevel(root.leftChild, level - 1);
			printLevel(root.rightChild, level - 1);
		}
	}

//-------------------------------------------------------------
//given a node who idata is id and dd is ddata display it children in the following way:
	public void displaymyChilds(int id, double dd) {

		Node parent = find(id);
		if (parent.dData != dd) {
			System.out.println("No such node in the tree");
		} else {
			Node lc = parent.leftChild;
			Node rc = parent.rightChild;
			if (lc == null && rc == null) {
				System.out.println("The node do not have any child");
			} else if (lc == null) {
				System.out.println("The node does not have a left child");
				System.out.println("Right child: iData: " + rc.iData + " dData: " + rc.dData);
			} else if (rc == null) {
				System.out.println("Left child: iData: " + lc.iData + " dData: " + lc.dData);
				System.out.println("The node does not have a right child");
			} else {
				System.out.println("Left child: iData: " + lc.iData + " dData: " + lc.dData);
				System.out.println("Right child: iData: " + rc.iData + " dData: " + rc.dData);
			}

		}
	}

//-------------------------------------------------------------
//this method will display all the leaves (iData and dData) of all the leaves)
	public void displayLeaves(Node root) {
		if (root == null) {
			return;
		}
		if (root.leftChild == null && root.rightChild == null) {
			System.out.println("iData: " + root.iData + " ,dData: " + root.dData);
		}
		if (root.leftChild != null) {
			displayLeaves(root.leftChild);
		}
		if (root.rightChild != null) {
			displayLeaves(root.rightChild);

		}
	}

//-------------------------------------------------------------

}  // end class Tree