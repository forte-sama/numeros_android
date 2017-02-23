package com.example.nafl.numerologiadominicana;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by Neury on 2/21/2017.
 */

public class MyFirebaseInstanceIdService extends FirebaseInstanceIdService {


    public static final String TAG= "NumerologiaDominicana";
    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();

        String token = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG,"Token: "+token);

    }
}
