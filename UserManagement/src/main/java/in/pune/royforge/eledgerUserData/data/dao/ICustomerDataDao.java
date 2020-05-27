package in.pune.royforge.eledgerUserData.data.dao;

import java.util.List;

import in.pune.royforge.eledgerUserData.data.entity.CustomerDataEntity;
import in.pune.royforge.eledgerUserData.data.model.CustomerData;

public interface ICustomerDataDao {

	CustomerDataEntity save(CustomerData customerData);

	List<CustomerData> getCustomers();

	CustomerData getCustomerById(Long id);

	boolean deleteCustomer(long id);
	
	List<CustomerData> getAllCustomers();
	
	List<CustomerData> getcustomersByLenderId(String lenderId);
}
