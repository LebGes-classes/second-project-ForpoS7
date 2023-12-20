import org.json.simple.parser.ParseException;

import java.io.IOException;
import project.*;

public class Main {
    public static void main(String[] args) {

        JsonSimpleParser parser = new JsonSimpleParser();
        Provider milkman = parser.parse();

        milkman.getInfoAboutProducts();

        Warehouse warehouse1 = new Warehouse();
        warehouse1.setVal();

//        Warehouse warehouse2 = new Warehouse();
//        warehouse2.setVal();

//        PointOfSale point1 = new PointOfSale();
//        point1.setVal();

//        Purchaser purchaser = new Purchaser();
//        purchaser.setVal();

        warehouse1.purchase(milkman.getProductCells().get(0));

        warehouse1.purchase(milkman.getProductCells().get(1));

        warehouse1.purchase(milkman.getProductCells().get(2));

        warehouse1.getInfo();

        warehouse1.write("Data.json");
    }
}