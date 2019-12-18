package pavankreddy.blogspot.leadersofthenation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    int images[];
    String leader_names[];
    String info[];
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerview);
        setData();
        RvAdapter rvAdapter =
                new RvAdapter(this,images,leader_names,info);
        recyclerView.setAdapter(rvAdapter);
        recyclerView.setLayoutManager(
                new LinearLayoutManager(this));
    }

    private void setData()
    {
       images = new int[]{
               R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,
               R.drawable.e,R.drawable.g,R.drawable.i,R.drawable.j,
               R.drawable.k, R.drawable.l
       };
       leader_names = new String[]{
               "APJ Abdul Kalam","Bhagath Singh","Chandra Shekar Aazad","Dadabai Naoroji",
               "Ishwar Chandra Vidyasagar","MK Gandhi","Indira Gandhi","Jawaharlal Nehru",
               "Kandukuri Veereshalingam","Lalbahadur Sastry"
       };
       info = new String[]{
               "1931-2015","1907-1931","1906-1931","1825-1917",
               "1820-1891","1869-1948","1917-1984","1889-1964",
               "1848-1919","1904-1966"
       };
    }
}
