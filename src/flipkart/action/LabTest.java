package flipkart.action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import flipkart.Db.DBhandler;
import flipkart.Model.LabTestModel;

public class LabTest extends ActionSupport implements ModelDriven<LabTestModel> {
	LabTestModel lm=new LabTestModel();
	ArrayList<LabTestModel> array=new ArrayList<LabTestModel>();
	
	public ArrayList<LabTestModel> getArray() {
		return array;
	}
	public void setArray(ArrayList<LabTestModel> array) {
		this.array = array;
	}
	DBhandler db=new DBhandler();
public String execute(){
	System.out.println("inside the execute method");
	array=db.fetchProduct();
	return "success";
}
@Override
public LabTestModel getModel() {
	// TODO Auto-generated method stub
	return lm;
}
}
