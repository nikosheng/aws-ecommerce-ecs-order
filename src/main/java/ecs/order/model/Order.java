package ecs.order.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_order")
public class Order {

    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long orderId;

    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "item_id")
    private Long itemId;

    @Column(name = "shipment_id")
    private Long shipmentId;

//    @Column(name = "shipment_address")
    @Transient
    private String shipmentAddress;

    @Column(name = "create_timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTimestamp;

    @Column(name = "update_timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTimestamp;

    public Order(){}

    public Order(Long orderId, Long customerId, Long itemId, Long shipmentId, Date createTimestamp, Date updateTimestamp) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.itemId = itemId;
        this.shipmentId = shipmentId;
        this.createTimestamp = createTimestamp;
        this.updateTimestamp = updateTimestamp;
    }

    public Order(Long orderId, Long customerId, Long itemId, Long shipmentId) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.itemId = itemId;
        this.shipmentId = shipmentId;
    }

    public Order(OrderBuilder builder) {
        this.orderId = builder.orderId;
        this.customerId = builder.customerId;
        this.itemId = builder.itemId;
        this.shipmentId = builder.shipmentId;
        this.shipmentAddress = builder.shipmentAddress;
        this.createTimestamp = builder.createTimestamp;
        this.updateTimestamp = builder.updateTimestamp;
    }

    public static class OrderBuilder {
        private Long orderId;
        private Long customerId;
        private Long itemId;
        private Long shipmentId;
        private String shipmentAddress;
        private Date createTimestamp;
        private Date updateTimestamp;

        public static OrderBuilder newBuilder(){
            return new OrderBuilder();
        }
        public Order build(){
            return new Order(this);
        }

        public OrderBuilder orderId(Long orderId) {
            this.orderId = orderId;
            return this;
        }

        public OrderBuilder customerId(Long customerId) {
            this.customerId = customerId;
            return this;
        }

        public OrderBuilder itemId(Long itemId) {
            this.itemId = itemId;
            return this;
        }

        public OrderBuilder shipmentId(Long shipmentId) {
            this.shipmentId = shipmentId;
            return this;
        }

        public OrderBuilder shipmentAddress(String shipmentAddress) {
            this.shipmentAddress = shipmentAddress;
            return this;
        }

        public OrderBuilder createTimestamp(Date createTimestamp) {
            this.createTimestamp = createTimestamp;
            return this;
        }

        public OrderBuilder updateTimestamp(Date updateTimestamp) {
            this.updateTimestamp = updateTimestamp;
            return this;
        }

        public Order emptyOrder() {
            return new Order(0L, 0L, 0L, 0L, new Date(), new Date());
        }
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(Long shipmentId) {
        this.shipmentId = shipmentId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getShipmentAddress() {
        return shipmentAddress;
    }

    public void setShipmentAddress(String shipmentAddress) {
        this.shipmentAddress = shipmentAddress;
    }

    public Date getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(Date createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public Date getUpdateTimestamp() {
        return updateTimestamp;
    }

    public void setUpdateTimestamp(Date updateTimestamp) {
        this.updateTimestamp = updateTimestamp;
    }
}
