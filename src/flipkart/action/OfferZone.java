package flipkart.action;

import java.util.ArrayList;

import flipkart.Db.StockDBhandler;

public class OfferZone {
public ArrayList<String> Product=new ArrayList<String>();
//public ArrayList<String> OfferProduct=new ArrayList<String>();
public String execute(){
	try{
		StockDBhandler stockDB = new StockDBhandler();
		Product=stockDB.fetchProduct();
		return "success";
	}catch (Exception e) {
		// TODO: handle exception
		return "failure";
	}
	
}

public String addOffer(){
	try{
		StockDBhandler stockDB = new StockDBhandler();
		stockDB.insertOfferProduct();
		return "success";
	}catch (Exception e) {
		// TODO: handle exception
		return "failure";
	}
}

public String addOfferProduct(){
	try{
		StockDBhandler stockDB = new StockDBhandler();
		stockDB.insertProduct();
		return "success";
	}catch (Exception e) {
		// TODO: handle exception
		return "failure";
	}
}

}
