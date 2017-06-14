package nu.ssis.alcaj.barbroslokaltrafik;

import android.content.Intent;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Handler myHander = new Handler();

        myHander.postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.d("BL", "Does this look delayed to you?");
                Intent myIntent = new Intent(MainActivity.this, MainMenu.class);
                startActivity(myIntent);
            }
        }, 2000);



    }
}
