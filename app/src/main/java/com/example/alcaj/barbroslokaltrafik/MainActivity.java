package comalcaj.barbroslokaltrafik;

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

    int mStationChoice; // 0 = city, 1 = oden
    boolean isSwedish = true;

    public static Activity main; //used to exit activity when new data becomes present

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main = this;

        String from = getIntent().getStringExtra("fromInput");
        String to = getIntent().getStringExtra("toInput");

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

        final Intent toFrom = new Intent(MainActivity.this, FromActivity.class);
        final Intent toTo = new Intent(MainActivity.this, ToActivity.class);
        final Intent toKarta = new Intent(MainActivity.this, MapActivity.class);
        final Intent toKonstverk = new Intent(MainActivity.this, ArtActivity.class);
        final Intent toNavigation = new Intent(MainActivity.this, NavigationActivity.class);

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
                toFrom.putExtra("fromOld", mButtonFrom.getText().toString());
                toFrom.putExtra("toOld", mButtonTo.getText().toString());
                startActivity(toFrom);
            }
        });
        mButtonTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toTo.putExtra("fromOld", mButtonFrom.getText().toString());
                toTo.putExtra("toOld", mButtonTo.getText().toString());
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

//                Log.d("SL", "Is swedish before: " + isSwedish);
//                if (isSwedish == true) {
//                    mButtonLanguage.setBackgroundResource(R.drawable.languageenglish);
//                    isSwedish = false;
//                } else if (isSwedish == false) {
//                    mButtonLanguage.setBackgroundResource(R.drawable.languageschweden);
//                    isSwedish = true;
//                }
                Log.d("SL", "Is swedish after: " + isSwedish);
                changeLanguage();
            }
        });
        mButtonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                toNavigation.putExtra(INPUT_POSITION_FROM_TO_NAV ,mButtonFrom.getText().toString());
                toNavigation.putExtra(INPUT_POSITION_TO_TO_NAV, mButtonTo.getText().toString());
                startActivity(toNavigation);

                Log.d("SL", "DATA TO NAV" + mButtonFrom.getBackground().toString() + " " +
                    mButtonTo.getText().toString());

            }
        });
    }

    public void changeLanguage() {
        Log.d("SL", "Cahngin langguage");
//        if (isSwedish == true){
//
////            Locale locale = new Locale("en");
////            Resources resources = getResources();
////            Configuration configuration = resources.getConfiguration();
////            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
////            configuration.setLocale(locale);
////            getApplicationContext().createConfigurationContext(configuration);
////            Log.d("SL", "set to english");
//
//
//        } else  if (isSwedish == false) {
//
////            Locale locale = new Locale("default");
////            Resources resources = getResources();
////            Configuration configuration = resources.getConfiguration();
////            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
////            configuration.setLocale(locale);
////            getApplicationContext().createConfigurationContext(configuration);
////
////            Log.d("SL", "set to english2");
////            Log.d("SL", "wat" + getLocalClassName());
//
//        }
        Intent refreshMain = new Intent(this, MainActivity.class);
        refreshMain.putExtra("intentIsSwedish", isSwedish);
        finish();
        startActivity(refreshMain);
    }



    @Override
    protected void onResume() {
        super.onResume();

        Resources res = getResources();
        // Change locale settings in the app.
        DisplayMetrics dm = res.getDisplayMetrics();
        android.content.res.Configuration conf = res.getConfiguration();
        conf.setLocale(new Locale("EN".toLowerCase())); // API 17+ only.
        // Use conf.locale = new Locale(...) if targeting lower versions
        res.updateConfiguration(conf, dm);


//        if (isSwedish == false) {
//            Resources res = getResources();
//            // Change locale settings in the app.
//            DisplayMetrics dm = res.getDisplayMetrics();
//            android.content.res.Configuration conf = res.getConfiguration();
//            conf.setLocale(new Locale("DEFAULT".toLowerCase())); // API 17+ only.
//            // Use conf.locale = new Locale(...) if targeting lower versions
//            res.updateConfiguration(conf, dm);
//
//            mButtonLanguage.setBackgroundResource(R.drawable.languageschweden);
//
//
//            isSwedish = true;
//        } else {
//
//            Resources res = getResources();
//            // Change locale settings in the app.
//            DisplayMetrics dm = res.getDisplayMetrics();
//            android.content.res.Configuration conf = res.getConfiguration();
//            conf.setLocale(new Locale("EN".toLowerCase())); // API 17+ only.
//            // Use conf.locale = new Locale(...) if targeting lower versions
//            res.updateConfiguration(conf, dm);
//
//            mButtonLanguage.setBackgroundResource(R.drawable.languageenglish);
//
//            isSwedish = false;
//        }
    }
}
