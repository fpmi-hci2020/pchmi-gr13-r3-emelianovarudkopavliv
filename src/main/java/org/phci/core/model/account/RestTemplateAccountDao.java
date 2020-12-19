package org.phci.core.model.account;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestTemplateAccountDao implements AccountDao {

    private static final  String ROOT_URI = "http://enigmatic-fjord-21043.herokuapp.com/api/accounts/";

    private RestTemplate restTemplate;

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Account get(String email) {
        ResponseEntity<Account> response = restTemplate.getForEntity(ROOT_URI + email, Account.class);
        return response.getBody();
    }

    @Override
    public Account addAccount(Account account) {
        ResponseEntity<Account> response = restTemplate.postForEntity(ROOT_URI, account, Account.class);
        return response.getBody();
    }
}
