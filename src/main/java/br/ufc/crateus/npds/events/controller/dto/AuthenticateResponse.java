package br.ufc.crateus.npds.events.controller.dto;

public class AuthenticateResponse {
    private String jwt;

    public AuthenticateResponse() {
    }

    public AuthenticateResponse(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
