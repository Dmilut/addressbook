package com.dmilut.lesson_08.project.addressbook.service;

import com.dmilut.lesson_08.project.addressbook.util.Storage;
import com.dmilut.lesson_08.project.addressbook.entity.Contact;

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

    public void updateContact(Contact contact) {
        int index = getContactIndexByFirstName(contact.firstName);

        Storage.contacts[index] = contact;
    }


    public void deleteContact(Contact contact) {
        int index = getContactIndexByFirstName(contact.firstName);

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
            if (Storage.contacts[i].firstName.equals(firstName)) {
                index = i;
                break;
            }
        }

        return index;
    }


}
