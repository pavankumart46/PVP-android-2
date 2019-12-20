package pavankreddy.blogspot.jobscheduler;

import androidx.appcompat.app.AppCompatActivity;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    JobScheduler jobScheduler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jobScheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
    }

    public void scheduleJob(View view)
    {
        JobInfo.Builder builder = new JobInfo.Builder(30,
                new ComponentName(getPackageName(),MyService.class.getName()));
        builder.setRequiresCharging(true);
        builder.setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY);

        jobScheduler.schedule(builder.build());
    }
}
