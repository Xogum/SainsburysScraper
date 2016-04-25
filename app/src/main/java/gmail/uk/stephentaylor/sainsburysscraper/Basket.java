package gmail.uk.stephentaylor.sainsburysscraper;

import android.content.Context;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

/**
 * A container class with additional methods to total up product values.
 * @author Ste
 */

public class Basket extends ArrayList<Product> {

    Context context;
    float total = 0;

    public Basket(Context context) {

        super();
        this.context = context;
        fillBasket();
    }

    /**
     * Scrape the page using the Jsoup library Document object.
     */
    private void fillBasket() {

        File file = new Opener(context).getFile();
        Document doc = null;

        try {
            doc = Jsoup.parse(file, "UTF-8", "");
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.addAll(new Parser(doc).getProducts());
        setTotal();
    }

    /**
     * Extract the total of all items as an integer.
     */
    private void setTotal() {

        for (Product p: this) {

            int i = p.getUnitPriceAsInteger();
            total += i;
        }
    }

    /**
     * Convert the total to currency and return as a string
     */
    public String getTotalAsString() {

        NumberFormat GBP = NumberFormat.getCurrencyInstance(Locale.UK);
        return (GBP.format(total/100).toString());
    }

}
