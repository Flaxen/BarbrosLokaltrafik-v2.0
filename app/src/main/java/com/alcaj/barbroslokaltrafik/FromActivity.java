package com.alcaj.barbroslokaltrafik;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FromActivity extends AppCompatActivity {


    //TODO: convert all pieces of art to constants

    //TODO: !!! Merge FromActivity and ToActivity to one ChoosePosActivity !!!


    final String FROM_INPUT = "fromInput";
    final String TO_INPUT = "toInput";
    final String STARTPOS_FLOOR = "startPosFloor";

    Button mButtonSearch;
    Button mButtonChooseOnMap;
    EditText mEditTextSearchField;

    Intent toMainActivity;
    Intent toChooseOnMap;

    String oldTo;
    Boolean isSwedish;
    String stationChoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_from);

        Button mButtonAndetag = (Button) findViewById(R.id.buttonAndetag);
        Button mButtonRorligRymd = (Button) findViewById(R.id.buttonRorligRymd);
        Button mButtonStadTradAng = (Button) findViewById(R.id.buttonStadTradAng);
        Button mButtonOdentradgard = (Button) findViewById(R.id.buttonOdentradgard);
        Button mButtonSkies = (Button) findViewById(R.id.buttonSkies);
        Button mButtonLaDivina = (Button) findViewById(R.id.buttonLaDivina);
        Button mButtonVardagSal = (Button) findViewById(R.id.buttonVardagSal);
        Button mButtonCuckoo = (Button) findViewById(R.id.buttonCuckoo);
        Button mButtonMoaritisk = (Button) findViewById(R.id.buttonMoaritisk);
        Button mButtonPendlarkatedral = (Button) findViewById(R.id.buttonPendlarkatedral);
        Button mButtonVoyage = (Button) findViewById(R.id.buttonVoyage);
        Button mButtonItinerary = (Button) findViewById(R.id.buttonItinerary);
        Button mButtonLank = (Button) findViewById(R.id.buttonLank);
        Button mButtonLifeline = (Button) findViewById(R.id.buttonLifeline);

        mButtonSearch = (Button) findViewById(R.id.buttonSearch);
        mButtonChooseOnMap = (Button) findViewById(R.id.buttonChooseOnMap);

        mEditTextSearchField = (EditText) findViewById(R.id.editTextSearch);

        toMainActivity = new Intent(FromActivity.this, MainActivity.class);
        toChooseOnMap = new Intent(FromActivity.this, ChoosePositionOnMap.class);

        oldTo = getIntent().getStringExtra("toOld");
        isSwedish = getIntent().getExtras().getBoolean("isSwedish");
        stationChoice = getIntent().getStringExtra("stationChoice");

        Log.d("SL", "stationChoice is " + stationChoice);

        if (stationChoice.equals("city")) {

            Log.d("SL", "if loop returned 'city'");

            // Makes the example buttons only contain pieces of art and stores at the chosen station.

            mButtonVoyage.setVisibility(View.GONE);
            mButtonItinerary.setVisibility(View.GONE);
            mButtonLank.setVisibility(View.GONE);
            mButtonRorligRymd.setVisibility(View.GONE);
            mButtonLifeline.setVisibility(View.GONE);
            mButtonOdentradgard.setVisibility(View.GONE);

            //TODO: Change map for choice of position

        } else if (stationChoice.equals("odenplan")) {

            Log.d("SL", "if loop returned 'odenplan'");

            mButtonSkies.setVisibility(View.GONE);
            mButtonAndetag.setVisibility(View.GONE);
            mButtonStadTradAng.setVisibility(View.GONE);
            mButtonLaDivina.setVisibility(View.GONE);
            mButtonVardagSal.setVisibility(View.GONE);
            mButtonCuckoo.setVisibility(View.GONE);
            mButtonMoaritisk.setVisibility(View.GONE);
            mButtonPendlarkatedral.setVisibility(View.GONE);

            //TODO: Change map for choice of position


        } else {
            Log.d("SL", "Error stationChoice FromActivity");
        }



        //TODO: Shorten all this to methods
        //TODO: SUPER TODO!!! Convert all art piece names to constants
        //TODO: !!! Make constant strings pull content from res/strings.xml

        mButtonAndetag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toMainActivity.putExtra(FROM_INPUT, "Andetag");
                toMainActivity.putExtra(STARTPOS_FLOOR, 1);
                forslagButton();
            }
        });

        mButtonRorligRymd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toMainActivity.putExtra(FROM_INPUT, "Rörlig Rymd");
                //toMainActivity.putExtra(STARTPOS_FLOOR, 3); odenpland missing maps
                forslagButton();
            }
        });

        mButtonStadTradAng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toMainActivity.putExtra(FROM_INPUT, "Stad, Träd och Äng");
                toMainActivity.putExtra(STARTPOS_FLOOR, 3);
                forslagButton();
            }
        });

        mButtonOdentradgard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toMainActivity.putExtra(FROM_INPUT, "Odens trädgård");
                //toMainActivity.putExtra(STARTPOS_FLOOR, ?); odenplan missing maps
                forslagButton();
            }
        });

        mButtonSkies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toMainActivity.putExtra(FROM_INPUT, "Skies");
                toMainActivity.putExtra(STARTPOS_FLOOR, 3);
                forslagButton();
            }
        });

        mButtonLaDivina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toMainActivity.putExtra(FROM_INPUT, "La Divina Commedia");
                forslagButton();
            }
        });

        mButtonVardagSal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toMainActivity.putExtra(FROM_INPUT, "Vardagens Sal");
                forslagButton();
            }
        });

        mButtonCuckoo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toMainActivity.putExtra(FROM_INPUT, "Cuckoo Clock");
                forslagButton();
            }
        });

        mButtonMoaritisk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toMainActivity.putExtra(FROM_INPUT, "Moaritisk Absorbent");
                forslagButton();
            }
        });

        mButtonPendlarkatedral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toMainActivity.putExtra(FROM_INPUT, "Pendlarkatedralen");
                forslagButton();
            }
        });

        mButtonVoyage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toMainActivity.putExtra(FROM_INPUT, "Voyage");
                forslagButton();
            }
        });

        mButtonItinerary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toMainActivity.putExtra(FROM_INPUT, "Itinerary");
                forslagButton();
            }
        });

        mButtonLank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toMainActivity.putExtra(FROM_INPUT, "Länk");
                forslagButton();
            }
        });

        mButtonLifeline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toMainActivity.putExtra(FROM_INPUT, "Life Line");
                forslagButton();
            }
        });

        mButtonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toMainActivity.putExtra(FROM_INPUT, mEditTextSearchField.getText().toString());
                toMainActivity.putExtra(TO_INPUT, oldTo);
                toMainActivity.putExtra("isSwedish", isSwedish);


//                Log.d("SL", mEditTextSearchField.getText().toString());

                finish();
                MainActivity.main.finish();
                startActivity(toMainActivity);
            }
        });

        mButtonChooseOnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ShowDialog();

                //TODO: Well the following:
                //Possible to make it a "Dialog"

                // Make popup map saying "Function coming soon"
                // Make future function in own activity

                //startActivity(toChooseOnMap);
            }
        });

    }



    public void forslagButton() {

        toMainActivity.putExtra(TO_INPUT, oldTo);
        toMainActivity.putExtra("isSwedish", isSwedish);
        finish();
        MainActivity.main.finish();
        startActivity(toMainActivity);

    }


    public void ShowDialog() {



    }

}
