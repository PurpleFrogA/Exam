package com.example.exam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText a;
    private EditText b;
    private EditText c;
    private Button bt;
    private ImageView im;
    private TextView tv;

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        connectComponents();
    }

    private void connectComponents() {
        a = findViewById(R.id.aMain);
        b = findViewById(R.id.bMain);
        c = findViewById(R.id.cMain);
        bt = findViewById(R.id.button);
        im = findViewById(R.id.imageView2);
        tv = findViewById(R.id.solution1);
    }


    public void calc(View view) {
        double delta,x1,x2;
        String valueStr1 = a.getText().toString();
        if (valueStr1.trim().isEmpty())
        {
            Toast.makeText(this, "No data entered!", Toast.LENGTH_SHORT).show();
            return;
        }
        String valueStr2 = b.getText().toString();
        if (valueStr2.trim().isEmpty())
        {
            Toast.makeText(this, "No data entered!", Toast.LENGTH_SHORT).show();
            return;
        }
        String valueStr3 = c.getText().toString();
        if (valueStr3.trim().isEmpty())
        {
            Toast.makeText(this, "No data entered!", Toast.LENGTH_SHORT).show();
            return;
        }
        double v1 = Double.parseDouble(valueStr1);
        double v2 = Double.parseDouble(valueStr2);
        double v3 = Double.parseDouble(valueStr3);
        delta = (v2*v2)-(4*v1*v3);
        x1 = ((-v2 + (Math.sqrt(delta)))/(2*v1));
        x2 = ((-v2 - (Math.sqrt(delta)))/(2*v1));
        if(delta == 0){
            im.setImageResource(R.drawable.number1);
            tv.setText("there is one solution, x = " + x1 );
        }
        if(delta > 0){
            im.setImageResource(R.drawable.number2);
            tv.setText("there are two solutions, x1 = " +x1 + " x2 = " + x2);
        }
        if(delta < 0){
            im.setImageResource(R.drawable.number0);
            tv.setText("there is no solution for this Equation");
        }

    }
}