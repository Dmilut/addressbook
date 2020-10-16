package com.dmilut.lesson_14.project.addressbook.util;

import java.util.ArrayList;
import com.dmilut.lesson_14.project.addressbook.entity.Contact;

public class Storage {

    // Storage для хранения контактов
    private static final ArrayList<Contact> contacts = new ArrayList<>();

    public static ArrayList<Contact> getContacts() {
        return contacts;
    }

}
