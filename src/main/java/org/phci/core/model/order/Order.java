package org.phci.core.model.order;

import org.phci.core.model.cart.CartItem;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Order {
    private Integer id;
    private String account;
    private String payment_method;
    private String shipping_method;
    private Date date_placed;
    private Date date_delivered;
    private BigDecimal price;
    private List<CartItem> books;

    public Order() {
    }

    public Order(Integer id, String account, String payment_method, String shipping_method, Date date_placed, Date date_delivered, BigDecimal price, List<CartItem> books) {
        this.id = id;
        this.account = account;
        this.payment_method = payment_method;
        this.shipping_method = shipping_method;
        this.date_placed = date_placed;
        this.date_delivered = date_delivered;
        this.price = price;
        this.books = books;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }

    public String getShipping_method() {
        return shipping_method;
    }

    public void setShipping_method(String shipping_method) {
        this.shipping_method = shipping_method;
    }

    public Date getDate_placed() {
        return date_placed;
    }

    public void setDate_placed(Date date_placed) {
        this.date_placed = date_placed;
    }

    public Date getDate_delivered() {
        return date_delivered;
    }

    public void setDate_delivered(Date date_delivered) {
        this.date_delivered = date_delivered;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List<CartItem> getBooks() {
        return books;
    }

    public void setBooks(List<CartItem> books) {
        this.books = books;
    }
}
