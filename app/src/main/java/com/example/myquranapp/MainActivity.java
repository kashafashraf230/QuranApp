package com.example.myquranapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText surahNo;
    String surahCount;
    ListView surahList;
    SearchView searchView;
    ArrayList<String> allSurahNames = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       /* allSurahNames.add("Ali");
        allSurahNames.add("abc");
        allSurahNames.add("123");*/
        QDH surahName = new QDH();

        String data;

        for (int i = 0; i < surahName.englishSurahNames.length; i++ ){

            data = String.valueOf(i+1);
            allSurahNames.add((data + " - " + surahName.englishSurahNames[i]));

        }
        ArrayAdapter<String> arrayAdapter =  new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,allSurahNames);
        surahList = findViewById(R.id.SurahNameList);
        surahList.setAdapter(arrayAdapter);

        surahNo = findViewById(R.id.searchSurah);
      /*  searchView = findViewById(R.id.searchView);

        if(Integer.parseInt(surahCount) >= 1 && Integer.parseInt(surahCount) <= 114) {

            searchView.setOnSearchClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //your code here
                    surahCount = surahNo.getText().toString();
                    Intent nextIntent = new Intent(MainActivity.this, FullSurahDisplay.class);
                    nextIntent.putExtra("SurahNum", surahNo.getText().toString());
                    startActivity(nextIntent);
                }
            });
        }
        else{
                    Toast.makeText(this, "Enter Valid Surah No(1 to 114)", Toast.LENGTH_SHORT).show();
                }*/

        surahList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent nextIntent = new Intent(MainActivity.this, FullSurahDisplay.class);
                nextIntent.putExtra("SurahNum", i+1);
                startActivity(nextIntent);
            }
        });

    }

   public void onSearchClick(View view)
    {
        surahCount = surahNo.getText().toString();

        if(Integer.parseInt(surahCount) >= 1 && Integer.parseInt(surahCount) <= 114) {
            Intent nextIntent = new Intent(MainActivity.this, FullSurahDisplay.class);
            nextIntent.putExtra("SurahNum", Integer.parseInt(surahNo.getText().toString()));
            startActivity(nextIntent);
        }

        else{
            Toast.makeText(this, "Enter Valid Surah No(1 to 114)", Toast.LENGTH_SHORT).show();
        }
    }


}