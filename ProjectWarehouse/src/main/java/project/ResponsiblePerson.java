package project;

import java.util.Scanner;

public class ResponsiblePerson extends Human {
    Scanner scan = new Scanner(System.in);
    @Override
    public void setVal () {
        System.out.println("<<<<<<<<<   Назначение Ответственного Лица   >>>>>>>>>");
        System.out.println();
        super.setVal();
    }
}
