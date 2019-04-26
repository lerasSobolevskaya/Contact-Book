package by.sobol.contact.book.project.web.action.util;

public class RequestParamValidator {

	private RequestParamValidator() {
	}

	public static void validateLoginAndPass(String login, String password) {
		if (login == null || password == null) {
			throw new RequestParamValidationException();
		}
	}

}
