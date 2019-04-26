package by.sobol.contact.book.project.test.service;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import by.sobol.contact.book.project.domain.User;
import by.sobol.contact.book.project.service.UserService;
import by.sobol.contact.book.project.service.impl.UserServiceImpl;

/**
 * @author user
 *
 */
public class UserServiceImplTets {

	private UserService userService;
	private List<User> users;
	private User user;

	@Before
	public void initUserServiceImpl() {
		userService = mock(UserServiceImpl.class);
	}

	@Test
	public void getAllUsersTest() {
		when(userService.getAllUsers()).thenReturn(users);
		userService.getAllUsers();
		verify(userService, times(1)).getAllUsers();
	}

	@Test
	public void getUserByIdTest() {
		when(userService.getUserById(anyInt())).thenReturn(user);
		userService.getUserById(anyInt());
		verify(userService, times(1)).getUserById(anyInt());
	}

	@Test
	public void deleteUserTest() {
		userService = mock(UserService.class);
		userService.deleteUser(anyInt());
		verify(userService, times(1)).deleteUser(anyInt());
	}

	@Test
	public void addNewUserTest() {
		userService.addNewUser(user);
		verify(userService, times(1)).addNewUser(user);
	}

	@Test
	public void updateInfoUserTest() {
		userService.updateInfoUser(user);
		verify(userService, times(1)).updateInfoUser(user);
	}

	@Test
	public void checkRoleTest() {
		when(userService.authorization(anyString(), anyString())).thenReturn(user);
		userService.authorization(anyString(), anyString());
		verify(userService, times(1)).authorization(anyString(), anyString());
	}

}
