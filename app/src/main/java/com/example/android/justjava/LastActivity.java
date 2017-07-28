package com.example.android.justjava;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LastActivity extends AppCompatActivity {

    private String name;
    private String total;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last);
        Intent intent = getIntent();
        name = intent.getStringExtra(MainActivity.EXTRA_NAME);
        total = intent.getStringExtra(MainActivity.EXTRA_TOTAL);
        TextView message = (TextView) findViewById(R.id.thankmessage_text_view);
        message.setText("Obrigado " + name.trim() + ", volte sempre!");

        message = (TextView)findViewById(R.id.total_order_text_view);
        message.setText(total);
    }

    /**
     * this method is called when mainmenu button is clicked
     */

    public void mainMenu (View view){
        Intent main = new Intent(this, MainActivity.class);
        startActivity(main);
    }
}
