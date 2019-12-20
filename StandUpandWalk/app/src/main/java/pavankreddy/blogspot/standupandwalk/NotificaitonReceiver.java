package pavankreddy.blogspot.standupandwalk;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;

import androidx.core.app.NotificationCompat;

import static android.content.Context.NOTIFICATION_SERVICE;

public class NotificaitonReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        final String CHANNEL_ID = "mychannel";
        final int NOTIFICATION_ID = 23;
        NotificationManager nm
                = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel nc =
                    new NotificationChannel(CHANNEL_ID, "pvp channel",
                            NotificationManager.IMPORTANCE_HIGH);
            nc.enableLights(true);
            nc.enableVibration(true);
            nc.setDescription("My first Notification channel");
            nc.setLightColor(Color.RED);
            nm.createNotificationChannel(nc);
        }
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(context,CHANNEL_ID);
        builder.setSmallIcon(R.drawable.walk);
        builder.setContentTitle("Stand Up and Walk Around!");
        builder.setContentText("Walking around each 10 min is healthier");
        builder.setPriority(NotificationCompat.PRIORITY_HIGH);
        Intent i = new Intent(context,MainActivity.class);
        PendingIntent pi = PendingIntent.getActivity(context,
                12,i,PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pi);
        builder.setAutoCancel(true);
        builder.addAction(R.drawable.walk,"Action - 1",pi);
        builder.addAction(R.drawable.walk,"Action - 2",pi);

        Bitmap bitmap =
                BitmapFactory.decodeResource(context.getResources(),R.drawable.abc);
        builder.setStyle(new NotificationCompat.
                BigPictureStyle().bigPicture(bitmap));

        nm.notify(NOTIFICATION_ID,builder.build());
    }
}
