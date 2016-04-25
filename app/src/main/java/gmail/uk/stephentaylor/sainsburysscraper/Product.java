package gmail.uk.stephentaylor.sainsburysscraper;

/**
 * A class for storing scraped information about each product on the page.
 * @author Ste
 */

public class Product {

    private String productImageURL;
    private String description;
    private String pricePerUnit;
    private String priceEach;
    private int intPrice = 0;

    public Product(String productImageURL, String description, String pricePerUnit,
                   String priceEach) {

        this.productImageURL = productImageURL;
        this.description = description;
        this.pricePerUnit = pricePerUnit;
        this.priceEach = priceEach;
    }

    public Product() {

        productImageURL = "";
        description = "";
        pricePerUnit = "";
        priceEach = "";
        intPrice = 0;
    }

    public String getProductImageURL() {
        return productImageURL;
    }

    public void setProductImageURL(String productImageURL) {
        this.productImageURL = productImageURL;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(String pricePerUnit) {

        this.pricePerUnit = pricePerUnit;
        setUnitPriceAsInteger();
    }

    public String getPriceEach() {
        return priceEach;
    }

    public void setPriceEach(String priceEach) {
        this.priceEach = priceEach;
    }

    private void setUnitPriceAsInteger() {

        String temp = pricePerUnit.replaceAll("\\D+","");
        System.out.println(temp);
        intPrice = Integer.parseInt(temp);
    }

    public int getUnitPriceAsInteger() {

        return intPrice;
    }

    public String toString() {

        return "Description: " + description + "\n"
                + "Product Image: " + productImageURL + "\n"
                + "Price per unit: " + pricePerUnit + "\n"
                + "Price each: " + priceEach + "\n"
                + "Int price: " + getUnitPriceAsInteger();
    }

}
