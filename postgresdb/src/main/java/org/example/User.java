package org.example;

public class User {
    private String login;
    private String password;
    private java.sql.Date date;
    private String email;

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public java.sql.Date getDate() {
        return date;
    }

    public String getEmail() {
        return email;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDate(java.sql.Date date) {
        this.date = date;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return login + '\t' + password + '\t' + date + '\t' + email;
    }

    public User(String login, String password, java.sql.Date date, String email) {
        this.login = login;
        this.password = password;
        this.date = date;
        this.email = email;
    }
}
