package restaurant.back.Exceptions;

import java.util.HashMap;
import java.util.Map;

public class InvalidPathVariable extends RuntimeException implements ErrorMap{
	private Map<String, String> errorMap = new HashMap<>();
	
	public InvalidPathVariable(Map<String, String> errorMap) {
		super();
		this.errorMap = errorMap;
	}
	
	public Map<String, String> getErrorMap() {
		return errorMap;
	}
}
