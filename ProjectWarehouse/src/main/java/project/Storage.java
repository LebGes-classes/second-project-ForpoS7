package project;

import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.Jsoner;
import org.json.simple.JSONObject;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Storage {
    private boolean state;
    private String id;
    private String address;
    private int capacity;
    private int fill;
    private ResponsiblePerson responsiblePerson = new ResponsiblePerson();
    private List<Product> productCells = new ArrayList<>();
    public boolean getState () {
        return state;
    }
    public String getId() {
        return id;
    }
    public String getAddress() {
        return address;
    }
    public int getCapacity() {
        return capacity;
    }
    public int getFill() {
        return fill;
    }
    public Human getResponsiblePerson() {
        return responsiblePerson;
    }
    public List<Product> getProductCells() {
        return productCells;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public void setFill(int fill) {
        this.fill = fill;
    }
    public void setResponsiblePerson(ResponsiblePerson responsiblePerson) {
        this.responsiblePerson = responsiblePerson;
    }
    public void setProductCells(List<Product> productCells) {
        this.productCells = productCells;
    }
    public void movementOfProduct (Storage storage, Product product) { // Storage storage - туда перемещаем товар: Product product
        if (state) {
            if (storage.filling(product)) { // проверка на переполненность
                storage.productCells.add(product);
                for (int i = 0; i < storage.productCells.size(); i++) {
                    for (int j = 0; j < productCells.size(); j++) {
                        if (storage.productCells.get(i) == productCells.get(j)) { // находим в списке товар проверяя по ссылке, с последующим удалением с места окуда перемещали
                            productCells.remove(j);
                            break;
                        }
                    }
                }
            } else {
                System.out.println();
                System.out.println("<<<<<<<<< Error >>>>>>>>>");
                System.out.println("Ячеки с товаром переполнены.");
                System.out.println("Товар не передан.");
            }
        } else {
            System.out.println();
            System.out.println("<<<<<<<<<   Error   >>>>>>>>>");
            System.out.println("Строение закрыто.");
        }
    }
    public boolean filling (Product product) {
        int tmp = fill;
        fill += product.getSize();
        if (fill > capacity) {
            System.out.println("<<<<<<<<< Error >>>>>>>>>");
            System.out.println("Превышен лимит вместимости.");
            System.out.println("Товар не получен.");
            fill = tmp;
            return false;
        }
        return true;
    }
    Scanner scan = new Scanner(System.in);
    public void setVal () { // создание
        String tmp;
        int tmpI;
        state = true;
        System.out.println("Доступные данные - ID, ADDRESS, CAPACITY, RESPONSIBLE_PERSON");
        System.out.println();
        System.out.println("Задайте значение для ID:");
        tmp = scan.nextLine();
        if (tmp.isEmpty()) {
            System.out.println("Данные не изменены.");
            System.out.println();
        } else {
            id = tmp;
            System.out.println("Данные изменены.");
            System.out.println();
        }
        System.out.println("Задайте значение для ADDRESS:");
        tmp = scan.nextLine();
        if (tmp.isEmpty()) {
            System.out.println("Данные не изменены.");
            System.out.println();
        } else {
            address = tmp;
            System.out.println("Данные изменены.");
            System.out.println();
        }
        System.out.println("Задайте значение для CAPACITY:");
        tmpI = scan.nextInt();
        if (tmpI < 1) {
            System.out.println("Данные не изменены.");
            System.out.println();
        } else {
            capacity = tmpI;
            System.out.println("Данные изменены.");
            System.out.println();
        }
        fill = 0;
        System.out.println("Заполните данные RESPONSIBLE_PERSON:");
        responsiblePerson.setVal();
    }
    public void changeStatus () {
        state = !state;
    }
    public void changeResponsiblePerson () {
        System.out.println("<<<<<<<<<   Смена Ответственного Лица   >>>>>>>>>");
        System.out.println("Заполните данные RESPONSIBLE_PERSON:");
        responsiblePerson.setVal();
    }
    public void getInfoAboutProducts () {
        if (getProductCells().isEmpty()) {
            System.out.println("Ячейки с товаром пусты.");
        } else {
            System.out.println("Кол-во ячеек, заполненных товаром - " + productCells.size() + ".");
            for (int i = 0; i < productCells.size(); i++) {
                System.out.println();
                System.out.print("Информация о ячейке под номером ");
                System.out.print(i+1);
                System.out.println(":");
                System.out.println("ID: " + productCells.get(i).getId());
                System.out.println("NAME: " + productCells.get(i).getName());
                System.out.println("DESCRIPTION: " + productCells.get(i).getDescription());
                System.out.println("DELIVERY_START_DAY: " + productCells.get(i).getDeliveryStartDay());
                System.out.println("DELIVERY_DEADLINE: " + productCells.get(i).getDeliveryDeadline());
                System.out.println("SIZE: " + productCells.get(i).getSize());
                System.out.println("PRICE: " + productCells.get(i).getPrice());
            }
        }
    }
    public void getInfo () {
        System.out.println("ID: " + id);
        System.out.println("ADDRESS: " + address);
        System.out.println("CAPACITY: " + capacity);
        System.out.println("FILL: " + fill);
        System.out.println("RESPONSIBLE_PERSON_NAME: " + responsiblePerson.getName());
        System.out.println("RESPONSIBLE_PERSON_DATE_OF_BIRTH: " + responsiblePerson.getDateOfBirth());
        System.out.println("PRODUCT_CELLS: ");
        getInfoAboutProducts();
    }
    public void write (String Data) {
        try {
            BufferedWriter writer = Files.newBufferedWriter(Paths.get(Data));

            JSONObject storageJsonObject = new JSONObject();
            JSONObject responsiblePersonObject = new JSONObject();
            JsonArray productCellsArray = new JsonArray();

            responsiblePersonObject.put("name", getResponsiblePerson().getName());
            responsiblePersonObject.put("dateOfBirth", getResponsiblePerson().getDateOfBirth());

            for (int i = 0; i < productCells.size(); i++) {
                JSONObject productObject = new JSONObject();

                productObject.put("id", productCells.get(i).getId());
                productObject.put("name", productCells.get(i).getName());
                productObject.put("description", productCells.get(i).getDescription());
                productObject.put("deliveryStartDay", productCells.get(i).getDeliveryStartDay());
                productObject.put("deliveryDeadline", productCells.get(i).getDeliveryDeadline());
                productObject.put("price", productCells.get(i).getPrice());
                productObject.put("size", productCells.get(i).getSize());

                productCellsArray.add(productObject);
            }

            storageJsonObject.put("id", id);
            storageJsonObject.put("address", address);
            storageJsonObject.put("capacity", capacity);
            storageJsonObject.put("fill", fill);
            storageJsonObject.put("responsiblePerson", responsiblePersonObject);
            storageJsonObject.put("productCells", productCellsArray);

            Jsoner.serialize(storageJsonObject, writer);

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}