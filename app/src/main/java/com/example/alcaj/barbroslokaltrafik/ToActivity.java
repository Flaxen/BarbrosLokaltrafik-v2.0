package comalcaj.barbroslokaltrafik;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ToActivity extends AppCompatActivity {

    //TODO: convert all pieces of art to constants

    final String FROM_INPUT = "fromInput";
    final String TO_INPUT = "toInput";


    Button mButtonAndetag;
    Button mButtonRymd;
    Button mButtonStadstradgard;
    Button mButtonOdentradgard;
    Button mButtonSearch;
    Button mButtonChooseOnMap;

    EditText mEditTextSearchField;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to);

        mButtonAndetag = (Button) findViewById(R.id.buttonAndetag);
        mButtonRymd = (Button) findViewById(R.id.buttonRymd);
        mButtonStadstradgard = (Button) findViewById(R.id.buttonStadstradgard);
        mButtonOdentradgard = (Button) findViewById(R.id.buttonOdentradgard);
        mButtonSearch = (Button) findViewById(R.id.buttonSearch);
        mButtonChooseOnMap = (Button) findViewById(R.id.buttonChooseOnMap);

        mEditTextSearchField = (EditText) findViewById(R.id.editTextSearch);

        final Intent toMainActivity = new Intent(ToActivity.this, MainActivity.class);
        final Intent toChooseOnMap = new Intent(ToActivity.this, ChoosePositionOnMap.class);

        final String oldFrom = getIntent().getStringExtra("fromOld");

        mButtonAndetag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toMainActivity.putExtra(TO_INPUT, "Andetag");
                toMainActivity.putExtra(FROM_INPUT, oldFrom);
                finish();
                MainActivity.main.finish();
                startActivity(toMainActivity);
            }
        });

        mButtonRymd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toMainActivity.putExtra(TO_INPUT, "Rörlig Rymd");
                toMainActivity.putExtra(FROM_INPUT, oldFrom);
                finish();
                MainActivity.main.finish();
                startActivity(toMainActivity);
            }
        });

        mButtonStadstradgard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toMainActivity.putExtra(TO_INPUT, "Stadsträdgård");
                toMainActivity.putExtra(FROM_INPUT, oldFrom);
                finish();
                MainActivity.main.finish();
                startActivity(toMainActivity);
            }
        });

        mButtonOdentradgard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toMainActivity.putExtra(TO_INPUT, "Odens trädgård");
                toMainActivity.putExtra(FROM_INPUT, oldFrom);
                finish();
                MainActivity.main.finish();
                startActivity(toMainActivity);
            }
        });

        mButtonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toMainActivity.putExtra("toInput", mEditTextSearchField.getText().toString());
                toMainActivity.putExtra(FROM_INPUT, oldFrom);


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

    public void ShowDialog() {



    }

}