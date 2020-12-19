package org.phci.core.model.news;

import org.phci.core.model.book.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

public class RestTemplateNewsDao implements NewsDao {
    private static final  String ROOT_URI = "http://enigmatic-fjord-21043.herokuapp.com/api/accounts/";

    private RestTemplate restTemplate;

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @Override
    public List<News> get(String email) {
        ResponseEntity<News[]> response = restTemplate.getForEntity(ROOT_URI + "news/" + email, News[].class);
        return Arrays.asList(response.getBody());
    }
}
