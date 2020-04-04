package in.pune.royforge.eledgerUserData.exceptionhandler;

import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import in.pune.royforge.eledgerUserData.data.model.Response;

public class CustomExceptionHandler {
	
	/*
	 * This Method is used to handle Custom Exception when data is not found in
	 * database. It will throw RecordNotFoundException
	 */
	@ExceptionHandler(RecordNotFoundException.class)
	public final ResponseEntity<Object> handleRecordNotFoundException(RecordNotFoundException ex) {
		return new ResponseEntity<Object>(new Response(new Date(), ex.getMessage(), HttpStatus.NOT_FOUND),
				HttpStatus.NOT_FOUND);
	}
	
	/*
	 * Method to handle all types of Exceptions other than RecordNotFoundException.
	 */
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex) {
		return new ResponseEntity<Object>(
				new Response(new Date(), ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
