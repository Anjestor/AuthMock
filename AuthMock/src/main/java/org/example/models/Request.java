package org.example.models;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Request {

    @NotNull
    private String login;

    @NotNull
    //@Size(min = 6)
    private String password;

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public Request() {
    }
}
