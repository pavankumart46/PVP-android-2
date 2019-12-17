package pavankreddy.blogspot.multiapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MYTAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG,"onCreate()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG,"onRestart()");
    }

    /*@Override
    public void onBackPressed() {

        AlertDialog.Builder builder =
                new AlertDialog.Builder(this);
        builder.setTitle("You can't Leave Me!");
        builder.setIcon(R.drawable.feelingsad);
        builder.setMessage("Please dont leave this app! We love all our users equally. There is no partiality. If you leave us - even then our love for you will not go!");
        // Positive Button - "Stay Back"
        // Negative Button - "Exit Anyway"
        // Neutral Button - "Not Now"
        builder.setPositiveButton("Stay Back", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,
                        "We Love you more", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("Exit Anyway", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,
                        "We Will Keep Loving you. Thanks", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        builder.setNeutralButton("Not Now", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Ok! Let us make this app a better place for you!", Toast.LENGTH_SHORT).show();
            }
        });

        builder.show();
    }*/
}
