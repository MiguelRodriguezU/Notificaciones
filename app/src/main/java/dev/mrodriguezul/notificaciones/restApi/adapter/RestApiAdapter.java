package dev.mrodriguezul.notificaciones.restApi.adapter;

import com.google.gson.Gson;

import dev.mrodriguezul.notificaciones.restApi.ConstantesRestApi;
import dev.mrodriguezul.notificaciones.restApi.EndPoints;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by MIGUEL on 14/01/2018.
 */

public class RestApiAdapter {

    public EndPoints establecerConexionRestApi(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantesRestApi.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(EndPoints.class);
    }
}
