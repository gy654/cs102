import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class application {
	static Scanner myinput = new Scanner(System.in);
	public static void main(String args[]) {
		
		System.out.println("Is this the first time you use the program? 1 for yes and 0 for no");
		int answer = myinput.nextInt();
		courseDirectory course_directory = new courseDirectory();
		course_directory.setDirectory(loadCourseData(answer));
		studentDirectory student_directory = new studentDirectory();
		student_directory.setDirectory(deserialize_student(answer,"student.ser"));

		
		
		int selection = 0;
		do {
			selection = display_main_menu();

			if (selection == 2) {
				
				System.out.println("Username: ");
				String user = myinput.next();
				System.out.println("Password: ");
				String entered_password = myinput.next();
				student st = new student();
				for (int i =0; i < student_directory.getDirectory().size(); i++) {
					if (student_directory.getDirectory().get(i).getUsername().equals(user)) {
						st = student_directory.getDirectory().get(i);
					}
				}
				
				if (!entered_password.equals(st.getPassword())) {
					System.out.println("wrong password.");
					System.exit(0);
				} else {
				int choice = 0;
				do {
					choice = display_student_menu();
					switch (choice) {
					case 1:
						System.out.println("View all courses: ");
						st.view_all_course(course_directory);
						break;
					case 2:
						System.out.println("View all courses that are not full: ");
						st.view_all_not_full_courses(course_directory);
						break;
					case 3:
						System.out.println("Register on a course: ");
						System.out.println("Enter the course id of the course you want to register: ");
						String course_id = myinput.next();
						System.out.println("Enter the section number: ");
						int se = myinput.nextInt();
						int count = 0;
						for (int i = 0; i < course_directory.getDirectory().size(); i++) {
							if (course_directory.getDirectory().get(i).getCourse_id().equals(course_id)
									&& !course_directory.getDirectory().get(i).isfull() && course_directory.getDirectory().get(i).getSection() == se) {
								course a = course_directory.getDirectory().get(i);
								st.register(a);
								count++;
								System.out.println("Registered successfully");
							}
						}
						if (count == 0) {
							System.out.println("No such course found");
						}
						break;
					case 4:
						System.out.println("Withdraw from a course");
						System.out.println("Enter the course id of the course you want to withdraw: ");
						String id2 = myinput.next();
						System.out.println("Enter the section number: ");
						int secti = myinput.nextInt();
						int count2 = 0;
						for (int i = 0; i < st.getCourse_registered().size(); i++) {
							if (st.getCourse_registered().get(i).getCourse_id().equals(id2) && st.getCourse_registered().get(i).getSection() ==secti) {
								course a = st.getCourse_registered().get(i);
								st.withdraw(a);
								count2++;
								System.out.println("The course is successfully deleted.");
							}
						}
						if (count2 == 0) {
							System.out.println("No such course found");
						}

						break;
					case 5:
						System.out.println("View all courses that the current student is being registered in");
						st.course_registered();
						break;

					}
				} while (choice != 6);
				System.out.println("good bye!");
				} 
			}else if (selection == 1) {
				int choice = 0;
				String password = "Admin001";
				System.out.println("Please enter the password for Admin");
				String entered_password = myinput.next();
				if (!entered_password.equals(password)) {
					System.out.println("wrong password.");
					System.exit(0);
				} else {	
					administrator admin = new administrator();
					do {
						choice = display_administrator_menu();
						switch (choice) {
						case 1:
							System.out.println("View all courses");
							admin.view_all_course(course_directory);
							break;
						case 2:
							System.out.println("View all courses that are full");
							admin.view_all_full_courses(course_directory);
							break;
						case 3:
							System.out.println("Write to a file the list of course that are full");
							admin.write_full_file(course_directory);
							break;
						case 4:
							System.out.println("View the names of the students being registered in a course");
							System.out.println(
									"Enter the course id of the course you want to know registered students: ");
							String id2 = myinput.next();
							System.out.println("Enter the course section number:");
							int sec = myinput.nextInt();
							int count3 = 0;
							for (int i = 0; i < course_directory.getDirectory().size(); i++) {
								if (course_directory.getDirectory().get(i).getCourse_id().equals(id2) && course_directory.getDirectory().get(i).getSection() ==sec ) {
									course a = course_directory.getDirectory().get(i);
									admin.view_course_student(a);
									count3++;
								}
							}
							if (count3 == 0) {
								System.out.println("No such course found");
							}
							break;
						case 5:
							System.out.println("View the list of courses that a given student is being registered on");
							System.out.println("Enter the student's first name");
							String fn = myinput.next();
							System.out.println("Enter the last name of the student");
							String ln = myinput.next();
							for(int i = 0; i < student_directory.getDirectory().size(); i++) {
								if (student_directory.getDirectory().get(i).getFirst_name().equals(fn) && student_directory.getDirectory().get(i).getLast_name().equals(ln)) {
									ArrayList <course> courses = student_directory.getDirectory().get(i).getCourse_registered();
									for (int j = 0; j < courses.size(); j++) {
										courses.get(j).printMe();
									}
								}else {
									System.out.println("Student not found");
								}
							}

							break;
						case 6:
							System.out.println(" Sort courses based on the cuurrent number of student registers");
							admin.sort(course_directory);
							break;
						case 8:
							admin.add_student(student_directory);
							System.out.println("The student is added successfully");
							break;
						case 9:
							course_directory.add_course();
							break;
						case 10:
							course_directory.delete();
							break;
						case 11:
							course_directory.editCourse();
							break;
						case 12:
							course_directory.info_course();
							break;
							

						}
					} while (choice != 7);
					System.out.println("return to the main menu");
				}

			}else if (selection ==3){
				serialize(course_directory);
				serialize(student_directory);		
			}
		} while (selection != 4);
		
	}

	
	public static ArrayList<course> loadCourseData(int a) {	
		
		ArrayList<course> courses = new ArrayList<course>();

		if (a ==1) {
			String fileName = "MyUniversityCoursesFile.csv";
			String line = null;
			try {
				FileReader fileReader = new FileReader(fileName);
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				bufferedReader.readLine();

				while ((line = bufferedReader.readLine()) != null) {
					String [] Data = line.split(",");
					course read_course = new course(Data[0],Data[1] ,Integer.parseInt(Data[2]), Integer.parseInt(Data[3]), Data[5], Integer.parseInt(Data[6]), Data[7]);	
					courses.add(read_course);
				}
				bufferedReader.close();
		
			} catch (FileNotFoundException ex2) {
				System.out.println("file not found");

			} catch (IOException ex3) {
				System.out.println("IO Exception");
				ex3.printStackTrace();

			}
		}else {
			String fn_course = "course.ser";
			String line_course = null;
			courses= deserialize_course(fn_course);
		}
		
		return courses;
		
	}
	
	

	
	
	
	public static int display_main_menu() {
		System.out.println("1. Administrator\n"+
				"2. Student\n"+
				"3. Serialization\n"+
				"4. Exit\n");
		int answer = myinput.nextInt();
		return answer;
	}
	
	
	
	public static int display_student_menu() {
		System.out.println("1. View all courses\n "
				+ "2. View all courses that are not full\n "
				+ "3. Register on a course\n "
				+ "4. Withdraw from a course\n "
				+ "5. View all courses that the current student is being registered in\n "
				+ "6. Return to the main menu\n");
		int choice = myinput.nextInt();
		return choice;
	}
	
	
	public static int display_administrator_menu() {
		System.out.println(" 1. View all courses\n "
				+ "2. View all courses that are full\n "
				+ "3. Write to a file the list of course that are full\n "
				+ "4. View the names of the students being registered in a specific course\n "
				+ "5. View the list of courses that a given student is being registered on\n "
				+ "6. Sort courses based on the cuurrent number of student registers\n"
				+ "7. Return to the main menu\n"
				+ "8. Add student\n"
				+ "9. Create a new course\n"
				+ "10. Delete a course\n"
				+ "11. Edit a course\n"
				+ "12. Display info for a given course\n"
				);
		int choice = myinput.nextInt();
		return choice;
	}
	
	
	public static void serialize(studentDirectory a){
		ArrayList<student> ser = a.getDirectory();
		try {
			//FileOutput Stream writes data to a file
			FileOutputStream fos = new FileOutputStream("student.ser");
			
			//ObjectOutputStream writes objects to a stream (A sequence of data)
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			//Writes the specific object to the OOS

			oos.writeObject(ser);
				// Close both streams
			oos.close();
			fos.close();	
			System.out.println("Serialization complete");
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
	}
	
	
	public static void serialize(courseDirectory a){
		ArrayList<course> ser = a.getDirectory();
		try {
			//FileOutput Stream writes data to a file
			FileOutputStream fos = new FileOutputStream("course.ser");
			
			//ObjectOutputStream writes objects to a stream (A sequence of data)
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			//Writes the specific object to the OOS
		
			oos.writeObject(ser);
			// Close both streams
			oos.close();
			fos.close();
			
			System.out.println("Serialization complete");
		} 
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
	}
	
	
	public static ArrayList<student> deserialize_student(int a, String fn) {
		ArrayList<student> de = new ArrayList<student>();
		if (a ==1) {
			return de;
		}else {
			try {
				FileInputStream fis = new FileInputStream(fn);
				ObjectInputStream ois = new ObjectInputStream(fis);
				de = (ArrayList<student>) ois.readObject();
				ois.close();
				fis.close();

			} catch (IOException ioe) {
				ioe.printStackTrace();
				
			} catch (ClassNotFoundException ex) {
				ex.printStackTrace();
			}
			return de;
		}
					
	}
	
	
	public static ArrayList<course> deserialize_course(String fn) {
		ArrayList<course> de = null;
		try {
			FileInputStream fis = new FileInputStream(fn);
			ObjectInputStream ois = new ObjectInputStream(fis);
			de = (ArrayList<course>) ois.readObject();
			ois.close();
			fis.close();
			return de;
		} catch (IOException ioe) {
			String fileName = "MyUniversityCoursesFile.csv";
			String line = null;
			try {
				FileReader fileReader = new FileReader(fileName);
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				bufferedReader.readLine();

				while ((line = bufferedReader.readLine()) != null) {
					String [] Data = line.split(",");
					course read_course = new course(Data[0],Data[1] ,Integer.parseInt(Data[2]), Integer.parseInt(Data[3]), Data[5], Integer.parseInt(Data[6]), Data[7]);	
					de.add(read_course);
				}
				bufferedReader.close();
			} catch (FileNotFoundException ex2) {
				System.out.println("file not found");
			} catch (IOException ex3) {
				System.out.println("IO Exception");
				ex3.printStackTrace();
			}
			ioe.printStackTrace();
			return de;
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
			return de;
		}
		

	}
}


