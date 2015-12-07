package com.example.jemy_pc.justjava;

import android.support.v7.app.ActionBarActivity;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.jemy_pc.justjava.R;

import java.text.NumberFormat;
import java.util.jar.Attributes;

public class MainActivity extends ActionBarActivity {
    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void increment(View view) {
        quantity = quantity + 1;
        display(quantity);
    }
    public void decrement(View view) {
        quantity = quantity - 1;
        display(quantity);
    }
    public void submitOrder(View view) {

        EditText nameField = (EditText)findViewById(R.id.name_field);
        String name = nameField.getText().toString();
        Log.v("MainActivity", "Name" + name);

        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();

        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = chocolateCheckBox.isChecked();

        int price = calculateThePrice(hasWhippedCream, hasChocolate) ;
        String priceMessage = createOrderSummary(name, price , hasWhippedCream, hasChocolate);
        displayMessage(priceMessage);
    }
    private int calculateThePrice(boolean hasWhippedCream,boolean hasChocolate ){
        int basePrice = 5;
        if (hasWhippedCream){
            basePrice = basePrice + 1;
        }
        if (hasChocolate){
            basePrice = basePrice +2;
        }
        return quantity * basePrice;
    }
    private String createOrderSummary(String name, int price, boolean addWhippedcream, boolean addChocolate){
        String priceMessage = "Name : " + name;
        priceMessage += "\nwhipped cream ? " + addWhippedcream ;
        priceMessage += "\nchocolate ? " + addChocolate;
        priceMessage += "\n quantity : " + quantity;
        priceMessage += "\nTotal: $"  + price;
        priceMessage += "\nThank You ;) " + "\nHAve fun ";
        return priceMessage;
    }
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
}