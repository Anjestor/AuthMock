package org.example.models;

public class User {
    private String login;

    private String password;

    private java.sql.Date date;

    private String email;

    public String getLogin(){
        return this.login;
    }

    public String getPassword(){
        return this.password;
    }

    public java.sql.Date getDate(){
        return this.date;
    }

    public String getEmail() {
        return email;
    }

    public void setLogin(final String login) {
        this.login = login;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public void setDate(final java.sql.Date date) {
        this.date = date;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String userData() {
        return String.format("{\"login\": \"%s\", \"password\": \"%s\", \"date\": \"%s\", \"email\": \"%s\"}",
                this.getLogin(), this.getPassword(), this.getDate(), this.getEmail());
    }

    public User() {
    }

    public User(String login, String password, java.sql.Date date, String email) {
        this.login = login;
        this.password = password;
        this.date = date;
        this.email = email;
    }
}
