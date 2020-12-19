package org.phci.core.model.favorite;

import org.phci.core.model.book.Book;

import java.util.List;

public interface FavoriteDao {
    List<Favorite> get(String email);
    Favorite addFavorite(Favorite favorite);
    void remove(String email, Integer bookId);
}
