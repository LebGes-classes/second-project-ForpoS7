import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import project.Product;
import project.Provider;
import project.ResponsiblePerson;
import project.Storage;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class JsonSimpleParser {
    public Provider parse() {

        Provider provider = new Provider();

        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader("Provider.json")){

            JSONObject providerJsonObject = (JSONObject) parser.parse(reader);

            JSONArray productCellsArray = (JSONArray) providerJsonObject.get("productCells");

            List <Product> productCellsList = new ArrayList<>();
            for (Object it: productCellsArray) {
                JSONObject productCellsObject = (JSONObject) it;

                String idProduct = (String) productCellsObject.get("id");
                String nameProduct = (String) productCellsObject.get("name");
                String descriptionProduct = (String) productCellsObject.get("description");
                String deliveryStartDayProduct = (String) productCellsObject.get("deliveryStartDay");
                String deliveryDeadlineProduct = (String) productCellsObject.get("deliveryDeadline");
                long sizeProduct = (long) productCellsObject.get("size");
                long priceProduct = (long) productCellsObject.get("price");

                Product product = new Product();

                product.setId(idProduct);
                product.setName(nameProduct);
                product.setDescription(descriptionProduct);
                product.setDeliveryStartDay(deliveryStartDayProduct);
                product.setDeliveryDeadline(deliveryDeadlineProduct);
                product.setSize((int)sizeProduct);
                product.setPrice((int)priceProduct);

                productCellsList.add(product);
            }

            provider.setProductCells(productCellsList);

            return provider;
        } catch (Exception e) {
            System.out.println("Parsing error " + e.toString());
        }
        return null;
    }
}
