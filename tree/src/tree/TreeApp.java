package tree;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class TreeApp {
	public static void main(String[] args) throws IOException {
		Scanner myinput = new Scanner(System.in);
		int value;
		Tree theTree = new Tree();
		theTree.insert(50, 1.5);
		theTree.insert(25, 1.2);
		theTree.insert(75, 1.7);
		theTree.insert(12, 1.5);
		theTree.insert(37, 1.2);
		theTree.insert(43, 1.7);
		theTree.insert(30, 1.5);
		theTree.insert(33, 1.2);
		theTree.insert(87, 1.7);
		theTree.insert(93, 1.5);
		theTree.insert(97, 1.5);


		ArrayList<Integer> inOrderArray = new ArrayList<Integer>();
	    int i = 0;

		while (true) {
			
			System.out.print(
					"\nMenu: \n1. Traverse\n2. isBST\n3. Delete\n4. Display Tree by Levels\n5. Display my Childs\n6. Insert a New Node\n7. Display All the Leaves");
			int choice = myinput.nextInt();
			switch (choice) {

			case 1:
				System.out.println("Traverse type: 1. pre-order, 2. in-order, 3. post-order");
				int traverseType = myinput.nextInt();
				theTree.traverse(traverseType);
				break;
			case 2:
				System.out.println("Check if the tree is a BST");
				System.out.print(theTree.isBST(theTree.getRoot(),i,inOrderArray));
				for (int j = 0; j <inOrderArray.size(); j++) {
					System.out.print(inOrderArray.get(j));
				}
				break;
			case 3:
				System.out.println("Enter value to delete: ");
				value = myinput.nextInt();
				boolean didDelete = theTree.delete(value);
				if (didDelete)
					System.out.println("Deleted " + value + '\n');
				else
					System.out.println("Could not delete ");
				System.out.print(value + '\n');
				break;
			case 4:
				System.out.println("Display tree by level:");
				theTree.displayTreeLevels();
				break;
			case 5:
				System.out.println("Enter the iData");
				int id = myinput.nextInt();
				System.out.println("Enter the dData");
				double dd = myinput.nextDouble();
				theTree.displaymyChilds(id, dd);
				break;
			case 6:
				System.out.println("Enter iData to insert: ");
				int Id = myinput.nextInt();
				System.out.println("Enter dData to insert: ");
				double Dd = myinput.nextDouble();
				theTree.insert(Id, Dd);
				break;
			case 7:
				theTree.displayLeaves(theTree.getRoot());
				break;

			default:
				System.out.print("Invalid entry\n");
			} 
			
		}

	}


}
