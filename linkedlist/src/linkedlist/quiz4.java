package linkedlist;


public class quiz4
   {
   public static void main(String[] args)
      {
      LinkList theList = new LinkList();  // make new list
      //this code is for you to use to test you code
      //feel free to modify it. 

          // insert four items
      theList.insertFirst(55, 5.99);
      theList.insertFirst(44, 4.99);
      theList.insertFirst(22, 2.99);  
      theList.insertFirst(66, 6.99);
      theList.insertFirst(99, 9.99);
      theList.insertFirst(88, 8.99);
      theList.insertFirst(66, 6.99);
      theList.insertFirst(88, 8.99);
      theList.insertFirst(44, 4.99);
      theList.insertFirst(99, 9.99);
      //theList.displayList();
      //theList.deleteFirst();
      //theList.displayList();
      //theList.displaytheLastNODEiData();
      //int min = theList.findMin();
      //System.out.println("minumum of iData: "+min);
      //theList.DeleteElementwithiData(66);
      //System.out.println("\nafter deleting links with iData = 66\n");
      //theList.displayList();
      theList.removeDuplicates();
      System.out.println("\nafter removing duplicates:\n");
      theList.displayList();
      //theList.sortList();
      //System.out.println("\nafter sorting\n");
      //theList.displayList();
      //... add more elements if you want..

      //CALL and TEST YOUR METHODS HERE 
      

                 
      }  // end main()
   }  // end class LinkListApp
////////////////////////////////////////////////////////////////

