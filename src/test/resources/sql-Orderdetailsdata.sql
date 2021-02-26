INSERT INTO `customers` (`first_name`, `surname`) VALUES ('jordan', 'harrison');
INSERT INTO `items` (`name`, `price`) VALUES ('apples', 1.2);
INSERT INTO `customers` (`first_name`, `surname`) VALUES ('jord', 'harr');
INSERT INTO `items` (`name`, `price`) VALUES ('pears', 1.5);
INSERT INTO `orders` (`customer_ID`, `Item_ID`, quantity) VALUES (1, 1, 1);
INSERT INTO `orders` (`customer_ID`, `Item_ID`, quantity) VALUES (2, 2, 2);
INSERT INTO `order_details` (`order_id`, `item_id`, quantity) VALUES (1, 1, 1);