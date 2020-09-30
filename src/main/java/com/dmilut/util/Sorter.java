package com.dmilut.util;

import com.dmilut.entity.Contact;

import java.util.Comparator;

public class Sorter implements Comparator<Contact> {

    @Override
    public int compare(Contact contact1, Contact contact2) {

        return contact1.getLastName().compareTo(contact2.getLastName());
    }

}
