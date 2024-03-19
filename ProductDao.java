package Shop.Dao;

import java.util.List;

import Shop.model.Product;
import Shop.model.Register;
import oracle.jdbc.util.Login;

public interface ProductDao {
	

	int createRecord(List<Register> lst);
	//boolean validateUser()
	
	
	int LoginRecord(List<Login> lst);
	int ProductRecord(List<Product>lst);


	List<Register> getAllRegister();

	

}
