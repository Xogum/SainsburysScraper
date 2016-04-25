package gmail.uk.stephentaylor.sainsburysscraper;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.jsoup.Jsoup;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import android.test.suitebuilder.annotation.SmallTest;

import org.junit.runner.RunWith;

import java.io.File;
import java.io.IOException;

@RunWith(AndroidJUnit4.class)
@SmallTest
public class ScraperTest {

    private Context instrumentationCtx;
    private Opener opener;
    private File file;
    private Parser parser;
    private Basket basket;

    @Before
    public void setup() {

        instrumentationCtx = InstrumentationRegistry.getTargetContext();
        opener = new Opener(instrumentationCtx);
        file = opener.getFile();
        try {
            parser = new Parser(Jsoup.parse(file,"UTF-8",""));
        } catch (IOException e) {
            e.printStackTrace();
        }
        basket = new Basket(instrumentationCtx);
    }

    @Test
    public void testAccessToFile() {

        assertEquals("source.txt", file.getName());
    }

    @Test
    public void testContentExtraction() {

        assertEquals("Sainsbury's Avocado, Ripe & Ready x2", parser.getProducts().get(0).getDescription());
    }

    @Test
    public void testItemCount() {

        assertEquals(8, parser.getProducts().size());
    }

    @Test
    public void testTotaliser() {

        assertEquals("£14.30", basket.getTotalAsString());
    }
}
