package com.example.wtensyo.scalegenerator;

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

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
        //せんたくされているアイテムのIndexを取得
        int idx = leftSpinner.getSelectedItemPosition();

        //〜〜〜ここでindexをsrotToneに処理させて、ソートを済ませたい〜〜〜
        //ケース毎に引数を渡して、sortToneで処理させたい
        switch(idx){
            case 0:
                //A,A#,B,C,C#,D,D#,E,F,F#,G,G#にソートする
                sortToneUtil(0,28);
                break;
            case 1:
                //A#,B,C,C#,D,D#,E,F,F#,G,G#,Aにソートする
                sortToneUtil(2,30);
                break;
            case 2:
                //B,C,C#,D,D#,E,F,F#,G,G#,A,A#にソートする
                sortToneUtil(5,33);
                break;
            case 3:
                //C,C#,D,D#,E,F,F#,G,G#,A,A#,Bにソートする
                sortToneUtil(7,35);
                break;
            case 4:
                //C#,D,D#,E,F,F#,G,G#,A,A#,B,Cにソートする
                sortToneUtil(9,37);
                break;
            case 5:
                //D,D#,E,F,F#,G,G#,A,A#,B,C,C#にソートする
                sortToneUtil(12,40);
                break;
            case 6:
                //D#,E,F,F#,G,G#,A,A#,B,C,C#,Dにソートする
                sortToneUtil(14,42);
                break;
            case 7:
                //E,F,F#,G,G#,A,A#,B,C,C#,D,D#にソートする
                sortToneUtil(17,45);
                break;
            case 8:
                //F,F#,G,G#,A,A#,B,C,C#,D,D#,Eにソートする
                sortToneUtil(19,47);
                break;
            case 9:
                //F#,G,G#,A,A#,B,C,C#,D,D#,E,Fにソートする
                sortToneUtil(21,49);
                break;
            case 10:
                //G,G#,A,A#,B,C,C#,D,D#,E,F,F#にソートする
                sortToneUtil(24,52);
                break;
            case 11:
                //G#,A,A#,B,C,C#,D,D#,E,F,F#,Gにソートする
                sortToneUtil(26,54);
                break;
        }

    }

    private static final String SORT_STRING = "A,A#,B,C,C#,D,D#,E,F,F#,G,G#,A,A#,B,C,C#,D,D#,E,F,F#,G,";
    //配列のソートを行う処理を描きたい
    static void sortToneUtil(int i, int j) {
        String result = SORT_STRING.substring(i,j);
            //Spinnerで選択したIndex番号を
        return ;
    }
}

