package com.kadaluarsa.cleaner.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.NotificationCompat;

import com.kadaluarsa.cleaner.ui.SplashActivity;
import com.kadaluarsa.cleanerr.R;

/**
 *
 */
public class NotificationEveryDayReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        if(Build.VERSION.SDK_INT >= 16){
            NotificationCompat.Builder mBuilder =
                    new NotificationCompat.Builder(context)
                            .setSmallIcon(R.drawable.noti_icon)
                            .setContentTitle("WARNING !")
                            .setContentText("Your phone is slow ! Clean Now !");
            // Creates an explicit intent for an Activity in your app
            Intent resultIntent = new Intent(context, SplashActivity.class);
            TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
            stackBuilder.addParentStack(SplashActivity.class);
            stackBuilder.addNextIntent(resultIntent);
            PendingIntent resultPendingIntent =
                    stackBuilder.getPendingIntent(
                            0,
                            PendingIntent.FLAG_UPDATE_CURRENT
                    );
            mBuilder.setContentIntent(resultPendingIntent);
            NotificationManager mNotificationManager =
                    (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            mNotificationManager.notify(124, mBuilder.build());
        }else {
            Intent resultIntent = new Intent(context, SplashActivity.class);
            PendingIntent pi = PendingIntent.getActivity(context, 0, resultIntent, 0);

            Notification n  = new Notification.Builder(context)
                    .setContentTitle("WARNING !")
                    .setContentText("Your phone is slow ! Clean Now !")
                    .setSmallIcon(R.drawable.noti_icon)
                    .setContentIntent(pi)
                    .setAutoCancel(true).getNotification();
            NotificationManager notificationManager =
                    (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.notify(0, n);
        }

    }
}
