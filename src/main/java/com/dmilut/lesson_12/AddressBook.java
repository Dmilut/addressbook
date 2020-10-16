package com.dmilut.lesson_12;

import com.dmilut.lesson_12.project.addressbook.service.ContactService;
import com.dmilut.lesson_12.project.addressbook.util.Util;

import java.io.IOException;

/* TODO: 9/2/20
    1.1. Добавить в проект метод delete contact
    1.2. Добавить в проект метод search by last name
    1.3. Добавить в проект метод search by city name
    1.4. Добавить в проект метод print all contacts names, который выводит в консоль только имена и фамилии всех контактов */
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
            System.out.println("search by first name    - поиск по имени контакта =======================================");
            System.out.println("search by last name     - поиск по фамилии контакта =====================================");
            System.out.println("search by city          - поиск по городу ===============================================");
            System.out.println("delete by first name    - удаление контакта =============================================");
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
                case "search by first name": {
                    System.out.println("Введите имя");
                    String firstName = Util.inputText();

                    contactService.printContact(contactService.searchByFirstName(firstName));
                }
                case "search by last name": {
                    System.out.println("Введите фамилию");
                    String lastName = Util.inputText();

                    contactService.printContact(contactService.getContactByLastName(lastName));
                }
                case "search by city": {
                    System.out.println("Введите город");
                    String cityName = Util.inputText();

                    contactService.printContact(contactService.getContactByCityName(cityName));
                }
                break;
                case "delete by first name": {
                    System.out.println("Введите имя");
                    String firstName = Util.inputText();

                    contactService.deleteContactByFirstName(firstName);
                }
                break;
                default: {
                    System.out.println("Вы ошиблись!!!");
                }
            }

            System.out.println('\n' + "Для продолжения введите continue или что-нибудь другое если хотите выйти");
            command = Util.inputText();
        }
    }
}



