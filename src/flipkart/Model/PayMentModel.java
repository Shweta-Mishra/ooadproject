package flipkart.Model;

public class PayMentModel {
	 String cvv1;
	String card1,balance,month,year;
	private String Bank_ID,Bank_Password,S_price,S_stock,S_originalStock;
	public String getS_price() {
		return S_price;
	}

	public void setS_price(String s_price) {
		S_price = s_price;
	}

	public String getS_stock() {
		return S_stock;
	}

	public void setS_stock(String s_stock) {
		S_stock = s_stock;
	}

	public String getS_originalStock() {
		return S_originalStock;
	}

	public void setS_originalStock(String s_originalStock) {
		S_originalStock = s_originalStock;
	}

	private int flag;
	
	public String getCard1() {
		return card1;
	}

	public void setCard1(String card1) {
		System.out.println("I am in the setter of the Card");
		this.card1 = card1;
	}

	

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getCvv1() {
		System.out.println("I am in the getter of the cvv");
		
		return cvv1;
	}

	public void setCvv1(String cvv1) {
		System.out.println("I am in the setter of the cvv");
		this.cvv1 = cvv1;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public String getBank_ID() {
		return Bank_ID;
	}

	public void setBank_ID(String bank_ID) {
		Bank_ID = bank_ID;
	}

	public String getBank_Password() {
		return Bank_Password;
	}

	public void setBank_Password(String bank_Password) {
		Bank_Password = bank_Password;
	}





}