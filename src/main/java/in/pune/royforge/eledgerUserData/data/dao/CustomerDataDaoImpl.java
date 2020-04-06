package in.pune.royforge.eledgerUserData.data.dao;

import java.util.ArrayList;
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

	private void getCustomers(CustomerData customerData, CustomerDataEntity customerDataEntity) {
		customerData.setCustomerId(customerDataEntity.getCustomerId());
		customerData.setCustomerName(customerDataEntity.getCustomerName());
		customerData.setCustomerPhoneNo(customerDataEntity.getCustomerPhoneNo());
		customerData.setBorrowId(customerDataEntity.getBorrowId());
		customerData.setLenderId(customerDataEntity.getLenderId());
	}

	@Override
	public List<CustomerData> getCustomers() {
		List<CustomerData> customers = new ArrayList<>();
		Iterable<CustomerDataEntity> customersList = customerRepository.findAll();
		if (null != customersList) {
			for (CustomerDataEntity customerDataEntity : customersList) {
				CustomerData customerData = new CustomerData();
				getCustomers(customerData, customerDataEntity);
				customers.add(customerData);
			}
		}
		return customers;
	}

}
