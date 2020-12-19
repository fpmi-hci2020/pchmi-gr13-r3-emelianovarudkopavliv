package org.phci.core.model.favorite;

public class Favorite {
    private String account;
    private Integer book;

    public Favorite() {
    }

    public Favorite(String account, Integer book) {
        this.account = account;
        this.book = book;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Integer getBook() {
        return book;
    }

    public void setBook(Integer book) {
        this.book = book;
    }
}
