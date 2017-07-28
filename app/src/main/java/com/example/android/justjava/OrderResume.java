package com.example.android.justjava;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class OrderResume extends AppCompatActivity {

    public static final String EXTRA_NAME = "com.example.android.justjava.NAME";
    public static final String EXTRA_TOTAL = "com.example.android.justjava.TOTAL";
    private String name;
    private String total;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_resume);

        // Get the Intent that started this activity and extract the string
        // Capture the layout's TextView and set the string as its text
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_EXPRESSO);
        TextView valueview = (TextView) findViewById(R.id.expresso_order_text_view);
        valueview.setText(message);
        // BlackCoffe
        message = intent.getStringExtra(MainActivity.EXTRA_BLACKCOFFE);
        valueview = (TextView) findViewById(R.id.blackcoffe_order_text_view);
        valueview.setText(message);
        // Capuccino
        message = intent.getStringExtra(MainActivity.EXTRA_CAPUCCINO);
        valueview = (TextView) findViewById(R.id.capuccino_order_text_view);
        valueview.setText(message);
        // MilkCoffe
        message = intent.getStringExtra(MainActivity.EXTRA_MILKCOFFE);
        valueview = (TextView) findViewById(R.id.milkcoffe_order_text_view);
        valueview.setText(message);
        // Total
        total = intent.getStringExtra(MainActivity.EXTRA_TOTAL);
        valueview = (TextView) findViewById(R.id.total_order_text_view);
        valueview.setText(total);
        name = intent.getStringExtra(MainActivity.EXTRA_NAME);
    }

    /**
     * This method is called when the confirm button is clicked
     * @param view
     */
    public void confirmButton (View view){
        Intent nextview = new Intent(this, LastActivity.class);
        nextview.putExtra(EXTRA_NAME, name);
        nextview.putExtra(EXTRA_TOTAL, total);
        startActivity (nextview);
    }
    }
