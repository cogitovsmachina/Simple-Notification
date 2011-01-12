package org.androidtitlan.simplenotification;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class SimpleNotification extends Activity {
    public static final int HELLO_ID = 1;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        String ns = Context.NOTIFICATION_SERVICE;
        //Get a reference to the Notification Manager
        NotificationManager mNotificationManager = (NotificationManager) getSystemService(ns);
        
        //Instantiate the Notification
        int icon = R.drawable.notification_icon;
        CharSequence tickerText = "Hello";
        long when = System.currentTimeMillis();
        //Creating a Object Notification passing the id of the icon, the flowing text in the notification
        //bar and the time to show in the time field.
        Notification mNotification = new Notification(icon, tickerText, when);
        
        //Define the Notification's expanded message and Intent
        Context context = getApplicationContext();
        CharSequence contentTitle = "This is the Title";
        CharSequence contentText = "Hello Notifications!";
        Intent mIntent = new Intent(this, SimpleNotification.class);
      //  Retrieve a PendingIntent that will start a new activity, like calling Context.startActivity(Intent).
        PendingIntent mPendingIntent = PendingIntent.getActivity(this, 0, mIntent, 0);
        
        mNotification.setLatestEventInfo(context, contentTitle, contentText, mPendingIntent);

        
       // Pass the Notification to the NotificationManager:
          mNotificationManager.notify(HELLO_ID, mNotification);
          
        
    }
}