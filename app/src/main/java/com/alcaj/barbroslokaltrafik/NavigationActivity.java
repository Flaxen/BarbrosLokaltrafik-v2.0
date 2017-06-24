package com.alcaj.barbroslokaltrafik;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class NavigationActivity extends AppCompatActivity {

    TextView mPosToPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        mPosToPos = (TextView) findViewById(R.id.textViewNavStatusFrom);

        String mFromOutput = getIntent().getStringExtra("inputFromToNav");
        String mToOutput = getIntent().getStringExtra("inputToToNav");


        String completeTravel = mFromOutput + " > " + mToOutput;
        Log.d("SL", completeTravel);

        mPosToPos.setText(completeTravel);

    }
}
