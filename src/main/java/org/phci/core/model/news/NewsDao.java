package org.phci.core.model.news;

import java.util.List;

public interface NewsDao {
    List<News> get(String email);
}
