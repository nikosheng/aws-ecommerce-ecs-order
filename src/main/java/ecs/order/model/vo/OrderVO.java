package ecs.order.model.vo;

import java.util.Date;

public class OrderVO {
    private String tag;

    private String version;

    private String ip;

    private Long orderId;

    private Long customerId;

    private Long itemId;

    private Long shipmentId;

    private String shipmentAddress;

    private Date createTimestamp;

    private Date updateTimestamp;

    public OrderVO(){}

    public OrderVO(Long orderId, Long customerId, Long itemId, Long shipmentId, Date createTimestamp, Date updateTimestamp) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.itemId = itemId;
        this.shipmentId = shipmentId;
        this.createTimestamp = createTimestamp;
        this.updateTimestamp = updateTimestamp;
    }

    public OrderVO(Long orderId, Long customerId, Long itemId, Long shipmentId) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.itemId = itemId;
        this.shipmentId = shipmentId;
    }

    public OrderVO(OrderVOBuilder builder) {
        this.tag = builder.tag;
        this.version = builder.version;
        this.ip = builder.ip;
        this.orderId = builder.orderId;
        this.customerId = builder.customerId;
        this.itemId = builder.itemId;
        this.shipmentId = builder.shipmentId;
        this.shipmentAddress = builder.shipmentAddress;
        this.createTimestamp = builder.createTimestamp;
        this.updateTimestamp = builder.updateTimestamp;
    }

    public static class OrderVOBuilder {
        private String tag;
        private String version;
        private String ip;
        private Long orderId;
        private Long customerId;
        private Long itemId;
        private Long shipmentId;
        private String shipmentAddress;
        private Date createTimestamp;
        private Date updateTimestamp;

        public static OrderVOBuilder newBuilder(){
            return new OrderVOBuilder();
        }
        public OrderVO build(){
            return new OrderVO(this);
        }

        public OrderVOBuilder tag(String tag) {
            this.tag = tag;
            return this;
        }

        public OrderVOBuilder version(String version) {
            this.version = version;
            return this;
        }

        public OrderVOBuilder ip(String ip) {
            this.ip = ip;
            return this;
        }

        public OrderVOBuilder orderId(Long orderId) {
            this.orderId = orderId;
            return this;
        }

        public OrderVOBuilder customerId(Long customerId) {
            this.customerId = customerId;
            return this;
        }

        public OrderVOBuilder itemId(Long itemId) {
            this.itemId = itemId;
            return this;
        }

        public OrderVOBuilder shipmentId(Long shipmentId) {
            this.shipmentId = shipmentId;
            return this;
        }

        public OrderVOBuilder shipmentAddress(String shipmentAddress) {
            this.shipmentAddress = shipmentAddress;
            return this;
        }

        public OrderVOBuilder createTimestamp(Date createTimestamp) {
            this.createTimestamp = createTimestamp;
            return this;
        }

        public OrderVOBuilder updateTimestamp(Date updateTimestamp) {
            this.updateTimestamp = updateTimestamp;
            return this;
        }

        public OrderVO emptyOrder() {
            return new OrderVO(0L, 0L, 0L, 0L, new Date(), new Date());
        }
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
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
