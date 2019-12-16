package pavankreddy.blogspot.firstapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int count = 0;
    private TextView tv;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.reset:
                count = 0;
                tv.setText(""+count);
                break;
            case R.id.second:
                Toast.makeText(this, "Second Option", Toast.LENGTH_SHORT).show();
                break;
            case R.id.third:
                Toast.makeText(this, "Third Option", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_items,menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.tvcount);

        if(savedInstanceState!=null){
            count = savedInstanceState.getInt("COUNT");
            tv.setText(""+count);
        }

    }

    public void showToast(View view) {
        count--; // count = count - 1
        tv.setText(""+count);
    }

    public void showCount(View view) {
        count++; // count = count + 1
        tv.setText(""+count);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("COUNT",count);
    }
}
