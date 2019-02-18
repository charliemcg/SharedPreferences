package com.example.sharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView tv2;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tv2 = findViewById(R.id.tv2);
        //initialize the same shared preferences as MainActivity
        preferences = this.getSharedPreferences("com.example.sharedpreferences", this.MODE_PRIVATE);
        //setting the text view to display the value saved in shared preferences. if there is no
        //value it will display "Error". Need to specify 'MainActivity.KEY' in this case because
        //that is where the key is
        tv2.setText(preferences.getString(MainActivity.KEY, "Error"));
    }
}
