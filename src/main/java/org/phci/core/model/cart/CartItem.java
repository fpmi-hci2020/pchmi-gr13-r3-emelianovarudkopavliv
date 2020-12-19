package org.phci.core.model.cart;

import org.phci.core.model.book.Book;

import java.io.Serializable;

public class CartItem implements Serializable {
    private Book book;

    private Integer quantity;

    public CartItem() {    }

    public CartItem(Book book, Integer quantity) {
        this.book = book;
        this.quantity = quantity;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
