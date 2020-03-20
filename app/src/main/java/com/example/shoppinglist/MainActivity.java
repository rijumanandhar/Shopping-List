package com.example.shoppinglist;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static final int TEXT_REQUEST = 1;
    private TextView listText1, listText2, listText3, listText4, listText5, listText6, listText7, listText8, listText9, listText10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(LOG_TAG,"On Create");
        listText1 = findViewById(R.id.text_item1);
        listText2 = findViewById(R.id.text_item2);
        listText3 = findViewById(R.id.text_item3);
        listText4 = findViewById(R.id.text_item4);
        listText5 = findViewById(R.id.text_item5);
        listText6 = findViewById(R.id.text_item6);
        listText7 = findViewById(R.id.text_item7);
        listText8 = findViewById(R.id.text_item8);
        listText9 = findViewById(R.id.text_item9);
        listText10 = findViewById(R.id.text_item10);

        if (savedInstanceState != null){
            Log.d(LOG_TAG,"Check Saved Instance State");
            listText1.setText(savedInstanceState.getString("Item1"));
            listText2.setText(savedInstanceState.getString("Item2"));
            listText3.setText(savedInstanceState.getString("Item3"));
            listText4.setText(savedInstanceState.getString("Item4"));
            listText5.setText(savedInstanceState.getString("Item5"));
            listText6.setText(savedInstanceState.getString("Item6"));
            listText7.setText(savedInstanceState.getString("Item7"));
            listText8.setText(savedInstanceState.getString("Item8"));
            listText9.setText(savedInstanceState.getString("Item9"));
            listText10.setText(savedInstanceState.getString("Item10"));
        }
    }

    public void launchItemList(View view) {
        Log.d(LOG_TAG,"Button Clicked");
        Intent intent = new Intent(this,ShoppingListActivity.class);
        startActivityForResult(intent, TEXT_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TEXT_REQUEST){
            Log.d(LOG_TAG,"Intent Return");
            if (resultCode == RESULT_OK){
                String reply = data.getStringExtra(ShoppingListActivity.EXTRA_REPLY);
                addItem(reply);
            }
        }
    }

    public void addItem (String itemName){
        Log.d(LOG_TAG,"addItem " + itemName);
        if (listText1.getText().toString().trim().length() <= 0)
            listText1.setText("1. "+itemName);
        else if (listText2.getText().toString().trim().length() <= 0)
            listText2.setText("2. "+itemName);
        else if (listText3.getText().toString().trim().length() <= 0)
            listText3.setText("3. "+itemName);
        else if (listText4.getText().toString().trim().length() <= 0)
            listText4.setText("4. "+itemName);
        else if (listText5.getText().toString().trim().length() <= 0)
            listText5.setText("5. "+itemName);
        else if (listText6.getText().toString().trim().length() <= 0)
            listText6.setText("6. "+itemName);
        else if (listText7.getText().toString().trim().length() <= 0)
            listText7.setText("7. "+itemName);
        else if (listText8.getText().toString().trim().length() <= 0)
            listText8.setText("8. "+itemName);
        else if (listText9.getText().toString().trim().length() <= 0)
            listText9.setText("9. "+itemName);
        else if (listText10.getText().toString().trim().length() <= 0)
            listText10.setText("10. "+itemName);
        else{
            Toast toast = Toast.makeText(this, "List is full, clear the list to add more!",
                    Toast.LENGTH_SHORT);
            toast.show();
        }


    }

    public void clearItemList(View view) {
        Log.d(LOG_TAG,"Clear List");
        listText1.setText("");
        listText2.setText("");
        listText3.setText("");
        listText4.setText("");
        listText5.setText("");
        listText6.setText("");
        listText7.setText("");
        listText8.setText("");
        listText9.setText("");
        listText10.setText("");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(LOG_TAG,"Save Instance");
        outState.putString("Item1", (String) listText1.getText());
        outState.putString("Item2", (String) listText2.getText());
        outState.putString("Item3", (String) listText3.getText());
        outState.putString("Item4", (String) listText4.getText());
        outState.putString("Item5", (String) listText5.getText());
        outState.putString("Item6", (String) listText6.getText());
        outState.putString("Item7", (String) listText7.getText());
        outState.putString("Item8", (String) listText8.getText());
        outState.putString("Item9", (String) listText9.getText());
        outState.putString("Item10", (String) listText10.getText());
    }
}
