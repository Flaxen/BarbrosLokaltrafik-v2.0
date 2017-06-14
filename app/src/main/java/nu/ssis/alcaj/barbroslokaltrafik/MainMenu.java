package nu.ssis.alcaj.barbroslokaltrafik;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainMenu extends AppCompatActivity {

    //TODO: FIND BETTER FUNCTION FOR DP TO PX CONVERSION

    final int STATION_BUTTON_DEFAULT_HEIGHT = 140;
    final int STATION_BUTTON_DEFAULT_WIDTH = 76;
    final int STATION_BUTTON_SMALLER_WIDTH = 65;

    Boolean mIsChoiceCity = true;

    Button mButtonCity;
    Button mButtonOdenplan;
    Button mButtonKarta;
    Button mButtonKonst;

    TextView mTextViewFrom;
    TextView mTextViewTo;

    //TODO: FIND BETTER FUNCTION FOR THE CONVERSION BELOW?
    public int dpToPx(int dp) {
        DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();
        return Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
    }

    private void setMargins (View view, int left, int top, int right, int bottom) {
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            p.setMargins(left, top, right, bottom);
            view.requestLayout();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        mButtonCity = (Button) findViewById(R.id.buttonCity);
        mButtonOdenplan = (Button) findViewById(R.id.buttonOdenplan);
        mButtonKarta = (Button) findViewById(R.id.buttonKarta);
        mButtonKonst = (Button) findViewById(R.id.buttonKonst);

        mTextViewFrom = (TextView) findViewById(R.id.TextViewFrom);
        mTextViewTo = (TextView) findViewById(R.id.TextViewTo);

        mButtonKarta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("BL", "Button Karta tapped");
            }
        });
        mButtonKonst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("BL", "Button Konst tapped");
            }
        });

        mButtonCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("BL", "City tapped");
                mButtonCity.setBackgroundResource(R.drawable.citythumbnail);
                mButtonCity.setLayoutParams(new LinearLayout.LayoutParams(dpToPx(STATION_BUTTON_DEFAULT_HEIGHT), dpToPx(STATION_BUTTON_DEFAULT_WIDTH)));
                mButtonOdenplan.setBackgroundResource(R.drawable.odenplanthumbnail_gray);
                mButtonOdenplan.setLayoutParams(new LinearLayout.LayoutParams(dpToPx(STATION_BUTTON_DEFAULT_HEIGHT), dpToPx(STATION_BUTTON_SMALLER_WIDTH)));
                setMargins(mButtonCity, 0, 0, dpToPx(25), 0);
                mIsChoiceCity = true;
            }
        });
        mButtonOdenplan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("BL", "Odenplan tapped");
                mButtonOdenplan.setBackgroundResource(R.drawable.odenplanthumbnail);
                mButtonOdenplan.setLayoutParams(new LinearLayout.LayoutParams(dpToPx(STATION_BUTTON_DEFAULT_HEIGHT), dpToPx(STATION_BUTTON_DEFAULT_WIDTH)));
                mButtonCity.setBackgroundResource(R.drawable.citythumbnail_gray);
                mButtonCity.setLayoutParams(new LinearLayout.LayoutParams(dpToPx(STATION_BUTTON_DEFAULT_HEIGHT), dpToPx(STATION_BUTTON_SMALLER_WIDTH)));
                setMargins(mButtonCity, 0, 0, dpToPx(25), 0);
                mIsChoiceCity = false;
            }
        });

        mButtonKarta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                outputTest();
            }
        });

        mButtonKonst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        final Intent toFromActivity = new Intent(MainMenu.this, FromActivity.class);
        mTextViewFrom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                outputTest();
                startActivity(toFromActivity);
            }
        });
    }

    public void outputTest() {
        Log.d("BL", "Yo the thing is working");
    }











}
