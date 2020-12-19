package org.phci.core.model.cart;

public class AddToCartItem {
    private String account;
    private Integer book;
    private Integer quantity;

    public AddToCartItem() {
    }

    public AddToCartItem(String account, Integer book, Integer quantity) {
        this.account = account;
        this.book = book;
        this.quantity = quantity;
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
