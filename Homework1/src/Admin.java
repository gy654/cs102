
public interface Admin {
	
	public void view_all_full_courses(courseDirectory a);
	public void write_full_file(courseDirectory a);
	public void view_course_student(course a);
	public void view_student_course(String a, String b, studentDirectory c);
	public void sort(courseDirectory a);
	public void add_student(studentDirectory stu_dir);
	public void register_student(student a, String b, int d, courseDirectory c);
	
	

}
