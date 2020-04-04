package in.pune.royforge.eledgerUserData.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.pune.royforge.eledgerUserData.data.dao.ICustomerDataDao;
import in.pune.royforge.eledgerUserData.data.entity.CustomerDataEntity;
import in.pune.royforge.eledgerUserData.data.model.CustomerData;

@Service
public class CustomerDataServiceImpl implements CustomerDataService {

	@Autowired
	private ICustomerDataDao customerEntityDao;

	@Override
	public CustomerDataEntity save(CustomerData customerData) {
		return customerEntityDao.save(customerData);
	}

	@Override
	public List<CustomerData> getCustomers() {
		return customerEntityDao.getCustomers();
	}

}
