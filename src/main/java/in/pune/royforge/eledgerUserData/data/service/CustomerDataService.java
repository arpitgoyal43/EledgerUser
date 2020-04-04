package in.pune.royforge.eledgerUserData.data.service;

import java.util.List;

import in.pune.royforge.eledgerUserData.data.entity.CustomerDataEntity;
import in.pune.royforge.eledgerUserData.data.model.CustomerData;

public interface CustomerDataService {

	CustomerDataEntity save(CustomerData customerData);

	List<CustomerData> getCustomers();

}
