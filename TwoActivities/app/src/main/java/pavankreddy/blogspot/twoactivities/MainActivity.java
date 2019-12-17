package pavankreddy.blogspot.twoactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void nextActivity(View view)
    {
        Intent i = new Intent(this,
                SecondActivity.class);
        startActivity(i);
    }

    public void openWeb(View view)
    {
        EditText e = findViewById(R.id.webdata);
        String s = e.getText().toString();
        //Setting up the data
        Uri data = Uri.parse("https://"+s);
        Intent i = new Intent(Intent.ACTION_VIEW,data);
        startActivity(i);
    }
}
