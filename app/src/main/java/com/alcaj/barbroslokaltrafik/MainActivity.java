package com.alcaj.barbroslokaltrafik;

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

    final String INPUT_POSITION_FROM_TO_NAV = "inputFromToNav";
    final String INPUT_POSITION_TO_TO_NAV = "inputToToNav";

    Button mButtonCity;
    Button mButtonOdenplan;
    Button mButtonFrom;
    Button mButtonTo;
    Button mButtonKarta;
    Button mButtonKonstverk;
    Button mButtonLanguage;
    Button mButtonSearch;

    String stationChoice;

    Boolean isSwedish = true;
    String from;
    String to;

    public static Activity main; //used to exit activity when new data becomes present

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main = this;

        from = getIntent().getStringExtra("fromInput");
        to = getIntent().getStringExtra("toInput");
        isSwedish = getIntent().getExtras().getBoolean("isSwedish");

        mButtonCity = (Button) findViewById(R.id.buttonCity);
        mButtonOdenplan = (Button) findViewById(R.id.buttonOdenplan);
        mButtonFrom = (Button) findViewById(R.id.buttonFrom);
        mButtonTo = (Button) findViewById(R.id.buttonTo);
        mButtonKarta = (Button) findViewById(R.id.buttonKarta);
        mButtonKonstverk = (Button) findViewById(R.id.buttonKonstverk);
        mButtonLanguage = (Button) findViewById(R.id.buttonSprak);
        mButtonSearch = (Button) findViewById(R.id.buttonSearch);

        mButtonFrom.setText(from);
        mButtonTo.setText(to);

        if (isSwedish == true) {
            mButtonLanguage.setBackgroundResource(R.drawable.languageschweden);
        } else if (isSwedish == false) {
            mButtonLanguage.setBackgroundResource(R.drawable.languageenglish);

        }

        final Intent toFrom = new Intent(MainActivity.this, FromActivity.class);
        final Intent toTo = new Intent(MainActivity.this, ToActivity.class);
        final Intent toKarta = new Intent(MainActivity.this, MapActivity.class);
        final Intent toKonstverk = new Intent(MainActivity.this, ArtActivity.class);
        final Intent toNavigation = new Intent(MainActivity.this, NavigationActivity.class);

        mButtonCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stationChoice = "city";
            }
        });
        mButtonOdenplan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stationChoice = "odenplan";
            }
        });
        mButtonFrom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toFrom.putExtra("fromOld", mButtonFrom.getText().toString());
                toFrom.putExtra("toOld", mButtonTo.getText().toString());
                toFrom.putExtra("isSwedish", isSwedish);
                toFrom.putExtra("stationChoice", stationChoice);
                startActivity(toFrom);
            }
        });
        mButtonTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toTo.putExtra("fromOld", mButtonFrom.getText().toString());
                toTo.putExtra("toOld", mButtonTo.getText().toString());
                toTo.putExtra("isSwedish", isSwedish);
                toTo.putExtra("stationChoice", stationChoice);
                startActivity(toTo);
            }
        });
        mButtonKarta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(toKarta);
                toKarta.putExtra("isSwedish", isSwedish);
            }
        });
        mButtonKonstverk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(toKonstverk);
                toKonstverk.putExtra("isSwedish", isSwedish);
            }
        });
        mButtonLanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: Add language switch function
                Log.d("SL", "Is swedish before: " + isSwedish);
                changeLanguage();
            }
        });
        mButtonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                toNavigation.putExtra(INPUT_POSITION_FROM_TO_NAV ,mButtonFrom.getText().toString());
                toNavigation.putExtra(INPUT_POSITION_TO_TO_NAV, mButtonTo.getText().toString());
                toNavigation.putExtra("isSwedish", isSwedish);
                startActivity(toNavigation);

                Log.d("SL", "DATA TO NAV" + mButtonFrom.getBackground().toString() + " " +
                    mButtonTo.getText().toString());

            }
        });
    }

    public void changeLanguage() {

        if (isSwedish == true) {

            Resources res = getResources();
            // Change locale settings in the app.
            DisplayMetrics dm = res.getDisplayMetrics();
            android.content.res.Configuration conf = res.getConfiguration();
            conf.setLocale(new Locale("EN".toLowerCase())); // API 17+ only.
            // Use conf.locale = new Locale(...) if targeting lower versions
            res.updateConfiguration(conf, dm);

            isSwedish = false;
        } else  if (isSwedish == false) {

            isSwedish = true;

            Resources res = getResources();
            // Change locale settings in the app.
            DisplayMetrics dm = res.getDisplayMetrics();
            android.content.res.Configuration conf = res.getConfiguration();
            conf.setLocale(new Locale("DEFAULT".toLowerCase())); // API 17+ only.
            // Use conf.locale = new Locale(...) if targeting lower versions
            res.updateConfiguration(conf, dm);
        }
        Log.d("SL", "Changing language. New value of isSwedish = " + isSwedish);

        Intent refreshMain = new Intent(this, MainActivity.class);
        refreshMain.putExtra("isSwedish", isSwedish);
        refreshMain.putExtra("fromInput", getResources().getString(R.string.buttonFrom));
        refreshMain.putExtra("toInput", getResources().getString(R.string.buttonTo));
        finish();
        startActivity(refreshMain);
    }

    @Override
    protected void onResume() {
        super.onResume();

        isSwedish = getIntent().getExtras().getBoolean("isSwedish");
        from = getIntent().getStringExtra("fromInput");
        to = getIntent().getStringExtra("toInput");




    }
}
