package com.alcaj.barbroslokaltrafik;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ToActivity extends AppCompatActivity {

    //TODO: convert all pieces of art to constants

    //TODO: !!! Merge FromActivity and ToActivity to one ChoosePosActivity !!!

    final String FROM_INPUT = "fromInput";
    final String TO_INPUT = "toInput";

    Button mButtonSearch;
    Button mButtonChooseOnMap;
    EditText mEditTextSearchField;

    Intent toMainActivity;
    Intent toChooseOnMap;

    String oldFrom;
    Boolean isSwedish;
    String stationChoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to);

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

        toMainActivity = new Intent(ToActivity.this, MainActivity.class);
        toChooseOnMap = new Intent(ToActivity.this, ChoosePositionOnMap.class);

        oldFrom = getIntent().getStringExtra("fromOld");
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


        mButtonAndetag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toMainActivity.putExtra(TO_INPUT, "Andetag");
                forslagButton();
            }
        });

        mButtonRorligRymd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toMainActivity.putExtra(TO_INPUT, "Rörlig Rymd");
                forslagButton();
            }
        });

        mButtonStadTradAng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toMainActivity.putExtra(TO_INPUT, "Stadsträdgård");
                forslagButton();
            }
        });

        mButtonOdentradgard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toMainActivity.putExtra(TO_INPUT, "Odens trädgård");
                forslagButton();
            }
        });

        mButtonSkies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toMainActivity.putExtra(TO_INPUT, "Skies");
                forslagButton();
            }
        });

        mButtonLaDivina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toMainActivity.putExtra(TO_INPUT, "La Divina Commedia");
                forslagButton();
            }
        });

        mButtonVardagSal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toMainActivity.putExtra(TO_INPUT, "Vardagens Sal");
                forslagButton();
            }
        });

        mButtonCuckoo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toMainActivity.putExtra(TO_INPUT, "Cuckoo Clock");
                forslagButton();
            }
        });

        mButtonMoaritisk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toMainActivity.putExtra(TO_INPUT, "Moaritisk Absorbent");
                forslagButton();
            }
        });

        mButtonPendlarkatedral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toMainActivity.putExtra(TO_INPUT, "Pendlarkatedralen");
                forslagButton();
            }
        });

        mButtonVoyage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toMainActivity.putExtra(TO_INPUT, "Voyage");
                forslagButton();
            }
        });

        mButtonItinerary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toMainActivity.putExtra(TO_INPUT, "Itinerary");
                forslagButton();
            }
        });

        mButtonLank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toMainActivity.putExtra(TO_INPUT, "Länk");
                forslagButton();
            }
        });

        mButtonLifeline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toMainActivity.putExtra(TO_INPUT, "Life Line");
                forslagButton();
            }
        });

        mButtonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toMainActivity.putExtra(TO_INPUT, mEditTextSearchField.getText().toString());
                toMainActivity.putExtra(FROM_INPUT, oldFrom);
                toMainActivity.putExtra("isSwedish", isSwedish);


//                Log.d("SL", mEditTextSearchField.getText().toString());

                finish();
                MainActivity.main.finish();
                startActivity(toMainActivity);
            }
        });
        Log.d("SL", "Swedish status before as ToActivity output: " + isSwedish);


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

        toMainActivity.putExtra(FROM_INPUT, oldFrom);
        toMainActivity.putExtra("isSwedish", isSwedish);
        finish();
        MainActivity.main.finish();
        startActivity(toMainActivity);

    }

    public void ShowDialog() {



    }

}