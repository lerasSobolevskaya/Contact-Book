package by.sobol.contact.book.project.web.action.util;

public class RequestParamValidationException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8809054553560643489L;

	public RequestParamValidationException() {
	}

	public RequestParamValidationException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public RequestParamValidationException(String message, Throwable cause) {
		super(message, cause);
	}

	public RequestParamValidationException(String message) {
		super(message);
	}

	public RequestParamValidationException(Throwable cause) {
		super(cause);
	}
	

}
