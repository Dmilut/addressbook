package com.dmilut.lesson_10;

import com.dmilut.lesson_10.project.addressbook.entity.Contact;
import com.dmilut.lesson_10.project.addressbook.service.ContactService;
import com.dmilut.lesson_10.project.addressbook.util.Util;

import java.io.IOException;

/* TODO: 8/26/20
    1. Реализовать проект "Адресная книга" в отдельном репозитории (не ветке, а именно создать отдельный репозиторий).
    Проект должен демонстрировать функционал адресной книги из реальной жизни:
    - просмотр контакта (поиск по имени)
    - просмотр всех контактов
    - создание контакта
    - обновление контакта
    - удаление контакта */
public class AddressBook {

    private static final ContactService contactService = new ContactService();
    private static final Util util = new Util();

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



