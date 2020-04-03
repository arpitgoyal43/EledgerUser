package in.pune.royforge.eledgerUserData.exceptionhandler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import in.pune.royforge.eledgerUserData.data.model.Response;

public class CustomExceptionHandler {

	  @ExceptionHandler(Exception.class)
	    public final ResponseEntity<Response> handleAllExceptions(Exception ex, WebRequest request) {
	        List<String> details = new ArrayList<>();
	        details.add(ex.getLocalizedMessage());
	        Response error = new Response(new Date(), ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
}