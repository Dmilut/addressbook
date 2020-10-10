package com.dmilut.service;

import com.dmilut.entity.Address;
import com.dmilut.entity.Contact;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactServiceTest {

    /*  MethodName_ExpectedBehavior_StateUnderTest
    example: isAdult_AgeLessThan18_False*/
    private static ContactService contactService;
    private static Address address;
    private static String firstName;
    private static String lastName;
    private static long phoneNumber;
    private static Contact contact;

    @BeforeAll
    public static void setUp() {
        contactService = new ContactService();
        firstName = "TestName1";
        lastName = "TestLastName1";
        phoneNumber = 1234567890;

        String houseNumber = "TestHouseNumber1";
        String streetName = "TestStreet1";
        String cityName = "TestCity1";
        String stateName = "TestState1";
        int zipCode = 11111;
        address = new Address(houseNumber, streetName, cityName, stateName, zipCode);
        contact = new Contact(firstName, lastName, phoneNumber, address);
    }

    @Test
    public void createContact_ContactShouldBeCreated() {
        contactService.createContact(firstName, lastName, phoneNumber, address);

        assertNotNull(contactService.searchByFirstNameOrLastNameOrCityName(firstName));
    }

    @Test
    public void createContact_ThrowException_WhenFirstNameIsNull() {

        assertThrows(NullPointerException.class, () -> {
            contactService.createContact(null, lastName, phoneNumber, address);
        });
    }

    @Test
    public void createContact_ThrowException_WhenLastNameIsNull() {

        assertThrows(NullPointerException.class, () -> {
            contactService.createContact(firstName, null, phoneNumber, address);
        });
    }

    @Test
    public void saveContact_ContactShouldBeSaved() {
        contactService.saveContact(contact);

        assertNotNull(contactService.searchByFirstNameOrLastNameOrCityName(firstName));
    }

    @Test
    public void deleteAll_AllContactsShouldBeDeleted() {
        contactService.createContact(firstName, lastName, phoneNumber, address);
        contactService.deleteAll();

        assertTrue(contactService.getAllContacts().isEmpty());
    }

    @Test
    public void deleteContactByFirstName_ContactShouldBeDeleted() {
        contactService.createContact(firstName, lastName, phoneNumber, address);
        contactService.deleteContactByFirstName(firstName);

        assertTrue(contactService.getAllContacts().isEmpty());
    }

    @AfterEach
    void tearDown() {
        contactService.deleteAll();
    }

}