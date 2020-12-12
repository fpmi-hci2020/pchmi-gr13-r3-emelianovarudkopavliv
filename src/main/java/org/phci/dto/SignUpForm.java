package org.phci.dto;

public class SignUpForm {

    //@Pattern(message = "wrong input", regexp="") add check email (@) ?
    private String login = "temp@gmail.com";

    private String password = "temp";

    private String repeatPassword = "temp";

    public SignUpForm() { }

    public SignUpForm(String login, String password, String repeatPassword) {
        this.login = login;
        this.password = password;
        this.repeatPassword = repeatPassword;
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

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }
}
