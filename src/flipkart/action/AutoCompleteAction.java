package flipkart.action;

import java.util.ArrayList;



import com.opensymphony.xwork2.Action;

import flipkart.Model.SearchModel;
import flipkart.Db.DBhandler;
//import flipkart.Db.DataDao;
import flipkart.Model.*;


public class AutoCompleteAction implements Action {
	// Received via Ajax request
	private String term;
	// Returned as responce
	private ArrayList<String> list;
	//JSONArray jsonA=new JSONArray();
	//JSONObject json=new JSONObject();
	 private ArrayList<SearchModel> keywordsList = new ArrayList<SearchModel>();
	public String execute() {
		try {
			
			System.out.println("Parameter from ajax request : - " + term);
			DBhandler dataDao = new DBhandler();
			list = dataDao.getFrameWork(term);System.out.println(list);
			//jsonA.add(list);
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return SUCCESS;
	}
	public String execute1() {
		try {
			System.out.println("Parameter from ajax request : - " + term);
			DBhandler dataDao = new DBhandler();
			keywordsList = dataDao.getKeywordList(term);
			System.out.println("keyword list:"+ keywordsList);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return SUCCESS;
	}

	public ArrayList<SearchModel> getKeywordsList() {
		return keywordsList;
	}
	public void setKeywordsList(ArrayList<SearchModel> keywordsList) {
		this.keywordsList = keywordsList;
	}
	public ArrayList<String> getList() {
		return list;
	}

	public void setList(ArrayList<String> list) {
		this.list = list;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}
	
}
