package pavankreddy.blogspot.githubjobs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.jobs);
        progressBar = findViewById(R.id.progressbar);
        progressBar.setVisibility(View.GONE);
    }

    public void fetchJobs(View view)
    {
         progressBar.setVisibility(View.VISIBLE);
         FetchJobs fetchJobs = new FetchJobs();
         fetchJobs.execute();
    }

    class FetchJobs extends AsyncTask<Void,Void,String>
    {
        public static final String link
                = "https://jobs.github.com/positions.json";

        @Override
        protected String doInBackground(Void... voids)
        {
            try
            {
                URL url = new URL(link);
                HttpsURLConnection urlConnection =
                        (HttpsURLConnection) url.openConnection();
                InputStream inputStream = urlConnection.getInputStream();
                BufferedReader br =
                        new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder sb = new StringBuilder();
                String line;
                while((line = br.readLine())!=null){
                    sb.append(line);
                }
                return sb.toString();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            progressBar.setVisibility(View.GONE);
            try
            {
                textView.setText("");
                JSONArray array = new JSONArray(s);
                for(int i=0;i<array.length();i++){
                    JSONObject data = array.getJSONObject(i);
                    String company = data.getString("company");
                    String location = data.getString("location");
                    String jobtitle = data.getString("title");
                    textView.append("\nCompany Name:"+company +"\nLocation: "+location+"\nTitle:"+jobtitle);
                    textView.append("\n____________________");
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
