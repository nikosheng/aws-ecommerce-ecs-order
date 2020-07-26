package ecs.order.service;

import ecs.order.model.Order;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

public interface OrderService {
    void createOrder(@NotNull(message = "The order cannot be null.") @Valid Order order);

    void updateOrder(@NotNull(message = "The order cannot be null.") @Valid Order order);

    Order findOrderById(Long orderId);

    List<Order> listOrders();
}
