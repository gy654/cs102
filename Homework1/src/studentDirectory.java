import java.util.ArrayList;
import java.util.Scanner;

import apple.laf.JRSUIConstants.Direction;

public class studentDirectory {
	static Scanner myinput = new Scanner(System.in);
	private ArrayList<student> directory = new ArrayList<student>(); 
	
	
	studentDirectory(){
		
	}
	

	
	public void add_student(student a) {
		directory.add(a);
	}
	
	public void remove_student(student a) {
		directory.remove(a);
	}
	
	public void edit_student_directory(int a) {
		System.out.println("Enter the id of the student whom you would like to edit: ");
		int student_id = myinput.nextInt();
		for (int i =0; i < directory.size(); i++) {
			if (directory.get(i).getStudent_id() == student_id) {
				System.out.println("Enter the firstname: ");
				String firstname = myinput.next();
				System.out.println("Enter the lastname: ");
				String lastname = myinput.next();
				System.out.println("Enter the student id: ");
				int id = myinput.nextInt();
				student changed_student = new student(firstname, lastname, id);
				directory.set(i, changed_student);
			}
		}
		
	}

	public ArrayList<student> getDirectory() {
		return directory;
	}



	public void setDirectory(ArrayList<student> directory) {
		this.directory = directory;
	}




}
