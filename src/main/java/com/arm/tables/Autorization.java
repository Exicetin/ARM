package com.arm.tables;
@Entity
public class Autorization {
    private int idSotr;//id
    private String login;
    private String password;

    public int getIdSotr() {
        return idSotr;
    }

    public void setIdSotr(int idSotr) {
        this.idSotr = idSotr;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
