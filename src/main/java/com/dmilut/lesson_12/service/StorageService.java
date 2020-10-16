package com.dmilut.lesson_12.project.addressbook.service;

import com.dmilut.lesson_12.project.addressbook.entity.Contact;
import com.dmilut.lesson_12.project.addressbook.util.Storage;

public class StorageService {

    public void saveContact(Contact contact) {
        int emptySlotIndex = getFirstEmptySlotIndex();

        Storage.contacts[emptySlotIndex] = contact;
    }

    public Contact[] getAllContact() {
        return Storage.contacts;
    }

    public Contact getByFirstName(String firstName) {

        return Storage.contacts[getContactIndexByFirstName(firstName)];
    }

    public Contact getByLastName(String lastName) {

        return Storage.contacts[getContactIndexByLastName(lastName)];
    }

    public Contact getByCityName(String cityName) {

        return Storage.contacts[getContactIndexByCityName(cityName)];
    }

    public void deleteByFirstName(String firstName) {
        int index = getContactIndexByFirstName(firstName);

        Storage.contacts[index] = null;
    }

    private int getFirstEmptySlotIndex() {
        int index = 0;

        for (int i = 0; i < Storage.contacts.length; i++) {
            if (Storage.contacts[i] == null) {
                index = i;
                break;
            }
        }

        return index;
    }

    private int getContactIndexByFirstName(String firstName) {
        int index = 0;

        for (int i = 0; i < Storage.contacts.length; i++) {
            if (Storage.contacts[i] != null && Storage.contacts[i].getFirstName().equals(firstName)) {
                index = i;
                break;
            }
        }

        return index;
    }

    private int getContactIndexByLastName(String lastName) {
        int index = 0;

        for (int i = 0; i < Storage.contacts.length; i++) {
            if (Storage.contacts[i] != null && Storage.contacts[i].getLastName().equals(lastName)) {
                index = i;
                break;
            }
        }

        return index;
    }

    private int getContactIndexByCityName(String cityName) {
        int index = 0;

        for (int i = 0; i < Storage.contacts.length; i++) {
            if (Storage.contacts[i] != null && Storage.contacts[i].getAddress().getCityName().equals(cityName)) {
                index = i;
                break;
            }
        }

        return index;
    }


}
