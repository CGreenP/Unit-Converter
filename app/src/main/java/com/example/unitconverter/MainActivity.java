package com.example.unitconverter;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button btn;
    TextView textView;
    private double pounds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        btn = findViewById(R.id.btn);
        textView = findViewById(R.id.textview);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Getting user input (Kilos)
                String inputText = editText.getText().toString();

                if (inputText.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please give valid input!", Toast.LENGTH_SHORT).show();
                } else {
                    //Converting a string into double
                    double kilos = Double.parseDouble(inputText);

                    //Converting kilos to pounds
                    pounds = makeConversion(kilos);

                    //Displaying the conversion result
                    textView.setText(""+pounds+" lb");
                }
            }
        });

        if (savedInstanceState != null) {
            pounds = savedInstanceState.getDouble("pound");
            textView.setText(""+pounds+" lb");
        }
    }

    public double makeConversion(double kilos) {
        // 1 Kilogram = 2.20462 Pound
        return kilos*2.20462;
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putDouble("pound",pounds);
    }
}