import java.util.ArrayList;
import java.io.Serializable;
public class course implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String course_name;
	private String course_id;
	private int course_capacity;
	private int current_student;
	private ArrayList <student> studentList = new ArrayList<student>();
	private String instructor;
	private int section;
	private String location;
	
	// constructor
	public course(){
	}
	
	public course(String a, String b, int c, int d,String f, int g, String h) {
		this.course_name = a;
		this.course_id = b;
		this.course_capacity = c;
		this.current_student = d;
		this.instructor = f;
		this.section = g;
		this.location = h;
		
	}
	
	
	// getters and setters

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public String getCourse_id() {
		return course_id;
	}

	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}

	public int getCourse_capacity() {
		return course_capacity;
	}

	public void setCourse_capacity(int course_capacity) {
		this.course_capacity = course_capacity;
	}

	public int getCurrent_student() {
		return current_student;
	}

	public void setCurrent_student(int current_student) {
		this.current_student = current_student;
	}


	public String getInstructor() {
		return instructor;
	}

	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}

	public int getSection() {
		return section;
	}

	public void setSection(int section) {
		this.section = section;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	
	// this method checks if the course is full
	public boolean isfull() {
		if (course_capacity == current_student) {
			return true;
		} else {
			return false;
		}
	}
	
	// this method adds student to the course
	public void add_student(student a) {
		if(current_student + 1 > course_capacity) {
			System.out.println("Course is full");
		}else {
			studentList.add(a);
			current_student ++;
		}
	}
	
	// this method removes a student from the course
	public void remove_student(student a) {
		studentList.remove(a);
		current_student --;
	}
	
	// this method display all students registered in the course
	public void display_student() {
		for (int i = 0; i < studentList.size(); i++){
			studentList.get(i).student_info();
		}
	}
	
	public ArrayList<student> getStudentList() {
		return studentList;
	}
	
	

	public void setStudentList(ArrayList<student> studentList) {
		this.studentList = studentList;
	}

	// this method display the information of this course
	public void printMe() {
		System.out.println("CourseName: "+ course_name);
		System.out.println("Courseid: "+ course_id);
		System.out.println("Section number: "+ section);
		System.out.println("Number of student registered: "+current_student);
		System.out.println("Maximum number of students allowed to be registered"+ course_capacity);
		System.out.println("________________________");
	}

}
