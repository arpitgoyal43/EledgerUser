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
import in.pune.royforge.eledgerUserData.data.model.LenderData;
import in.pune.royforge.eledgerUserData.data.service.ILenderDataService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/lender")
public class LenderDataController {

	@Autowired
	ILenderDataService userEntityService;

	@RequestMapping(method = RequestMethod.POST)

	public ResponseEntity<Response> createLender(@RequestBody LenderData lenderData) {
		return new ResponseEntity<>(
				new Response(new Date(), "success", HttpStatus.CREATED, userEntityService.save(lenderData)),
				HttpStatus.CREATED);
	}

	@RequestMapping(value = "/lenders", method = RequestMethod.GET)
	public ResponseEntity<Response> getUsers() {
		return new ResponseEntity<>(new Response(new Date(), "success", HttpStatus.OK, userEntityService.getLenderss()),
				HttpStatus.OK);
	}
}