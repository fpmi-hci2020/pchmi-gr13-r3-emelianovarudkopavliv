package org.phci.core.model.book;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.Collectors;

public class RestTemplateBookDao implements BookDao {

    protected final ReadWriteLock rwLock = new ReentrantReadWriteLock();
    private static final  String ROOT_URI = "http://enigmatic-fjord-21043.herokuapp.com/api";

    private RestTemplate restTemplate;

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Book get(Integer key) {
        Lock readLock = rwLock.readLock();
        readLock.lock();
        try {
            ResponseEntity<Book> response = restTemplate.getForEntity(ROOT_URI + "/store/books/" + key, Book.class);
            return response.getBody();
        } finally {
            readLock.unlock();
        }
    }

    @Override
    public List<Book> findAll(String queryProduct, String searchField) {
        Lock readLock = rwLock.readLock();
        readLock.lock();
        ResponseEntity<Book[]> response = restTemplate.getForEntity(ROOT_URI + "/store/books/", Book[].class);
        List<Book> books = Arrays.asList(response.getBody());
        try {
            return books.stream()
                    .filter(product -> product.getPrice() != null)
                    .filter(product -> product.getTitle().contains(queryProduct))
                    .collect(Collectors.toList());
        } finally {
            readLock.unlock();
        }
    }

    @Override
    public String getBookCover(Integer key) throws IOException {
        Lock readLock = rwLock.readLock();
        readLock.lock();
        try {
            BufferedImage image = null;
            String encoding = "";
            image = ImageIO.read(new URL(ROOT_URI + "/store/books/cover/" + key));
            int height = image.getHeight();
            int width = image.getWidth();
            ImageIO.write(image,"png",new File("tmpImage.png"));
            byte[] imageBytes = Files.readAllBytes(Paths.get("tmpImage.png"));
            Base64.Encoder encoder = Base64.getEncoder();
            encoding = "data:image/png;base64," + encoder.encodeToString(imageBytes);
            return encoding;
        } finally {
            readLock.unlock();
        }
    }

    @Override
    public void save(Book book) {
        throw new UnsupportedOperationException();
    }

}
