package org.phci.core.model.cart;

import java.util.List;

public interface CartDao {
    List<CartItem> get(String email);
    void updateCart(AddToCartItem addToCartItem);
    AddToCartItem addToCart(AddToCartItem addToCartItem);
    void deleteFromCart(String email, Integer bookId);
}
