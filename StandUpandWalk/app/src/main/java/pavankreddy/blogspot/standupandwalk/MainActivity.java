package pavankreddy.blogspot.standupandwalk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    ToggleButton toggleButton;
    AlarmManager alarmManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toggleButton = findViewById(R.id.togglebutton);
        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        Intent in = new Intent(this,NotificaitonReceiver.class);
        boolean almState = (PendingIntent.getBroadcast(this,
                10,in,PendingIntent.FLAG_NO_CREATE)!=null);
        toggleButton.setChecked(almState);

        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Intent intent = new Intent(MainActivity.this,
                        NotificaitonReceiver.class);
                PendingIntent pi = PendingIntent.getBroadcast(MainActivity.this,
                        10, intent,PendingIntent.FLAG_UPDATE_CURRENT);
                if(isChecked){
                    long triggerTime = SystemClock.elapsedRealtime();
                    long intervalTime = 1*60*1000;
                    alarmManager.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                            triggerTime,intervalTime,pi);
                    Toast.makeText(MainActivity.this, "Alarm ON", Toast.LENGTH_SHORT).show();
                }
                else{
                    alarmManager.cancel(pi);
                    Toast.makeText(MainActivity.this, "Alarm OFF", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    
}
