package flipkart.Model;

import java.util.Map;

public class LoginModel {
	private String email;  //U_ID in DB
	private String password;//PASSWORD in DB 
	
	public Map<String,Object> session;

	
	
	
	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
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
	

}
