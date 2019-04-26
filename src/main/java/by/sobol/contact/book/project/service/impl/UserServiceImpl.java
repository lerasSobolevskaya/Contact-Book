package by.sobol.contact.book.project.service.impl;

import java.util.List;

import by.sobol.contact.book.project.dao.UserDao;
import by.sobol.contact.book.project.dao.factory.DaoFactory;
import by.sobol.contact.book.project.domain.User;
import by.sobol.contact.book.project.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao userDao = DaoFactory.getUserDao();

	@Override
	public List<User> getAllUsers() {
		return userDao.getList();
	}

	@Override
	public void addNewUser(User user) {
		userDao.create(user);

	}

	@Override
	public User getUserById(int id) {
		return userDao.read(id);
	}

	@Override
	public void updateInfoUser(User user) {
		userDao.update(user);

	}

	@Override
	public void deleteUser(int id) {
		userDao.delete(id);

	}

	@Override
	public User authorization(String login, String password) {
		User user = new User(login, password);
		return userDao.authorization(user);
	}

	@Override
	public int createUserTest(User user) {
		return userDao.createUserTest(user);
		
	}

}
