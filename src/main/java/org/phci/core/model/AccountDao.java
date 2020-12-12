package org.phci.core.model;

import org.springframework.http.HttpStatus;

public interface AccountDao {
    Account get(String email);
    Account addAccount(Account account);
}
