package ecs.order.service;

import com.alibaba.fastjson.JSONObject;
import ecs.order.dao.OrderRepository;
import ecs.order.model.Order;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    @Transactional
    public void createOrder(@NotNull(message = "The order cannot be null.") @Valid Order order) {
        order.setCreateTimestamp(Date.from(Instant.now()));
        order.setUpdateTimestamp(Date.from(Instant.now()));
        orderRepository.save(order);

        ProducerRecord<String, String> record =
                new ProducerRecord<>("aws.topic.shipment.test", JSONObject.toJSONString(order));
        kafkaTemplate.send(record);
    }

    @Override
    @Transactional
    public void updateOrder(@NotNull(message = "The order cannot be null.") @Valid Order order) {
        order.setUpdateTimestamp(Date.from(Instant.now()));
        orderRepository.save(order);
    }

    @Override
    public Order findOrderById(@NotNull(message = "The order cannot be null.") Long orderId) {
        return orderRepository.findById(orderId).orElse(Order.OrderBuilder.newBuilder().emptyOrder());
    }

    @Override
    public List<Order> listOrders() {
        return orderRepository.findAll();
    }
}
