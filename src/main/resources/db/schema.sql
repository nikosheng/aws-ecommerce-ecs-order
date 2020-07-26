CREATE TABLE `t_customer` (
  `customer_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `firstname` varchar(255) NOT NULL,
  `lastname` varchar(255) NOT NULL,
  `create_timestamp` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `update_timestamp` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`customer_id`)
);

CREATE TABLE `t_item` (
  `item_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `item_name` varchar(255) NOT NULL,
  `item_price` varchar(255) NOT NULL,
  `create_timestamp` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `update_timestamp` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`item_id`)
);

CREATE TABLE `t_order` (
  `order_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `customer_id` bigint(20),
  `item_id` bigint(20),
  `shipment_id` bigint(20),
  `create_timestamp` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `update_timestamp` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`order_id`)
);

CREATE TABLE `t_shipment` (
  `shipment_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `customer_id` bigint(20),
  `item_id` bigint(20),
  `order_id` bigint(20),
  `shipment_address` varchar(256) NOT NULL,
  `create_timestamp` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `update_timestamp` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`shipment_id`)
);