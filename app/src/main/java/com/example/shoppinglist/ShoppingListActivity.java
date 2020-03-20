package com.example.shoppinglist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ShoppingListActivity extends AppCompatActivity {
    private Button button1,  button2,  button3,  button4,  button5,  button6,  button7,  button8,  button9,  button10,  button11,  button12;
    private static final String LOG_TAG = ShoppingListActivity.class.getSimpleName();
    public static final String EXTRA_REPLY = "ShoppingListActivity.extra.REPLY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_list);
        button1 = findViewById(R.id.button_item1);
        button2 = findViewById(R.id.button_item2);
        button3 = findViewById(R.id.button_item3);
        button4 = findViewById(R.id.button_item4);
        button5 = findViewById(R.id.button_item5);
        button6 = findViewById(R.id.button_item6);
        button7 = findViewById(R.id.button_item7);
        button8 = findViewById(R.id.button_item8);
        button9 = findViewById(R.id.button_item9);
        button10 = findViewById(R.id.button_item10);
        button11 = findViewById(R.id.button_item11);
        button12 = findViewById(R.id.button_item12);

        button1.setOnClickListener(new ButtonListener("Chicken"));
        button2.setOnClickListener(new ButtonListener("Egg"));
        button3.setOnClickListener(new ButtonListener("Flour"));
        button4.setOnClickListener(new ButtonListener("Ramen"));
        button5.setOnClickListener(new ButtonListener("Cookies"));
        button6.setOnClickListener(new ButtonListener("Pie"));
        button7.setOnClickListener(new ButtonListener("Jam"));
        button8.setOnClickListener(new ButtonListener("Butter"));
        button9.setOnClickListener(new ButtonListener("Ketchup"));
        button10.setOnClickListener(new ButtonListener("Wafer"));
        button11.setOnClickListener(new ButtonListener("Candy"));
        button12.setOnClickListener(new ButtonListener("Cake"));

    }

    private class ButtonListener implements View.OnClickListener{
        String itemName;
        public ButtonListener(String name){
            itemName = name;
        }
        @Override
        public void onClick(View v) {
            Intent replyIntent = new Intent();
            replyIntent.putExtra(EXTRA_REPLY, itemName);
            setResult(RESULT_OK,replyIntent);
            Log.d(LOG_TAG, "Reply "+itemName);
            finish();
        }
    }
}
