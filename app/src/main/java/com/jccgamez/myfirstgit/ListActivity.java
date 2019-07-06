package com.jccgamez.myfirstgit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        String[] mylist = new String[]{"CNY - Yuan Renminbi - China - Beijing", "USD - US Dollar - USA - Washington",
                "EUR - Euro - European-Union", "GBP - Pound Sterling - United-Kingdom - London",
                "INR - Indian Rupee - India - New Delhi", "AUD - Australian Dollar - Australia - Canberra",
                "CAD - Canadian Dollar - Canada - Ottawa", "SGD - Singapore Dollar - Singapore - Singapore",
                "CHF - Swiss Franc - Switzerland - Bern", "MYR - Malaysian Ringgit - Malaysia - Kuala Lumpur",
                "JPY - Japanese Yen - Japan - Tokyo", "NZD - New Zealand Dollar - New Zealand - Wellington",
                "HKD - Hong Kong Dollar - Hong Kong - Victoria", "SEK - Swedish Krona - Sweden - Stockholm",
                "NOK - Norwegian Krone - Norway - Oslo", "DKK - Danish Krone - Denmark - Copenhagen"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mylist);

        ListView listView = (ListView) findViewById(R.id.lstMonedas);
        listView.setAdapter(adapter);
        addItemClickListener(listView);
    }

    private void addItemClickListener(final ListView listView) {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String itemValue = (String) listView.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(), "Position: " + position + " item: " + itemValue,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

}
