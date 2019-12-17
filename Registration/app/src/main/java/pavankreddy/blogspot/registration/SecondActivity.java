package pavankreddy.blogspot.registration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        TextView textView = findViewById(R.id.textview);
        textView.setText("");
        textView.append(intent.getStringExtra("NAME")+"\n");
        textView.append(intent.getStringExtra("GENDER")+"\n");
        if(intent.getIntExtra("AGE",0) <18){
            textView.append("MINOR\n");
        }else if(intent.getIntExtra("AGE",0)>=18){
            textView.append("MAJOR\n");
        }
    }
}
