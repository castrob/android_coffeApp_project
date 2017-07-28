package com.example.android.justjava;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    public static final String EXTRA_MESSAGE = "com.example.android.justjava.MESSAGE";
    private int expressoAmountOfCoffe;
    private int blackCoffeAmountOfCoffe;
    private int capuccinoAmountOfCoffe;
    private int milkCoffeAmountOfCoffe;
    private double totalPrice;

    TextView textViewExpressoAmountOfCoffe;
    TextView textViewBlackCoffeAmountOfCoffe;
    TextView textViewCapuccinoAmountOfCoffe;
    TextView textViewMilkCoffeAmountOfCoffe;
    TextView textViewCost;

    /**
      *  This App displays an order form to order coffe
      */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewExpressoAmountOfCoffe = (TextView) findViewById(R.id.quantity_expresso_text_view);
        textViewBlackCoffeAmountOfCoffe = (TextView) findViewById(R.id.quantity_blackcoffe_text_view);
        textViewCapuccinoAmountOfCoffe = (TextView) findViewById(R.id.quantity_capuccino_text_view);
        textViewMilkCoffeAmountOfCoffe = (TextView) findViewById(R.id.quantity_milkcoffe_text_view);
        textViewCost = (TextView) findViewById(R.id.cost_text_view);
    }

    /**
     * this method is called when the Expresso Button is Clicked
     */

    public void expressoCoffe (View view){
        CheckBox ckbExpresso = (CheckBox) findViewById(R.id.expresso_checkbox);
        // Only increase or decrease if checkbox is checked
        if (ckbExpresso.isChecked()){
            // get which button is pressed plus or minus
            if (view.getId() == R.id.btn_amount_plus_expresso){
                expressoAmountOfCoffe = expressoAmountOfCoffe + 1;
                textViewExpressoAmountOfCoffe.setText(String.valueOf(expressoAmountOfCoffe));
                priceUpdate();
            }else if (view.getId() == R.id.btn_amount_minus_expresso){
                if(expressoAmountOfCoffe != 0)
                    expressoAmountOfCoffe = expressoAmountOfCoffe - 1;
                    textViewExpressoAmountOfCoffe.setText(String.valueOf(expressoAmountOfCoffe));
                    priceUpdate();
                // if not checked, show a 0 amout to dont confuse the user.
            }
        }else{
            textViewExpressoAmountOfCoffe.setText(String.valueOf(0));
            expressoAmountOfCoffe = 0;
            priceUpdate();
        }
    }


    /**
     * this method is called when the black coffe button is clicked
     */

    public void blackCoffe (View view){
        CheckBox ckbBlackCoffe = (CheckBox) findViewById(R.id.blackcoffe_checkbox);
        // Only increase or decrease if checkbox is checked
        if (ckbBlackCoffe.isChecked()){
            // get which button is pressedn plus or minus
            if (view.getId() == R.id.btn_amount_plus_blackcoffe){
                blackCoffeAmountOfCoffe = blackCoffeAmountOfCoffe + 1;
                textViewBlackCoffeAmountOfCoffe.setText(String.valueOf(blackCoffeAmountOfCoffe));
                priceUpdate();
            }else if (view.getId() == R.id.btn_amount_minus_blackcoffe){
                if (blackCoffeAmountOfCoffe != 0)
                blackCoffeAmountOfCoffe = blackCoffeAmountOfCoffe - 1;
                textViewBlackCoffeAmountOfCoffe.setText(String.valueOf(blackCoffeAmountOfCoffe));
                priceUpdate();
            }
        }else {
            textViewBlackCoffeAmountOfCoffe.setText(String.valueOf(0));
            blackCoffeAmountOfCoffe = 0;
            priceUpdate();
        }
    }


    /**
     *  this method is called when the capuccino button is clicked
     */

    public void capuccinoCoffe (View view){
        CheckBox ckbCapuccinoCoffe = (CheckBox) findViewById(R.id.capuccino_checkbox);
        // Only increase or decrease if checkbox is checked
        if (ckbCapuccinoCoffe.isChecked()){
            // get which button is pressed plus or minus
            if (view.getId() == R.id.btn_amount_plus_capuccino){
                capuccinoAmountOfCoffe = capuccinoAmountOfCoffe + 1;
                textViewCapuccinoAmountOfCoffe.setText(String.valueOf(capuccinoAmountOfCoffe));
                priceUpdate();
            } else if (view.getId() == R.id.btn_amount_minus_capuccino){
                if(capuccinoAmountOfCoffe != 0)
                capuccinoAmountOfCoffe = capuccinoAmountOfCoffe - 1;
                textViewCapuccinoAmountOfCoffe.setText(String.valueOf(capuccinoAmountOfCoffe));
                priceUpdate();
            }
        } else {
            textViewCapuccinoAmountOfCoffe.setText(String.valueOf(0));
            capuccinoAmountOfCoffe = 0;
            priceUpdate();
        }
    }

    /**
     * this method is called when the milkCoffe button is clicked
     */

    public void milkCoffe (View view){
        CheckBox ckbMilkCoffe = (CheckBox) findViewById(R.id.milkcoffe_checkbox);
        // Only increase or decrease if checkbox is checked
        if (ckbMilkCoffe.isChecked()){
            // get which button is pressed plus or minus
            if (view.getId() == R.id.btn_amount_plus_milkcoffe){
                milkCoffeAmountOfCoffe = milkCoffeAmountOfCoffe + 1;
                textViewMilkCoffeAmountOfCoffe.setText(String.valueOf(milkCoffeAmountOfCoffe));
                priceUpdate();
            }else if (view.getId() == R.id.btn_amount_minus_milkcoffe){
                if (milkCoffeAmountOfCoffe != 0)
                milkCoffeAmountOfCoffe = milkCoffeAmountOfCoffe - 1;
                textViewMilkCoffeAmountOfCoffe.setText(String.valueOf(milkCoffeAmountOfCoffe));
                priceUpdate();
            }
        }else{
            textViewMilkCoffeAmountOfCoffe.setText(String.valueOf(0));
            milkCoffeAmountOfCoffe = 0;
            priceUpdate();
        }
    }


    /**
     * this method displays the given quantity value on the screen
     */

    public void priceUpdate ( ){
        CheckBox ckbExpresso = (CheckBox) findViewById(R.id.expresso_checkbox);
        CheckBox ckbCapuccinoCoffe = (CheckBox) findViewById(R.id.capuccino_checkbox);
        CheckBox ckbBlackCoffe = (CheckBox) findViewById(R.id.blackcoffe_checkbox);
        CheckBox ckbMilkCoffe = (CheckBox) findViewById(R.id.milkcoffe_checkbox);
        totalPrice = 0;
        if (ckbExpresso.isChecked())
            totalPrice = totalPrice + expressoAmountOfCoffe*2.0;
        if(ckbBlackCoffe.isChecked())
            totalPrice = totalPrice + blackCoffeAmountOfCoffe*1.50;
        if(ckbCapuccinoCoffe.isChecked())
            totalPrice = totalPrice + capuccinoAmountOfCoffe*2.50;
        if(ckbMilkCoffe.isChecked())
            totalPrice = totalPrice + milkCoffeAmountOfCoffe*1.80;

        textViewCost.setText("R$ " + totalPrice + "0");
    }

    /**
     * this function is called when the submit button is clicked
     */

    public void submitOrder (View view){
        Intent intent = new Intent(this, OrderResume.class);
        String message = "Hello World";
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    /**
     * TODO
     * function to submit order
     */
}
