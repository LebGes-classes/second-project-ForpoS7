package project;

public class Purchaser extends Human {
    private int k = 0;
    public int getK() {
        return k;
    }
    public void setK(int k) {
        this.k = k;
    }
    @Override
    public void setVal() {
        System.out.println("<<<<<<<<<   Создание Потанциального Покупателя   >>>>>>>>>");
        super.setVal();
    }
}
