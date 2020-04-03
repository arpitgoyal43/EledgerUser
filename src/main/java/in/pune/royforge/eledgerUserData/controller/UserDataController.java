package in.pune.royforge.eledgerUserData.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import in.pune.royforge.eledgerUserData.data.model.Response;
import in.pune.royforge.eledgerUserData.data.model.UserData;
import in.pune.royforge.eledgerUserData.data.service.UserDataService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class UserDataController {

	@Autowired
	UserDataService userEntityService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Response> createOrUpdateWallet(@RequestBody UserData userData) {
		return new ResponseEntity<>(
				new Response(new Date(), "success", HttpStatus.CREATED, userEntityService.save(userData)),
				HttpStatus.CREATED);
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ResponseEntity<Response> getUsers() {
		return new ResponseEntity<>(new Response(new Date(), "success", HttpStatus.OK, userEntityService.getUsers()),
				HttpStatus.OK);
	}

}
