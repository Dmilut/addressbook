package com.dmilut.util;

import com.dmilut.entity.Contact;

import java.util.ArrayList;

public class Storage {

    // Storage для хранения контактов
    private static final ArrayList<Contact> contacts = new ArrayList<>();

    public static ArrayList<Contact> getContacts() {
        return contacts;
    }

}
