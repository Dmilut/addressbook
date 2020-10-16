package com.dmilut.lesson_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AddressBook {

    /*
     * NOTE : =====================================================================================================
     * Задача - написать программу, которая будет решать проблему из реальной жизни.
     * Level 1 - Используя перменные получить, сохранить и вывести на экран атрибуты контакта.
     * ============================================================================================================
     */

    public static void main(String[] args) throws IOException {

        String firstName;
        String lastName;
        String phoneNumber;
        String address;

        {
            System.out.println("Введите контакт:");

            System.out.println("Введите имя:");
            firstName = inputText();

            System.out.println("Введите фамилию:");
            lastName = inputText();

            System.out.println("Введите номер телефона:");
            phoneNumber = inputText();

            System.out.println("Введите адрес:");
            address = inputText();
        }

        {
            System.out.println("Вы записали контакт:");
            System.out.println("Имя: " + firstName);
            System.out.println("Фамилия: " + lastName);
            System.out.println("Номер телефона: " + phoneNumber);
            System.out.println("Адрес: " + address);
        }


    }

    public static String inputText() throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String text = reader.readLine();

        return text;
    }
}



