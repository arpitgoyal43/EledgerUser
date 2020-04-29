package in.pune.royforge.eledgerUserData.data.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.pune.royforge.eledgerUserData.data.entity.CustomerDataEntity;
import in.pune.royforge.eledgerUserData.data.entity.RelationDataEntity;
import in.pune.royforge.eledgerUserData.data.model.CustomerData;
import in.pune.royforge.eledgerUserData.repo.CustomerRepository;
import in.pune.royforge.eledgerUserData.repo.RelationRepository;

@Repository
public class CustomerDataDaoImpl implements ICustomerDataDao {

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	RelationRepository relationRepository;

	/*
	 * Method to save new data or update existing data to the customers database
	 */
	@Override
	public CustomerDataEntity save(CustomerData customerData) {
		if (null != customerData) {
			CustomerDataEntity customerEntity = new CustomerDataEntity();
			CustomerDataEntity customerEntityObj;
			if (null == customerData.getId()) {
				createCustomer(customerData, customerEntity);
				RelationDataEntity relationDataEntity = new RelationDataEntity();
				relationDataEntity.setBorrowId(customerEntity.getBorrowId());
				relationDataEntity.setLenderId(customerEntity.getLenderId());
				customerEntityObj = customerRepository.save(customerEntity);
				relationRepository.save(relationDataEntity);
			} else {
				updateCustomer(customerData, customerEntity);
				customerEntityObj = customerRepository.save(customerEntity);
			}
			return customerEntityObj;
		} else {
			return new CustomerDataEntity();
		}
	}

	// Method to push customer data to repository entity
	private void createCustomer(CustomerData customerData, CustomerDataEntity customerDataEntity) {
		customerDataEntity.setName(customerData.getName());
		customerDataEntity.setPhone(customerData.getPhone());
		customerDataEntity.setBorrowId(customerData.getBorrowId());
		customerDataEntity.setLenderId(customerData.getLenderId());
		customerDataEntity.setIsDeleted(false);
	}

	// Method to update customer data to repository entity
	private void updateCustomer(CustomerData customerData, CustomerDataEntity customerDataEntity) {
		customerDataEntity.setId(customerData.getId());
		customerDataEntity.setName(customerData.getName());
		customerDataEntity.setPhone(customerData.getPhone());
		customerDataEntity.setBorrowId(customerData.getBorrowId());
		customerDataEntity.setLenderId(customerData.getLenderId());
		customerDataEntity.setIsDeleted(false);
	}

	// Method to get customer data from repository entity
	private void getCustomers(CustomerData customerData, CustomerDataEntity customerDataEntity) {
		customerData.setId(customerDataEntity.getId());
		customerData.setName(customerDataEntity.getName());
		customerData.setPhone(customerDataEntity.getPhone());
		customerData.setBorrowId(customerDataEntity.getBorrowId());
		customerData.setLenderId(customerDataEntity.getLenderId());
		customerData.setIsDeleted(customerDataEntity.getIsDeleted());
	}

	/*
	 * Method to get list of customers
	 */
	@Override
	public List<CustomerData> getCustomers() {
		List<CustomerData> customers = new ArrayList<>();
		Iterable<CustomerDataEntity> customersList = customerRepository.findAll();
		if (null != customersList) {
			for (CustomerDataEntity customerDataEntity : customersList) {
				if (!customerDataEntity.getIsDeleted()) {
					CustomerData customerData = new CustomerData();
					getCustomers(customerData, customerDataEntity);
					customers.add(customerData);
				}
			}
		}
		return customers;
	}

	/*
	 * Method to get a customer by its id
	 */
	@Override
	public CustomerData getCustomerById(Long id) {
		Optional<CustomerDataEntity> existedCustomer = customerRepository.findById(id);
		CustomerData customerData = null;
		if (existedCustomer.isPresent()) {
			if (!existedCustomer.get().getIsDeleted()) {
				customerData = new CustomerData();
				customerData.setId(existedCustomer.get().getId());
				customerData.setName(existedCustomer.get().getName());
				customerData.setPhone(existedCustomer.get().getPhone());
				customerData.setBorrowId(existedCustomer.get().getBorrowId());
				customerData.setLenderId(existedCustomer.get().getLenderId());
			}
		}
		return customerData;
	}

	// By taking input {Id}, delete the wallet.
	@Override
	public boolean deleteCustomer(long id) {
		Optional<CustomerDataEntity> existedCustomer = customerRepository.findById(id);
		if (existedCustomer.isPresent()) {
			if (!existedCustomer.get().getIsDeleted()) {
				CustomerDataEntity customerDataEntity = new CustomerDataEntity();
				customerDataEntity.setId(existedCustomer.get().getId());
				customerDataEntity.setName(existedCustomer.get().getName());
				customerDataEntity.setPhone(existedCustomer.get().getPhone());
				customerDataEntity.setBorrowId(existedCustomer.get().getBorrowId());
				customerDataEntity.setLenderId(existedCustomer.get().getLenderId());
				customerDataEntity.setIsDeleted(true);
				customerRepository.save(customerDataEntity);
				return true;
			}
			return false;
		} else {
			return false;
		}
	}

	/*
	 * Method to get list of customers including all deleted customers.
	 */
	@Override
	public List<CustomerData> getAllCustomers() {
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
