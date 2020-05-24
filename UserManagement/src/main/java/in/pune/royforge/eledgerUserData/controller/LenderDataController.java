package in.pune.royforge.eledgerUserData.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import in.pune.royforge.eledgerUserData.data.entity.LenderDataEntity;
import in.pune.royforge.eledgerUserData.data.model.LenderData;
import in.pune.royforge.eledgerUserData.data.service.ILenderDataService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/lender")
public class LenderDataController {

	@Autowired
	ILenderDataService userEntityService;

	@RequestMapping(method = RequestMethod.POST)
	public LenderDataEntity createOrUpdateLender(@RequestBody LenderData lenderData) {
		return userEntityService.save(lenderData);
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signUpLender(@RequestBody LenderData lenderData) {
		return userEntityService.checkForSignUp(lenderData);
	}

	@RequestMapping(value = "/lenders", method = RequestMethod.GET)
	public List<LenderData> getLenders() {
		return userEntityService.getLenders();
	}

	@RequestMapping(value = "/userId/{id}", method = RequestMethod.GET)
	public LenderData getLenderById(@PathVariable(value = "id") Long id) {
		return userEntityService.getLender(id);
	}
}