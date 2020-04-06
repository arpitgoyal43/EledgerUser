package in.pune.royforge.eledgerUserData.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import in.pune.royforge.eledgerUserData.data.model.CustomerData;
import in.pune.royforge.eledgerUserData.data.model.Response;
import in.pune.royforge.eledgerUserData.data.service.CustomerDataService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/customer")
public class CustomerDataController {

	@Autowired
	CustomerDataService customerEntityService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Response> createOrUpdateCustomer(@RequestBody CustomerData customerData) {
		return new ResponseEntity<>(
				new Response(new Date(), "success", HttpStatus.CREATED, customerEntityService.save(customerData)),
				HttpStatus.CREATED);
	}

	@RequestMapping(value = "/customers", method = RequestMethod.GET)
	public ResponseEntity<Response> getCustomers() {
		return new ResponseEntity<>(
				new Response(new Date(), "success", HttpStatus.OK, customerEntityService.getCustomers()),
				HttpStatus.OK);
	}

	@RequestMapping(value = "/customer/{id}", method = RequestMethod.GET)
	public ResponseEntity<Response> getCustomerById(@PathVariable(value = "id") Long id) {
		return new ResponseEntity<>(
				new Response(new Date(), "Success", HttpStatus.OK, customerEntityService.getCustomerById(id)),
				HttpStatus.OK);
	}

	@RequestMapping(value = "/customer/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Response> deleteCustomer(@PathVariable(value = "id") Long id) {
		return new ResponseEntity<>(
				new Response(new Date(), "Success", HttpStatus.OK, customerEntityService.deleteCustomer(id)),
				HttpStatus.OK);
	}
}
