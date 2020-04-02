package in.pune.royforge.eledgerUserData.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import in.pune.royforge.eledgerUserData.data.entity.UserDataEntity;
import in.pune.royforge.eledgerUserData.data.model.UserData;
import in.pune.royforge.eledgerUserData.data.service.UserDataService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class UserDataController {

	@Autowired
	UserDataService userEntityService;

	@RequestMapping(method = RequestMethod.POST)
	public UserDataEntity createOrUpdateWallet(@RequestBody UserData userData) {
		return userEntityService.save(userData);
	}
}
