package linkedlist;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class LinkList {
	private Link first; // ref to first link on list

// -------------------------------------------------------------
	public LinkList() // constructor
	{
		first = null; // no links on list yet
	}

// -------------------------------------------------------------
	public boolean isEmpty() // true if list is empty
	{
		return (first == null);
	}

// -------------------------------------------------------------
// insert at start of list
	public void insertFirst(int id, double dd) {
		Link new_link = new Link(id, dd);
		new_link.next = first;
		first = new_link;
	}

// -------------------------------------------------------------
	public Link deleteFirst() {
		if (first == null) {
			throw new NoSuchElementException();
		} else {
			Link temp = first;
			first = first.next;
			return temp;
		}

	}

// -------------------------------------------------------------
	public void displayList() {
		if (first == null) {
			throw new NoSuchElementException();
		} else {
			Link temp = first;
			while (temp.next != null) {
				temp.displayLink();
				temp = temp.next;
			}
			temp.displayLink();

		}

	}

// -------------------------------------------------------------
	public void displaytheLastNODEiData() {
		if (first == null) {
			throw new NoSuchElementException();
		} else {
			Link temp = first;
			while (temp.next != null) {
				temp = temp.next;
			}
			System.out.println(temp.iData);
		}
	}

// ------------------------------------------------------------- 

	public int findMin() {
		if (first == null) {
			throw new NoSuchElementException();
		} else {
			int min = first.iData;
			Link temp = first;
			while (temp.next != null) {
				temp = temp.next;
				if (temp.iData < min) {
					min = temp.iData;
				}
			}
			return min;
		}

	}

// ------------------------------------------------------------- 

	public void DeleteElementwithiData(int a) {
		Link previous = first;
		Link current = first;
		if (first == null) {
			throw new NoSuchElementException();
		} else {
			while (current.next != null) {
				if (current.iData == a) {
					previous.next = current.next;
					current = previous.next;
				} else {
					previous = current;
					current = current.next;
				}
			}

		}

	}

// ------------------------------------------------------------- 

	public void removeDuplicates() {
		Link previous = first;
		Link current = first;
		ArrayList<Object> num = new ArrayList<Object>();
		while (current.next != null) {
			if (!num.contains(current.iData)) {
				num.add(current.iData);
				previous = current;
				current = current.next;
			} else {
				previous.next = current.next;
				current = previous.next;
			}
		}

		// this method will scan through the list and remove
		// duplicates. (if the list is: 2->3->2->4->3->5->90 the method should
		// keep on copy of each duplicate, so the list become:
		// 2->3->4->5-90
		// if there are no duplicates then the method does not need do anything

	}

// -------------------------------------------------------------

	public void sortList() {
		Link current = first;
		if (first == null) {
			throw new NoSuchElementException();
		} else {
			while (current != null) {
				Link index = current.next;
				while (index != null) {
					if (current.iData > index.iData) {
						int temp = current.iData;
						current.iData = index.iData;
						index.iData = temp;
						double temp2 = current.dData;
						current.dData = index.dData;
						index.dData = temp2;
					}
					index = index.next;
				}
				current = current.next;
			}
		}

	}

}

// end class LinkList
////////////////////////////////////////////////////////////////