package org.example.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@JsonIgnoreProperties(ignoreUnknown = false)
public class Request {

    @NotNull
    @NotBlank
    private String login;

    @NotNull
    @NotBlank
    private String password;

    public void setLogin(String login) { this.login = login; }

    public void setPassword(String password) { this.password = password; }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public Request() {
    }
}
