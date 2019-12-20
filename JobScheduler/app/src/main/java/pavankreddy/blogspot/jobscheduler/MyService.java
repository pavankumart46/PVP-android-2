package pavankreddy.blogspot.jobscheduler;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.widget.Toast;

public class MyService extends JobService
{

    @Override
    public boolean onStartJob(JobParameters params) {
        Toast.makeText(this, "JOB Finished", Toast.LENGTH_SHORT).show();
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        return false;
    }
}
