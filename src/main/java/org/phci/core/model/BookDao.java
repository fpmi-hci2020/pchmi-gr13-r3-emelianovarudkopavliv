package org.phci.core.model;

import java.io.IOException;
import java.util.List;

public interface BookDao {
    Book get(Long key);
    List<Book> findAll(String queryProduct, String searchField);
    String getBookCover(Long key) throws IOException;
    void save(Book book);
}
