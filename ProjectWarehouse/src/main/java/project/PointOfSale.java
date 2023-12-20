package project;

public class PointOfSale extends Storage {
    private int k;
    public int getK() {
        return k;
    }
    public void sale (Product product, Purchaser purchaser) {
        if (getState()) { // проверка на то, что Предприятие открыто
            if (getProductCells().isEmpty()) { // проверка на наличие товара
                System.out.println("<<<<<<<<< Error >>>>>>>>>");
                System.out.println("Товара нет в Пункте Продажи");
            } // не сделал else, т.к. всё равно не зайдет в цикл ни разу
            for (int i = 0; i < getProductCells().size(); i++) {
                if (getProductCells().get(i).getId().equals(product.getId())) { // если товар есть в Пункте Продажи (Проверка по id)
                    getProductCells().remove(i); // удаляем товар (Покупатель в тильте)
                    purchaser.setK(purchaser.getK() + 1); // имитация того, что Покупатель купил товар (Счетчик покупателя +1)
                    k++; // счетчик продаж у Пункта Продажи
                    break;
                } else if (!getProductCells().get(getProductCells().size() - 1).getId().equals(product.getId())) { // если товара нет в последней ячеке
                    System.out.println("<<<<<<<<< Error >>>>>>>>>");
                    System.out.println("Товара нет в Пункте Продажи");
                }
            }
        } else {
            System.out.println();
            System.out.println("<<<<<<<<<   Error   >>>>>>>>>");
            System.out.println("Строение закрыто.");
        }
    }
    @Override
    public void setVal() {
        System.out.println("<<<<<<<<<   Создание Пункта Продаж   >>>>>>>>>");
        super.setVal();
    }
    public void getInfo () {
        System.out.println("<<<<<<<<<   Информация о Пункте Продажи   >>>>>>>>>");
        super.getInfo();
    }
}
