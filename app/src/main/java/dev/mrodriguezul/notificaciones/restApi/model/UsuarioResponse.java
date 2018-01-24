package dev.mrodriguezul.notificaciones.restApi.model;

/**
 * Created by MIGUEL on 14/01/2018.
 */

public class UsuarioResponse {
    private String id;
    private String token;
    private String avenger;

    public UsuarioResponse(String id, String token, String avenger) {
        this.id = id;
        this.token = token;
        this.avenger = avenger;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getAvenger() {
        return avenger;
    }

    public void setAvenger(String avenger) {
        this.avenger = avenger;
    }
}
