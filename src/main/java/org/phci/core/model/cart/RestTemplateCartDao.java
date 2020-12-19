package org.phci.core.model.cart;

import org.phci.core.model.account.Account;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class RestTemplateCartDao implements CartDao {
    protected final ReadWriteLock rwLock = new ReentrantReadWriteLock();
    private static final  String ROOT_URI = "http://enigmatic-fjord-21043.herokuapp.com/api";

    private RestTemplate restTemplate;

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<CartItem> get(String email) {
        Lock readLock = rwLock.readLock();
        readLock.lock();
        try {
            ResponseEntity<CartItem[]> response = restTemplate.getForEntity(ROOT_URI + "/store/cart/" + email, CartItem[].class);
            return Arrays.asList(response.getBody());
        } finally {
            readLock.unlock();
        }
    }

    @Override
    public AddToCartItem addToCart(AddToCartItem addToCartItem) {
        ResponseEntity<AddToCartItem> response = restTemplate.postForEntity(ROOT_URI + "/store/cart/", addToCartItem, AddToCartItem.class);
        return response.getBody();
    }


    @Override
    public void updateCart(AddToCartItem addToCartItem) {
        restTemplate.put(ROOT_URI + "/store/cart/", addToCartItem);
    }

    @Override
    public void deleteFromCart(String email, Integer bookId) {

    }
}
