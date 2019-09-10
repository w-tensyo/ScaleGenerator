package com.example.wtensyo.scalegenerator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    ArrayAdapter<CharSequence> leftAdapter;
    ArrayAdapter<CharSequence> rightAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //データ型変数leftSpinnerにleft_spinnerを入れる
        final Spinner leftSpinner = findViewById(R.id.left_spinner);
        final Spinner rightSpinner = findViewById(R.id.right_spinner);

        //array.xmlに記載したstring-arrayのplus_toneをadapter変数に入れる
        leftAdapter = ArrayAdapter.createFromResource(this, R.array.plus_tone, android.R.layout.simple_spinner_item);
        leftSpinner.setAdapter(leftAdapter);

        rightAdapter = ArrayAdapter.createFromResource(this, R.array.scale_list, android.R.layout.simple_spinner_item);
        rightSpinner.setAdapter(rightAdapter);

        RadioButton leftRadio = findViewById(R.id.tone_select_left);
        RadioButton rightRadio = findViewById(R.id.tone_select_right);

        leftRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                leftSpinner.setAdapter(null);
                if (isChecked) {
                    leftAdapter = ArrayAdapter.createFromResource(MainActivity.this, R.array.plus_tone, android.R.layout.simple_spinner_item);
                } else {
                    leftAdapter = ArrayAdapter.createFromResource(MainActivity.this, R.array.scale_list, android.R.layout.simple_spinner_item);
                }
                leftSpinner.setAdapter(leftAdapter);
            }
        });

        rightRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                rightSpinner.setAdapter(null);
                if (isChecked) {
                    rightAdapter = ArrayAdapter.createFromResource(MainActivity.this, R.array.scale_list, android.R.layout.simple_spinner_item);
                } else {
                    rightAdapter = ArrayAdapter.createFromResource(MainActivity.this, R.array.plus_tone, android.R.layout.simple_spinner_item);
                }
                rightSpinner.setAdapter(rightAdapter);
            }
        });
    }
}

