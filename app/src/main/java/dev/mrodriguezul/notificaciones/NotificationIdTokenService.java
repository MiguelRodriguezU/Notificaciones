package dev.mrodriguezul.notificaciones;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by MIGUEL on 13/01/2018.
 */

public class NotificationIdTokenService extends FirebaseInstanceIdService {
    private static final String TAG = "notificacion-test";
    @Override
    public void onTokenRefresh() {
        //super.onTokenRefresh();
        String token = FirebaseInstanceId.getInstance().getToken();

        enviarTokenRegistro(token);
    }
    private void enviarTokenRegistro(String token){
        Log.d(TAG,"Este es el pinche token: "+token);

    }
}
