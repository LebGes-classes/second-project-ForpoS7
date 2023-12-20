package project;

import java.util.Scanner;

public abstract class Human {
    private String name;
    private String dateOfBirth;
    public void setName(String name) {
        this.name = name;
    }
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public String getName() {
        return name;
    }
    public String getDateOfBirth() {
        return dateOfBirth;
    }
    Scanner scan = new Scanner(System.in);
    public void setVal() {
        String tmp;
        System.out.println("Доступные данные - NAME, DATE_OF_BIRTH.");
        System.out.println();
        System.out.println("Задайте новое значение для NAME:");
        tmp = scan.nextLine();
        if (tmp.isEmpty()) {
            System.out.println("Данные не изменены.");
            System.out.println();
        } else {
            setName(tmp);
            System.out.println("Данные изменены.");
            System.out.println();
        }
        System.out.println("Задайте новое значение для DATE_OF_BIRTH:");
        tmp = scan.nextLine();
        if (tmp.isEmpty()) {
            System.out.println("Данные не изменены.");
            System.out.println();
        } else {
            setDateOfBirth(tmp);
            System.out.println("Данные изменены.");
            System.out.println();
        }
    }
}

