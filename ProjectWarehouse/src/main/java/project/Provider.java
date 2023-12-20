package project;

import java.util.ArrayList;
import java.util.List;

public class Provider {
    private List<Product> productCells = new ArrayList<>();
    public List<Product> getProductCells() {
        return productCells;
    }
    public void setProductCells(List<Product> productCells) {
        this.productCells = productCells;
    }
    public void getInfoAboutProducts () {
        System.out.println("<<<<<<<<<   Доступные Товары   >>>>>>>>>");
        for (int i = 0; i < productCells.size(); i++) {
            System.out.println();
            System.out.print("Продукт молочника №");
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
