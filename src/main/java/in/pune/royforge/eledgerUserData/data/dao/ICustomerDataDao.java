package in.pune.royforge.eledgerUserData.data.dao;

import java.util.List;

import in.pune.royforge.eledgerUserData.data.entity.CustomerDataEntity;
import in.pune.royforge.eledgerUserData.data.model.CustomerData;

public interface ICustomerDataDao {

	CustomerDataEntity save(CustomerData customerData);

	List<CustomerData> getCustomers();
}