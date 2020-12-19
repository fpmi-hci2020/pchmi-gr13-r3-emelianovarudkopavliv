package org.phci.core.model.book;

import java.io.IOException;
import java.util.List;

public interface BookDao {
    Book get(Integer key);
    List<Book> findAll(String queryProduct, String searchField);
    String getBookCover(Integer key) throws IOException;
    void save(Book book);
}
