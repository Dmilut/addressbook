package com.dmilut.service;

import com.dmilut.entity.Address;
import com.dmilut.entity.Contact;
import com.dmilut.util.Util;

import java.util.ArrayList;

public class ContactService {

    private final StorageService storageService = new StorageService();

    public void createContact(String firstName, String lastName, long phoneNumber, Address address) {
        if (address == null) {
            throw new NullPointerException();
        }

        Contact contact = new Contact(firstName, lastName, phoneNumber, address);

        saveContact(contact);
    }

    public void saveContact(Contact contact) {
        storageService.saveContact(contact);
    }

    public Contact searchByFirstNameOrLastNameOrCityName(String searchQuery) {

        return storageService.getByFirstNameOrLastNameOrCityName(searchQuery);
    }

    public Contact searchByFirstName(String firstName) {

        return storageService.getByFirstName(firstName);
    }

    public ArrayList<Contact> getAllContacts() {
        return storageService.getAllContacts();
    }

    public void deleteContactByFirstName(String firstName) {

        storageService.removeContact(searchByFirstName(firstName));
    }

    public void deleteAll() {
        storageService.removeAll();
    }

    public void inputContact() {

        System.out.println("Введите имя             ");
        String firstName = Util.inputText();

        System.out.println("Введите фамилию         ");
        String lastName = Util.inputText();

        System.out.println("Введите номер телефона  ");
        long phoneNumber = Long.parseLong(Util.inputText());

        System.out.println("Адрес-------------------");
        System.out.println("Введите номер дома      ");
        String houseNumber = Util.inputText();

        System.out.println("Введите улицу           ");
        String streetName = Util.inputText();

        System.out.println("Введите город           ");
        String cityName = Util.inputText();

        System.out.println("Введите штат            ");
        String stateName = Util.inputText();

        System.out.println("Введите зип-код         ");
        int zipCode = Integer.parseInt(Util.inputText());

        Contact contact = new Contact(firstName, lastName, phoneNumber, new Address(houseNumber, streetName, cityName, stateName, zipCode));

        saveContact(contact);
    }

    public void printContact(Contact contact) {
        System.out.println("=========================================================================================");
        System.out.println("Имя                     " + contact.getFirstName());
        System.out.println("Фамилия                 " + contact.getLastName());
        System.out.println("Номер телефона          " + contact.getPhoneNumber());
        System.out.println("Адрес ===================================================================================");
        System.out.println("Номер дома              " + contact.getAddress().getHouseNumber());
        System.out.println("Улица                   " + contact.getAddress().getStreetName());
        System.out.println("Город                   " + contact.getAddress().getCityName());
        System.out.println("Штат                    " + contact.getAddress().getStateName());
        System.out.println("Зип-код                 " + contact.getAddress().getZipCode());
        System.out.println("=========================================================================================");
    }

    public void printContacts(ArrayList<Contact> contacts) {

        for (Contact contact : contacts) {
            printContact(contact);
        }
    }

}
