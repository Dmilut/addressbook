package com.dmilut.lesson_22;

import com.dmilut.lesson_22.service.ContactService;
import com.dmilut.lesson_22.util.Util;

/* TODO: 9/28/20
    1. Преобразовать проект AddressBook в maven-проект в вашем отдельном репозитории. */
public class AddressBook {

    private static final ContactService contactService = new ContactService();
    private static final Util util = new Util();

    public static void main(String[] args) {
        util.initApp();

        System.out.println("=========================================================================================");
        System.out.println("                        Добро пожаловать в адресную книгу                                ");
        System.out.println("=========================================================================================");

        String command = "continue";

        while (!command.equals("exit")) {

            System.out.println("Подсказка по коммандам ==================================================================");
            System.out.println("enter contact           - ввод нового контакта ==========================================");
            System.out.println("print contacts          - вывод в консоль всех контактов ================================");
            System.out.println("search                  - поиск контакта ================================================");
            System.out.println("delete by first name    - удаление контакта =============================================");
            System.out.println("delete all              - удаление всех контактов =======================================");
            System.out.println("exit                    - выход из программы ============================================");
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

                case "search": {
                    System.out.println("Введите имя / фамилию / город");
                    String searchQuery = Util.inputText();

                    contactService.printContact(contactService.searchByFirstNameOrLastNameOrCityName(searchQuery));
                }
                break;

                case "delete by first name": {
                    System.out.println("Введите имя");
                    String firstName = Util.inputText();

                    contactService.deleteContactByFirstName(firstName);
                }
                break;

                case "delete all": {
                    contactService.deleteAll();
                }
                break;

                case "exit": {
                    command = "exit";
                }
                break;

                default: {
                    System.out.println("Вы ошиблись!!!");
                    command = "continue";
                }
            }

        }
    }
}



