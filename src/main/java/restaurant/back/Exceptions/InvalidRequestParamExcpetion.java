package restaurant.back.Exceptions;

import java.util.HashMap;
import java.util.Map;

public class InvalidRequestParamExcpetion extends RuntimeException{
	private Map<String, String> errorMap = new HashMap<>();

	public InvalidRequestParamExcpetion(Map<String, String> errorMap) {
		super();
		this.errorMap = errorMap;
	}
	
	public Map<String, String> getErrorMap() {
		return errorMap;
	}
	
}
