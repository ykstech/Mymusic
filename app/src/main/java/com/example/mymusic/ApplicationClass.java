package com.example.mymusic;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class ApplicationClass extends Application {
    public static  final  String chid1 = "CHANNEL_1";

    public static  final  String chid2 = "CHANNEL_2";

    public static  final  String anext = "NEXT";
    public static  final  String aprev = "PREVIOUS";
    public static  final  String aplay = "PLAY";


    @Override
    public void onCreate() {
        super.onCreate();

        createnotificationchannel();
    }

    private  void createnotificationchannel(){
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel notificationChannel1 = new NotificationChannel(chid1,
                    "channel1(1)", NotificationManager.IMPORTANCE_HIGH);
            notificationChannel1.setDescription("channel 1 Description");

            NotificationChannel notificationChannel2 = new NotificationChannel(chid2,
                    "channel1(2)", NotificationManager.IMPORTANCE_HIGH);
            notificationChannel1.setDescription("channel 2 Description");
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(notificationChannel1);
            notificationManager.createNotificationChannel(notificationChannel2);

        }
    }
}
