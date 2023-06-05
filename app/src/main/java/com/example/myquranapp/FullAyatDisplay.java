package com.example.myquranapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class FullAyatDisplay extends AppCompatActivity {

    int ayat,surah;
    TextView surahName, searchAyat;
    int reachAyat;
    QDH nameObj = new QDH();
    QuranArabicText textAyat = new QuranArabicText();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_ayat_display);

        Intent getAyat = getIntent();
        ayat = getAyat.getIntExtra("AyatNum",1);
        surah = getAyat.getIntExtra("SurahNum", 1);

        surahName = findViewById(R.id.SurahName);
        surahName.setText(nameObj.englishSurahNames[surah-1]);
        searchAyat = findViewById(R.id.AyatDisplay);

        reachAyat = nameObj.getSurahStart(surah-1) + ayat -1;
        searchAyat.setText(textAyat.QuranArabicText[reachAyat]);

    }
}