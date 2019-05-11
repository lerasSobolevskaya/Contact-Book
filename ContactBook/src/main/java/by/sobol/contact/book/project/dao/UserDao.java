package by.sobol.contact.book.project.dao;

import by.sobol.contact.book.project.domain.User;

public interface UserDao extends BaseDao<User> {

	User authorization(User user);
	
}
