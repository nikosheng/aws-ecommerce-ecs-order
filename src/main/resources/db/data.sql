insert into t_order(order_id,customer_id,item_id,shipment_id)
values(1,1,1,1);
insert into t_order(order_id,customer_id,item_id,shipment_id)
values(2,1,2,2);
insert into t_shipment(shipment_id, customer_id, item_id, order_id, shipment_address) values(1, 1, 1, 1, 'Milan, Italy');
insert into t_shipment(shipment_id, customer_id, item_id, order_id, shipment_address) values(2, 1, 2, 2, 'Rome, Italy');