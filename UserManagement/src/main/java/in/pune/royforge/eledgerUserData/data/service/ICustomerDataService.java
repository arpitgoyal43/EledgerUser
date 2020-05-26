package in.pune.royforge.eledgerUserData.data.service;

import java.util.List;

import in.pune.royforge.eledgerUserData.data.entity.CustomerDataEntity;
import in.pune.royforge.eledgerUserData.data.model.CustomerData;

public interface ICustomerDataService {

	CustomerDataEntity save(CustomerData customerData);

	List<CustomerData> getCustomers();

	CustomerData getCustomerById(Long id);

	boolean deleteCustomer(long id);

	List<CustomerData> getAllCustomers();

	List<CustomerData> getcustomersByLenderId(String lenderId);
}
