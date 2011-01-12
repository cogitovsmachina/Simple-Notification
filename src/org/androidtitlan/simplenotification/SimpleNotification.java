package org.androidtitlan.simplenotification;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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
        // icon from resources
        int icon = R.drawable.notification_icon;
       // ticker-text
        CharSequence tickerText = "Simple Notification!";
        // notification time
        long when = System.currentTimeMillis();
        //Creating a Object Notification passing the id of the icon, the flowing text in the notification
        //bar and the time to show in the time field.
        Notification mNotification = new Notification(icon, tickerText, when);
        
        //Using default Sound
        //mNotification.defaults = Notification.DEFAULT_SOUND;
        
        //Using other sound
        mNotification.sound = Uri.parse("file:///sdcard/Media/Audio//13 Are You In-.mp3");

        //Configurations of Notification
        mNotification.flags= Notification.FLAG_AUTO_CANCEL;
        
      //Vibrate
      //  mNotification.defaults= Notification.DEFAULT_VIBRATE;
        
        long[] vibrate = {0,500,100,200,0,500,100,200,0};
        mNotification.vibrate = vibrate;
        
        
        //Define the Notification's expanded message and Intent
        
        // application Context
        Context context = getApplicationContext();
       
     // expanded message title
        CharSequence contentTitle = "This is the Title =)";
        // expanded message text
        CharSequence contentText = "This is the inner text"; 
        Intent mIntent = new Intent(this, SimpleNotification.class);
      //  Retrieve a PendingIntent that will start a new activity, like calling Context.startActivity(Intent).
        PendingIntent mPendingIntent = PendingIntent.getActivity(this, 0, mIntent, 0);
       
        
     // The next two lines initialize the Notification, using the configurations above
        mNotification.setLatestEventInfo(context, contentTitle, contentText, mPendingIntent);
       

       // Pass the Notification to the NotificationManager:
          mNotificationManager.notify(HELLO_ID, mNotification);
          
        
    }
}