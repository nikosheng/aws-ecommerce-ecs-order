package ecs.order.model;

import javax.persistence.*;
import java.util.Date;

@Embeddable
public class Shipment {

    @Id
    @Column(name = "shipment_id")
    private Long shipmentId;

    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "item_id")
    private Long itemId;

    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "shipment_address")
    private String shipmentAddress;

    @Column(name = "create_timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTimestamp;

    @Column(name = "update_timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTimestamp;

    public Shipment(){}

    public Shipment(Long shipmentId, Long customerId, Long itemId, Long orderId, String shipmentAddress, Date createTimestamp, Date updateTimestamp) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.itemId = itemId;
        this.shipmentId = shipmentId;
        this.shipmentAddress = shipmentAddress;
        this.createTimestamp = createTimestamp;
        this.updateTimestamp = updateTimestamp;
    }

    public Shipment(ShipmentBuilder builder) {
        this.orderId = builder.orderId;
        this.customerId = builder.customerId;
        this.itemId = builder.itemId;
        this.shipmentAddress = builder.shipmentAddress;
        this.createTimestamp = builder.createTimestamp;
        this.updateTimestamp = builder.updateTimestamp;
    }

    public static class ShipmentBuilder {
        private Long shipmentId;
        private Long orderId;
        private Long customerId;
        private Long itemId;
        private String shipmentAddress;
        private Date createTimestamp;
        private Date updateTimestamp;

        public static ShipmentBuilder newBuilder(){
            return new ShipmentBuilder();
        }
        public Shipment build(){
            return new Shipment(this);
        }

        public ShipmentBuilder shipmentId(Long shipmentId) {
            this.shipmentId = shipmentId;
            return this;
        }

        public ShipmentBuilder orderId(Long orderId) {
            this.orderId = orderId;
            return this;
        }

        public ShipmentBuilder customerId(Long customerId) {
            this.customerId = customerId;
            return this;
        }

        public ShipmentBuilder itemId(Long itemId) {
            this.itemId = itemId;
            return this;
        }

        public ShipmentBuilder shipmentAddress(String shipmentAddress) {
            this.shipmentAddress = shipmentAddress;
            return this;
        }

        public ShipmentBuilder createTimestamp(Date createTimestamp) {
            this.createTimestamp = createTimestamp;
            return this;
        }

        public ShipmentBuilder updateTimestamp(Date updateTimestamp) {
            this.updateTimestamp = updateTimestamp;
            return this;
        }

        public Shipment emptyShipment() {
            return new Shipment(0L, 0L, 0L, 0L, null, new Date(), new Date());
        }
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
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

    public Long getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(Long shipmentId) {
        this.shipmentId = shipmentId;
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
