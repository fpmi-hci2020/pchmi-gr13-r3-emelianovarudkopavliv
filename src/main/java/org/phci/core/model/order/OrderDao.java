package org.phci.core.model.order;

import java.util.List;

public interface OrderDao {
    List<Order> get(String email);
    Order placeOrder(Order order);
    void cancel(Integer bookId);
}
