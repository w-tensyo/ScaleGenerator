package com.example.wtensyo.scalegenerator;

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    Spinner leftSpinner;
    Spinner rightSpinner;
    String[] selectTone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //データ型変数leftSpinnerにleft_spinnerを入れる
        Spinner leftSpinner = (Spinner) findViewById(R.id.left_spinner);

        //array.xmlに記載したstring-arrayのplus_toneをadapter変数に入れる
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.plus_tone, android.R.layout.simple_spinner_item);
        //試しに、drop_toneをadapter変数に入れて、反映されるか実験
        //ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.drop_tone, android.R.layout.simple_spinner_item);
        //アダプタがスピナーの選択肢の一覧を表示するのに使うレイアウトを指定 と書いてあるけど理解はできていない・・・。
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //leftSpinner変数にplus_toneのstring-arrayを代入した変数"adapter"を代入する
        leftSpinner.setAdapter(adapter);
    }
}

