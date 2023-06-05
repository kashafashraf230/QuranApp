package com.example.myquranapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class FullSurahDisplay extends AppCompatActivity {

    TextView textSurah;
    ListView ayatList;
    EditText ayatNo;

    String ayatCount;
    QDH surahObj = new QDH();
    QuranArabicText text = new QuranArabicText();
    int surahNum;
    ArrayList<String> fullAyat = new ArrayList<String>();
    //String[] fullAyat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_surah_display);

        textSurah = findViewById(R.id.SurahName);

        Intent getSurahNo = getIntent();
        surahNum = getSurahNo.getIntExtra("SurahNum",1);


        int surahStart = surahObj.getSurahStart(surahNum-1)-1;
        int surahEnd = surahObj.surahAyatCount[surahNum-1] + surahStart ;
        //fullAyat = text.GetData(surahStart,surahEnd);
        textSurah.setText(surahObj.englishSurahNames[surahNum-1]);

        for (int i = surahStart; i <= surahEnd; i++ ){

            fullAyat.add(text.QuranArabicText[i]);
        }

        ArrayAdapter<String> arrayAdapter =  new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,fullAyat);
        ayatList = findViewById(R.id.FullSurah);
        ayatList.setAdapter(arrayAdapter);


        ayatNo = findViewById(R.id.searchAyat);
    }

    public void onSearchClick(View view)
    {
        ayatCount = ayatNo.getText().toString();

        if(Integer.parseInt(ayatCount) >= 1 && Integer.parseInt(ayatCount) <= surahObj.surahAyatCount[surahNum-1]) {
            Intent nextIntent = new Intent(FullSurahDisplay.this, FullAyatDisplay.class);
            nextIntent.putExtra("AyatNum", Integer.parseInt(ayatNo.getText().toString()));
            nextIntent.putExtra("SurahNum", surahNum);
            startActivity(nextIntent);
        }

        else{
            Toast.makeText(this, "Enter Valid Ayat No", Toast.LENGTH_SHORT).show();
        }
    }

}