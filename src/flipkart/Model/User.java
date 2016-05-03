package flipkart.Model;

import java.util.Map;

public class User {
	private String email;  //U_ID in DB
	private String password;//PASSWORD in DB 
	private String role; //ROLE in DB
	private String fname;// F_NAME in DB
	
	
		
	
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public User(String email2, String password2, String user_id) {
		super();
		this.email = email2;
		this.password = password2;
		this.email = user_id;
	
		// TODO Auto-generated constructor stub
	}
	public User() {
		// TODO Auto-generated constructor stub
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
}
