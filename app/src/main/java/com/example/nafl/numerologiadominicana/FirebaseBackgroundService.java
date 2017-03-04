package com.example.nafl.numerologiadominicana;


import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.content.res.Resources;
import android.os.IBinder;
import android.support.v7.app.NotificationCompat;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class FirebaseBackgroundService extends Service {

    public static  String message;
    public FirebaseBackgroundService() {
    }



    private TextView textViewReal;


    private DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
    DatabaseReference cf = reference.child("_3dias");
    DatabaseReference f = cf.child("desde");
    private ValueEventListener handler;



    @Override
    public IBinder onBind(Intent arg0) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        //textViewReal =(TextView)textViewReal.findViewById(R.id.textViewReal);
        handler = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                message =  dataSnapshot.getValue(String.class);

               // publishResults(message);
                postNotif();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        };

        f.addValueEventListener(handler);
    }



    private void postNotif() {
        PendingIntent pi = PendingIntent.getActivity(this, 0, new Intent(this, MainActivity.class), 0);
        Resources r = getResources();
        Notification notification = new NotificationCompat.Builder(this)
                .setTicker(r.getString(R.string.common_google_play_services_unknown_issue))
                .setSmallIcon(android.R.drawable.ic_menu_report_image)
                .setContentTitle(r.getString(R.string.common_google_play_services_unknown_issue))
                .setContentText(r.getString(R.string.common_google_play_services_unknown_issue))
               // .setContentText(r.getString(R.string.notification_text))
                .setContentIntent(pi)
                .setAutoCancel(true)

                .build();

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(0, notification);

    }

//-----------------------------------------------------------------------------------------------------


    private void publishResults(String x) {


        Intent intent = new Intent("1");
        intent.putExtra("x", x);

        sendBroadcast(intent);
    }























}
