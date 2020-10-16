package com.dmilut.lesson_08.project.addressbook.service;

import com.dmilut.lesson_08.project.addressbook.entity.Contact;
import com.dmilut.lesson_08.project.addressbook.util.Util;

import java.io.IOException;

public class ContactService {
    private final StorageService storageService = new StorageService();

    public void createContact(String firstName, String lastName, long phoneNumber) {
        Contact contact = new Contact();
        contact.firstName = firstName;
        contact.lastName = lastName;
        contact.phoneNumber = phoneNumber;

        saveContact(contact);
    }

    public void saveContact(Contact contact) {
        storageService.saveContact(contact);
    }

    public Contact getContactByFirstName(String firstName) {

        return storageService.getByFirstName(firstName);
    }

    public Contact[] getAllContacts() {
        return storageService.getAllContact();
    }

    public void inputContact() throws IOException {
        Contact contact = new Contact();
        System.out.println("Введите имя             ");
        contact.firstName = Util.inputText();

        System.out.println("Введите фамилию         ");
        contact.lastName = Util.inputText();

        System.out.println("Введите номер телефона  ");
        contact.phoneNumber = Long.parseLong(Util.inputText());

        saveContact(contact);
    }

    public void printContact(Contact contact) {
        System.out.println("=========================================================================================");
        System.out.println("Имя                     " + contact.firstName);
        System.out.println("Фамилия                 " + contact.lastName);
        System.out.println("Номер телефона          " + contact.phoneNumber);
        System.out.println("=========================================================================================");
    }

    public void printContacts(Contact[] contacts) {
        for (Contact contact : contacts) {
            if (contact != null) {
                printContact(contact);
            }
        }
    }
}
