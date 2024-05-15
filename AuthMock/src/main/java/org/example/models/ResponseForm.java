package org.example.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ResponseForm {
    private String login;
    private String password;
    private String date;

    public String getLogin(){
        return this.login;
    }

    public String getPassword(){
        return this.password;
    }

    public String getDate(){
        return this.date;
    }

    public void setLogin(final String login) {
        this.login = login;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public void setDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        this.date = dtf.format(now);
    }

    public ResponseForm(){
    }

    public ResponseForm(String login, String password) {
        this.login = login;
        this.password = password;

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        this.date = dtf.format(now);
    }
}
