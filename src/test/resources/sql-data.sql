INSERT INTO `customers` (`first_name`, `surname`) VALUES ('jordan', 'harrison');
INSERT INTO `items` (`item_name`, `item_type`, `item_price`) VALUES ('A', 'B', 1.0);
Insert into `orders`(`cust_id`, `order_status`) values(1,'oos');

Insert into  `order_items` set `itemID` = 1,  `order_quantity` = 1 , `orderID` = 1;