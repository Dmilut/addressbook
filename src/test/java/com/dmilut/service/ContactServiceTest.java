package com.dmilut.service;

import com.dmilut.entity.Address;
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

    @BeforeAll
    static void setUp() {
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
    }

    @Test
    void createContact_WillBeCreated_WhenArgumentsAreValid() {
        contactService.createContact(firstName, lastName, phoneNumber, address);

        assertNotNull(contactService.searchByFirstNameOrLastNameOrCityName(firstName));
    }

    @Test
    void createContact_ThrowException_WhenAddressIsNull() {

        assertThrows(NullPointerException.class, () -> {
            contactService.createContact(firstName, lastName, phoneNumber, null);
        });
    }

}