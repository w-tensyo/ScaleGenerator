package com.example.wtensyo.scalegenerator;

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Spinner leftSpinner;
    Spinner rightSpinner;
    String[] selectTone;
    String item = null;
    ListView lvMenu;
    ArrayList<String> toneList = new ArrayList<>();
    TextView dispSortTone;

    ArrayAdapter<CharSequence> leftAdapter;
    RadioButton leftToneSelect;


    private static final String SORT_STRING_SHARP = "A,A#,B,C,C#,D,D#,E,F,F#,G,G#,A,A#,B,C,C#,D,D#,E,F,F#,G,";
    private static final String SORT_STRING_FLAT = "A,Bb,B,C,Db,D,Eb,E,F,Gb,G,Ab,A,Bb,B,C,Cb,D,Db,E,F,Gb,G,";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //activity_main.xmlのlvMenuを認識させるために呼び出し
        lvMenu = findViewById(R.id.lvMenu);

        dispSortTone = (TextView) findViewById(R.id.sort_tone_string);

        //まずはgetLeftSpinnerでLeftSpinnerでtoneListに配列を突っ込む
        getLeftSpinner();

    }

    public void getLeftSpinner() {

        //データ型変数leftSpinnerにleft_spinnerを入れる
        leftSpinner = (Spinner) findViewById(R.id.left_spinner);

        //array.xmlに記載したstring-arrayのplus_toneをadapter変数に入れる
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.plus_tone, android.R.layout.simple_spinner_item);

        //leftSpinner変数にplus_toneのstring-arrayを代入した変数"adapter"を代入する
        leftSpinner.setAdapter(adapter);

        //アダプタがスピナーの選択肢の一覧を表示するのに使うレイアウトを指定。
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //ラジオボタンの判定
        //データ型変数leftToneSelectに入れる
        leftToneSelect = (RadioButton) findViewById(R.id.tone_select_left);

        leftToneSelect.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView,boolean isChecked){
                leftSpinner.setAdapter(null);
                if(isChecked){
                    leftAdapter = ArrayAdapter.createFromResource(MainActivity.this, R.array.drop_tone, android.R.layout.simple_spinner_item);
                    item = SORT_STRING_FLAT;
                }else{
                    leftAdapter = ArrayAdapter.createFromResource(MainActivity.this, R.array.plus_tone, android.R.layout.simple_spinner_item);
                    item = SORT_STRING_SHARP;
                }
                leftSpinner.setAdapter(leftAdapter);
            }
        });

        leftSpinner.setOnItemSelectedListener(new SpinnerSelectedListener());
    }


    public class SpinnerSelectedListener implements AdapterView.OnItemSelectedListener{
        public void onItemSelected(AdapterView parent, View view, int position, long id) {
            Spinner spinner = (Spinner) parent;

            //選択されているアイテムのIndexを取得
            int idx = spinner.getSelectedItemPosition();


            //〜〜〜ここでindexをsrotToneに処理させて、ソートを済ませたい〜〜〜
            //ケース毎に引数を渡して、sortToneで処理させたい
            switch (idx) {
                case 0:
                    //A,A#,B,C,C#,D,D#,E,F,F#,G,G#にソートする
                    //メソッド化せずに実装した場合。これでいいのだろうか・・・
                    item = SORT_STRING_SHARP.substring(0, 28);
                    break;
                case 1:
                    //A#,B,C,C#,D,D#,E,F,F#,G,G#,Aにソートする
                    //メソッド化せずに実装した場合。
                    item = SORT_STRING_SHARP.substring(2, 30);
                    break;
                case 2:
                    //B,C,C#,D,D#,E,F,F#,G,G#,A,A#にソートする
                    //メソッド化せずに実装した場合。
                    item = SORT_STRING_SHARP.substring(5, 33);
                    break;
                case 3:
                    //C,C#,D,D#,E,F,F#,G,G#,A,A#,Bにソートする
                    //メソッド化せずに実装した場合。
                    item = SORT_STRING_SHARP.substring(7, 35);
                    break;
                case 4:
                    //C#,D,D#,E,F,F#,G,G#,A,A#,B,Cにソートする
                    //メソッド化せずに実装した場合。
                    item = SORT_STRING_SHARP.substring(9, 37);
                    break;
                case 5:
                    //D,D#,E,F,F#,G,G#,A,A#,B,C,C#にソートする
                    //メソッド化せずに実装した場合。
                    item = SORT_STRING_SHARP.substring(12, 40);
                    break;
                case 6:
                    //D#,E,F,F#,G,G#,A,A#,B,C,C#,Dにソートする
                    //メソッド化せずに実装した場合。
                    item = SORT_STRING_SHARP.substring(14, 42);
                    break;
                case 7:
                    //E,F,F#,G,G#,A,A#,B,C,C#,D,D#にソートする
                    //メソッド化せずに実装した場合。
                    item = SORT_STRING_SHARP.substring(17, 45);
                    break;
                case 8:
                    //F,F#,G,G#,A,A#,B,C,C#,D,D#,Eにソートする
                    //メソッド化せずに実装した場合。
                    item = SORT_STRING_SHARP.substring(19, 47);
                    break;
                case 9:
                    //F#,G,G#,A,A#,B,C,C#,D,D#,E,Fにソートする
                    //メソッド化せずに実装した場合。
                    item = SORT_STRING_SHARP.substring(21, 49);
                    break;
                case 10:
                    //G,G#,A,A#,B,C,C#,D,D#,E,F,F#にソートする
                    //メソッド化せずに実装した場合。
                    item = SORT_STRING_SHARP.substring(24, 52);
                    break;
                case 11:
                    //G#,A,A#,B,C,C#,D,D#,E,F,F#,Gにソートする
                    //メソッド化せずに実装した場合。
                    item = SORT_STRING_SHARP.substring(26);
                    break;
            }
            //本来は不要。一旦配列用に切り出したStringが正しく切り出されているかここで確認。
            dispSortTone.setText(item);

            List<String> toneList = Arrays.asList(item.split(","));

            ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this,android.R.layout.simple_list_item_1,toneList);

            lvMenu.setAdapter(adapter);
        }
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }
}