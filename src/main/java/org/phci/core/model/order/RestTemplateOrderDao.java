package org.phci.core.model.order;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class RestTemplateOrderDao implements OrderDao {
    protected final ReadWriteLock rwLock = new ReentrantReadWriteLock();
    private static final  String ROOT_URI = "http://enigmatic-fjord-21043.herokuapp.com/api";

    private RestTemplate restTemplate;

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Order> get(String email) {
        Lock readLock = rwLock.readLock();
        readLock.lock();
        try {
            String uri = ROOT_URI + "/store/order/" + email;
            ResponseEntity<Order[]> response = restTemplate.getForEntity(uri, Order[].class);
            return Arrays.asList(response.getBody());
        } finally {
            readLock.unlock();
            //return null;
        }
    }

    @Override
    public Order placeOrder(Order order) {
        ResponseEntity<Order> response = restTemplate.postForEntity(ROOT_URI + "/store/order/", order, Order.class);
        return response.getBody();
        //return new Order();
    }

    @Override
    public void cancel(Integer bookId) {
        Map<String, Integer> params = new HashMap();
        params.put("id", bookId);
        restTemplate.delete(ROOT_URI + "/store/order/" + bookId, params);
    }
}
