package by.sobol.contact.book.project.service;

import java.util.List;

import by.sobol.contact.book.project.domain.User;

public interface UserService {

	List<User> getAllUsers();

	void addNewUser(User user);

	User getUserById(int id);

	void updateInfoUser(User user);

	void deleteUser(int id);
	
	User authorization(String login, String password);

	int createUserTest(User user);
}
