package com.alcaj.barbroslokaltrafik;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NavigationActivity extends AppCompatActivity {

    TextView mPosToPos;
    Button mButtonEnlargeMap;

    String completeTravelString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        mPosToPos = (TextView) findViewById(R.id.textViewNavStatusFrom);
        mButtonEnlargeMap = (Button) findViewById(R.id.buttonEnlargeMap);

        String mFromOutput = getIntent().getStringExtra("inputFromToNav");
        String mToOutput = getIntent().getStringExtra("inputToToNav");

        final Intent toMapActivity = new Intent(NavigationActivity.this, MapActivity.class);

        String completeTravelDisplay = mFromOutput + " > " + mToOutput;
        mPosToPos.setText(completeTravelDisplay);

        Log.d("SL", getIntent().getStringExtra("startPosFloor"));

        completeTravelString = getIntent().getStringExtra("inputFromToNav") +
                getIntent().getStringExtra("inputToToNav") +
                getIntent().getStringExtra("startPosFloor");

        completeTravelString = stringToDrawableID(completeTravelString);

        Log.d("SL", "String used as drawable name is: " + completeTravelString);

        int resId = getResources().getIdentifier(completeTravelString, "drawable", getPackageName());
        mButtonEnlargeMap.setBackgroundResource(resId);

        mButtonEnlargeMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                toMapActivity.putExtra("completeTravelString", completeTravelString);
                finish();
                startActivity(toMapActivity);
            }
        });
    }

    public String stringToDrawableID(String string) {

        string = string.toLowerCase();
        string = string.replace(" ", "");
        string = string.replace(",", "");
        string = string.replace("å", "a");
        string = string.replace("ä", "a");
        string = string.replace("ö", "o");
        string = string.toLowerCase();

        return string;
    }


}
