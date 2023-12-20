package project;

import java.util.UUID;

public class Warehouse extends Storage {
    public void purchase (Product product) {
        if (getState()) { // проверка на то, что Склад открыт
            Product newProduct = new Product();
            setNewProduct(product, newProduct);
            if (filling(newProduct)) { // проверка на заполненность
                getProductCells().add(newProduct);
            } else {
                newProduct = null;
            }
        } else {
            System.out.println();
            System.out.println("<<<<<<<<<   Error   >>>>>>>>>");
            System.out.println("Строение закрыто.");
        }
    }
    private void setNewProduct (Product product, Product newProduct) {
        UUID uuid = UUID.randomUUID();
        newProduct.setId(uuid.toString());
        newProduct.setName(product.getName());
        newProduct.setDescription(product.getDescription());
        newProduct.setDeliveryStartDay(product.getDeliveryStartDay());
        newProduct.setDeliveryDeadline(product.getDeliveryDeadline());
        newProduct.setSize(product.getSize());
        newProduct.setPrice(product.getPrice());
    }
    @Override
    public void setVal() {
        System.out.println("<<<<<<<<<   Создание Cклада   >>>>>>>>>");
        super.setVal();
    }
    public void getInfo () {
        System.out.println("<<<<<<<<<   Информация о Складе   >>>>>>>>>");
        super.getInfo();
    }
}
