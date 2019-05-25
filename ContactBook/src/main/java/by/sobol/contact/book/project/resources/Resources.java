package by.sobol.contact.book.project.resources;

import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;

public class Resources {

	private static final String MESSAGES_PATH = "messages";

	public static String getMessage(String key, HttpServletRequest request) {
		ResourceBundle bundle = ResourceBundle.getBundle(MESSAGES_PATH);
		return bundle.getString(key);
	}
}
