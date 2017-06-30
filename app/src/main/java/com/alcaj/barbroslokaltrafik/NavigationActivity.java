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
import java.util.Random;

public class NavigationActivity extends AppCompatActivity {

    final int MAX_AMOUNT_OF_ART_PIECES = 6;
    final int FLOORS = 3;

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

    final String CITY_ART_PLATFORM_1 = "Vardagens Sal";
    final String CITY_ART_PLATFORM_2 = "Stad, Träd och Äng";
    final String CITY_ART_PLATFORM_3 = "Skies";

    final String CITY_ART_CENTRALEAST_MELLANPLAN_1 = "Cuckoo Clock";
    final String CITY_ART_CENTRALEAST_MELLANPLAN_2 = "Moaritisk Absorbent";

    final String CITY_ART_NORTH_MELLANPLAN_1 = "Andetag och Fotfäste";

    // add missing pieces of art from list in drive SL - Projekt folder

    final int[] artAmountOnFloor = {
            NAV_PLATFORM_ART_AMOUNT,
            NAV_CENTRALEAST_MELLANPLAN_ART_AMOUNT,
            NAV_NORTH_MELLANPLAN_ART_AMOUNT//,
            //NAV_SOUTH_ENTRANCE_ART_AMOUNT,
            //etc

    };

    int[] existingMapId = new int[FLOORS];
    String[] existingMapArray;
    int mapIndex = 0;
    int[] resources = new int[6];




    TextView mPosToPos;
    Button mButtonEnlargeMap;

    ImageView mImageViewArtOnWay;
    Button mButtonArtPieceOnWay1;
    Button mButtonArtPieceOnWay2;
    Button mButtonArtPieceOnWay3;
    Button mButtonArtPieceOnWay4;
    Button mButtonArtPieceOnWay5;
    Button mButtonArtPieceOnWay6;

    Button mButtonNextMap;
    Button mButtonBackMap;

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
        mButtonNextMap = (Button) findViewById(R.id.button8);
        mButtonBackMap = (Button) findViewById(R.id.button10);

        String mFromOutput = getIntent().getStringExtra("inputFromToNav");
        String mToOutput = getIntent().getStringExtra("inputToToNav");


        resources[0] = getResources().getIdentifier("artstadtradangthumbnail", "drawable", getPackageName());
        resources[1] = getResources().getIdentifier("artskiesthumbnail", "drawable", getPackageName());
        resources[2] = getResources().getIdentifier("artmoaritiskabsorbentthumbnail", "drawable", getPackageName());
        resources[3] = getResources().getIdentifier("artcuckooclockthumbnail", "drawable", getPackageName());
        resources[4] = getResources().getIdentifier("artvardagsalthumbnail", "drawable", getPackageName());
        resources[5] = getResources().getIdentifier("artandetagochfotfastethumbnail", "drawable", getPackageName());

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

        existingMapArray = new String[mapArray.length];

        int mapsTrue = 0;
        int checkExistance;
        for (int i = 0; i < FLOORS; i++) {

            checkExistance = getResources().getIdentifier(stringToDrawableID(mapArray[i]), "drawable", getPackageName());
            Log.d("SL", "saker: " + checkExistance);
            mapsTrue++;
            if (checkExistance != 0) {
                artPieces = artPieces + artAmountOnFloor[i];
                existingMapArray[i] = mapArray[i];
                existingMapId[i] = getResources().getIdentifier(stringToDrawableID(mapArray[i]),"drawable",getPackageName());
            }

        }


        //debug integer. DO NOT USE AT RELEASE
        //artPieces = 6;


        //chance ArtOnWay image according to calculated amount of pieces of art

        int imageArtOnWayResId = getResources().getIdentifier("artonway" + artPieces + "locations", "drawable", getPackageName());
        mButtonEnlargeMap.setBackgroundResource(resId);
        mImageViewArtOnWay.setImageResource(imageArtOnWayResId);

        // change individual art piece images according to the ArtOnWay Image above

        //sort all images for use in foor loop
        Button[] artPieceButtons = {
            mButtonArtPieceOnWay1,
            mButtonArtPieceOnWay2,
            mButtonArtPieceOnWay3,
            mButtonArtPieceOnWay4,
            mButtonArtPieceOnWay5,
            mButtonArtPieceOnWay6
        };


        //make unwanted images invisible
        for (int i = artPieces; i < MAX_AMOUNT_OF_ART_PIECES;  i++) {
            artPieceButtons[i].setVisibility(View.INVISIBLE);
        }

        for (int i = 0; i < (MAX_AMOUNT_OF_ART_PIECES - (MAX_AMOUNT_OF_ART_PIECES - artPieces)); i++) {



            artPieceButtons[i].setBackgroundResource(resources[i]);

        }


        // Button functions
        mButtonNextMap.setOnClickListener(new View.OnClickListener() {

            int mapIndex = 0;

            @Override
            public void onClick(View v) {
             //   setMap(1);
            }
        });

        mButtonBackMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //setMap(-1);
            }
        });

        // Art on the way buttons start here

        mButtonArtPieceOnWay1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toDialog.putExtra("resId", resources[0]);
                startActivity(toDialog);
            }
        });

        mButtonArtPieceOnWay2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toDialog.putExtra("resId", resources[1]);
                startActivity(toDialog);
            }
        });

        mButtonArtPieceOnWay3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toDialog.putExtra("resId", resources[2]);
                startActivity(toDialog);
            }
        });

        mButtonArtPieceOnWay4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toDialog.putExtra("resId", resources[3]);
                startActivity(toDialog);
            }
        });

        mButtonArtPieceOnWay5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toDialog.putExtra("resId", resources[4]);
                startActivity(toDialog);
            }
        });

        mButtonArtPieceOnWay6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toDialog.putExtra("resId", resources[5]);
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
//
//    public void setMap(int value) {
//
//        mapIndex = mapIndex + value;
//
//        if (mapIndex == existingMapArray.length) {
//            mButtonEnlargeMap.setBackgroundResource(existingMapId[mapIndex]);
//            mapIndex = 0;
//
//        } else if (mapIndex == 0) {
//            mButtonEnlargeMap.setBackgroundResource(existingMapId[mapIndex]);
//            mapIndex = existingMapArray.length;
//
//        }
//    }


}
