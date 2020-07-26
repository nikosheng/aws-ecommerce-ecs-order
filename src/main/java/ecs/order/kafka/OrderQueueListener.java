package ecs.order.kafka;

import com.alibaba.fastjson.JSONObject;
import ecs.order.model.Order;
import ecs.order.model.Shipment;
import ecs.order.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class OrderQueueListener {

    private final Logger log = LoggerFactory.getLogger(OrderQueueListener.class);

    public OrderQueueListener(){}

    @Autowired
    private OrderService orderService;

    @KafkaListener(topics = "aws.topic.order.test")
    public void order(String shipmentJson) {
        Shipment shipment = JSONObject.parseObject(shipmentJson, Shipment.class);
        log.info("Received shipment " + shipment.getShipmentId());
        Order order = orderService.findOrderById(shipment.getOrderId());
        order.setShipmentId(shipment.getShipmentId());
        orderService.updateOrder(order);
    }
}
