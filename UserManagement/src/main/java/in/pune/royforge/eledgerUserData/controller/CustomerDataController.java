package in.pune.royforge.eledgerUserData.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import in.pune.royforge.eledgerUserData.data.entity.CustomerDataEntity;
import in.pune.royforge.eledgerUserData.data.model.CustomerData;
import in.pune.royforge.eledgerUserData.data.service.ICustomerDataService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/customer")
public class CustomerDataController {

	@Autowired
	ICustomerDataService customerEntityService;

	@RequestMapping(method = RequestMethod.POST)
	public CustomerDataEntity createOrUpdateCustomer(@RequestBody CustomerData customerData) {
		return customerEntityService.save(customerData);
	}

	@RequestMapping(value = "/customers", method = RequestMethod.GET)
	public List<CustomerData> getCustomers() {
		return customerEntityService.getCustomers();
	}

	@RequestMapping(value = "/customer/{id}", method = RequestMethod.GET)
	public CustomerData getCustomerById(@PathVariable(value = "id") Long id) {
		return customerEntityService.getCustomerById(id);
	}

	@RequestMapping(value = "/customer/{id}", method = RequestMethod.DELETE)
	public boolean deleteCustomer(@PathVariable(value = "id") Long id) {
		return customerEntityService.deleteCustomer(id);
	}

	@RequestMapping(value = "/allcustomers", method = RequestMethod.GET)
	public List<CustomerData> getAllCustomers() {
		return customerEntityService.getAllCustomers();
	}
}
