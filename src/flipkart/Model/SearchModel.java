package flipkart.Model;

import java.util.ArrayList;

public class SearchModel {
	 public String productId, productName;
	 private int count;
	 public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	
	public String result="m geeta";
	 ArrayList<String> item=new ArrayList<String>();

	public ArrayList<String> getItem() {
		return item;
	}

	public void setItem(ArrayList<String> item) {
		this.item = item;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}


}
