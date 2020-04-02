package in.pune.royforge.eledgerUserData.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.pune.royforge.eledgerUserData.service.UserDataService;

@RestController
@RequestMapping("/user")
public class UserDataController {
	
	@Autowired
	UserDataService userEntityService;

}
