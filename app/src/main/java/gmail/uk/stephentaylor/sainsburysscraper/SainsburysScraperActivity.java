package gmail.uk.stephentaylor.sainsburysscraper;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Main activity class that contains the entry point.  It contains an Android adapter class
 * to dynamically update the UI.
 */

public class SainsburysScraperActivity extends ListActivity {

    private Basket basket;
    private ProductAdapter m_aAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        basket = new Basket(this);
        this.m_aAdapter = new ProductAdapter(this, R.layout.row, basket);
            setListAdapter(this.m_aAdapter); //Update the UI with the basket details.
        updateTotal();
    }

    private void updateTotal() {

        TextView tv = (TextView) this.findViewById(R.id.total);
//        System.out.println(basket.getTotalAsString());
        tv.setText("Total: " + basket.getTotalAsString());
    }

    private class ProductAdapter extends ArrayAdapter<Product> {

        private Basket basket;
        private Context context;

        public ProductAdapter(Context context, int textViewResourceId, Basket basket){

            super(context, textViewResourceId, basket);
            this.context = context;
            this.basket = basket;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v = convertView;
            if (v == null) {

                LayoutInflater vi = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                v = vi.inflate(R.layout.row, null);
            }

            Product p = basket.get(position);
            if (p != null) {

                ImageView image = (ImageView) v.findViewById(R.id.imageView);
                TextView description = (TextView) v.findViewById(R.id.description);
                TextView perUnitCost = (TextView) v.findViewById(R.id.unitCost);
                TextView eachCost = (TextView) v.findViewById(R.id.perCost);

                if (image != null) {
                    Picasso.with(context).load(p.getProductImageURL()).into(image);
                }
                if (description != null) {
                    description.setText(p.getDescription());
                }
                if (perUnitCost != null) {
                    perUnitCost.setText(p.getPricePerUnit());
                }
                if (eachCost != null) {
                    eachCost.setText(p.getPriceEach());
                }
            }
            return v;
        }
    }
}