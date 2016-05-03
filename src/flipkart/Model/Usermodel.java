package flipkart.Model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Map;


public class Usermodel {
	    private String uid;
	    private String status;
		private String firstname;
		private String lastname;
		private String mobno;
		private String landlineno;
		private String gender;
		private String password;
		private String newpassword;
		private String newemail;
		private String address;
		private String city;
		private String pincode;
        private String email;
        private Date order_date, delievry_date;
        private int orderid;
        long days_ago;
        ArrayList<Integer> arr =new  ArrayList<Integer>();
        private int Selectarr;
        private String Offer_name;
        private String Offer_Product;
        
        
   
        //private String Status;
        private String Status1;
        
        public String getStatus1() {
			return Status1;
		}
		public void setStatus1(String status1) {
			Status1 = status1;
		}
		public int getSelectarr() {
			return Selectarr;
		}
		public void setSelectarr(int selectarr) {
			Selectarr = selectarr;
		}
		public ArrayList<Integer> getArr() {
			return arr;
		}
		public void setArr(ArrayList<Integer> arr) {
			this.arr = arr;
		}
		private String message;
        
        public long getDays_ago() {
			return days_ago;
		}
		public void setDays_ago(long days_ago) {
			this.days_ago = days_ago;
		}
		public Date getOrder_date() {
			return order_date;
		}
		public void setOrder_date(Date order_date) {
			this.order_date = order_date;
		}
		public Date getDelievry_date() {
			return delievry_date;
		}
		public void setDelievry_date(Date delievry_date) {
			this.delievry_date = delievry_date;
		}
		private String phoneno;
		public Map<String,Object> session;
		//public String getOffer_name;

		public String getUid() {
			return uid;
		}
		public void setUid(String uid) {
			this.uid = uid;
		}
		public String getFirstname() {
			System.out.println(firstname);
			return firstname;
		}
		public void setFirstname(String firstname) {
			this.firstname = firstname;
			System.out.println(firstname);
		}
		public String getLastname() {
			return lastname;
		}
		public void setLastname(String lastname) {
			this.lastname = lastname;
		}
		public String getMobno() {
			return mobno;
		}
		public void setMobno(String mobno) {
			this.mobno = mobno;
		}
		public String getLandlineno() {
			return landlineno;
		}
		public void setLandlineno(String landlineno) {
			this.landlineno = landlineno;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public Map<String,Object> getSession() {
			return session;
		}
		public void setSession(Map<String,Object> session) {
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
		public String getNewpassword() {
			return newpassword;
		}
		public void setNewpassword(String newpassword) {
			this.newpassword = newpassword;
		}
		public String getNewemail() {
			
			return newemail;
		}
		public void setNewemail(String newemail) {
			this.newemail = newemail;
			System.out.println(newemail);
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getPincode() {
			return pincode;
		}
		public void setPincode(String pincode) {
			this.pincode = pincode;
		}
		
		public String getPhoneno() {
			return phoneno;
		}
		public void setPhoneno(String phoneno) {
			this.phoneno = phoneno;
		}
		
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public int getOrderid() {
			return orderid;
		}
		public void setOrderid(int orderid) {
			this.orderid = orderid;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		public String getOffer_name() {
			return Offer_name;
		}
		public void setOffer_name(String offer_name) {
			Offer_name = offer_name;
		}
		public String getOffer_Product() {
			return Offer_Product;
		}
		public void setOffer_Product(String offer_Product) {
			Offer_Product = offer_Product;
		}
		
		
	
}