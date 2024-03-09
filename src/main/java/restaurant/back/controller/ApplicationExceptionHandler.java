package restaurant.back.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import restaurant.back.Exceptions.InvalidRequestParamExcpetion;

@RestControllerAdvice
public class ApplicationExceptionHandler {
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> constraintViolationException(MethodArgumentNotValidException ex) {
		List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
		Map<String, String> errorMap = new HashMap<>();				
		System.out.println(fieldErrors);
		fieldErrors.forEach(e->{errorMap.put(e.getField(), e.getDefaultMessage());});
		return errorMap;
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidRequestParamExcpetion.class)
	public Map<String, String> invalidRequestParam(InvalidRequestParamExcpetion ex) {
		return ex.getErrorMap();
		
	}
}
