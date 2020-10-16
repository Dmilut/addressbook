package com.dmilut.lesson_18.project.addressbook.util;

import com.dmilut.lesson_18.project.addressbook.entity.Address;
import com.dmilut.lesson_18.project.addressbook.service.ContactService;

import java.io.InputStreamReader;
import java.util.Scanner;

public class Util {

    private final ContactService contactService = new ContactService();

    // Добавляем несколько тестовых контактов
    public void initApp() {

        Address testAddress1 = new Address("TestHouseNumber1", "TestStreet1", "TestCity1", "TestState1", 11111);
        Address testAddress2 = new Address("TestHouseNumber2", "TestStreet2", "TestCity2", "TestState2", 22222);
        Address testAddress3 = new Address("TestHouseNumber3", "TestStreet3", "TestCity3", "TestState3", 33333);

        contactService.createContact("TestName1", "Bbbbbbbbb", 1234567890L, testAddress1);
        contactService.createContact("TestName2", "Aaaaaaaaa", 2345678901L, testAddress2);
        contactService.createContact("TestName3", "Ccccccccc", 3456789012L, testAddress3);
    }

    // Ввод данных через консоль
    public static String inputText() {
        Scanner scanner = new Scanner(new InputStreamReader(System.in));

        return scanner.nextLine();
    }
}
