package com.example.medicineapp;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Vibrator;

import androidx.annotation.RequiresApi;

public class MyBroadcastReceiver extends BroadcastReceiver {

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onReceive(Context context, Intent intent) {
        Vibrator vibrator = (Vibrator)context.getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(10000);

        Notification noti = new Notification.Builder(context)
                .setContentTitle("Medi Alarm is ON")
                .setContentText("It's time to take medicine")
                .setSmallIcon(R.mipmap.ic_launcher).build();

        NotificationManager manager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        noti.flags|= Notification.FLAG_AUTO_CANCEL;
        manager.notify(0,noti);

        Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        Ringtone r = RingtoneManager.getRingtone(context,notification);
        r.play();

    }
}