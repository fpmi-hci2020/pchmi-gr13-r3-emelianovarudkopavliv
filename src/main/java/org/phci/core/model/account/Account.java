package org.phci.core.model.account;

import java.io.Serializable;

public class Account implements Serializable {

    private String email;

    private String password;

    public Account() { }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
