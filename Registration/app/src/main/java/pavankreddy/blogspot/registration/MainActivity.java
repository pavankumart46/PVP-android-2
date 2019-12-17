package pavankreddy.blogspot.registration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    String gender = "perfer not to say";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitForm(View view)
    {
        EditText name,age;
        name = findViewById(R.id.etname);
        age = findViewById(R.id.etage);
        String n = name.getText().toString();
        int a = Integer.parseInt(age.getText().toString());
        Intent i = new Intent(this,SecondActivity.class);
        i.putExtra("NAME",n);
        i.putExtra("AGE",a);
        i.putExtra("GENDER",gender);
        startActivity(i);
    }

    public void selectMale(View view) {
        gender = "Male";
    }

    public void selectFemale(View view)
    {
      gender = "Female";
    }
}
