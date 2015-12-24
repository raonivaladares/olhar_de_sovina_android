package br.com.devsup.www.sovina;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(br.com.devsup.www.sovina.R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(br.com.devsup.www.sovina.R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(br.com.devsup.www.sovina.R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final EditText editTextQuantityProduct01 = (EditText) findViewById(br.com.devsup.www.sovina.R.id.edit_text_quantity_product_01);
                final EditText editTextValueProduct01 = (EditText) findViewById(br.com.devsup.www.sovina.R.id.edit_text_value_product_01);
                final EditText editTextQuantityProduct02 = (EditText) findViewById(br.com.devsup.www.sovina.R.id.edit_text_quantity_product_02);
                final EditText editTextValueProduct02 = (EditText) findViewById(br.com.devsup.www.sovina.R.id.edit_text_value_product_02);

                final double quantityProduct01 = Double.valueOf(editTextQuantityProduct01.getText().toString());
                final double valueProduct01 = Double.valueOf(editTextValueProduct01.getText().toString());
                final double quantityProduct02 = Double.valueOf(editTextQuantityProduct02.getText().toString());
                final double valueProduct02 = Double.valueOf(editTextValueProduct02.getText().toString());

                final double x = (quantityProduct02 * valueProduct01) / quantityProduct01;

                final String resultText;

                if(valueProduct02 > x) {
                    resultText = "Produto 01 mais barato";
                } else if (valueProduct02 == x) {
                    resultText = "Produto com mesmo valor";
                } else {
                    resultText = "Produto 02 mais barato";
                }
                Snackbar.make(view, resultText, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(br.com.devsup.www.sovina.R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == br.com.devsup.www.sovina.R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
