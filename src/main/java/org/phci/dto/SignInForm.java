package org.phci.dto;

import javax.validation.constraints.Pattern;

public class SignInForm {

    //@Pattern(message = "wrong input", regexp="") add check email (@) ?
    private String login = "temp@gmail.com";

    private String password = "temp";

    public SignInForm() { }

    public SignInForm(String login, String password) {
        this.login = login;
        this.password = password;
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
