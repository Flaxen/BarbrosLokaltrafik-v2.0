package com.alcaj.barbroslokaltrafik;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

public class NavigationActivity extends AppCompatActivity {

    TextView mPosToPos;
    Button mButtonEnlargeMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        mPosToPos = (TextView) findViewById(R.id.textViewNavStatusFrom);
        mButtonEnlargeMap = (Button) findViewById(R.id.buttonEnlargeMap);

        String mFromOutput = getIntent().getStringExtra("inputFromToNav");
        String mToOutput = getIntent().getStringExtra("inputToToNav");


        String completeTravel = mFromOutput + " > " + mToOutput;
        Log.d("SL", completeTravel);

        mPosToPos.setText(completeTravel);

    }
}
