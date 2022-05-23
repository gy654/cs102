import java.util.ArrayList;
import java.io.Serializable;

public class student extends user implements stu ,Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int student_id;
	private ArrayList<course> course_registered = new ArrayList<course>();
	
	
	// constructors
	public student() {
		super();
	}
	
	public student( String a, String b, int c) {
		this.first_name = a;
		this.last_name = b;
		this.student_id =c;
	}
	
	public student( String a, String b, String c, String d, int e) {
		this.username = a;
		this.password = b;
		this.first_name = c;
		this.last_name = d;
		this.student_id =e;
	}
	
	public student( String a, String b) {
		this.first_name = a;
		this.last_name = b;
	}
	
	// getters and setters
	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	
	// print student info
	public void student_info() {
		System.out.println("first name: "+ first_name);
		System.out.println("last name: "+ last_name);
		System.out.println("student id: "+ student_id);
	}
	
	// implement the stu interface

	public void view_all_not_full_courses(courseDirectory a) {
		a.course_not_full();
	}
	
	public void register(course a) {
		course_registered.add(a);
		student b = new student(this.first_name,this.last_name,this.student_id);
		a.add_student(b);
	}
	
	
	public void withdraw(course a) {
		course_registered.remove(a);
		student b = new student(this.first_name,this.last_name,this.student_id);
		a.remove_student(b);
	}
	
	public ArrayList<course> getCourse_registered() {
		return course_registered;
	}

	public void setCourse_registered(ArrayList<course> course_registered) {
		this.course_registered = course_registered;
	}

	public void course_registered() {
		for(int i =0; i < course_registered.size(); i++) {
			course_registered.get(i).printMe();
		}
	}

	@Override
	public void withdraw() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void register() {
		// TODO Auto-generated method stub
		
	}

}
