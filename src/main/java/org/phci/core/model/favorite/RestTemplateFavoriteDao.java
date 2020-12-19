package org.phci.core.model.favorite;

import org.phci.core.model.account.Account;
import org.phci.core.model.book.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestTemplateFavoriteDao implements FavoriteDao {
    private static final  String ROOT_URI = "http://enigmatic-fjord-21043.herokuapp.com/api/accounts/";

    private RestTemplate restTemplate;

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @Override
    public List<Favorite> get(String email) {
        ResponseEntity<Favorite[]> response = restTemplate.getForEntity(ROOT_URI + "favorites/" + email, Favorite[].class);
        return Arrays.asList(response.getBody());
    }

    @Override
    public Favorite addFavorite(Favorite favorite) {
        ResponseEntity<Favorite> response = restTemplate.postForEntity(ROOT_URI + "favorites", favorite, Favorite.class);
        return response.getBody();
    }

    @Override
    public void remove(String email, Integer bookId) {
        Map<String, String> params = new HashMap();
        params.put("book_id", bookId.toString());
        params.put("email", email);
        restTemplate.delete(ROOT_URI + email + "/" + bookId, params);
    }
}
