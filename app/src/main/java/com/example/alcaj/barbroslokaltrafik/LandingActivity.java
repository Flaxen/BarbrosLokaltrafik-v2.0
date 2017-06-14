
package com.example.alcaj.barbroslokaltrafik;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.Locale;

import static android.R.attr.bottom;
import static android.R.attr.typeface;

public class LandingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        // Changes the Landing Activity font to Bebas
        TextView topRow = (TextView) findViewById(R.id.textViewTopRow);
        TextView bottomRow = (TextView) findViewById(R.id.textViewBottomRow);

        Typeface custom_font = Typeface.createFromAsset(getAssets(),  "fonts/BebasNeueRegular.ttf");
        topRow.setTypeface(custom_font);

        custom_font = Typeface.createFromAsset(getAssets(), "fonts/BebasNeueBold.ttf");
        bottomRow.setTypeface(custom_font);
        // End of Font Change

        // Delays activity for 2000ms and proceeds to main activity
        Handler myHandler = new Handler();

        myHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.d("BL", "Does this look delayed to you?");
                Intent myIntent = new Intent(LandingActivity.this, MainActivity.class);
                startActivity(myIntent);
            }
        }, 2000);


    }
}
