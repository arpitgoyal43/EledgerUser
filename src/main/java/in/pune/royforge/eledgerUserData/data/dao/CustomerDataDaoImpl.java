package in.pune.royforge.eledgerUserData.data.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.pune.royforge.eledgerUserData.data.entity.CustomerDataEntity;
import in.pune.royforge.eledgerUserData.data.model.CustomerData;
import in.pune.royforge.eledgerUserData.repo.CustomerRepository;

@Repository
public class CustomerDataDaoImpl implements ICustomerDataDao {

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public CustomerDataEntity save(CustomerData customerData) {
		CustomerDataEntity customerEntity = new CustomerDataEntity();

		createCustomer(customerData, customerEntity);
		return customerRepository.save(customerEntity);
	}

	private void createCustomer(CustomerData customerData, CustomerDataEntity customerDataEntity) {
		customerDataEntity.setCustomerName(customerData.getCustomerName());
		customerDataEntity.setCustomerPhoneNo(customerData.getCustomerPhoneNo());
		customerDataEntity.setBorrowId(customerData.getBorrowId());
		customerDataEntity.setLenderId(customerData.getLenderId());
	}

	@Override
	public List<CustomerData> getCustomers() {
		return null;
	}

}
