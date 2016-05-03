package flipkart.action;

import java.sql.SQLException;
import java.util.ArrayList;








import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import flipkart.Db.*;
import flipkart.Model.*;

public class AddDetailAction extends ActionSupport implements ModelDriven<AddDetailModel>{

	AddDetailModel addDetailModel = new AddDetailModel();
	private static final long serialVersionUID = 1L;
	CartDBhandler cdb=new CartDBhandler();
	public String execute() throws ClassNotFoundException, SQLException{
		
		System.out.println("verify Email Here");
		
		productDescriptionDB.User_Id = addDetailModel.getEmail();
		
		AddDetailDb verifyDetail = new AddDetailDb();
		int i = verifyDetail.LoginDetail(addDetailModel);
		cdb.ChangeUserAfterLogin(addDetailModel.getEmail());
		if(i==0){
			addDetailModel.setEmail(null);
			System.out.println(addDetailModel.getEmail()+"after");
			System.out.println("I am Failure");
		return "success";
		}
		else{
			addDetailModel.setFlag(1);
			System.out.println("I am succsess");
			return "success";
		}
	}
public String CartCheck() throws ClassNotFoundException, SQLException{
		
		System.out.println("verify Email Here");
		
		productDescriptionDB.User_Id = addDetailModel.getEmail();
		
		AddDetailDb verifyDetail = new AddDetailDb();
		int i = verifyDetail.LoginDetail(addDetailModel);
		if(i==0){
			System.out.println(addDetailModel.getEmail()+"after");

			addDetailModel.setEmail(null);
			System.out.println(addDetailModel.getEmail()+"after");
			System.out.println("I am Failure");
		return "failure";
		}
		else{
			addDetailModel.setFlag(1);
			System.out.println("I am succsess");
			return "success";
		}
	}
	
	@Override
	public AddDetailModel getModel() {
		// TODO Auto-generated method stub
		return addDetailModel;
	}

}