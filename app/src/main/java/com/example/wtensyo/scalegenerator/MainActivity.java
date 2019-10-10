package com.example.wtensyo.scalegenerator;

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
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
    List<String> toneList;

    TextView dispSortTone = (TextView) findViewById(R.id.sort_tone_string);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //activity_main.xmlのlvMenuを認識させるために呼び出し
        ListView lvMenu = findViewById(R.id.lvMenu);
        //まずはgetLeftSpinnerでLeftSpinnerでtoneListに配列を突っ込む
        getLeftSpinner();

        //getLeftSpinner内で作った配列toneListをAdapterに登録
        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this,android.R.layout.simple_list_item_1,toneList);

        //lvMenuにadapterをセット
        lvMenu.setAdapter(adapter);

    }

    public void getLeftSpinner() {
        //データ型変数leftSpinnerにleft_spinnerを入れる
        Spinner leftSpinner = (Spinner) findViewById(R.id.left_spinner);

        //array.xmlに記載したstring-arrayのplus_toneをadapter変数に入れる
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.plus_tone, android.R.layout.simple_spinner_item);

        //leftSpinner変数にplus_toneのstring-arrayを代入した変数"adapter"を代入する
        leftSpinner.setAdapter(adapter);

        //アダプタがスピナーの選択肢の一覧を表示するのに使うレイアウトを指定。
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        leftSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView parent, View view, int position, long id) {
                Spinner spinner = (Spinner) parent;

                //選択されているアイテムのIndexを取得
                int idx = spinner.getSelectedItemPosition();

                //〜〜〜ここでindexをsrotToneに処理させて、ソートを済ませたい〜〜〜
                //ケース毎に引数を渡して、sortToneで処理させたい
                switch (idx) {
                    case 0:
                        //A,A#,B,C,C#,D,D#,E,F,F#,G,G#にソートする
                        item = sortToneUtil(0, 28);
                        break;
                    case 1:
                        //A#,B,C,C#,D,D#,E,F,F#,G,G#,Aにソートする
                        item = sortToneUtil(2, 30);
                        break;
                    case 2:
                        //B,C,C#,D,D#,E,F,F#,G,G#,A,A#にソートする
                        item = sortToneUtil(5, 33);
                        break;
                    case 3:
                        //C,C#,D,D#,E,F,F#,G,G#,A,A#,Bにソートする
                        item = sortToneUtil(7, 35);
                        break;
                    case 4:
                        //C#,D,D#,E,F,F#,G,G#,A,A#,B,Cにソートする
                        item = sortToneUtil(9, 37);
                        break;
                    case 5:
                        //D,D#,E,F,F#,G,G#,A,A#,B,C,C#にソートする
                        item = sortToneUtil(12, 40);
                        break;
                    case 6:
                        //D#,E,F,F#,G,G#,A,A#,B,C,C#,Dにソートする
                        item = sortToneUtil(14, 42);
                        break;
                    case 7:
                        //E,F,F#,G,G#,A,A#,B,C,C#,D,D#にソートする
                        item = sortToneUtil(17, 45);
                        break;
                    case 8:
                        //F,F#,G,G#,A,A#,B,C,C#,D,D#,Eにソートする
                        item = sortToneUtil(19, 47);
                        break;
                    case 9:
                        //F#,G,G#,A,A#,B,C,C#,D,D#,E,Fにソートする
                        item = sortToneUtil(21, 49);
                        break;
                    case 10:
                        //G,G#,A,A#,B,C,C#,D,D#,E,F,F#にソートする
                        item = sortToneUtil(24, 52);
                        break;
                    case 11:
                        //G#,A,A#,B,C,C#,D,D#,E,F,F#,Gにソートする
                        item = sortToneUtil(26, 54);
                        break;
                }
                //本来は不要。一旦配列用に切り出したStringが正しく切り出されているかここで確認。
                dispSortTone.setText(item);

                //itemの中身を配列化させる
                //これで、toneLisの中に配列ができあがっている想定
                toneList = makeArray(item);

            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
            });
        }

    private static final String SORT_STRING = "A,A#,B,C,C#,D,D#,E,F,F#,G,G#,A,A#,B,C,C#,D,D#,E,F,F#,G,";

    //配列用の下準備。配列の先頭がどこになるか。をこれで切り出す
    static String sortToneUtil(int i, int j) {
        String result = SORT_STRING.substring(i, j);
        //Spinnerで選択したIndex番号を
        return result;
    }

    //sortToneUtilで切り出した文字列をList<String>で配列化させる処理
    static List<String> makeArray(String a){
        List<String> toneMake = Arrays.asList(a.split(","));
        return toneMake;
    }
}