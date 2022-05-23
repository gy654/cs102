
public abstract class user {
	
	protected String username;
	protected String password;
	protected String first_name;
	protected String last_name;
	
	
	public user(){	
	}
	
	public user(String a, String b, String c, String d) {
		this.username = a;
		this.password = b;
		this.first_name = c;
		this.last_name =d;
	}
	
	// user can view all course information
	public void view_all_course(courseDirectory a) {
		a.all_course();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirst_name() {
		
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	
	public abstract void withdraw();
	
	public abstract void register();
	
	

}
