package pavankreddy.blogspot.powerandheadsetreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.Toast;

public class CustomReceiver extends BroadcastReceiver {

   ImageView imageView;
   boolean flag = false;

    public CustomReceiver(ImageView imageView) {
        this.imageView = imageView;
    }

    @Override
    public void onReceive(Context context, Intent intent)
    {
        switch (intent.getAction())
        {
            case Intent.ACTION_POWER_CONNECTED:
                imageView.setImageResource(R.drawable.charging);
                Toast.makeText(context, "Charging", Toast.LENGTH_SHORT).show();
                break;
            case Intent.ACTION_POWER_DISCONNECTED:
                imageView.setImageResource(R.drawable.discharging);
                Toast.makeText(context, "discharging", Toast.LENGTH_SHORT).show();
                break;
            case Intent.ACTION_HEADSET_PLUG:
                if(flag)
                {
                    imageView.setImageResource(R.drawable.disconnected);
                    flag = false;
                }
                else
                {
                    imageView.setImageResource(R.drawable.connected);
                    flag = true;
                }
                break;
        }
    }
}
