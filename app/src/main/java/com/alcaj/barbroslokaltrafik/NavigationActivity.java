package com.alcaj.barbroslokaltrafik;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;

public class NavigationActivity extends AppCompatActivity {


    final String NAV_NORTH_MELLANPLAN = "NorraMellanplan";
    final int NAV_NORTH_MELLANPLAN_ART_AMOUNT = 1;
    final String NAV_PLATFORM = "Plattform";
    final int NAV_PLATFORM_ART_AMOUNT = 3;
    final String NAV_CENTRALEAST_MELLANPLAN = "CentralaMellanplan";
    final int NAV_CENTRALEAST_MELLANPLAN_ART_AMOUNT = 2;
    //final String NAV_SOUTH_ENTRANCE = "Sodrauppgangen";  Grafik saknas
    //final int NAV_SOUTH_ENTRANCE_ART_AMOUNT = ????;
    //final String NAV_NORTH_ENTRANCE = "Sodrauppgangen";  Grafik saknas. OBS, KAN VARA BILJETTHALL
    //final int NAV_NORTH_ENTRANCE_ART_AMOUNT = 0???;

    final int[] artAmountOnFloor = {
            NAV_PLATFORM_ART_AMOUNT,
            NAV_CENTRALEAST_MELLANPLAN_ART_AMOUNT,
            NAV_NORTH_MELLANPLAN_ART_AMOUNT//,
            //NAV_SOUTH_ENTRANCE_ART_AMOUNT,
            //etc

    };




    TextView mPosToPos;
    Button mButtonEnlargeMap;

    ImageView mImageViewArtOnWay;
    Button mButtonArtPieceOnWay1;
    Button mButtonArtPieceOnWay2;
    Button mButtonArtPieceOnWay3;
    Button mButtonArtPieceOnWay4;
    Button mButtonArtPieceOnWay5;
    Button mButtonArtPieceOnWay6;

    String completeTravelString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        mPosToPos = (TextView) findViewById(R.id.textViewNavStatusFrom);
        mButtonEnlargeMap = (Button) findViewById(R.id.buttonEnlargeMap);
        mImageViewArtOnWay = (ImageView) findViewById(R.id.imageViewArtOnWay);
        mButtonArtPieceOnWay1 = (Button) findViewById(R.id.buttonArtPiece1);
        mButtonArtPieceOnWay2 = (Button) findViewById(R.id.buttonArtPiece2);
        mButtonArtPieceOnWay3 = (Button) findViewById(R.id.buttonArtPiece3);
        mButtonArtPieceOnWay4 = (Button) findViewById(R.id.buttonArtPiece4);
        mButtonArtPieceOnWay5 = (Button) findViewById(R.id.buttonArtPiece5);
        mButtonArtPieceOnWay6 = (Button) findViewById(R.id.buttonArtPiece6);

        String mFromOutput = getIntent().getStringExtra("inputFromToNav");
        String mToOutput = getIntent().getStringExtra("inputToToNav");

        final Intent toDialog = new Intent(NavigationActivity.this, DialogImageArtOnWay.class);

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

        // make array of all maps for chosen points

        String[] mapArray = new String[3];

        mapArray[0] = getIntent().getStringExtra("inputFromToNav") +
                getIntent().getStringExtra("inputToToNav") +
                NAV_PLATFORM;

        mapArray[1] = getIntent().getStringExtra("inputFromToNav") +
                getIntent().getStringExtra("inputToToNav") +
                NAV_CENTRALEAST_MELLANPLAN;

        mapArray[2] = getIntent().getStringExtra("inputFromToNav") +
                getIntent().getStringExtra("inputToToNav") +
                NAV_NORTH_MELLANPLAN;
        //add more when adding floors

        // check which maps exist
        // calculate amount of artpieces

        int artPieces = 0;

        for (int i = 0; i < mapArray.length; i++) {

            int checkExistance = getResources().getIdentifier(stringToDrawableID(mapArray[i]), "drawable", getPackageName());

            if (checkExistance != 0) {
                artPieces = artPieces + artAmountOnFloor[i];
            }

            Log.d("SL", "YO LOOK HERE" + checkExistance);
            Log.d("SL", " " + artPieces);
        }

        //chance ArtOnWay image according to calculated amount of pieces of art

        //String imageArtOnWayResId = "artonway" + artPieces + "locations";
        int imageArtOnWayResId = getResources().getIdentifier("artonway" + artPieces + "locations", "drawable", getPackageName());
        mButtonEnlargeMap.setBackgroundResource(resId);
        mImageViewArtOnWay.setImageResource(imageArtOnWayResId);










        mButtonEnlargeMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        // Art on the way buttons start here

        mButtonArtPieceOnWay1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                startActivity(toDialog);

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
