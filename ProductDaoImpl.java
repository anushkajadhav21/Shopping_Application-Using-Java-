package Shop.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import Shop.db.Dbconnection;
import Shop.model.Product;
import Shop.model.Register;
import oracle.jdbc.util.Login;

public class ProductDaoImpl implements ProductDao{
	
Dbconnection proddao=new Dbconnection();
Connection con = proddao.getDbConnection();
PreparedStatement pstate=null;
	
	@Override
	public int createRecord(List<Register> lst) {
		// TODO Auto-generated method stub
		
		Register regobj=lst.get(0);
		int i=0;
//		Connection con=null;
		try {
//			con=proddao.getDbConnection();
			PreparedStatement pstate=con.prepareStatement("insert into Registration values(?,?,?,?,?)");
			pstate.setInt(1,regobj.getRegNo());
			pstate.setString(2,regobj.getCustName());
			pstate.setString(3,regobj.getUserName());
			pstate.setString(4,regobj.getPassword());
			pstate.setFloat(5,regobj.getAccbal());
			i = pstate.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return i;
	}

	public boolean validate_Cust_Login(String cust_email, String cust_pass) {
		boolean b = false;
		List<Register> lst= getAllRegister();
		for(int i=0;i<lst.size();i++) {
			if((lst.get(i).getUserName().equals(cust_email)) && (lst.get(i).getPassword().equals(cust_email))) {
				b= true;
				return b;
			}
		}
		
		return b;
	}
	
	public List<Register> getAllRegister() {
		int i=0;
		Connection conn=null;
		List<Register>lst=new LinkedList<Register>();
		try {
			conn=Dbconnection.getDbConnection();
			String str = "select * from registration";
			
			Statement state=conn.createStatement();
			ResultSet result=state.executeQuery(str);
			
			while(result.next())
			{
				Register reg=new Register(result.getInt(1),result.getString(2), result.getString(3), result.getString(4), result.getFloat(5));
				lst.add(reg);
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lst;
	}


	



	@Override
	public int LoginRecord(List<Login> lst) {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public int ProductRecord(List<Product> lst) {
		int i=0;
		for(int j=0;j<lst.size();j++) {
			Product prod= lst.get(j);
//			
//			PreparedStatement pstate;
			try {
				pstate = con.prepareStatement("insert into Product values(?,?,?,?)");
				pstate.setInt(1, prod.getProdId());
				pstate.setString(2, prod.getProdName());
				pstate.setFloat(3, prod.getProdPrice());
				pstate.setInt(4, prod.getProdQty());
				i = pstate.executeUpdate();
				
			} catch (SQLException e) {
				System.out.println(e);
				e.printStackTrace();
			}	
			
		}
		return i;
	}

	public List<Product> getAllProduct() {
		int i=0;
		Connection conn=null;
		List<Product>lst=new LinkedList<Product>();
		try {
			conn=Dbconnection.getDbConnection();
			String str = "select * from Product";
			
			Statement state=conn.createStatement();
			ResultSet result=state.executeQuery(str);
			
			while(result.next())
			{
				Product prod=new Product(result.getInt(1),result.getString(2), result.getFloat(3), result.getInt(4));
				lst.add(prod);
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lst;
	}



	
	

}
