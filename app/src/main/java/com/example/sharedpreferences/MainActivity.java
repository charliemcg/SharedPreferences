package com.example.sharedpreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText et;
    TextView tv;
    InputMethodManager numPad;
    SharedPreferences preferences;
    //the key for knowing what value is being dealt with. Need a separate key for every value
    //needs to be public static if it is to be accessed from other classes
    public static String KEY = "key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et = findViewById(R.id.et);
        tv = findViewById(R.id.tv);
        numPad = (InputMethodManager) getSystemService(this.INPUT_METHOD_SERVICE);
        //initializing shared preferences
        preferences = this.getSharedPreferences("com.example.sharedpreferences", this.MODE_PRIVATE);
        //setting the text view to the value stored in shared preferences. if no value it will show "Error"
        tv.setText(preferences.getString(KEY, "Error"));

    }

    public void submit(View view) {
        tv.setText(et.getText());
        numPad.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
        //saving the value to shared preferences
        preferences.edit().putString(KEY, et.getText().toString()).apply();
        et.setText("");
    }

    public void changeActivity(View view) {
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }
}
