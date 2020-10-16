package com.dmilut.lesson_14.project.addressbook.service;

import com.dmilut.lesson_14.project.addressbook.entity.Contact;
import com.dmilut.lesson_14.project.addressbook.util.Storage;

import java.util.ArrayList;

public class StorageService {

    public void saveContact(Contact contact) {
        Storage.getContacts().add(contact);
    }

    public ArrayList<Contact> getAllContact() {
        return Storage.getContacts();
    }

    public Contact getByFirstName(String firstName) {
        for (Contact contact : Storage.getContacts()) {

            if (contact.getFirstName().equals(firstName)) {
                return contact;
            }
        }

        return null;
    }

    public Contact getByLastName(String lastName) {
        for (Contact contact : Storage.getContacts()) {

            if (contact.getLastName().equals(lastName)) {
                return contact;
            }
        }

        return null;
    }

    public Contact getByCityName(String cityName) {
        for (Contact contact : Storage.getContacts()) {

            if (contact.getAddress().getCityName().equals(cityName)) {
                return contact;
            }
        }

        return null;
    }

    public void removeContact(Contact contact) {
        Storage.getContacts().remove(contact);
    }

}
