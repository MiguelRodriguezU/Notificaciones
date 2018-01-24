package dev.mrodriguezul.notificaciones.restApi;

import dev.mrodriguezul.notificaciones.restApi.model.UsuarioResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by MIGUEL on 14/01/2018.
 */

public interface EndPoints {

    @FormUrlEncoded
    @POST(ConstantesRestApi.KEY_POST_ID_TOKEN)
    Call<UsuarioResponse> registrarTokenId(@Field("token") String token, @Field("avenger") String avenger);

    @GET(ConstantesRestApi.KEY_TOQUE_AVENGER)
    Call<UsuarioResponse> toqueAvenger(@Path("id") String id, @Path("avenger") String avenger);
}
