package com.dmilut.lesson_08;

import com.dmilut.lesson_08.project.addressbook.entity.Contact;
import com.dmilut.lesson_08.project.addressbook.service.ContactService;
import com.dmilut.lesson_08.project.addressbook.util.Util;

import java.io.IOException;

public class AddressBook {

    private static final ContactService contactService = new ContactService();
    private static final Util util = new Util();

    /*
     * NOTE : =====================================================================================================
     * Задача   -   написать программу, которая будет решать проблему из реальной жизни.
     * Level 3  -   провести анализ предметной области
     *          -   записать сущности предметной области как классы программы
     *          -   записать поля классов
     * ============================================================================================================
     */

    public static void main(String[] args) throws IOException {
        util.initApp();

        System.out.println("=========================================================================================");
        System.out.println("                        Добро пожаловать в адресную книгу                                ");
        System.out.println("=========================================================================================");

        String command = "start";

        while (command.equals("start") || command.equals("continue")) {

            System.out.println("Подсказка по коммандам ==================================================================");
            System.out.println("enter contact           - ввод нового контакта ==========================================");
            System.out.println("print contacts          - вывод в консоль всех контактов ================================");
            System.out.println("search by name          - поиск по имени контакта =======================================");
            System.out.println("=========================================================================================");
            System.out.println("Введите комманду");

            command = Util.inputText();

            switch (command) {
                case "enter contact": {
                    contactService.inputContact();
                }
                break;
                case "print contacts": {
                    contactService.printContacts(contactService.getAllContacts());
                }
                break;
                case "search by name": {
                    System.out.println("Введите имя");
                    String name = Util.inputText();
                    Contact contact = contactService.getContactByFirstName(name);

                    contactService.printContact(contact);
                }
                break;
                default: {
                    System.out.println("Вы ошиблись!!!");
                }
            }

            System.out.println('\n' + "Для продолжения введите continue");
            command = Util.inputText();
        }
    }
}



