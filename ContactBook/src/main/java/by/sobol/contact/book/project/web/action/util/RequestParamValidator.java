package by.sobol.contact.book.project.web.action.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.sobol.contact.book.project.dao.impl.ContactsDaoMySqlImpl;

public class RequestParamValidator {
	public static ContactsDaoMySqlImpl dao = new ContactsDaoMySqlImpl();

	private RequestParamValidator() {
	}

	public static final String REGEX_ONLY_LETTERS = "";
	public static final String REGEX_EMAIL = "^((\\w|[-+])+(\\.[\\w-]+)*@[\\w-]+((\\.[\\d\\p{Alpha}]+)*(\\.\\p{Alpha}{2,})*)*)$";
	public static final String REGEX_PHONE_NUM = "(\\+?37529|8029)[-]?\\s?\\d{3}[-]?\\s?\\d{2}[-]?\\s?\\d{2}";

	public static void validateLoginAndPass(String login, String password) {
		if (login == null || password == null) {
			throw new RequestParamValidationException();
		}
	}

	public static void validateParamNotNull(String param) {
		if (param == null) {
			throw new RequestParamValidationException();
		}
	}

	public static boolean validatePhoneNumber(String phoneNum) {
		validateParamNotNull(phoneNum);
		return matchToRegex(phoneNum, REGEX_PHONE_NUM);

	}

	public static boolean validateEmail(String email) {
		validateParamNotNull(email);
		return matchToRegex(email, REGEX_EMAIL);

	}

	public static boolean validateUserName(String name) {
		validateParamNotNull(name);
		return matchToRegex(name, REGEX_ONLY_LETTERS);
	}

	public static boolean validateUserSurname(String surname) {
		validateParamNotNull(surname);
		return matchToRegex(surname, REGEX_ONLY_LETTERS);
	}

	public static boolean validateUserPatronymic(String patronymic) {
		validateParamNotNull(patronymic);
		return matchToRegex(patronymic, REGEX_ONLY_LETTERS);
	}

	private static boolean matchToRegex(String input, String regex) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		return matcher.matches();
	}

}
