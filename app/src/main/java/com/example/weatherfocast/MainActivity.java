package com.example.weatherfocast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button button;
    TextView textView2;
    DecimalFormat formatter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);
        textView2 = findViewById(R.id.textView2);

        textView2.setVisibility(View.GONE);

        formatter = new DecimalFormat("#0.0");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editText.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this , "Please enter the counted Chirps" , Toast.LENGTH_SHORT).show();
                }
                else {
                    int chirps = Integer.parseInt(editText.getText().toString().trim());

                    double temp = (chirps / 3.0) + 4;

                    String results = "The approximate temperature outside is " + formatter.format(temp) + " degrees Celsius.";

                    textView2.setText(results);
                    textView2.setVisibility(View.VISIBLE);
                }
            }
        });



    }
}
