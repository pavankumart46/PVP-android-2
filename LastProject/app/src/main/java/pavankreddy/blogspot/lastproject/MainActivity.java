
package pavankreddy.blogspot.lastproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText pName,pAge;
    private TextView pResults;
    private PersonDatabase personDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pName = findViewById(R.id.personname);
        pAge = findViewById(R.id.personage);
        pResults = findViewById(R.id.results);

        personDatabase = Room
                .databaseBuilder(this,PersonDatabase.class,"mydb")
                .allowMainThreadQueries()
                .build();
    }

    public void saveData(View view)
    {
        String n = pName.getText().toString();
        int a = Integer.parseInt(pAge.getText().toString());
        Person p = new Person(n,a);
        personDatabase.personDao().insert(p);
        Toast.makeText(this, "DATA INSERTED", Toast.LENGTH_SHORT)
                .show();
        getAllData();
    }

    private void getAllData() {
        List<Person> personList = personDatabase.personDao().getAll();
        pResults.setText("");
        for(int i = 0; i<personList.size();i++){
            pResults.append("\nID-"+personList.get(i).getId());
            pResults.append("\nNAME-"+personList.get(i).getName());
            pResults.append("\nAGE-"+personList.get(i).getAge());
            pResults.append("\n___________________");
        }
    }
}
