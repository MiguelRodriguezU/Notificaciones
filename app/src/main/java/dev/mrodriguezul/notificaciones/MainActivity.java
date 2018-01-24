package dev.mrodriguezul.notificaciones;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;

import dev.mrodriguezul.notificaciones.restApi.EndPoints;
import dev.mrodriguezul.notificaciones.restApi.adapter.RestApiAdapter;
import dev.mrodriguezul.notificaciones.restApi.model.UsuarioResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "notificacion-test";
    private static final String AVENGER_DEADPOOL = "deadpool";
    private static final String AVENGER_IRONMAN = "ironman";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void lanzarNotificacion(View v) {
        String token = FirebaseInstanceId.getInstance().getToken();

        enviarTokenRegistro(token);
    }

    private void enviarTokenRegistro(String token){
        Toast.makeText(this,"Toke: "+token,Toast.LENGTH_LONG).show();
        Log.i(TAG,"PincheTOK: "+token);

        RestApiAdapter restApiAdapter = new RestApiAdapter();
        EndPoints endPoints = restApiAdapter.establecerConexionRestApi();
        Call<UsuarioResponse> usuarioResponseCall = endPoints.registrarTokenId(token, AVENGER_IRONMAN);

        usuarioResponseCall.enqueue(new Callback<UsuarioResponse>() {
            @Override
            public void onResponse(Call<UsuarioResponse> call, Response<UsuarioResponse> response) {
                UsuarioResponse usuarioResponse = response.body();

                Log.i(TAG,"Respuesta de Firebase:  "+usuarioResponse.getId());
                Log.i(TAG,"Respuesta de Firebase:  "+usuarioResponse.getToken());
            }

            @Override
            public void onFailure(Call<UsuarioResponse> call, Throwable t) {

            }
        });
    }

    public void tokeAvenger(View view){
        //UsuarioResponse usuarioResponse = new UsuarioResponse("-L3K_GGE5FF0QJ9J-HnH","c81vnCPDq5s:APA91bFxxIaD1-d1Y1icjPvP3dbeN97t269lfVvrDvMbXYjTV7Ja6BUz5g3kpS0aNrVVpL76yfRW7nbst4ARLoGBdTBg6qxXvHf2LI1elxrsL3LQSElyEcTUosCvHYxsBDRsw6Ds33jH",AVENGER_IRONMAN);
        UsuarioResponse usuarioResponse = new UsuarioResponse("-L3KZrQh7gzteThG1wN1","e84kld9hKiw:APA91bG6n7LeNtEZ6Ljb2jcfYkLSZ30tLG5tqN-2CF4v5nK-WZEB7OOImra0ap_1ywbbq4sobXPh1WHagGXzZZ1Po_Jt6Hu6kFToHl7YNAaN5m29LDqLxvuWMli0OvjWepOxx2IU2a4R",AVENGER_DEADPOOL);

        RestApiAdapter restApiAdapter = new RestApiAdapter();
        EndPoints endPoints = restApiAdapter.establecerConexionRestApi();
        Call<UsuarioResponse> usuarioResponseCall = endPoints.toqueAvenger(usuarioResponse.getId(), usuarioResponse.getAvenger());

        usuarioResponseCall.enqueue(new Callback<UsuarioResponse>() {
            @Override
            public void onResponse(Call<UsuarioResponse> call, Response<UsuarioResponse> response) {
                UsuarioResponse usuarioResponse1 = response.body();

                Log.i(TAG,"ID Firebase:  "+usuarioResponse1.getId());
                Log.i(TAG,"TOKEN Firebase:  "+usuarioResponse1.getToken());
                Log.i(TAG,"AVENGER:  "+usuarioResponse1.getAvenger());
            }

            @Override
            public void onFailure(Call<UsuarioResponse> call, Throwable t) {

            }
        });
    }
}
