package gmail.uk.stephentaylor.sainsburysscraper;

import java.util.ArrayList;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 * The class that extracts content from the Document representation of the HTML page.
 * It populates product object fields and adds these products to an array, which will in turn
 * be consumed by the Basket class.
 * @author Ste
 */

public class Parser {

    Document document;
    int numberOfProducts;
    ArrayList<Product> productList = new ArrayList<Product>();

    public Parser(Document document) {

        this.document = document;
        this.numberOfProducts = document.select("div.productInfo").size();
        buildArray();
    }

    private void buildArray() {

        for (int i = 0; i < numberOfProducts ; i++) {

            productList.add(new Product());
            extractProductImage(i);
            extractProductDescription(i);
            extractPricePerUnit(i);
            extractPriceEach(i);
//			System.out.println(productList.get(i));
        }
    }

    private void extractProductImage(int index) {

        Element element = document.select("h3").get(index).select("img").first();
        String imgSrc = element.attr("src");
        productList.get(index).setProductImageURL(imgSrc);
    }

    private void extractProductDescription(int index) {

        Element element = document.select("h3").get(index);
        String innerText = element.text().trim();
        productList.get(index).setDescription(innerText);
    }

    private void extractPricePerUnit(int index) {

        Element element = document.select("p.pricePerUnit").get(index);
        String innerText = element.text().trim();
        productList.get(index).setPricePerUnit(innerText);
    }

    private void extractPriceEach(int index) {

        Element element = document.select("p.pricePerMeasure").get(index);
        String innerText = element.text().trim();
        productList.get(index).setPriceEach(innerText);
    }

    public ArrayList<Product> getProducts() {

        return productList;
    }
}
