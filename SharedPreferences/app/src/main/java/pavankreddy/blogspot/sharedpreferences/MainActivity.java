package pavankreddy.blogspot.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    private static final int BLACK = 1;
    private static final int RED = 2;
    private static final int WHITE = 3;
    private static final int GREEN = 4;

    private SharedPreferences sharedPreferences;

    private int color_selected = BLACK;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textview);
        sharedPreferences = getSharedPreferences("mypref",MODE_PRIVATE);
        if(sharedPreferences!=null){
            color_selected = sharedPreferences.getInt("COLOR",0);
            switch (color_selected){
                case BLACK:
                    textView.setBackgroundColor(Color.BLACK);
                    break;
                case RED:
                    textView.setBackgroundColor(Color.RED);
                    break;
                case WHITE:
                    textView.setBackgroundColor(Color.WHITE);
                    break;
                case GREEN:
                    textView.setBackgroundColor(Color.GREEN);
                    break;
            }
        }
    }

    public void selectedBlack(View view) {
        textView.setBackgroundColor(Color.BLACK);
        color_selected = BLACK;
    }

    public void selectedRed(View view) {
        textView.setBackgroundColor(Color.RED);
        color_selected = RED;
    }

    public void selectedGreen(View view) {
        textView.setBackgroundColor(Color.GREEN);
        color_selected = GREEN;
    }

    public void selectedWhite(View view) {
        textView.setBackgroundColor(Color.WHITE);
        color_selected = WHITE;
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("COLOR",color_selected);
        editor.apply();
    }
}
