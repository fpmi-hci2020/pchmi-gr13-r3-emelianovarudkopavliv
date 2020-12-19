package org.phci.core.model.account;

public interface AccountDao {
    Account get(String email);
    Account addAccount(Account account);
}
