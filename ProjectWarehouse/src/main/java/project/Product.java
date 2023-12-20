package project;

import java.util.Scanner;

public class Product {
    private String id;
    private String name;
    private String description;
    private String deliveryStartDay;
    private String deliveryDeadline;
    private int size;
    private int price;
    public String getDescription() {
        return description;
    }
    public String getDeliveryStartDay() {
        return deliveryStartDay;
    }
    public String getDeliveryDeadline() {
        return deliveryDeadline;
    }
    public int getPrice() {
        return price;
    }
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getSize() {
        return size;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setDeliveryStartDay(String deliveryStartDay) {
        this.deliveryStartDay = deliveryStartDay;
    }
    public void setDeliveryDeadline(String deliveryDeadline) {
        this.deliveryDeadline = deliveryDeadline;
    }
    public void setSize(int size) {
        this.size = size;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    Scanner scan = new Scanner(System.in);
    public void setVal () {
        String tmp;
        System.out.println("<<<<<<<<<   Создание Продукта   >>>>>>>>>");
        System.out.println("Доступные данные - ID, NAME, DESCRIPTION, DELIVERY_START_DAY, DELIVERY_DEADLINE, SIZE, PRICE");
        System.out.println();
        System.out.println("Задайте новое значение для ID:");
        tmp = scan.nextLine();
        if (tmp.isEmpty()) {
            System.out.println("Данные не изменены.");
            System.out.println();
        } else {
            id = tmp;
            System.out.println("Данные изменены.");
            System.out.println();
        }
        System.out.println("Задайте новое значение для NAME:");
        tmp = scan.nextLine();
        if (tmp.isEmpty()) {
            System.out.println("Данные не изменены.");
            System.out.println();
        } else {
            name = tmp;
            System.out.println("Данные изменены.");
            System.out.println();
        }
        System.out.println("Задайте новое значение для DESCRIPTION:");
        tmp = scan.nextLine();
        if (tmp.isEmpty()) {
            System.out.println("Данные не изменены.");
            System.out.println();
        } else {
            description = tmp;
            System.out.println("Данные изменены.");
            System.out.println();
        }
        System.out.println("Задайте новое значение для DELIVERY_START_DAY:");
        tmp = scan.nextLine();
        if (tmp.isEmpty()) {
            System.out.println("Данные не изменены.");
            System.out.println();
        } else {
            deliveryStartDay = tmp;
            System.out.println("Данные изменены.");
            System.out.println();
        }
        System.out.println("Задайте новое значение для DELIVERY_DEADLINE:");
        tmp = scan.nextLine();
        if (tmp.isEmpty()) {
            System.out.println("Данные не изменены.");
            System.out.println();
        } else {
            deliveryDeadline = tmp;
            System.out.println("Данные изменены.");
            System.out.println();
        }
        System.out.println("Задайте новое значение для PRICE:");
        int tmpI;
        tmpI = scan.nextInt();
        if (tmpI < 1) {
            System.out.println("Данные не изменены.");
            System.out.println();
        } else {
            price = tmpI;
            System.out.println("Данные изменены.");
            System.out.println();
        }
        System.out.println("Задайте новое значение для SIZE:");
        tmpI = scan.nextInt();
        if (tmpI < 1) {
            System.out.println("Данные не изменены.");
            System.out.println();
        } else {
            size = tmpI;
            System.out.println("Данные изменены.");
            System.out.println();
        }
    }
}
