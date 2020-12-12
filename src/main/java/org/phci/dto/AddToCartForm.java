package org.phci.dto;

import javax.validation.constraints.Pattern;

public class AddToCartForm {

    private Long bookId;

    @Pattern(message = "wrong input", regexp="^0*[1-9][0-9]*$")
    private String quantity = "1";

    public AddToCartForm() { }

    public AddToCartForm(Long bookId, @Pattern(message = "wrong input", regexp = "^0*[1-9][0-9]*$") String quantity) {
        this.bookId = bookId;
        this.quantity = quantity;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long id) {
        this.bookId = id;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
