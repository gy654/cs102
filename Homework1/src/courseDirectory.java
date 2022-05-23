import java.util.ArrayList;
import java.util.Scanner;

public class courseDirectory {
	
	
	static Scanner myinput = new Scanner(System.in);
	private ArrayList<course> directory = new ArrayList<course>(); 
	
	
	courseDirectory(){
		
	}

	
	public void add_course(course a) {
		directory.add(a);
	}
	
	public void add_course() {
		System.out.println("Enter the course name:");
		String Name = myinput.nextLine();
		System.out.println("Enter the course id: ");
		String course_id = myinput.nextLine();
		System.out.println("Enter the course capacity: ");
		int course_capacity = myinput.nextInt();
		System.out.println("Enter the number of current student: ");
		int current_student = myinput.nextInt();
		System.out.println("Enter the course instructor: ");
		String instructor = myinput.nextLine();
		instructor = myinput.nextLine();
		System.out.println("Enter the course section number: ");
		int sectionNumber = myinput.nextInt();
		System.out.println("Enter the course location:");
		String courseLocation = myinput.nextLine();
		courseLocation = myinput.nextLine();
		course added_course = new course(Name, course_id, course_capacity, current_student, instructor, sectionNumber, courseLocation);
		directory.add(added_course);
		
		
		
		
	}
	
	//edit a course
	public void editCourse() {

		System.out.println("Enter the course id you want to edit:");
		String id = myinput.next();
		System.out.println("Enter the course section number you want to edit:");
		int courseSectionNumber = myinput.nextInt();
		for (int i = 0; i < directory.size(); i++) {
			if(directory.get(i).getCourse_id().equals(id) && directory.get(i).getSection()==courseSectionNumber) {
				System.out.println("Enter the course name:");
				String Name = myinput.nextLine();
				Name = myinput.nextLine();
				System.out.println("Enter the course id: ");
				String course_id = myinput.nextLine();
				System.out.println("Enter the course capacity: ");
				int course_capacity = myinput.nextInt();
				System.out.println("Enter the number of current student: ");
				int current_student = myinput.nextInt();
				System.out.println("Enter the course instructor:");
				String instructor = myinput.nextLine();
				instructor = myinput.nextLine();
				System.out.println("Enter the course section number:");
				int sectionNumber = myinput.nextInt();
				System.out.println("Enter the course location:");
				String courseLocation = myinput.nextLine();
				courseLocation = myinput.nextLine();
				course changed_course = new course(Name, course_id, course_capacity, current_student, instructor, sectionNumber, courseLocation);
				directory.set(i, changed_course);
				System.out.println("successfully edited.");
			}
			
		}

	}
	
	
	// display all courses
	public void printAll() {
		for(int k = 0; k <directory.size();k++) {
			directory.get(k).printMe();
		}
	}
	
	
	
	// delete a course
	public void delete() {
		System.out.println("Enter the course id you want to delete: ");
		String c_id = myinput.next();
		System.out.println("Enter the section number of the course you want to delete:");
		int se = myinput.nextInt();
		int j = 0;
		for (int i = 0; i < directory.size(); i++) {
			if(directory.get(i).getCourse_id().equals(c_id) && directory.get(i).getSection()== se) {
				directory.remove(i);
				j = 1;
				System.out.println("Successfully deleted");
			}
		}
		if (j == 0) {
			System.out.println("No matching course found");
		}
	}
	
	// sort the directory by the number of student registered and display the,
	public void sort(){
		for (int k =0; k < directory.size(); k++) {
			int index = k;
			for (int m = k+1; m<directory.size(); m++) {
				if(directory.get(m).getCurrent_student()<directory.get(index).getCurrent_student()) {
					index = m;
				}
			}
			course smaller = directory.get(index);
			directory.set(index, directory.get(k));
			directory.set(k, smaller);
		}
		for (int k =0; k < directory.size(); k++) {
			directory.get(k).printMe();
		}
		
	}
	
	// display all the courses
	public void all_course() {
		for (int i = 0; i < directory.size(); i++) {
			directory.get(i).printMe();
		}
	}



	
	// print out courses not full;
	public void course_not_full() {
		for (int k =0; k < directory.size(); k++) {
			if (! directory.get(k).isfull()) {
				directory.get(k).printMe();	
			}
		}	
	}
	
	public ArrayList<course> getDirectory() {
		return directory;
	}


	public void setDirectory(ArrayList<course> directory) {
		this.directory = directory;
	}


	// print out courses that are full
	public void course_full() {
		for (int k =0; k < directory.size(); k++) {
			if (directory.get(k).isfull()) {
				directory.get(k).printMe();
			}
		}	
	}

	public void info_course() {
		System.out.println("Enter the course id that you want more information about: ");
		String id = myinput.next();
		System.out.println("Enter the section number: ");
		int sec = myinput.nextInt();
		for (int i = 0; i < directory.size(); i++) {
			if(directory.get(i).getCourse_id().equals(id) && directory.get(i).getSection()==sec){
				directory.get(i).printMe();
			}
		}
		
	}
}
