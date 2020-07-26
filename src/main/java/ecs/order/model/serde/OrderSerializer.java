package ecs.order.model.serde;

import ecs.order.model.Order;
import org.springframework.kafka.support.serializer.JsonSerializer;

public class OrderSerializer extends JsonSerializer<Order> {

}
