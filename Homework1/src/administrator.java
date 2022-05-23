import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class administrator extends user implements Admin{
	static Scanner myinput = new Scanner(System.in);
	
	public administrator(){
		super();
	}
	
	public administrator(String a, String b) {
		super("Admin","Admin001",a,b);
	}
	
	public void view_all_full_courses(courseDirectory a) {
		a.course_full();
	}
	
	
	public void write_full_file(courseDirectory a) {
		String fileName = "full_courses.txt";
		try{
			FileWriter fileWriter = new FileWriter(fileName);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			int count = 0;
			bufferedWriter.write("Courses that are full: ");
			for (int k =0; k < a.getDirectory().size(); k++) {
				if (a.getDirectory().get(k).isfull()) {
					bufferedWriter.write(a.getDirectory().get(k).getCourse_name()+' '+a.getDirectory().get(k).getCourse_id());
					bufferedWriter.newLine();
					count ++;
				}
			}
			if (count == 0 ) {
				bufferedWriter.write("No course is full");
			}
			bufferedWriter.close();
		}

		//Always close files

		catch (IOException exk) {
			System.out.println( "Error writing file '" + fileName + "'");
			exk.printStackTrace();
		}
	}

	public void view_course_student(course a) {
		a.display_student();
	}
	
	public void view_student_course(String a, String b, studentDirectory c) {
		int count = 0;
		for (int i = 0; i < c.getDirectory().size(); i++) {
			if(c.getDirectory().get(i).getFirst_name().equals(a) && c.getDirectory().get(i).getLast_name().equals(b)) {
				c.getDirectory().get(i).course_registered();

				count ++;
			}
		}
		if(count ==0) {
			System.out.println("No such student found");
		}
	}
	
	public void view_student_course(int a, studentDirectory c) {
		int count = 0;
		for (int i = 0; i < c.getDirectory().size(); i++) {
			if(c.getDirectory().get(i).getStudent_id()==a) {
				c.getDirectory().get(i).course_registered();
				count ++;
			}
		}
		if(count ==0) {
			System.out.println("No such student found");
		}
	}
	
	public void sort(courseDirectory a) {
		a.sort();
		System.out.println("Courses are sorted accoding to the current number of students in the course");
	}
	
	public void add_student(studentDirectory stu_dir) {
		System.out.println("first name of the student: ");
		String fn = myinput.next();
		System.out.println("last name of the student: ");
		String ln = myinput.next();
		System.out.println("student id: ");
		int id = myinput.nextInt();
		System.out.println("username: ");
		String user = myinput.next();
		System.out.println("password: ");
		String pass = myinput.next();
		student stu = new student(user, pass, fn, ln, id);
		stu_dir.add_student(stu);
		
	}
	
	public void withdraw(student a, String b, int d, courseDirectory c) {
		for(int i =0; i <c.getDirectory().size(); i ++ ) {
			if(c.getDirectory().get(i).getCourse_id().equals(b) &&c.getDirectory().get(i).getSection()==d) {
				c.getDirectory().get(i).remove_student(a);
			}
		}
		
	}
	
	public void register_student(student a, String b, int d, courseDirectory c) {
		for(int i =0; i <c.getDirectory().size(); i ++ ) {
			if(c.getDirectory().get(i).getCourse_id().equals(b) && ! c.getDirectory().get(i).isfull() && c.getDirectory().get(i).getSection()==d) {
				c.getDirectory().get(i).add_student(a);
			}
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
