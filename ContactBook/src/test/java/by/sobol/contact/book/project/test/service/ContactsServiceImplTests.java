package by.sobol.contact.book.project.test.service;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import by.sobol.contact.book.project.domain.Contacts;
import by.sobol.contact.book.project.service.ContactsService;
import by.sobol.contact.book.project.service.impl.ContactsServiceImpl;

public class ContactsServiceImplTests {

	private ContactsService contactsService;
	private List<Contacts> contacts;
	private Contacts contact;

	@Before
	public void initContactsServiceImpl() {
		contactsService = mock(ContactsServiceImpl.class);
	}

	@Test
	public void getAllContactsTest() {
		when(contactsService.getAllContacts()).thenReturn(contacts);
		contactsService.getAllContacts();
		verify(contactsService, times(1)).getAllContacts();

	}

	@Test
	public void addNewContactTest() {
		contactsService.addNewContact(contact);
		verify(contactsService, times(1)).addNewContact(contact);
	}

	@Test
	public void getContactByIdTets() {
		when(contactsService.getContactById(anyInt())).thenReturn(contact);
		contactsService.getContactById(anyInt());
		verify(contactsService, times(1)).getContactById(anyInt());
	}

	@Test
	public void deleteContactTest() {
		contactsService.deleteContact(anyInt());
		verify(contactsService, times(1)).deleteContact(anyInt());
	}

	@Test
	public void updateContactInfoTest() {
		contactsService.updateContactInfo(contact);
		verify(contactsService, times(1)).updateContactInfo(contact);
	}

}
