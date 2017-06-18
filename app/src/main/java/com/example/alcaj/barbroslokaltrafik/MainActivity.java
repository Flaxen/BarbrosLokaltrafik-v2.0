package com.example.alcaj.barbroslokaltrafik;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Button mButtonCity;
    Button mButtonOdenplan;
    Button mButtonFrom;
    Button mButtonTo;
    Button mButtonKarta;
    Button mButtonKonstverk;
    Button mButtonLanguage;

    int mStationChoice; // 0 = city, 1 = oden
    boolean isSwedish = true;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButtonCity = (Button) findViewById(R.id.buttonCity);
        mButtonOdenplan = (Button) findViewById(R.id.buttonOdenplan);
        mButtonFrom = (Button) findViewById(R.id.buttonFrom);
        mButtonTo = (Button) findViewById(R.id.buttonTo);
        mButtonKarta = (Button) findViewById(R.id.buttonKarta);
        mButtonKonstverk = (Button) findViewById(R.id.buttonKonstverk);
        mButtonLanguage = (Button) findViewById(R.id.buttonSprak);

        final Intent toFrom = new Intent(MainActivity.this, FromActivity.class);
        final Intent toTo = new Intent(MainActivity.this, ToActivity.class);
        final Intent toKarta = new Intent(MainActivity.this, MapActivity.class);
        final Intent toKonstverk = new Intent(MainActivity.this, ArtActivity.class);

        mButtonCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mStationChoice = 0;
            }
        });
        mButtonOdenplan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mStationChoice = 1;
            }
        });
        mButtonFrom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(toFrom);
            }
        });
        mButtonTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(toTo);
            }
        });
        mButtonKarta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(toKarta);
            }
        });
        mButtonKonstverk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(toKonstverk);
            }
        });
        mButtonLanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: Add language switch function

                Log.d("SL", "Is swedish before: " + isSwedish);
                if (isSwedish == true) {
                    mButtonLanguage.setBackgroundResource(R.drawable.languageenglish);
                    isSwedish = false;
                } else if (isSwedish == false) {
                    mButtonLanguage.setBackgroundResource(R.drawable.languageschweden);
                    isSwedish = true;
                }
                Log.d("SL", "Is swedish after: " + isSwedish);
                changeLanguage();
            }
        });
    }

    public void changeLanguage() {

        if (isSwedish == true){

            Locale locale = new Locale("en");
            Resources resources = getResources();
            Configuration configuration = resources.getConfiguration();
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            configuration.setLocale(locale);
            getApplicationContext().createConfigurationContext(configuration);

        } else  if (isSwedish == false) {

            Locale locale = new Locale("default");
            Resources resources = getResources();
            Configuration configuration = resources.getConfiguration();
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            configuration.setLocale(locale);
            getApplicationContext().createConfigurationContext(configuration);

        }
        Intent refreshMain = new Intent(MainActivity.this, MainActivity.class);
        refreshMain.putExtra("intentIsSwedish", isSwedish);
        startActivity(refreshMain);
    }

}
